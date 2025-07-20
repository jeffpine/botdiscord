package org.jeffpine;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import javax.security.auth.login.LoginException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class BotMain {
    public static void main(String[] args) throws LoginException {
        var jda = JDABuilder.createDefault("MTM5NjE3Mjg3MDc0MDIxNzkwOA.Gne6-N.zVsx1tWj_R8B9a11GrsEIDeIqhN1YetmvZMlQA")
                .setActivity(Activity.playing("https://github.com/jeffpine"))
                .addEventListeners(new SlashCommandsListener())
                .build();

        jda.updateCommands().addCommands(
                Commands.slash("roll", "Rola dados.")
                        .addOption(OptionType.STRING, "expressao", "Ex: d20, d20 adv, 2d6+3", true),
                Commands.slash("ajuda", "Exibe ajuda.")
        ).queue();
    }
}