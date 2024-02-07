package dev.bernstern;

import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;


public class ParametricSplineInterpreter {
    private PolynomialSplineFunction splineX;
    private PolynomialSplineFunction splineY;

    /**
     * Constructs a parametric spline using the provided data points.
     * @param t The parameter values corresponding to each point (typically time).
     * @param x The x coordinates of the points.
     * @param y The y coordinates of the points.
     */
    public ParametricSplineInterpreter(double[] t, double[] x, double[] y) {
        if (t.length != x.length || x.length != y.length) {
            throw new IllegalArgumentException("Arrays must have the same length.");
        }

        SplineInterpolator interpolator = new SplineInterpolator();
        splineX = interpolator.interpolate(t, x);
        splineY = interpolator.interpolate(t, y);
    }

    /**
     * Evaluates the spline at a given parameter value.
     * @param t The parameter value at which to evaluate the spline.
     * @return A 2D point (x, y) corresponding to the parameter value.
     */
    public double[] evaluate(double t) {
        return new double[]{splineX.value(t), splineY.value(t)};
    }
}

