package com.leonteq.sinfo.part2.generated;

public class StockPricesGeneratorGenerated {
        // write a method that generates a serie of random stock prices
        // prices starts at 100 and can go up or down by 1% at each iteration
        // the method should take a number of iterations as an argument
        // and return an array of prices
        // prices have 2 decimal places
        // (hint: use Math.random() to generate a random number between 0 and 1)
        public static double[] generate(int iterations) {
            double[] prices = new double[iterations];
            double price = 100;
            for (int i = 0; i < iterations; i++) {
                double random = Math.random();
                if (random < 0.5) {
                    price = price * 0.99;
                } else {
                    price = price * 1.01;
                }
                prices[i] = price;
            }
            return prices;
        }

        // write a main method that prints the generated prices to the console
        // (hint: use Arrays.toString() to print an array)
        public static void main(String[] args) {
            double[] prices = generate(90);
            for (int i = 0; i < prices.length; i++) {
                System.out.println(prices[i]);
            }
        }

}
