package dev.bernstern;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Plane {
    private List<Point> points;
    private List<Point> splinePoints;

    public Plane() {
        points = new ArrayList<>();
        splinePoints = new ArrayList<>();
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public List<Point> getPoints() {
        return points;
    }

    public void addSplinePoint(Point point) {
        splinePoints.add(point);
    }

    public List<Point> getSplinePoints() {
        return splinePoints;
    }
}