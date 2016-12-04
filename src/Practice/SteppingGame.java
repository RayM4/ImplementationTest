package Practice;

import java.util.ArrayList;


public class SteppingGame {
    public static boolean isWinnable(ArrayList<Integer> arr, int steps) {
        int position = 0;
        while (position < arr.size()) {
            if (arr.get(position) > 0) {
                return false;
            }
            if (steps > 0) {
                if (stepToEnd(arr, position, steps)) {
                    return true;
                } else if (stepBackAndFoward(arr, position, steps)) {
                    return true;
                }
            }
            position++;
        }
        return true;
    }

    private static boolean stepToEnd(ArrayList<Integer> arr, int pos, int steps) {
        //base case
        if (pos + steps >= arr.size()-1) {
            return true;
        }

        //case 2
        if (arr.get(pos+steps) > 0) {
            return false;
        }


        return stepToEnd(arr, pos+steps, steps);
    }

    private static boolean stepBackAndFoward(ArrayList<Integer> arr, int pos, int steps) {
        ArrayList<Integer> idx = new ArrayList<>();
        int curr = pos;
        while((curr-1 > 0) && (arr.get(curr-1) > 0)) {
            idx.add(curr-1);
            curr--;
        }
        for (int i : idx) {
            if (stepToEnd(arr, i, steps)) {
                return true;
            }
        }
        return false;
    }
}
