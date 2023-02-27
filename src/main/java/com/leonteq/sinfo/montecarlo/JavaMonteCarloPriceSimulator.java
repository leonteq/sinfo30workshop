package com.leonteq.sinfo.montecarlo;

import java.util.Random;

public class JavaMonteCarloPriceSimulator implements MonteCarloPriceSimulator {
    // having a fixed seed allows to reproduce the same results
    // this is by design to make the exercise easier to follow
    // for something to put in production, you should use a random seed
    final long seed = 123;
    final Random random = new Random(seed);

    @Override
    public double getPrice(final double initialPrice, final double volatility) {
        return initialPrice + random.nextGaussian() * volatility;
        // pss .. with Java17+ you can directly call:
        //        return random.nextGaussian(initialPrice, volatility);
    }

}
