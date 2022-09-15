package students;

public class Student {
    // характеристики:
    private String firstName;
    private String lastName;
    private double grade;

    // конструктор:
    public Student (String firstName, String lastName, double grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    // методи:
    public double getGrade (){
        return this.grade;
    }
    @Override
    public String toString (){
        return String.format("%s %s: %.2f", this.firstName, this.lastName, this.grade);
    }
}
