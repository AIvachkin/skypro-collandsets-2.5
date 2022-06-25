package pro.sky.skyprocollandsets25;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/employee")

public class EmployeeController {

    public EmployeeController(EmployeeService employeeService) {
    }

    @GetMapping("/add")
    public Object add(@RequestParam(value = "firstName", required = false) String a,
                      @RequestParam(value = "lastName", required = false) String b)
            throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException, EmployeeNotFoundException {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Оба параметра должны быть переданы";
        }
        return EmployeeService.addPerson(a, b);
    }


    @GetMapping("/remove")
    public Object remove(@RequestParam(value = "firstName", required = false) String a,
                      @RequestParam(value = "lastName", required = false) String b)
            throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException, EmployeeNotFoundException {
        if (Objects.isNull(a) || Objects.isNull(b)){
            return "Оба параметра должны быть переданы" ;
        }
        return EmployeeService.deletePerson(a, b);
    }

    @GetMapping("/find")
    public Object find(@RequestParam(value = "firstName", required = false) String a,
                         @RequestParam(value = "lastName", required = false) String b)
            throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException, EmployeeNotFoundException {
        if (Objects.isNull(a) || Objects.isNull(b)){
            return "Оба параметра должны быть переданы" ;
        }
        return EmployeeService.findPerson(a, b);
    }

    @GetMapping("/print")
    public Object print (){
        return EmployeeService.print();
    }
//}

}