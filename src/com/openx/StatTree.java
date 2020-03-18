package com.openx;

import java.util.ArrayList;
import java.util.Collections;

public class StatTree extends BinaryTree
{
    //---------------------------Fields----------------------------//
    private int sum;
    private double avg;
    private int counter;
    private ArrayList<Integer> alist;
    //---------------------------Constructors----------------------------//
    public StatTree()
    {
        super();
        this.sum = 0;
        this.avg = 0;
        this.counter = 0;
        this.alist = new ArrayList<Integer>();
    }

    public StatTree(int d )
    {
        super(d);
        this.sum = 0;
        this.avg = 0;
        this.counter = 0;
        this.alist = new ArrayList<Integer>();
    }

    //---------------------------Methods----------------------------//

    private void CalcSum(Node n)
    {
        // I use preOrder to move between nodes
        this.sum += n.getData();

        if( n.getLeftChild() != null )
            CalcSum(n.getLeftChild());
        if( n.getRightChild() != null )
            CalcSum(n.getRightChild());
    }

    public int getSum(Node n)
    {
        CalcSum(n);
        int tmpSum = this.sum;
        this.sum = 0; //to make field reusable
        return tmpSum;
    }


    private void CalcAvg(Node n)
    {
        // I use preOrder to move between nodes
        this.sum += n.getData();
        this.counter++;

        if( n.getLeftChild() != null )
            CalcAvg(n.getLeftChild());
        if( n.getRightChild() != null )
            CalcAvg(n.getRightChild());
    }

    public double getAvg(Node n)
    {
        CalcAvg(n);
        double tmpC = (double)this.counter;
        double tmpSum = (double)this.sum;
        this.counter = 0; //to make fields reusable
        this.sum = 0;
        return tmpSum/tmpC;
    }

    private void CalcMediana(Node n)
    {
        // I use preOrder to move between nodes
        this.alist.add(n.getData());

        if( n.getLeftChild() != null )
            CalcMediana(n.getLeftChild());
        if( n.getRightChild() != null )
            CalcMediana(n.getRightChild());
    }

    public double getMediana(Node n)
    {
        alist.clear();
        CalcMediana(n);
        Collections.sort(alist);
        int size = alist.size();
        if( size%2 == 1 )
        {
            return alist.get( ((size+1)/2)-1 );
        }
        else
        {
            return ( ( (double)alist.get(size/2-1) + (double)alist.get(size/2) ) / 2 );
        }
    }
}
