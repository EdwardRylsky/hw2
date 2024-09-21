package org.example;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class BinaryIntSearchTreeTest {
    @Test
    void add() {
        HomeWork tree = new HomeWork();

        tree.add(5);
        tree.add(3);
        tree.add(1);
        tree.add(2);
        tree.add(4);
        tree.add(8);
        tree.add(7);
        tree.add(6);
        tree.add(10);
        tree.add(9);

        assertEquals(asList(1), tree.findMaxDigits(1, 1));
        assertEquals(asList(2, 1), tree.findMaxDigits(2, 2));
        assertEquals(asList(3, 2, 1), tree.findMaxDigits(3, 3));
        assertEquals(asList(4, 3, 2, 1), tree.findMaxDigits(4, 4));
        assertEquals(asList(5, 4, 3, 2, 1), tree.findMaxDigits(5, 5));
        assertEquals(asList(9, 8, 7, 6, 5, 4), tree.findMaxDigits(6, 9));
        assertEquals(asList(9, 8, 7, 6, 5, 4, 3), tree.findMaxDigits(7, 9));
        assertEquals(asList(9, 8, 7, 6, 5, 4, 3, 2), tree.findMaxDigits(8, 9));
        assertEquals(asList(9, 8, 7, 6, 5, 4, 3, 2, 1), tree.findMaxDigits(9, 9));
    }
}