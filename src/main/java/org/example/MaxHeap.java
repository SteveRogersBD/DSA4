package org.example;

import java.util.ArrayList;

public class MaxHeap {

    private ArrayList<Integer> heap;

    // Constructor to initialize the MaxHeap
    public MaxHeap() {
        heap = new ArrayList<>();
    }

    // Parent index of node at i
    private int parent(int i) {
        return (i - 1) / 2;
    }

    // Left child index of node at i
    private int left(int i) {
        return 2 * i + 1;
    }

    // Right child index of node at i
    private int right(int i) {
        return 2 * i + 2;
    }

    // Heapify the node at index i
    private void maxHeapify(int i) {
        int largest = i;
        int leftChild = left(i);
        int rightChild = right(i);

        // Check if left child is larger than current node
        if (leftChild < heap.size() && heap.get(leftChild) > heap.get(largest)) {
            largest = leftChild;
        }

        // Check if right child is larger than the largest so far
        if (rightChild < heap.size() && heap.get(rightChild) > heap.get(largest)) {
            largest = rightChild;
        }

        // If largest is not the root
        if (largest != i) {
            // Swap the values
            int temp = heap.get(i);
            heap.set(i, heap.get(largest));
            heap.set(largest, temp);

            // Recursively heapify the affected subtree
            maxHeapify(largest);
        }
    }

    // Build a max-heap from an array
    public void buildHeap(int[] array) {
        for (int value : array) {
            heap.add(value);
        }
        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    // Get the maximum value
    public int maximum() {
        if (heap.size() == 0) {
            throw new IllegalStateException("Heap is empty.");
        }
        return heap.get(0);
    }

    // Extract the maximum value and maintain the max-heap property
    public int extractMax() {
        if (heap.size() == 0) {
            throw new IllegalStateException("Heap is empty.");
        }

        // The root is the maximum element
        int max = heap.get(0);

        // Move the last element to the root and remove the last element
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        // Restore the max-heap property
        maxHeapify(0);

        return max;
    }

    // Increase the value of an element at index i
    public void increaseKey(int i, int newValue) {
        if (newValue < heap.get(i)) {
            throw new IllegalArgumentException("New value is smaller than the current value.");
        }

        heap.set(i, newValue);

        // Maintain heap property by moving the element up
        while (i > 0 && heap.get(parent(i)) < heap.get(i)) {
            int temp = heap.get(i);
            heap.set(i, heap.get(parent(i)));
            heap.set(parent(i), temp);

            i = parent(i);
        }
    }

    // Insert a new value into the max-heap
    public void insert(int value) {
        // Add a very small value at the end of the heap
        heap.add(Integer.MIN_VALUE);

        // Increase its value to the actual value
        increaseKey(heap.size() - 1, value);
    }

    // Print the heap as an array
    public void printHeap() {
        System.out.println(heap);
    }

    // Main method to test the MaxHeap implementation
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();

        int[] array = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9};

        maxHeap.buildHeap(array);
        System.out.println("Heap after building:");
        maxHeap.printHeap();

        for(int i=0;i<2;i++)
        {
            maxHeap.extractMax();
        }
        System.out.println("Kth largest: "+maxHeap.maximum());
    }
}
