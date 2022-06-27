package pro.sky.skyprocollandsets25.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprocollandsets25.EmployeeAlreadyAddedException;
import pro.sky.skyprocollandsets25.exception.EmployeeNotFoundException;
import pro.sky.skyprocollandsets25.exception.EmployeeStorageIsFullException;
import pro.sky.skyprocollandsets25.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {
    private static final int LIMIT = 10;
    private final List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);
//        int index = -1;
//        for (int i = 0; i < employees.length; i++) {
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
//            if (Objects.isNull(employees[i])) {
//                index = i;
//                break;
//            }
//        }
//        if (index != -1) {
//            return employees[index] = employee;
//        }
        if (employees.size() < LIMIT) {
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee findEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);
//        for (Employee emp : employees) {
//            if (Objects.equals(emp, employee)) {
//                return employee;
//            }
//        }
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Employee removeEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);
//        for (int i = 0; i < employees.length; i++) {
//            if (Objects.equals(employees[i], employee)) {
//                employees[i] = null;
//                return employee;
//            }
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        throw new EmployeeNotFoundException();
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees) ;
    }
}