package Practice;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ray on 12/3/2016.
 */
public class DataStructureExtender {
    public static int greatestHourglass(int arr[][], int xLen, int yLen) {
        int greatestSum = Integer.MIN_VALUE;
        int tempSum;

        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (i+2 < xLen && j+2 < yLen) {
                    tempSum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                    if (tempSum > greatestSum) {
                        greatestSum = tempSum;
                    }
                }
            }
        }

        return greatestSum;
    }

    public static ArrayList<Integer[]> allContiuousSubArrays(int arr[]) {
        ArrayList<Integer[]> data = new ArrayList<>();

        //data.add(arr);

        for (int i = 0;i < arr.length; i++) {
            Integer[] single = {arr[i]};
            data.add(single);

            ArrayList<Integer> tempArr = new ArrayList<>();
            tempArr.add(arr[i]);

            for (int j = i+1 ; j < arr.length; j++) {
                tempArr.add(arr[j]);
                data.add(tempArr.toArray(new Integer[tempArr.size()]));
            }
        }

        return data;
    }

    public static int maxUniqueFromArrayList(ArrayList<Integer> arr, int subArraySize) {
        int max = 0;
        for (int i = 0; i+subArraySize < arr.size(); i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < subArraySize; j++) {
                set.add(arr.get(i+j));
            }
            if (set.size() > max) {
                max = set.size();
            }
        }
        return max;
    }

    public static int numOfUniques(Deque deque) {
        Set<Object> set = new HashSet<>();
        while (deque.peek() != null) {
            set.add(deque.pop());
        }
        return set.size();
    }

}
