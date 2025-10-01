package org.jeffpine;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BotCommands extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        String msg = event.getMessage().getContentRaw();
        if (!msg.startsWith("/")) return;

        String[] args = msg.substring(1).split(" ");

        switch (args[0].toLowerCase()) {
            case "roll":
                if (args.length == 1) {
                    event.getChannel().sendMessage("Use `/roll d20`, `/roll 2d6+3`, `/roll d20 adv`, etc.").queue();
                } else if (args.length == 2) {
                    if (args[1].equalsIgnoreCase("adv")) {
                        event.getChannel().sendMessage(DiceRoller.rollAdvantage(0)).queue();
                    } else if (args[1].equalsIgnoreCase("dis")) {
                        event.getChannel().sendMessage(DiceRoller.rollDisadvantage(0)).queue();
                    } else {
                        event.getChannel().sendMessage(DiceRoller.roll(args[1])).queue();
                    }
                } else {
                    event.getChannel().sendMessage("❌ Sintaxe inválida.").queue();
                }

                break;

            case "ajuda":
                event.getChannel().sendMessage("""
                    📘 Comandos de rolagem:
                    - `/roll d20` → Rola 1d20
                    - `/roll 2d6+3` → Rola 2 dados de 6 lados e soma +3
                    - `/roll d20 adv` → Rola com vantagem
                    - `/roll d20 dis` → Rola com desvantagem
                    """).queue();
                break;
            default:
                event.getChannel().sendMessage("🤖 Comando não reconhecido. Use `/ajuda`.").queue();
        }
    }
}
