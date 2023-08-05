package workshop3.task1;

public class Service {

    public void printEmpArray(Employee[] empOriginal) {
        for (Employee employee : empOriginal
        ) {
            System.out.print(employee);
            System.out.printf("*".repeat(33) + "%n");
        }
    }
}
