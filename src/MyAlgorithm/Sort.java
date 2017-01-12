package MyAlgorithm;

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
            //sort subArray left of pivot
            normalQSort(arr, left, idx - 1);
            //sort subArray right of pivot
            normalQSort(arr, idx + 1, right);
        }
    }

    private static int normalPartition(int[] arr, int left, int right) {
        //pivot value
        int pivot = arr[right];
        //pivot's index
        int hold = left;
        //iterate through unsorted
        for (int i = left; i < right; i++) {
            //if value less than pivot value
            if (arr[i] <= pivot) {
                //move value to left side
                swap(arr, hold, i);
                hold++;
            }
        }
        //put the pivot value at the end of the sorted subarray
        swap(arr, hold, right);
        //return index of the pivot
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
            //find midpoint
            int mid = low + ((high-low) / 2);
            //split left subArray
            mergeSort(arr, low, mid);
            //split right subArray
            mergeSort(arr, mid+1, high);
            //merge both subArrays
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = copyArr(arr);

        //left subArray pointer
        int i = low;
        //new subArray pointer
        int k = low;
        //right subArray pointer
        int j = mid+1;

        while (i <= mid && j <= high) {
            //if left subArray element is less than 
            //or equal to right subArray element
            //set left element to merged subArray
            //else set right element to merged subArray
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            //iterate pointing to original array
            k++;
        }

        //if elements on left remain dump them to
        //the right of new merged array
        while (i <= mid) {
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

    //copy array
    private static int[] copyArr(int[] arr) {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length;i++)
            temp[i] = arr[i];
        return temp;
    }
}

