package chapter09.code.listing.base;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {
	@Around("execution(* chapter09.code.listing.service.BookService.*(..))")
	public Object logMessage(ProceedingJoinPoint pjp) throws Throwable {
		Logger logger = Logger.getLogger(pjp.getTarget().getClass());
		logger.info("Entering " + pjp.getSignature());
		Object returnValue = pjp.proceed();
		logger.info("Exiting " + pjp.getSignature());
		return returnValue;
	}
}
