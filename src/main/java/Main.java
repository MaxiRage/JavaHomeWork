public class Main {
    public static void main(String[] args) {

        Employee employee1 = new Employee("Max", 646416, "1234567890", 10);
        Employee employee2 = new Employee("Rage", 12365, "9876548210", 1);

        EmployeeDirectory employeeDirectory = new EmployeeDirectory();

        try {
            employeeDirectory.addEmployee(employee1);
            System.out.println("Новый сотрудник добавлен: " + employee1.getName());
            employeeDirectory.addEmployee(employee2);
            System.out.println("Новый сотрудник добавлен: " + employee2.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            System.out.println("Опытные сотрудники: " +
                    employeeDirectory.findByExperience(10));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            System.out.println("Телефон сотрудника Max: " +
                    employeeDirectory.findPhone("Max"));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Employee employee = employeeDirectory.findByTable(12365);
            if (employee != null)
                System.out.println("Сотрудник к табелем 12365: " + employee.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}