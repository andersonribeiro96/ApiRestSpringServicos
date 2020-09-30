package com.anderson.servicos.web.rest.dto;

import com.anderson.servicos.web.rest.dto.exception.ApiErros;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handlerValidationError(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        List<String> messages = bindingResult.getAllErrors()
                .stream()
                .map(objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());
        return new ApiErros(messages);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity handlerResponserStatusException(ResponseStatusException exception){
        String mensagemError = exception.getMessage();
        HttpStatus codigoStatus = exception.getStatus();
        ApiErros apiErros = new ApiErros(mensagemError);
        return new ResponseEntity(apiErros, codigoStatus);
    }

}
