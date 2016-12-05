package MyAlgorithm;

import java.util.Random;

/**
 * Created by ray on 12/5/2016.
 */
public class Sort {
    public Sort() {}

    public int[] bubbleSort(int[] arr) {
        boolean switching;
        do {
            switching = false;
            int indexOfLastUnsortedElement = arr.length;
            for (int i = 0; i < indexOfLastUnsortedElement-1; i++) {
                if (arr[i] > arr[i+1]) {
                    int hold = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = hold;
                    switching = true;
                }
            }
        } while (switching);

        return arr;
    }

    public void RandQSort(int[] arr, int left, int right) {
        int idx = partition(arr, left, right);
        if (left < idx-1)
            RandQSort(arr, left, idx);
        if (idx < right)
            RandQSort(arr, idx, right);
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = selectPivot(left, right);
        int storedIndex = left+1;
        swap(arr, pivot, left);
        pivot = left;
        for (int i = left+1; i < right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, storedIndex);
                storedIndex++;
            }
        }
        swap(arr, storedIndex-1, pivot);
        return storedIndex;
    }

    private void swap(int[] arr, int a, int b) {
        int hold = arr[a];
        arr[a] = arr[b];
        arr[b] = hold;
    }

    public int selectPivot(int low, int high) {
        Random rand = new Random();
        return rand.nextInt((high-low) + 1) + low;
    }

}

