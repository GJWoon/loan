package com.june.loan.exception;

import com.june.loan.dto.ResponseDTO;
import com.june.loan.dto.ResultObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Slf4j
@RestControllerAdvice
public class APIExceptionHandler extends RuntimeException {

  @ExceptionHandler(BaseException.class)
  protected ResponseDTO<ResultObject> handleBaseException(BaseException e,
                                                          HttpServletRequest request, HttpServletResponse response) {
    log.error(e.getMessage(), e);
    return new ResponseDTO<>(e);
  }
}
