package com.openx;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatTreeTest
{
    @Test
    void getSum()
    {
        StatTree tree = new StatTree();
        tree.insertElement(5);
        tree.insertElement(3);
        tree.insertElement(7);
        tree.insertElement(2);
        tree.insertElement(5);
        tree.insertElement(1);
        tree.insertElement(0);
        tree.insertElement(8);
        tree.insertElement(2);
        tree.insertElement(5);

        int sum = tree.getSum(tree.getRoot().getLeftChild());
        assertEquals(10, sum);

        sum = tree.getSum(tree.getRoot().getRightChild());
        assertEquals(23, sum);

        //      5
        //   3      7
        // 2   5  1   0
        //          2   8
        //                5
    }

    @Test
    void getAvg()
    {
        StatTree tree = new StatTree();
        tree.insertElement(5);
        tree.insertElement(3);
        tree.insertElement(7);
        tree.insertElement(2);
        tree.insertElement(5);
        tree.insertElement(1);
        tree.insertElement(0);
        tree.insertElement(8);
        tree.insertElement(2);
        tree.insertElement(5);

        double avg = tree.getAvg(tree.getRoot().getLeftChild());
        assertEquals((double)10/3, avg);

        avg = tree.getAvg(tree.getRoot().getRightChild());
        assertEquals((double)23/6, avg);

        //      5
        //   3      7
        // 2   5  1   0
        //          2   8
        //                5
    }

    @Test
    void getMediana()
    {
        StatTree tree = new StatTree();
        tree.insertElement(5);
        tree.insertElement(3);
        tree.insertElement(7);
        tree.insertElement(2);
        tree.insertElement(5);
        tree.insertElement(1);
        tree.insertElement(0);
        tree.insertElement(8);
        tree.insertElement(2);
        tree.insertElement(5);

        double med = tree.getMediana(tree.getRoot().getLeftChild());
        assertEquals(3.0, med);

        med = tree.getMediana(tree.getRoot().getRightChild());
        assertEquals(3.5, med);

        //      5
        //   3      7
        // 2   5  1   0
        //          2   8
        //                5
    }
}