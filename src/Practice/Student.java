package Practice;

/**
 * Created by ray on 12/4/2016.
 */
class Student implements Comparable<Student>{
    private int token;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.token = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getToken() {
        return token;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }

    @Override
    public int compareTo(Student s) {
        if (s.getCgpa() == cgpa) {
            int nameCompare = s.getFname().compareTo(fname);
            if (nameCompare == 0) {
                if (s.getToken() > token) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (nameCompare > 0) {
                return -1;
            } else {
                return 1;
            }
        } else if (s.getCgpa() > cgpa) {
            return 1;
        }
        return -1;
    }
}
