package net.xdclass.demoproject.handler;

import net.xdclass.demoproject.utils.JsonData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 同一处理异常
 */
@RestControllerAdvice
public class CustomExtHandler {

	@ExceptionHandler(value = Exception.class)
	Object handlerException(Exception e, HttpServletRequest request){
		return  JsonData.buildError("服务端报错",-2);
	}
}
