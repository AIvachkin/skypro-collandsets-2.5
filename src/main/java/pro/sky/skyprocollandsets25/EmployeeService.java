package pro.sky.skyprocollandsets25;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private static Object Employee;
    static int lengthList = 10;
    static List<Employee> employees = new ArrayList<>(List.of(

            new Employee("Сидор", "Сидоров"),
            new Employee("Алла", "Николаева"),
            new Employee("Наталья", "Фролова"),
            new Employee("Василий", "Уткин"),
            new Employee("Сергей", "Медведев"),
            new Employee("Олег", "Антонов"),
            new Employee("Анатолий", "Москвин"),
            new Employee("Оксана", "Федорова")

    ));

    static Object deletePerson(String firstName, String lastName) throws EmployeeNotFoundException {
        for (int i = 0; i < employees.size(); i++) {
            if (firstName.equals(employees.get(i).getFirstName()) &&
                    lastName.equals(employees.get(i).getLastName())) {
                Object temp = employees.get(i);
                employees.remove(i);
                return temp;
            } else if (i == employees.size() - 1) {
                throw new EmployeeNotFoundException("Сотрудник не найден");
            }
        }
        return null;
    }


    public static Object addPerson(String firstName, String lastName)
            throws EmployeeStorageIsFullException, EmployeeNotFoundException,
            EmployeeAlreadyAddedException {


        for (pro.sky.skyprocollandsets25.Employee employee : employees) {
            if
//            (employees.get(i).getFirstName() == null && employees.get(i).getLastName() == null) {
//            } else if
            (firstName.equals(employee.getFirstName()) &&
                    lastName.equals(employee.getLastName())) {
                throw new EmployeeAlreadyAddedException("В массиве уже есть такой сотрудник");
            }
        }

//        for (int j = 0; j < lengthList; j++) {
        if (employees.size() < lengthList) {
            int index = employees.size();
//            (employees.get(j).getFirstName() == null && employees.get(j).getLastName() == null) {
            employees.add(new Employee(firstName, lastName));
            return employees.get(index);
        } else
//                if (j == employees.size() - 1)
        {
            throw new EmployeeStorageIsFullException("Массив сотрудников переполнен");
        }
    }


    public static Object findPerson(String firstName, String lastName) throws EmployeeNotFoundException
//            throws EmployeeNotFoundException
    {
        for (int i = 0; i < employees.size(); i++) {
            if  (firstName.equals(employees.get(i).getFirstName()) &&
                    lastName.equals(employees.get(i).getLastName())) {
//                System.out.println("Сотрудник, " + employees[i] + ", найден.");
                return employees.get(i);
//                return "Сотрудник, " + fullName[i] + ", найден.";
            } else if (i == employees.size() - 1) {
                throw new EmployeeNotFoundException("Сотрудник не найден");
            }
        }
        return null;
    }


    public static Object print() {
//        for (int i = 0; i < employees.size(); i++) {
//            System.out.println(employees.get(i));
//        System.out.println(employees);
        return employees;
    }
}




