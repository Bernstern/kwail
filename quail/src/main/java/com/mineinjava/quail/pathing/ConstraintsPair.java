package com.mineinjava.quail.pathing;

/**
 * Represents a pair of constraints (max velocity and max acceleration) for use in the path follower
 *
 * @param maxVelocity     your units/s
 * @param maxAcceleration your units/s^2
 */
public record ConstraintsPair(double maxVelocity,
                              double maxAcceleration) {
    public ConstraintsPair {
        if (maxVelocity < 0 || maxAcceleration < 0) {
            throw new IllegalArgumentException("Constraints cannot be negative");
        }
    }
}
