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
            if (parts[0].isEmpty()) {
                quantity = 1;
            } else {
                quantity = Integer.parseInt(parts[0]);
            }

            String second = parts[1];
            if (second.contains("+")) {
                String[] temp = second.split("\\+");
                sides = Integer.parseInt(temp[0]);
                bonus = Integer.parseInt(temp[1]);
            } else {
                sides = Integer.parseInt(second);
            }

            int result = rollDice(quantity, sides) + bonus;
            return "🎲 Resultado de `" + input + "`: **" + result + "**";
        } catch (Exception e) {
            return "❌ Comando inválido. Tente algo como `/roll 2d6+3`.";
        }
    }

    public static String rollAdvantage() {
        int first = rollDie(20);
        int second = rollDie(20);
        return "🎲 Vantagem: `" + first + "` vs `" + second + "` → **" + Math.max(first, second) + "**";
    }

    public static String rollDisadvantage() {
        int first = rollDie(20);
        int second = rollDie(20);
        return "🎲 Desvantagem: `" + first + "` vs `" + second + "` → **" + Math.min(first, second) + "**";
    }
}
