package student.demo.pro.parcticePro.Advie;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import student.demo.pro.parcticePro.ExceptionHandling.ExceptionResponse;
import student.demo.pro.parcticePro.ExceptionHandling.ResourceNotFoundException;
import student.demo.pro.parcticePro.ExceptionHandling.nameException;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class MyController {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)

    public @ResponseBody ExceptionResponse handleResourceNotFound(final ResourceNotFoundException exception,
                                                                  final HttpServletRequest request) {

      ExceptionResponse exceptionResponse=new ExceptionResponse();
        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(exception.getMessage());
        error.callerURL(request.getRequestURI());
        //error.setStatuscode(HttpStatus.NOT_FOUND.toString());
        error.setStatuscode("300");
       error.setErrormsg("id not found");
        return error;

   }

    @ExceptionHandler(nameException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody ExceptionResponse handlenameException(final nameException exception,
                                                                  final HttpServletRequest request) {

        ExceptionResponse exceptionResponse=new ExceptionResponse();
        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(exception.getMessage());
        error.callerURL(request.getRequestURI());
        //error.setStatuscode(HttpStatus.NOT_FOUND.toString());
        error.setStatuscode("301");

        return error;

    }


}
