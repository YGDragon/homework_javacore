package workshop3.task1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

@AllArgsConstructor
@Data
public class Employee {
    private String name;
    private String position;
    private long phoneNumber;
    private int salary;
    private int age;

    public void raiseSalary(int age, int bonus) {
        if (this.age > age) setSalary(salary + bonus);
    }

    public static void raiseSalary(Employee[] original, int age, int bonus) {
        for (Employee emp : original
        ) {
            if (emp.age > age) emp.setSalary(emp.salary + bonus);
        }
    }

    public static double calculateAverageAge(Employee[] original) {
        return Arrays.stream(original).mapToDouble(x -> x.age).reduce(Double::sum).stream().sum() / original.length;
    }

    public static double calculateAverageSalary(Employee[] original) {
        return Arrays.stream(original).mapToDouble(x -> x.salary).reduce(Double::sum).stream().sum() / original.length;
    }

    @Override
    public String toString() {
        return String.format(
                "ФИО - %s%n" +
                        "Должность - %s%n" +
                        "Номер телефона - %d%n" +
                        "Зарплата - %d%n" +
                        "Возраст - %d%n", name, position, phoneNumber, salary, age);
    }
}
