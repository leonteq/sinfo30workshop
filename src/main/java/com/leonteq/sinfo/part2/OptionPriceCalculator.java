package com.leonteq.sinfo.part2;

import com.leonteq.sinfo.graphics.BarChart;
import com.leonteq.sinfo.montecarlo.MonteCarloPriceSimulator;

public class OptionPriceCalculator {
    // Write a program that calculates the cost (price) of a Call Option.
    //For the purpose of this time-boxed exercise, the Call Option will be very simple:
    //- Strike Price 100€.
    //- Initial Price 100€.
    //- Maturity 3 months (90 days).
    //- Volatility, daily, is 1%.
    //- we will do 100 000 Monte Carlo simulations.
    //- for each Monte Carlo simulations we will calculate the gain/loss associated to it aka its Payoff.
    //- we will then take the average of all the payoffs to estimate what should be the minimum price of our Call Option.
    //
    //The tricky parts here are:
    //- how to do 1 Monte Carlo simulation: see MonteCarloPriceSimulator.getPrice() method in the project as one possible way to achieve it.
    //- how to code the payoff calculations: the 3 examples above should help you.
    //
    //You also have a helper method BarChart.plotPoints() which produces a bar chart from an array of points.
    //It can be useful if you want to validate that your Monte Carlo simulations follows normal distribution.

}
