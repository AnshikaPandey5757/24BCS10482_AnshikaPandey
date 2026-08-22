import java.util.*;
class Employee {
    int id;
    String name;
    double salary;
    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    double getSalary() {
        return salary;}
}
public class SalaryAnalytics {
    public static void main(String[] args) {
        List<Employee> list = Arrays.asList(
            new Employee(101, "Alice", 120000),
            new Employee(102, "Bob", 120000),
            new Employee(103, "Charlie", 95000),
            new Employee(104, "David", 80000),
            new Employee(105, "Emma", 45000));
        double high = list.stream()
                .map(Employee::getSalary)
                .max(Double::compare)
                .get();
        double last = list.stream()
                .map(Employee::getSalary)
                .min(Double::compare)
                .get();
        double sechigh = list.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Collections.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println("Highest Salary= " + high);
        System.out.println("2nd Highest Salary= " + sechigh);
        System.out.println("Lowest Salary= " + last);
    }
}
