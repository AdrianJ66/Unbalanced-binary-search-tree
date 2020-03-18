package com.openx;

public class Node {
    //---------------------------Fields----------------------------//
    private int data;
    private Node parent;
    private Node leftChild;
    private Node rightChild;
    private int childFactor;


    //---------------------------Constructors----------------------------//
    public Node()
    {
        this.data = 0;
        this.parent = null;
        this.leftChild = null;
        this.rightChild = null;
        this.childFactor = 0;
    }

    public Node( int d )
    {
        this.data  = d;
        this.parent = null;
        this.leftChild = null;
        this.rightChild = null;
        this.childFactor = 0;
    }

    //---------------------------Methods----------------------------//
    protected void setParent( Node p )
    {
        this.parent = p;
    }

    protected void setRightChild( Node p )
    {
        this.rightChild = p;
    }

    protected void setLeftChild( Node p )
    {
        this.leftChild = p;
    }


    public Node getLeftChild()
    {
        return this.leftChild;
    }

    public Node getRightChild()
    {
        return this.rightChild;
    }

    public Node getParent()
    {
        return this.parent;
    }

    public int getData()
    {
        return this.data;
    }

    public int getChildFactor()
    {
        return this.childFactor;
    }

    protected void incrementChildFactor()
    {
        this.childFactor++;
    }

    protected void decrementChildFactor()
    {
        this.childFactor--;
    }

    protected void setChildFactor( int v )
    {
        this.childFactor = v;
    }

}
