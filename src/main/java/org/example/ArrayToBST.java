package org.example;


import java.util.ArrayList;

public class ArrayToBST {

    public static BST buildBST(int []arr)
    {
        BST bst = new BST(arr[0]);
        for(int i=1;i<arr.length;i++)
        {
            bst.insert(bst.getRoot(),arr[i]);
        }
        return bst;
    }

    public static int emni(BST bst,int k)
    {
        BST.Node root = bst.getRoot();
        ArrayList<Integer>ans = bst.inArray(root,new ArrayList<>());
        if(ans==null) return -1;
        if(ans.size()<k) return k;
        int N = ans.size();
        return ans.get(N-k);
    }
    public static void main(String[] args) {

        int []arr = {7, 10, 4, 3, 20, 15};
        int[] array = {2, 5, 9, 6, 8, 20, 10, 12, 18, 9};
        BST bst = buildBST(arr);
        System.out.println(emni(bst,3));
    }
}
