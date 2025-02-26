package com.mineinjava.quail.util;

import com.mineinjava.quail.util.geometry.Pose2d;
import com.mineinjava.quail.util.geometry.Vec2d;

public class MathUtil {
  public static boolean epsilonEquals(double value1, double value2) {
    double epsilon = 1e-6; // Adjust the epsilon value as needed
    return Math.abs(value1 - value2) < epsilon;
  }

  /**
   * Detects if a line segment defined by two positions will intersect a circle with given center
   * and radius Note that the headings for all three Pose2d arguments are not used
   * https://stackoverflow.com/a/1084899/13224997
   */
  public static boolean LineSegHitCircle(
      Pose2d lineSegStart, Pose2d lineSegEnd, Pose2d circleCenter, double circleRadius) {

    Vec2d d = lineSegEnd.vec().subtract(lineSegStart.vec());
    Vec2d f = lineSegStart.vec().subtract(circleCenter.vec());

    double a = d.dot(d);
    if (a == 0.0) {
      return false;
    }
    double b = 2 * f.dot(d);
    double c = f.dot(f) - (circleRadius * circleRadius);

    double discriminant = (b * b) - (4 * a * c);
    if (discriminant < 0) {
      return false;
    }
    discriminant = Math.sqrt(discriminant);
    double t1 = (-b - discriminant) / (2 * a);
    double t2 = (-b + discriminant) / (2 * a);

    return ((0d <= t1 && t1 <= 1d) && (0d <= t2 && t2 <= 1d));
  }

  /**
   * basic lerp function
   *
   * @return value between a and b at t
   */
  public static double lerp(double a, double b, double t) {
    return a + (b - a) * t;
  }
}
