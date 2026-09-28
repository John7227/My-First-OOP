package student;

public class Student {

    private String name;
    private int gradeLevel;

    public Student(String name, int gradeLevel) {
        this.name = name;
        this.gradeLevel = gradeLevel;
    }

    public String introduce() {
        return "My Name is " + name + "," + " and I am in grade " + gradeLevel;
    }

    public int promote() {
        if(gradeLevel >= 1 && gradeLevel < 12)
            return gradeLevel += 1;

        return gradeLevel;
    }

    public boolean has_passed(int score) {
        if(score >= 50)
            return true;

        return false;
    }

    public String update_name(String name) {
        return this.name = name;
    }

    public boolean is_graduating() {
        return gradeLevel == 12;
    }
}
