package MyAlgorithm;

import java.util.Random;

/**
 * Created by ray on 12/5/2016.
 */
public class Sort {
    public Sort() {}

    //bubble sort
    public int[] bubbleSort(int[] arr) {
        boolean switching;
        do {
            switching = false;
            int indexOfLastUnsortedElement = arr.length;
            for (int i = 0; i < indexOfLastUnsortedElement-1; i++) {
                if (arr[i] > arr[i+1]) {
                    swap(arr, i, i+1);
                    switching = true;
                }
            }
        } while (switching);

        return arr;
    }

    //normal quick sort
    public void normalQSort(int[] arr, int left, int right) {
        if (left < right) {
            int idx = normalPartition(arr, left, right);
            normalQSort(arr, left, idx - 1);
            normalQSort(arr, idx + 1, right);
        }
    }

    private int normalPartition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int hold = left;
        for (int i = left; i < right; i++) {
            if (arr[i] <= pivot) {
                swap(arr, hold, i);
                hold++;
            }
        }
        swap(arr, hold, right);
        return hold;
    }


    //random pivot quick sort
    public void randQSort(int[] arr, int left, int right) {
        if (left < right) {
            int idx = partition(arr, left, right);
            randQSort(arr, left, idx - 1);
            randQSort(arr, idx + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = selectPivot(left, right);
        swap(arr, pivot, right);
        pivot = right;
        int storedIndex = left;

        for (int i = storedIndex; i < right; i++) {
            if (arr[i] <= arr[pivot]) {
                swap(arr, i, storedIndex);
                storedIndex++;
            }
        }
        swap(arr, storedIndex, pivot);
        return storedIndex;
    }

    private int selectPivot(int low, int high) {
        Random rand = new Random();
        return rand.nextInt((high-low) + 1) + low;
    }

    private void swap(int[] arr, int a, int b) {
        int hold = arr[a];
        arr[a] = arr[b];
        arr[b] = hold;
    }

}

