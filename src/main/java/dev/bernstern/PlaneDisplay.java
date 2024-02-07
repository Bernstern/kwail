package dev.bernstern;

import javax.swing.JPanel;
import java.awt.*;
import java.util.List;

public class PlaneDisplay extends JPanel {
    private Plane plane;

    public PlaneDisplay(Plane plane) {
        this.plane = plane;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Visualize the data points
        List<Point> points = plane.getPoints();
        for (Point point : points) {
            // Color the points red
            g.setColor(Color.RED);
            g.fillOval((int) point.getX(), (int) point.getY(), 10, 10);
        }

        // Visualize the spline points
        List<Point> splinePoints = plane.getSplinePoints();
        for (Point point : splinePoints) {
            // Color the points blue
            g.setColor(Color.BLUE);
            g.fillOval((int) point.getX(), (int) point.getY(), 5, 5);
        }
    }
}