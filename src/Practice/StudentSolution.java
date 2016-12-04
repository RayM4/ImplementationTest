package Practice;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by ray on 12/4/2016.
 */
public class StudentSolution {

    public static void test() {
        Scanner in = new Scanner(System.in);
        int totalEvents = Integer.parseInt(in.nextLine());
        PriorityQueue<Student> pq = new PriorityQueue<>();
        while(totalEvents>0){
            String event = in.next();

            if (event.equals("ENTER")) {
                String name = in.next();
                double gpa = in.nextFloat();
                int token = in.nextInt();
                Student s = new Student(token, name, gpa);
                pq.offer(s);
            } else if (event.equals("SERVED")) {
                pq.poll();
            }

            totalEvents--;
        }

        while(pq.peek() != null) {
            System.out.println(pq.remove().getFname());
        }
    }
}
