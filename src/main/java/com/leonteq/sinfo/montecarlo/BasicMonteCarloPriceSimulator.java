package com.leonteq.sinfo.montecarlo;

import java.util.Random;

/**
 * this is a Monte Carlo price simulator that uses a custom random generator
 * As it uses basic Java primitives, it is meant to be easy to port to other
 * languages.
 */
public class BasicMonteCarloPriceSimulator implements MonteCarloPriceSimulator {
    // having a fixed seed allows to reproduce the same results
    // this is by design to make the exercise easier to follow
    // for something to put in production, you should use a random seed
    final long seed = 123;
    final Random random = new Random(seed);
    final private Object pyramidMutex = new Object();
    private double[] customPyramid = null;

    @Override
    public double getPrice(final double initialPrice, final double volatility) {
        synchronized (pyramidMutex) {
            if (customPyramid == null) {
                customPyramid = initializeCustomPyramid();
            }
        }
        // range of values in the customPyramid is ]-10_000,10_000[, we normalize it
        double rnd = customPyramid[random.nextInt(customPyramid.length)] / 10_000;
        return initialPrice + rnd * volatility * 142;
    }

    private double[] initializeCustomPyramid() {
        final var depth = 20_000;
        final var nbSims = 10_000;
        final var customPyramid = new double[nbSims];
        for (int sim = 0; sim < nbSims; sim++) {
            float deviation = 0;
            for (int d = 0; d < depth; d++) {
                deviation += random.nextBoolean() ? -0.5 : +0.5;
            }
            customPyramid[sim] = deviation;
        }
        return customPyramid;
    }

}
