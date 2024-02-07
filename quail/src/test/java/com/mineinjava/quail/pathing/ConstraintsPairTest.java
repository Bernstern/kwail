package com.mineinjava.quail.pathing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstraintsPairTest {

    // Test that a constraints pair can be created and its values can be accessed
    @Test
    void simpleCheck() {
        ConstraintsPair pair = new ConstraintsPair(1, 2);

        assertEquals(1, pair.maxVelocity());
        assertEquals(2, pair.maxAcceleration());
    }

    // Test that either part of a constraints pair cannot be negative
    @Test
    void constraintsCannotBeNegative() {
        assertThrows(IllegalArgumentException.class, () -> new ConstraintsPair(-1, 2));
        assertThrows(IllegalArgumentException.class, () -> new ConstraintsPair(1, -2));
    }
}