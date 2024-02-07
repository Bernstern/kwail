package dev.bernstern;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Example data points
        double[] t = {0, 1 }; // Parameter values
        double[] x = {50, 150}; // X coordinates
        double[] y = {50, 50}; // Y coordinates

        ParametricSplineInterpreter spline = new ParametricSplineInterpreter(t, x, y);

        Plane plane = new Plane();

        // Add the data points to the plane
        for (int i = 0; i < t.length; i++) {
            plane.addPoint(new Point((int) x[i], (int) y[i]));
        }

        // Generate points along the spline and add to the plane
        for (double ti = t[0]; ti <= t[t.length - 1]; ti += 0.01) {
            double[] point = spline.evaluate(ti);
            plane.addSplinePoint(new Point((int) point[0], (int) point[1]));
        }

        // Display the points on the plane
        SwingUtilities.invokeLater(() -> displayPlane(plane));
    }

    private static void displayPlane(Plane plane) {
        PlaneDisplay display = new PlaneDisplay(plane);

        JFrame frame = new JFrame("Spline Points Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(display);
        frame.setSize(250, 250);
        frame.setVisible(true);
    }
}