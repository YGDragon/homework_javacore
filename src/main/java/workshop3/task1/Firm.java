package workshop3.task1;

public class Firm {
    public static void main(String[] args) {
        int[] raiseData = {45, 5000};//возраст сотрудников, зарплата
        Employee[] employees = {
                new Employee(
                        "Сикорский Дмитрий Валерьевич",
                        "Ведущий иженер",
                        375297065112L,
                        85000,
                        40),
                new Employee(
                        "Шкирман Сергей Егорович",
                        "Слесарь по КИПиА",
                        375332358812L,
                        54000,
                        25),
                new Employee("Андриевский Александр Михайлович",
                        "Приборист",
                        375292311235L,
                        61500,
                        49),
                new Employee("Павлов Константин Васильевич",
                        "Инженер-электроник",
                        375332341277L,
                        73000,
                        32),
                new Employee("Колос Федор Николаевич",
                        "Инженер-электроник",
                        375294425661L,
                        73000,
                        47)};
        View view = new View();
        Service service = new Service();
        while (true) {
            view.menuMessage();
            switch (view.selectActionMenu()) {
                case (1) -> service.printEmpArray(employees);//вывод данных о всех сотрудниках
                case (2) -> {//повышение зарплаты сотрудникам метод1
                    for (Employee emp : employees
                    ) {
                        emp.raiseSalary(raiseData[0], raiseData[1]);
                    }
                }
                case (3) -> {//повышение зарплаты сотрудникам метод2
                    Employee.raiseSalary(employees, raiseData[0], raiseData[1]);
                }
                case (4) -> {//средняя зарплата
                    view.salaryAverageMessage(
                            Employee.calculateAverageSalary(employees)
                    );
                }
                case (5) -> {//средний возраст
                    view.ageAverageMessage(
                            Employee.calculateAverageAge(employees)
                    );
                }
                default -> System.exit(0);
            }
        }
    }
}
