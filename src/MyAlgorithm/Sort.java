package MyAlgorithm;

import a.j.m.P;

import java.util.Random;

public class Sort {
    //bubble sort
    public static int[] bubbleSort(int[] arr) {
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
    public static void normalQSort(int[] arr, int left, int right) {
        if (left < right) {
            int idx = normalPartition(arr, left, right);
            normalQSort(arr, left, idx - 1);
            normalQSort(arr, idx + 1, right);
        }
    }

    private static int normalPartition(int[] arr, int left, int right) {
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
    public static void randQSort(int[] arr, int left, int right) {
        if (left < right) {
            int idx = qPartition(arr, left, right);
            randQSort(arr, left, idx - 1);
            randQSort(arr, idx + 1, right);
        }
    }

    private static int qPartition(int[] arr, int left, int right) {
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

    private static int selectPivot(int low, int high) {
        Random rand = new Random();
        return rand.nextInt((high-low) + 1) + low;
    }

    //merge sort
    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + ((high-low) / 2);
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[arr.length];
        System.arraycopy(arr,0,temp, 0, arr.length);

        int i = low;
        int j = mid+1;
        int k = low;

        while(i<= mid && j <= high) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        while(i <= mid) {
            arr[k] = temp[i];
            k++;
            i++;
        }
    }


    //swap function
    private static void swap(int[] arr, int a, int b) {
        int hold = arr[a];
        arr[a] = arr[b];
        arr[b] = hold;
    }

}

