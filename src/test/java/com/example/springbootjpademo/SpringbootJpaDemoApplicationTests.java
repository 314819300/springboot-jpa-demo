package com.example.springbootjpademo;

import com.example.springbootjpademo.po.Customer;
import com.example.springbootjpademo.po.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootTest
class SpringbootJpaDemoApplicationTests {

	@Test
	void contextLoads() {
	}

	/**
	 *
	 */
	@Test
	public void testJPA() {


		/**
		 * 通过静态方法创建实体类工厂
		 */
		EntityManagerFactory myJpa = Persistence.createEntityManagerFactory("myJpa");
		//创建试题管理类
		EntityManager entityManager = myJpa.createEntityManager();
		//获取事务对象
		EntityTransaction transaction = entityManager.getTransaction();
		//开启事务
		transaction.begin();

		Customer customer = new Customer();
		customer.setCustName("测试");
		//保存操作
		entityManager.persist(customer);
		//提交事务
		transaction.commit();
		//释放资源
		entityManager.close();
		myJpa.close();
	}

	@Test
	public void testPerson() {
		//创建工厂
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
		//通过工厂获取实体类管理器
		EntityManager entityManager = factory.createEntityManager();
		//获取事务管理器
		EntityTransaction tx = entityManager.getTransaction();
		//打开事务
		tx.begin();
		try {

			Person person = new Person();
			person.setPname("小李");

			entityManager.persist(person);//新增操作，没有返回值，返回void
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		//释放资源
		entityManager.close();
		factory.close();
	}


}
