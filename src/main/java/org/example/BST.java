package org.example;

import java.util.ArrayList;

public class BST {

    public Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public static class Node{
        int val;
        Node left,right;
        public Node(int val){
            this.val = val;
            this.left = this.right = null;
        }

    }

    //Default Constructor
    public BST(){
        this.root = null;
    }

    public BST(int x){
         this.root = new Node(x);
    }


    //insert method
    public Node insert(Node node, int x) {
        if (node == null) return new Node(x);
        if (x < node.val) {
            node.left = insert(node.left, x); // Update the left child
        } else if (x > node.val) {
            node.right = insert(node.right, x); // Update the right child
        }
        return node;
    }


    //search method

    public boolean search(Node node,int x)
    {
        if(node==null) return false;
        if(node.val==x) return true;
        else if(node.val>x) return search(node.left,x);
        else return search(node.right,x);
    }

    public Node delete(Node node,int x)
    {
        if(node==null) return null;
        if(node.val>x) node.left = delete(node.left,x);
        else if(node.val<x) node.right = delete(node.right,x);
        else{
            if(node.left==null && node.right==null) return null;
            else if(node.left==null) return node.right;
            else if(node.right==null) return node.left;
            else{
                node.val = findMin(node.right);
                node.right = delete(node.right,node.val);
            }
        }
        return node;
    }

    public int findMin(Node node){
        int min = node.val;
        while(node.left!=null)
        {
            min = node.val; node = node.left;
        }
        return min;
    }

    public void inOrder(Node node)
    {
        if(node ==null) return;
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    public void preOrder(Node node)
    {
        if(node ==null) return;
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder(Node node)
    {
        if(node ==null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }

    public ArrayList<Integer> inArray(Node node, ArrayList<Integer> list)
    {
        if(node==null) return list;
        inArray(node.left,list);
        list.add(node.val);
        inArray(node.right,list);
        return list;
    }



}
