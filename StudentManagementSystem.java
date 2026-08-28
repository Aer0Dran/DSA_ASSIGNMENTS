public class StudentManagementSystem {

    // Static counter for generating roll numbers
    static int rollCounter = 1;

    // Method to enroll a student
    static void enrollStudent(String name, String course) {
        String rollNumber = course.toUpperCase() + "_" +
                            String.format("%03d", rollCounter);

        System.out.println("Student Enrolled Successfully!");
        System.out.println("Name       : " + name);
        System.out.println("Course     : " + course);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println();

        rollCounter++;
    }

    // Overloaded method 1: Base fee
    static double calculateFee(String course) {

        if (course.equalsIgnoreCase("Java"))
            return 15000;

        else if (course.equalsIgnoreCase("Python"))
            return 12000;

        else if (course.equalsIgnoreCase("DataScience"))
            return 20000;

        else
            return 0;
    }

    // Overloaded method 2: Fee with scholarship
    static double calculateFee(String course, boolean hasScholarship) {

        double fee = calculateFee(course);

        if (hasScholarship) {
            fee = fee - (fee * 0.20);
        }

        return fee;
    }

    // Overloaded method 3: Scholarship + late fee
    static double calculateFee(String course,
                               boolean hasScholarship,
                               boolean isLate) {

        double fee = calculateFee(course, hasScholarship);

        if (isLate) {
            fee = fee + 500;
        }

        return fee;
    }

    // Method to calculate average marks
    static double calculateAverage(int[] marks) {

        int sum = 0;

        for (int mark : marks) {
            sum = sum + mark;
        }

        return (double) sum / marks.length;
    }

    // Method to determine grade
    static String determineGrade(double average) {

        if (average >= 90)
            return "A";

        else if (average >= 75)
            return "B";

        else if (average >= 60)
            return "C";

        else if (average >= 50)
            return "D";

        else
            return "F";
    }

    // Method to print student report
    static void printReport(String name,
                            String course,
                            double fee,
                            double average,
                            String grade) {

        System.out.println("======================================");
        System.out.println("          STUDENT REPORT");
        System.out.println("======================================");
        System.out.println("Name       : " + name);
        System.out.println("Course     : " + course);
        System.out.println("Fee        : Rs. " + fee);
        System.out.println("Average    : " + average);
        System.out.println("Grade      : " + grade);
        System.out.println("======================================");
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {

        // ---------------- STUDENT 1 ----------------
        String name1 = "Rahul";
        String course1 = "Java";

        enrollStudent(name1, course1);

        double fee1 = calculateFee(course1);
        int[] marks1 = {85, 90, 78, 88, 92};

        double average1 = calculateAverage(marks1);
        String grade1 = determineGrade(average1);

        printReport(name1, course1, fee1, average1, grade1);


        // ---------------- STUDENT 2 ----------------
        String name2 = "Priya";
        String course2 = "Python";

        enrollStudent(name2, course2);

        double fee2 = calculateFee(course2, true);
        int[] marks2 = {95, 88, 91, 90, 94};

        double average2 = calculateAverage(marks2);
        String grade2 = determineGrade(average2);

        printReport(name2, course2, fee2, average2, grade2);


        // ---------------- STUDENT 3 ----------------
        String name3 = "Amit";
        String course3 = "DataScience";

        enrollStudent(name3, course3);

        double fee3 = calculateFee(course3, true, true);
        int[] marks3 = {72, 68, 75, 70, 74};

        double average3 = calculateAverage(marks3);
        String grade3 = determineGrade(average3);

        printReport(name3, course3, fee3, average3, grade3);
    }
}