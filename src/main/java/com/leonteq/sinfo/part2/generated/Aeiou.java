package com.leonteq.sinfo.part2.generated;

public class Aeiou {

    // write a main method that takes a String as an argument and counts voyels of argument
    // and prints the result to the console

    ////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        final var input = "No sé a dónde va";
        //String input = args[0];
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        System.out.println(count);
    }
}
