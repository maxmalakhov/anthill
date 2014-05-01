package us.devcloud.anthill.network;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by max on 24/04/14.
 */
@Component
@Aspect
public class Sender {

    @Before("execution(* us.devcloud.anthill.core.Worker.run(..))")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("***AspectJ*** DoBefore() is running!! intercepted : " + joinPoint.getSignature().getName());
    }


    @Before("execution(* us.devcloud.anthill.core.Engine.run(..))")
    public void doEngineBefore(JoinPoint joinPoint) {
        System.out.println("***AspectJ*** DoEngineBefore() is running!! intercepted : " + joinPoint.getSignature().getName());
    }
}
