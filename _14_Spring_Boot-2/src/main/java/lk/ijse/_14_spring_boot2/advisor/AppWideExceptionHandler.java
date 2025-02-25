package lk.ijse._14_spring_boot2.advisor;

import lk.ijse._14_spring_boot2.util.ResponseUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@CrossOrigin
public class AppWideExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseUtil exceptionHandler(Exception e){
        return new ResponseUtil(
                500,e.getMessage(),null
        );
    }
}
