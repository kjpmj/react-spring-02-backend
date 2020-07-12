package my.spring.demo01.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.MethodNotAllowed;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.servlet.ModelAndView;

import my.spring.demo01.exception.ErrorCode;
import my.spring.demo01.exception.vo.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//	protected ModelAndView handleNotAllowException(HttpRequestMethodNotSupportedException e) {
//		System.out.println("Not Allow Exception");
//		System.out.println(e.toString());
//		
//		ErrorResponse response = ErrorResponse.of(ErrorCode.INTERNAL_SERVER_ERROR);
//		
//		return new ModelAndView("forward:index.html");
//	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	protected ResponseEntity<ErrorResponse> handleNotAllowException(HttpRequestMethodNotSupportedException e) {
		System.out.println("Not Allow Exception");
		System.out.println(e.toString());
		
		ErrorResponse response = ErrorResponse.of(ErrorCode.METHOD_NOT_ALLOWED);
		
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ErrorResponse> handleException(Exception e) {
		System.out.println("exception이다.");
		System.out.println(e.toString());
		
		ErrorResponse response = ErrorResponse.of(ErrorCode.INTERNAL_SERVER_ERROR);
		
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
