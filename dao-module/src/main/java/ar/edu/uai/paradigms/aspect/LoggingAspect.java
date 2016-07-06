package ar.edu.uai.paradigms.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * Created by Federico on 19/10/2014.
 */
@Aspect
public class LoggingAspect {

    @Before("execution(* ar.edu.uai.paradigms.dao.PersistentDAO.retrieve(..))")
    public void auditDatabase(JoinPoint joinPoint) {
        Logger LOGGER = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        LOGGER.info("About to retrieve from database with parameters: {" + StringUtils.arrayToCommaDelimitedString(joinPoint.getArgs()) + "}");
    }
}
