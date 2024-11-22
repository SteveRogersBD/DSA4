package org.example;

public class MaxHeapHelper {

    public static int KthLargest(int k,int []arr, MaxHeap maxHeap) {
        k=k-1;
        for(int i=0;i<k;i++)
        {
            maxHeap.extractMax();
        }
        return maxHeap.maximum();
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();

        int[] array = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9};

        maxHeap.buildHeap(array);
        System.out.println("Heap after building:");
        maxHeap.printHeap();


        System.out.println(KthLargest(4,array,maxHeap));
    }
}
