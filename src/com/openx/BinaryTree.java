package com.openx;

public class BinaryTree {
    //---------------------------Fields----------------------------//
    private Node root;
    private Node actualNode; //node active in the moment -- used in insert method
    private boolean altMode; //flag used to switch the way of inserting new nodes
    private Node deepestRight; //used in Node removal algorythm

    //---------------------------Constructors----------------------------//
    public BinaryTree()
    {
        this.root = null;
        this.actualNode = null;
        this.altMode = false;
        this.deepestRight = null;
    }

    public BinaryTree( int newData )
    {
        this.root = new Node(newData);
        this.actualNode = this.root;
        this.altMode = false;
        this.deepestRight = null;
    }


    //---------------------------Methods----------------------------//

    // Main concept of this method is that I insert new nodes from left side. I create balanced binary tree by inserting
    // new nodes level after level. Node with value = 0, has special meaning. It changes mechanics of tree creation.
    // After zero node first appears it is considered as quasi root, and new nodes are inserted from the right side.
    // Goal is to maintain balanced character of such subtree.

    public void insertElement(int newData)
    {
        if( root == null )
        {
            this.root = new Node(newData);
            this.actualNode = this.root;
        }
        else
        {
            Node newNode = new Node(newData);
            Node loopAux = this.actualNode;

            while(true)
            {
                if( !this.altMode )
                {
                    if (loopAux.getLeftChild() == null)
                    {
                        newNode.setParent(loopAux);
                        loopAux.setLeftChild(newNode);
                        loopAux.incrementChildFactor();

                        if (newData == 0)
                        {
                            this.actualNode = loopAux.getLeftChild();
                            this.altMode = true;
                        }
                        break;

                    } else if (loopAux.getRightChild() == null)
                    {
                        newNode.setParent(loopAux);
                        loopAux.setRightChild(newNode);
                        loopAux.incrementChildFactor();

                        if (newData == 0)
                        {
                            this.actualNode = loopAux.getRightChild();
                            this.altMode = true;
                        }
                        break;
                    } else
                    {
                        if (loopAux.getLeftChild().getChildFactor() < 2)
                            loopAux = loopAux.getLeftChild();
                        else if (loopAux.getRightChild().getChildFactor() < 2)
                            loopAux = loopAux.getRightChild();
                        else
                            loopAux = loopAux.getLeftChild();
                    }
                }
                else if( this.altMode ) //basically the same, but nodes are added form the right side
                {                       // and actualNode is set to latest '0' node
                    if (loopAux.getRightChild() == null)
                    {
                        newNode.setParent(loopAux);
                        loopAux.setRightChild(newNode);
                        loopAux.incrementChildFactor();

                        if (newData == 0)
                        {
                            this.actualNode = loopAux.getRightChild();
                            this.altMode = false;
                        }

                        break;

                    } else if (loopAux.getLeftChild() == null)
                    {
                        newNode.setParent(loopAux);
                        loopAux.setLeftChild(newNode);
                        loopAux.incrementChildFactor();

                        if (newData == 0)
                        {
                            this.actualNode = loopAux.getLeftChild();
                            this.altMode = false;
                        }

                        break;
                    } else
                    {
                        if (loopAux.getRightChild().getChildFactor() < 2)
                            loopAux = loopAux.getRightChild();
                        else if (loopAux.getLeftChild().getChildFactor() < 2)
                            loopAux = loopAux.getLeftChild();
                        else
                            loopAux = loopAux.getRightChild();
                    }
                }
            }
        }
    }

    private void preOrder(Node n) //used in removal algorythm
    {
        //inOrder traversal
        this.deepestRight = n;
        if(n.getLeftChild() != null)
            preOrder(n.getLeftChild());
        if(n.getRightChild() != null)
            preOrder(n.getRightChild());
    }


    public void removeElement(Node n) // I remove selected node and replace it with deepest rightmost node, to maintain
    {                                  // binary character of the tree.

        preOrder(this.root);

        //changing deepest nodes parent dependecies
        this.deepestRight.getParent().decrementChildFactor();

        if(this.deepestRight.getParent().getRightChild() == this.deepestRight)
            this.deepestRight.getParent().setRightChild(null);
        else if(this.deepestRight.getParent().getLeftChild() == this.deepestRight)
            this.deepestRight.getParent().setLeftChild(null);

        //changing deepest nodes dependecies
        this.deepestRight.setParent(n.getParent());
        this.deepestRight.setLeftChild(n.getLeftChild());
        this.deepestRight.setRightChild(n.getRightChild());
        this.deepestRight.setChildFactor(n.getChildFactor());


        //changing n nodes parent dependencies
        if( n != this.root )
        {
            if (this.deepestRight.getParent().getLeftChild() == n)
                this.deepestRight.getParent().setLeftChild(this.deepestRight);
            else if (this.deepestRight.getParent().getRightChild() == n)
                this.deepestRight.getParent().setRightChild(this.deepestRight);
        }
        else
        {
            this.root = deepestRight;
        }

        //changing n nodes children dependencies
        if(n.getLeftChild() != null)
            n.getLeftChild().setParent(this.deepestRight);

        if(n.getRightChild() != null)
            n.getRightChild().setParent(this.deepestRight);
    }

    public void printBinaryTree(Node n) //test purposes
    {
        //pre-order
        if(n.getParent() != null)
            System.out.print(n.getData() + "(" + n.getParent().getData()+ ") ");
        else
            System.out.print(n.getData() + "(root) ");

        if( n.getLeftChild() != null )
            printBinaryTree(n.getLeftChild());
        if( n.getRightChild() != null )
            printBinaryTree(n.getRightChild());
    }

    public void printBinaryTreeToStringBuffer(Node n, StringBuffer sb) //function purely for testing purposes
    {
        //pre-order -- I could implement other methods, but it is not a main problem in this task
        if(n.getParent() != null)
            sb.append(n.getData() + "(" + n.getParent().getData()+ ") ");
        else
            sb.append(n.getData() + "(root) ");

        if( n.getLeftChild() != null )
            printBinaryTreeToStringBuffer(n.getLeftChild(), sb);
        if( n.getRightChild() != null )
            printBinaryTreeToStringBuffer(n.getRightChild(), sb);
    }

    public Node getRoot()
    {
        return this.root;
    }

    public Node getDeepestRight() //test purposes
    {
        return this.deepestRight;
    }
}
