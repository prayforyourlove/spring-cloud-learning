package com.dzsw.wqh.handler;

import com.dzsw.wqh.protocol.ResultResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author chen.haisheng
 * @create 2018-08-24 10:31
 **/

@ControllerAdvice
public class GlobalExceptionHandler
{

	@ExceptionHandler(value = BindException.class)
	@ResponseBody
	public ResultResponse bindExceptionErrorResponse(
			BindException exception)
	{
		BindingResult bindingResult = exception.getBindingResult();
		List<FieldError> errors = bindingResult.getFieldErrors();
		StringBuilder errorMessage = new StringBuilder();

		for (FieldError error : errors)
		{
			errorMessage.append("[" + error.getField() + "] "
					+ error.getDefaultMessage() + " ");
		}
		return new ResultResponse().setCode("error")
				.setMessage(errorMessage.toString());
	}

	@ExceptionHandler(value = UnsatisfiedServletRequestParameterException.class)
	@ResponseBody
	public ResultResponse requestParameterExceptionErrorResponse(
			UnsatisfiedServletRequestParameterException exception)
	{
		return new ResultResponse().setCode("error")
				.setMessage(exception.getMessage());
	}
}
