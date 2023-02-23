package com.leonteq.sinfo.part1.generated;

public class FizzBuzz {

// Write a Fizz Buzz program that will either display Fizz, Buzz, FizzBuzz or integer value for a given integer value.
// given an integer input x:
// - for any x multiple of 3 print Fizz to console.
// - for any x multiple of 5 print Buzz to console.
// - for any x multiple of 3 and 5 print FizzBuzz to console.
// - else print value of x.
// The main method takes an integer as argument that the number of integer we iterate over, starting from 1.
// Use a helper function that returns a string for a given integer.
// For example, if the argument is 15, the output should be:
// 1
// 2
// Fizz
// 4
// Buzz
// Fizz
// 7
// 8
// Fizz
// Buzz
// 11
// Fizz
// 13
// 14
// FizzBuzz

    ////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        for (int i = 1; i <= x; i++) {
            System.out.println(fizzBuzz(i));
        }


    }

    public static String fizzBuzz(int x) {
        if (x % 3 == 0 && x % 5 == 0) {
            return "FizzBuzz";
        } else if (x % 3 == 0) {
            return "Fizz";
        } else if (x % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(x);
        }
    }

}