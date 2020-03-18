package com.openx;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {
    @Test
    void getData() {
        Node nn = new Node(6);
        assertEquals(6,nn.getData());
    }
    // I decided not to test other methods of this class, because these tests would be quite primitive
    // and a waste of time.
}