import java.util.Scanner;

public class SalaryAnalysis {
    static double TotalPayroll(double[] salary) {
        double total = 0;
        for (int i = 0; i < salary.length; i++) {
            total += salary[i];
        }
        System.out.println("Total Payroll: " + total);
        return total;
        
    }
    static double AverageSalary(double totalPayroll, double[] salary) {
        double average = totalPayroll / salary.length;
        System.out.printf("Average Salary: %.2f\n", average);
        return average;
    }
    static void HighestSalary(double[] salary){
        double highest = salary[0];
        int emp_no = 0;
        for (int i = 1; i < salary.length; i++) {
            if (salary[i] > highest) {
                highest = salary[i];
                emp_no = i+1;
            }
        }
        System.out.println("Highest Salary: " + highest + " Employee no. : "+ emp_no);
    }
    static void LowestSalary(double[] salary){
        double lowest = salary[0];
        int emp_no = 0;
        for (int i = 1; i < salary.length; i++) {
            if (salary[i] < lowest) {
                lowest = salary[i];
                emp_no = i+1;
            }
        }
        System.out.println("Lowest Salary: " + lowest + " Employee no. : "+ emp_no);
    }
    static void EarningAboveavg(double avg, double[] salary){
        int count = 0;
        for (int i = 0; i < salary.length; i++) {
            if (salary[i] > avg) {
                count++;
            }
        }
        System.out.println("Employees earning above avg are: "+ count);
    }
    static void EarningWithinavg(double[] salary, double avg){
        int count = 0;
        for(int i=0; i < salary.length; i++){
            if(salary[i] < avg-5000 || salary[i] > avg + 5000){
                count++;
            }
        }
        System.out.println("Employees earning Within Rs.5000 of Average:"+ count);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of employees");
        int n = sc.nextInt();
        double[] salary = new double[n];
        System.out.println("Enter the salaries of the employees");
        for (int i = 0; i < n; i++) {
            System.out.println("Salary of employee " + (i + 1) + ": ");
            salary[i] = sc.nextDouble();
        }
        double totalPayroll = TotalPayroll(salary);
        double avg = AverageSalary(totalPayroll, salary);
        HighestSalary(salary);
        LowestSalary(salary);
        EarningAboveavg(avg, salary);
        EarningWithinavg(salary, avg);
        sc.close();
    }
}
