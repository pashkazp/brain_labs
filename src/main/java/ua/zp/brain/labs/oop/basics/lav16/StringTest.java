package ua.zp.brain.labs.oop.basics.lav16;

import java.util.Arrays;
import java.util.Scanner;

public class StringTest {
    public static void main(String[] args) {
        //
        String literal = "This is literal";
        System.out.println("\n\"" + literal + "\"");

        //
        String newString = new String("This is \"new\" String");
        System.out.println("\n\"" + newString + "\"");

        //
        char[] chars = {'S', 't', 'r', 'i', 'n', 'g', ' ', 'f', 'r', 'o', 'm', ' ', 'c', 'h', 'a', 'r', 's'};
        String charStrting = new String(chars);
        System.out.println("\nChar array " + Arrays.toString(chars) + " converted to \"" + charStrting + "\"");

        //
        byte[] bytes = "String from bytes".getBytes();
        String bytesString = new String(bytes);
        System.out.println("\nByte array " + Arrays.toString(bytes) + " converted to \"" + bytesString + "\"");

        //
        StringBuilder sb = new StringBuilder(0);
        String sbString = sb.append("A string ")
                .append("StringBuilder.")
                .insert("A string ".length(), "constructed by ")
                .toString();
        System.out.println("\nA string \"" + sbString + "\" constructed by StringBuilder.");

        //
        String fruits = "Апельсин,Яблоко,Гранат,Груша";
        String[] fruitsArray = fruits.split(",");
        System.out.println("\nString: \"" + fruits + "\" converted to Array of Strings by split method: "
                + Arrays.toString(fruitsArray));
        int i = 0;
        int len = 0;
        for (int j = 0; j < fruitsArray.length; j++) {
            if (fruitsArray[j].length() > len) {
                len = fruitsArray[j].length();
                i = j;
            }
        }

        String longestFruit = fruitsArray[i];
        System.out.println("Longest word in Array of fruits: \"" + longestFruit.toLowerCase() + "\"");
        System.out.println("Shortcut of \"" + longestFruit.toLowerCase() + "\" is \""
                + longestFruit.toLowerCase().substring(0, 3) + "\"");

        //
        String nonTrimStringWithUnderscores = " Я_новая_строка ";
        String stringWithUnderscores = nonTrimStringWithUnderscores.trim();
        String withoutUnderscores = stringWithUnderscores.replaceAll("_", " ");
        System.out.println("\nString \"" + nonTrimStringWithUnderscores + "\" is first converted to \""
                + stringWithUnderscores + "\", and then to \"" + withoutUnderscores + "\".");

        //
        Scanner in = new Scanner(System.in);
        System.out.print("\nВведите текст: ");
        String ss = in.next();

        if (ss.toUpperCase().contains("ОШИБКА")) {
            System.out.println("Произошла ошибка");
        } else if (ss.toUpperCase().contains("ЗАПУСК")) {
            System.out.println("Запускаем процесс");
        } else if (ss.toUpperCase().contains("ЗАВЕРШЕН")) {
            System.out.println("Процесс завершен");
        }

        sb = new StringBuilder(0);
        ss = sb.append(literal)
                .append(newString)
                .append(charStrting).append("\n")
                .append(bytesString)
                .append(sbString)
                .append(fruits).append("\n")
                .append(nonTrimStringWithUnderscores)
                .append(stringWithUnderscores)
                .append(withoutUnderscores).append("\n")
                .append(ss)
                .reverse()
                .toString();
        System.out.println(ss);
    }
}
