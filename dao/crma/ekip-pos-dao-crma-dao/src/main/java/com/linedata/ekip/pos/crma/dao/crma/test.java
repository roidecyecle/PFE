package com.linedata.ekip.pos.crma.dao.crma;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public abstract class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		JdbcSaoImpl dao = ctx.getBean("jdbcSaoImpl", JdbcSaoImpl.class);
		
		
		
		System.out.println("test");
		System.out.println(dao.getChiffrageById(1).getLibelle()+" et le nombre des chiffrages est: "+dao.getAllChiffrage().size());
		
		
		
	}

}
