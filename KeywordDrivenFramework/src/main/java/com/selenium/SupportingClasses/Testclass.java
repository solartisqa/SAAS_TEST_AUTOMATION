package com.selenium.SupportingClasses;

import java.lang.reflect.Method;

import com.thoughtworks.paranamer.AnnotationParanamer;
import com.thoughtworks.paranamer.BytecodeReadingParanamer;
import com.thoughtworks.paranamer.CachingParanamer;
import com.thoughtworks.paranamer.Paranamer;

public class Testclass 
{
	public static void main(String[] args) 
	{				
        Method[] methods = TheEventListener.class.getDeclaredMethods();
        int nMethod = 1;
        System.out.println("1. List of all methods of Person class");
        for (Method method : methods) 
        {
        	Paranamer info = new CachingParanamer(new AnnotationParanamer(new BytecodeReadingParanamer()));
        	String[] parameterNames = info.lookupParameterNames(method);
        	System.out.print( method.getName()+"\t"+method.getReturnType()+"\t");
        	for(String ss : parameterNames)
        		System.out.print(ss +", ");
           System.out.println();
        }
        System.out.printf("%d. End - all  methods of Person class", ++nMethod);
    }
}