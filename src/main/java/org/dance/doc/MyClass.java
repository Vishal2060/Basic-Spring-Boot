package org.dance.doc;

import java.io.IOException;

import org.dance.query.Person;

/**
 * Class MyClass
 * 
 * How to make Java Doc
 * 
 * @author Vishal Vishwas Jadhav
 * @version 1.0.0
 *
 * @see Person
 */
public class MyClass {
	
	/**
	 * Integer member1
	 */
	private Integer member1;

	/**
	 * String member2
	 */
	private String member2;

	/**
	 * Method method1
	 * 
	 * @param i1
	 * @return void
	 * @exception IOException
	 */
	public void method1(Integer i1) throws IOException {
	}

	/**
	 * Method method1
	 * 
	 * @param s1
	 * @return member1
	 */
	public Integer method2(String s1) {
		return member1;
	}
	
	/**
	 * Method method3
	 * 
	 * @param s1
	 * @return member2
	 */
	public String method3(String s1) {
		return member2;
	}
}
