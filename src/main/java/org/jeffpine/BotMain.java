package org.jeffpine;

import net.dv8tion.jda.api.JDABuilder;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JDABuilder.createDefault(args[0])
                .build()
    }
}