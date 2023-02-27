package com.leonteq.sinfo.montecarlo;

public interface MonteCarloPriceSimulator {
    double getPrice(final double initialPrice, final double volatility);
}
