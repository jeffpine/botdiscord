package org.jeffpine;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SlashCommandsListener extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        switch (event.getName()) {
            case "roll" -> {
                String input = event.getOption("expressao").getAsString();

                if (input.equalsIgnoreCase("adv")) {
                    event.reply(DiceRoller.rollAdvantage(0)).queue();
                } else if (input.equalsIgnoreCase("dis")) {
                    event.reply(DiceRoller.rollDisadvantage(0)).queue();
                } else if (input.toLowerCase().contains("adv")) {
                    event.reply(DiceRoller.rollAdvantage(0)).queue();
                } else if (input.toLowerCase().contains("dis")) {
                    event.reply(DiceRoller.rollDisadvantage(0)).queue();
                } else {
                    event.reply(DiceRoller.roll(input)).queue();
                }
            }

            case "ajuda" -> {
                event.reply("""
                        📘 **Comandos disponíveis:**
                        `/roll [expressão]` → Rola dados (ex: d20, 2d6+3, d20 adv, d20 dis)
                        `/ajuda` → Mostra esta lista
                        """).setEphemeral(true).queue();
            }

            default -> event.reply("❌ Comando não reconhecido.").setEphemeral(true).queue();
        }
    }
}
