package workshop3.task2;

import workshop3.task1.Employee;

public class Manager extends Employee {

    private static final String POSITION = "Руководитель";

    public Manager(String name, String position, long phoneNumber, int salary, int age) {
        super(name, position, phoneNumber, salary, age);
    }

    public static void raiseSalary(Employee[] original, int bonus) {
        for (Employee emp : original
        ) {
            if (!emp.getPosition().equals(POSITION)) emp.setSalary(emp.getSalary() + bonus);
        }
    }
}
