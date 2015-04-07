package com.linedata.ekip.pos.crma.dao.crma;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.linedata.ekip.pos.dao.model.impl.Chiffrage;



public abstract class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		JdbcSaoImpl dao = ctx.getBean("jdbcSaoImpl", JdbcSaoImpl.class);
		
		System.out.println("");
		
		dao.insertChiffrage(new Chiffrage(9,"chiff 9"));
		System.out.println(dao.getChiffrageById(9).getLibelle()+" et le nombre des chiffrages est: "+dao.getAllChiffrage().size());
		
		
		
	}

}
