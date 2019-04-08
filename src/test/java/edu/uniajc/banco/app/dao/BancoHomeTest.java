package edu.uniajc.banco.app.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.uniajc.banco.app.entity.Banco;

@ContextConfiguration(locations="classpath:application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BancoHomeTest {

	@Autowired
	private BancoHomeInterface bancoDao;
	
	private Banco banco;
	
	@Before
	public void configuration() {
		banco = new Banco();
		banco.setIdBanco(1);
		banco.setNit("01");
		banco.setNombre("banco 01");
		banco.setTelefono("001");
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void addNewBanco() {
		
		bancoDao.persist(banco);
		
		assertEquals(true, true);
		
	}

}
