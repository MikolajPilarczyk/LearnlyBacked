package com.example.learnlybacked.listener;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SlashCommandListener extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        switch (event.getName()) {
            case "say" -> {
                String content = event.getOption("content", OptionMapping::getAsString);
                event.reply(content).queue();
            }
           case "roll" -> {
                String roll = event.getOption("roll", OptionMapping::getAsString).trim();
                String[] rollParams = roll.split("d");

                if(rollParams.length ==2) {
                    try {
                        int count = Integer.parseInt(rollParams[0]);
                        int rollValue = Integer.parseInt(rollParams[1]);
                        int maxResult = 0;
                        Random random = new Random();

                        for(int i=1;i<=count;i++) {
                            int singeRoll = random.nextInt(rollValue)+1;
                            maxResult += singeRoll;
                            event.getChannel().sendMessage("Your "+ String.valueOf(i) + " roll is " + String.valueOf(singeRoll) + "!").queue();

                        }



                        event.reply("Rolled "+String.valueOf(roll) +"\nFinal result: "+String.valueOf(maxResult)).queue();


                    } catch (NumberFormatException e) {
                        event.reply("Podaj rzut w poprawnym formacie").queue();
                    }

                }
                else
                {
                    event.reply("Podaj rzut w poprawnym formacie").queue();
                }

           }
        }
    }
}