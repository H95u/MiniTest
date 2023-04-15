public class Student extends Person {
    private double avgPoint;

    public Student() {
    }

    public Student(String name, int age, double avgPoint) {
        super(name, age);
        this.avgPoint = avgPoint;
    }

    public double getAvgPoint() {
        return avgPoint;
    }

    public void setAvgPoint(double avgPoint) {
        this.avgPoint = avgPoint;
    }

    @Override
    public String toString() {
        return super.toString() +
                "avgPoint=" + avgPoint +
                '}';
    }
}
