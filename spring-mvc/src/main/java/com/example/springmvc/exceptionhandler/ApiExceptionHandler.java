package com.example.springmvc.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.example.springmvc.message.ErrorMessage;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ApiExceptionHandler {
	
	
	@ExceptionHandler({ NoHandlerFoundException.class })
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ResponseEntity<ErrorMessage> handleNoHandlerFoundException(NoHandlerFoundException ex,
			HttpServletRequest httpServletRequest) {
		ErrorMessage apiErrorResponse = new ErrorMessage(404, "Resource not found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON)
				.body(apiErrorResponse);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage handleAllException(Exception ex, WebRequest request) {
		// quá trình kiểm soat lỗi diễn ra ở đây
		return new ErrorMessage(1000, ex.getLocalizedMessage());
	}

	/**
	 * IndexOutOfBoundsException sẽ được xử lý riêng tại đây
	 */
	@ExceptionHandler(IndexOutOfBoundsException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorMessage TodoException(Exception ex, WebRequest request) {
		return new ErrorMessage(10100, "Đối tượng không tồn tại");
	}

	
}
