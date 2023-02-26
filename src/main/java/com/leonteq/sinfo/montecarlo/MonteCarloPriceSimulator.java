package com.leonteq.sinfo.montecarlo;

import com.leonteq.sinfo.graphics.BarChart;

import java.util.Arrays;
import java.util.Random;

public class MonteCarloPriceSimulator {

  static final long seed = 123;
  static final Random random = new Random(seed);

  public static double getPrice(double initialPrice, double volatility) {
    return random.nextGaussian(initialPrice, volatility);
  }

  private static void analysisPricesGeneratedUsingRandom() {
    System.out.println("quick analysis of prices generated using random.nextGaussian()");
    final var vol = .01;
    final var nbSteps = 1;
    final var nbSims = 100_000;
    final double[] prices = new double[nbSims];
    for (int sims = 0; sims < nbSims; sims++) {
      var stepPrice = getPrice(100, vol);
      for (int steps = 1; steps < nbSteps; steps++) {
        stepPrice = getPrice(stepPrice, vol);
      }
      prices[sims] = stepPrice;
    }
    BarChart.plotPoints(prices);
    System.out.println(
        "First 20 elements: " + Arrays.toString(Arrays.stream(prices).limit(20).toArray()));
    System.out.println("Standard deviation: " + stdv(prices));
  }

  public static void main(String[] args) {
    analysisPricesGeneratedUsingRandom();
  }

  /**
   * helper method to compute standard deviation of an array of points
   */
  private static double stdv(double[] points) {
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
