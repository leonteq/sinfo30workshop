package com.leonteq.sinfo.graphics;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BarChart extends JPanel {

  private Map<Double, Integer> bars = new LinkedHashMap<>();

  public BarChart(Map<Double, Integer> buckets) {
    for (Double buckKey : buckets.keySet()) {
      addBar(buckKey, buckets.get(buckKey));
    }
  }

  public static void plotPoints(double[] points) {
    final var bdPoints =
        Arrays.stream(points)
            .mapToObj(x -> new BigDecimal(x))
            .collect(Collectors.toList())
            .toArray(new BigDecimal[points.length]);
    plotPoints(bdPoints);
  }

  public static void plotPoints(BigDecimal[] points) {
    chartBuckets(pointsToBuckets(points));
  }

  private static void chartBuckets(Map<Double, Integer> buckets) {
    BarChart bar = new BarChart(buckets);
    bar.display();
  }

  private static double min(BigDecimal[] points) {
    return Arrays.stream(points).min(BigDecimal::compareTo).get().doubleValue();
  }

  private static double max(BigDecimal[] points) {
    return Arrays.stream(points).max(BigDecimal::compareTo).get().doubleValue();
  }

  private static Integer numberOfPointsBetween(
      final BigDecimal[] points, final double min, final double max) {
    Integer res = 0;
    for (BigDecimal p : points) {
      if (p.compareTo(new BigDecimal(min)) * p.compareTo(new BigDecimal(max)) < 0) {
        res++;
      }
    }
    return res;
  }

  private static Map<Double, Integer> pointsToBuckets(final BigDecimal[] points) {
    Map<Double, Integer> buckets = new TreeMap<>();
    double minBound = Integer.MIN_VALUE;
    final double bucketMin = min(points);
    final double bucketMax = max(points);
    final int nbBuckets = 21;
    final double bucketSize = (bucketMax - bucketMin) / nbBuckets;

    for (double i = bucketMin; i <= bucketMax; i += bucketSize) {
      buckets.put(minBound, numberOfPointsBetween(points, minBound, i));
      minBound = i;
    }
    // fill last bucket to infinity and beyond
    buckets.put(minBound, numberOfPointsBetween(points, minBound, Integer.MAX_VALUE));
    return buckets;
  }

  public void addBar(double key, int value) {
    bars.put(key, value);
  }

  @Override
  protected void paintComponent(Graphics g) {
    // determine longest bar

    int max = Integer.MIN_VALUE;
    for (Integer value : bars.values()) {
      max = Math.max(max, value);
    }

    // paint bars

    int width = (getWidth() / bars.size()) - 2;
    int x = 1;
    int red = 255;
    for (Double buckKey : bars.keySet()) {
      int value = bars.get(buckKey);
      int height = (int) ((getHeight() - 5) * ((double) value / max));
      g.setColor(new Color(red, 10, 10));
      g.fillRect(x, getHeight() - height, width, height);
      g.setColor(Color.black);
      g.drawRect(x, getHeight() - height, width, height);
      x += (width + 2);
      red = red - (250 / bars.size());
    }
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(bars.size() * 50 + 2, 400);
  }

  public void display() {
    JFrame frame = new JFrame("Bar Chart");
    frame.getContentPane().add(this);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}
