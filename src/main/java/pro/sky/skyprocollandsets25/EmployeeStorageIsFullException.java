package pro.sky.skyprocollandsets25;

import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class EmployeeStorageIsFullException extends RuntimeException {

    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
