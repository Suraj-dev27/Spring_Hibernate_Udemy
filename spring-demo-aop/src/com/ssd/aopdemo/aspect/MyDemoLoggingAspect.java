package com.ssd.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging

	// let's start with an @Before advice

	// @Before("execution(public void add*())")

	// for parameter pattern:-
	// () - matches a method with no arguments
	// (*) - matches a method with one argument of any type
	// (..) - matches a method with 0 or more arguments of any type

	// in below pointcut expression initial * is to match any return type(modifier
	// is optional) then in specified package any class and any method and any
	// number of arguments(..)
	@Before("execution(* com.ssd.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {

		System.out.println("\n=====>>> Executing @Before advice in method");

	}
}
