package com.leonteq.sinfo.graphics;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class BarChart extends JPanel {

    private Map<Color, Integer> bars =
            new LinkedHashMap<Color, Integer>();

    public BarChart(Map<Integer, Integer> buckets) {
        for (Integer bucket : buckets.keySet()) {
            addBar(buckets.get(bucket));
        }
    }

    public BarChart() {

    }

    /**
     * Add new bar to chart
     *
     * @param color color to display bar
     * @param value size of bar
     */
    public void addBar(Color color, int value) {
        bars.put(color, value);
        repaint();
    }

    public void addBar(int value) {
       addBar(Color.getHSBColor(value, value, value), value);
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
        for (Color color : bars.keySet()) {
            int value = bars.get(color);
            int height = (int)
                    ((getHeight() - 5) * ((double) value / max));
            g.setColor(color);
            g.fillRect(x, getHeight() - height, width, height);
            g.setColor(Color.black);
            g.drawRect(x, getHeight() - height, width, height);
            x += (width + 2);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(bars.size() * 10 + 2, 50);
    }

    public void display() {
        JFrame frame = new JFrame("Bar Chart");
        frame.getContentPane().add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bar Chart");
        BarChart chart = new BarChart();
        chart.addBar(Color.red, 100);
        chart.addBar(Color.green, 8);
        chart.addBar(Color.blue, 54);
        chart.addBar(Color.black, 23);
        frame.getContentPane().add(chart);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
