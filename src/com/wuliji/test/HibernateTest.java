package com.wuliji.test;


import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wuliji.dao.UserDao;
import com.wuliji.domain.User;
import com.wuliji.service.UserService;

/**
 * ≤‚ ‘hibernateøÚº‹
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {
	
	@Resource(name="sessionFactory")
	private SessionFactory sf2;
	
	@Test
	/**
	 * ≤‚ ‘hibernate
	 */
	public void fun1() {
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		User u = new User();
		u.setUser_code("tom");
		u.setUser_name("wuliji");
		u.setUser_password("123");
		session.save(u);
		
		tx.commit();
		session.close();
	}
	
	@Test
	/**
	 * ≤‚ ‘sessionfactory
	 */
	public void fun2() {
		Session session = sf2.openSession();
		Transaction tx = session.beginTransaction();
		
		User u = new User();
		u.setUser_code("π˛π˛");
		u.setUser_name("rose");
		u.setUser_password("123");
		session.save(u);
		
		tx.commit();
		session.close();
	}
	
	
	/**
	 * ≤‚ ‘Hibernate ƒ£∞Â
	 */
	@Resource(name="userDao")
	private UserDao ud;
	@Test
	public void fun3() {
		User user = ud.getByUserCode("tom");
		System.out.println(user);
	}
	
	/**
	 * ≤‚ ‘aop ¬ŒÒ
	 */
	@Resource(name="userService")
	private UserService us;
	@Test
	public void fun4() {
		User u = new User();
		u.setUser_code("hehe");
		u.setUser_name("meimie");
		u.setUser_password("123");
		us.saveUser(u);
	}
	
	
}
