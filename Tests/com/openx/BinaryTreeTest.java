package com.openx;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest
{
    //I decided to test only methods that are important to the program functionality.
    //So there are no printing methods tests.
    @Test
    void InsertAndRemoveElement()
    {
        BinaryTree tree = new BinaryTree();
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

        //value in parethesis is the value of parent node or information about root placement
        StringBuffer sb = new StringBuffer();
        tree.printBinaryTreeToStringBuffer(tree.getRoot(), sb); //printing before removal
        assertEquals("5(root) 3(5) 2(3) 5(3) 7(5) 1(7) 0(7) 2(0) 8(0) 5(8) ", sb.toString());

        tree.removeElement(tree.getRoot().getRightChild());

        sb.delete(0,sb.length()); //clearing content
        tree.printBinaryTreeToStringBuffer(tree.getRoot(), sb); //printing after first removal
        assertEquals("5(root) 3(5) 2(3) 5(3) 5(5) 1(5) 0(5) 2(0) 8(0) ", sb.toString());

        tree.removeElement(tree.getRoot().getRightChild().getLeftChild());

        sb.delete(0,sb.length()); //clearing content
        tree.printBinaryTreeToStringBuffer(tree.getRoot(), sb); //printing after second removal
        assertEquals("5(root) 3(5) 2(3) 5(3) 5(5) 8(5) 0(5) 2(0) ", sb.toString());

        //      5                                       5                                   5
        //   3      7                               3       5                           3       5
        // 2   5  1   0             --->          2   5   1    0        --->         2    5   8    0
        //          2   8                                     2  8                                2
        //                5
    }
}