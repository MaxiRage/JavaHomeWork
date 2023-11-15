import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EmployeeDirectory {
    private List<Employee> employeeList;

    public EmployeeDirectory() {
        this.employeeList = new ArrayList<>();
    }

    public List<Employee> findByExperience(int experience) {
        if (experience < 0)
            throw new IllegalArgumentException("Отрицательный стаж");
        return employeeList.stream()
                .filter(employee -> employee.getExperience() == experience)
                .toList();
    }

    public List<String> findPhone(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Пустое имя");
        return employeeList.stream()
                .filter(employee -> employee.getName().equals(name))
                .map(Employee::getPhone)
                .toList();
    }

    public Employee findByTable(long table) {
        return employeeList.stream()
                .filter(employee -> employee.getTable() == table)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Не найден сотрудник с табелем " + table));
    }

    public void addEmployee(Employee employee) {
        if (employee != null)
            employeeList.add(employee);
    }
}