package com.example.learnlybacked.disocrd.config;

import com.example.learnlybacked.listener.MessageListener;
import com.example.learnlybacked.listener.SlashCommandListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.InteractionContextType;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiscordConfig {

    @Value("${discord.token}")
    private String token;

    @Bean
    public JDA jda(MessageListener messageListener, SlashCommandListener slashCommandListener) throws InterruptedException {
        // 1. Budujemy instancję JDA
        JDA jda = JDABuilder.createDefault(token)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .addEventListeners(messageListener) // Wstrzyknięte listenery
                .addEventListeners(slashCommandListener)
                .build()
                .awaitReady();



        //dev test
        String guildId = "944711940771561512";
        Guild guild = jda.getGuildById(guildId);

        if (guild != null) {
            guild.updateCommands().addCommands(
                    Commands.slash("say", "Opis")
                            .addOption(OptionType.STRING, "content", "Treść", true),


                    Commands.slash("roll","Roll dice")
                            .addOption(OptionType.STRING, "roll", "What the roll dice?", true)
            ).queue();
            System.out.println("Komendy zarejestrowane dla serwera!");
        } else {
            System.out.println("Nie znaleziono serwera o podanym ID - sprawdź czy bot tam jest.");
        }


        //official version
        jda.updateCommands().addCommands(
                Commands.slash("say", "Makes the bot say what you tell it to")
                        .addOption(OptionType.STRING, "content", "What the bot should say", true),

                Commands.slash("roll","Roll dice")
                        .addOption(OptionType.STRING, "roll", "What the roll dice?", true)

        ).queue();

        return jda;
    }
}