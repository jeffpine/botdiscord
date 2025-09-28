package org.jeffpine;

import java.util.Random;

public class DiceRoller {
    private static final Random rand = new Random();

    public static int rollDie(int sides) {
        return rand.nextInt(sides) + 1;
    }

    public static int rollDice(int quantity, int sides) {
        int total = 0;
        for (int i = 0; i < quantity; i++) {
            total += rollDie(sides);
        }
        return total;
    }

    public static String roll(String input) {
        input = input.toLowerCase().replace(" ", "");

        String[] parts = input.split("d");
        int quantity = 1;
        int sides;
        int bonus = 0;

        try {
            // quantidade de dados
            if (parts[0].isEmpty()) {
                quantity = 1;
            } else {
                quantity = Integer.parseInt(parts[0]);
            }

            // lados e bônus
            String second = parts[1];
            if (second.contains("+")) {
                String[] temp = second.split("\\+");
                sides = Integer.parseInt(temp[0]);
                bonus = Integer.parseInt(temp[1]);
            } else {
                sides = Integer.parseInt(second);
            }

            // rolar os dados
            StringBuilder rolls = new StringBuilder();
            int sum = 0;
            for (int i = 0; i < quantity; i++) {
                int roll = rollDie(sides);
                sum += roll;
                rolls.append(roll);
                if (i < quantity - 1) rolls.append(", ");
            }

            int total = sum + bonus;

            return "🎲 Rolagem de `" + input + "`:\n" +
                    "Dados: [" + rolls + "] → soma = " + sum + "\n" +
                    (bonus != 0 ? "Bônus: +" + bonus + "\n" : "") +
                    "**Total = " + total + "**";

        } catch (Exception e) {
            return "❌ Comando inválido. Tente algo como `/roll 2d6+3`";
        }
    }

    public static String rollAdvantage(int bonus) {
        int first = rollDie(20);
        int second = rollDie(20);
        int winner = Math.max(first, second);

        int total = winner + bonus;

        return "🎲 Vantagem: [" + first + "] vs [" + second + "] → ✅ " + winner +
                (bonus != 0 ? " + bônus(" + bonus + ") = **" + total + "**" : "");
    }

    public static String rollDisadvantage(int bonus) {
        int first = rollDie(20);
        int second = rollDie(20);
        int loser = Math.min(first, second);

        int total = loser + bonus;

        return "🎲 Desvantagem: [" + first + "] vs [" + second + "] → ❌ " + loser +
                (bonus != 0 ? " + bônus(" + bonus + ") = **" + total + "**" : "");
    }
}
