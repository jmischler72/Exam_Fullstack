package fr.polytech.backend_exam.config;

import fr.polytech.backend_exam.dto.response.ErrorMessageDto;
import fr.polytech.backend_exam.exception.ResourceAlreadyExistException;
import fr.polytech.backend_exam.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
@Slf4j
public class ExceptionConfig {

    Logger logger = LoggerFactory.getLogger(ExceptionConfig.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ErrorMessageDto internalServerError(Exception ex) {
        this.logger.error(ex.getMessage(), ex);
        return ErrorMessageDto.builder().code("INTERNAL_ERROR").message("An internal error occurred").build();
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorMessageDto resourceNotFound(ResourceNotFoundException ex) {
        return ErrorMessageDto.builder().code("NOT_FOUND").message(ex.getMessage()).build();
    }

    @ExceptionHandler(value = ResourceAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorMessageDto resourceNotFound(ResourceAlreadyExistException ex) {
        return ErrorMessageDto.builder().code("RESOURCE_ALREADY_EXIST").message(ex.getMessage()).build();
    }

}
