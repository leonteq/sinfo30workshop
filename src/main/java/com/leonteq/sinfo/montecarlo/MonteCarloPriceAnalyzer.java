package com.leonteq.sinfo.montecarlo;

import com.leonteq.sinfo.graphics.BarChart;

import java.util.Arrays;

public class MonteCarloPriceAnalyzer {

    public static void main(String[] args) {
        analysisPricesGeneratedUsing(new JavaMonteCarloPriceSimulator());
        analysisPricesGeneratedUsing(new BasicMonteCarloPriceSimulator());
    }

    private static void analysisPricesGeneratedUsing(MonteCarloPriceSimulator priceSimulator) {
        System.out.println("quick analysis of prices generated using " + priceSimulator.getClass().getSimpleName());
        final var vol = 1;
        final var nbSteps = 1;
        final var nbSims = 100_000;
        final double[] prices = new double[nbSims];
        for (int sims = 0; sims < nbSims; sims++) {
            var stepPrice = 100.0;
            for (int steps = 0; steps < nbSteps; steps++) {
                stepPrice = priceSimulator.getPrice(stepPrice, vol);
            }
            prices[sims] = stepPrice;
        }
        BarChart.plotPoints(prices);
        System.out.println(
                "First 20 elements: " + Arrays.toString(Arrays.stream(prices).limit(20).toArray()));
        System.out.println(
                "Avg: " + Arrays.stream(prices).average().getAsDouble());
        System.out.println("Standard deviation: " + stdv(prices));
    }

    /**
     * helper method to compute standard deviation of an array of points
     */
    private static double stdv(final double[] points) {
        double sum = 0.0;
        for (double i : points) {
            sum += i;
        }

        int length = points.length;
        double mean = sum / length;

        double stdev = 0.0;
        for (double num : points) {
            stdev += Math.pow(num - mean, 2);
        }

        return Math.sqrt(stdev / length);
    }
}
