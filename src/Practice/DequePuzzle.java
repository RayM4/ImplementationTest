package Practice;

import java.util.*;

/**
 * Created by ray on 12/4/2016.
 */
public class DequePuzzle {
    public static void solvePuzzle() {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        int max = 0;
        Set<Object> set = new HashSet<>();

        if (m > 0) {
            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                if (deque.size() == m) {
                    int size = set.size();
                    if (size > max) {
                        max = size;
                    }
                    Object popped = deque.removeFirst();
                    if (!(deque.contains(popped))) {
                        set.remove(popped);
                    }
                }
                deque.add(num);
                set.add(num);
            }
        }

        System.out.println(max);
    }
}


