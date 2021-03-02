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
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringbootJpaDemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testJPA() {

		//通过此项设置能够设置控制台不打印sql语句，然后在创建工厂的时候把该参数传入进去
		//此处的map可以传入到Persistence.createEntityManagerFactory("myJpa",map);
		//但是传入到myJpa.createEntityManager(map)就不会生效
		Map<String, Object> map = new HashMap<>();
		map.put("hibernate.show_sql",false);
		/**
		 * 通过静态方法创建实体类工厂
		 * EntityManagerFactory没有线程安全问题，所以可以设置成全局的变量
		 * 此处传入的map可以用来配置连接数据库的配置
		 */
		EntityManagerFactory myJpa = Persistence.createEntityManagerFactory("myJpa",map);
		System.out.println("判断工厂是否打开 myJpa.isOpen() = " + myJpa.isOpen());
		//创建实体管理类
		//myJpa.createEntityManager(map);此处 也可以传入一个map
		EntityManager entityManager = myJpa.createEntityManager();
		Map<String, Object> properties = entityManager.getProperties();
		System.out.println("打印EntityManager中的属性 properties = " + properties);
		/*
			{org.hibernate.flushMode=AUTO, javax.persistence.lock.timeout=-1, javax.persistence.cache.retrieveMode=USE,
			 javax.persistence.lock.scope=EXTENDED, javax.persistence.cache.storeMode=USE}
		 */
		/**
		 * EntityManager中实体类的四种状态
		 */
		//获取事务对象
		EntityTransaction transaction = entityManager.getTransaction();
		//开启事务
		transaction.begin();

		Customer customer = new Customer();
		customer.setCustName("测试");
		System.out.println("customer处于新建态......");
		//保存操作，使用此操作不能自定义主键的值，如果有id就认为他是一个游离态对象
		entityManager.persist(customer);
		System.out.println("customer处于持久态......");
		//提交事务
		transaction.commit();

		/**
		 * 使用此种方法查询，是会有缓存的，第二次就会从缓存中取值
		 * 如果id不存在，会返回null
		 */
		Customer c = entityManager.find(Customer.class, 1);//查询id为一的值
		/**
		 * 以下这种方式也是根据id查询，与上面的有什么不同呢？
		 * 下面的这种查询，如果查询不到不会返回null，而是直接抛出异常 EntityNotFoundException
		 * 还有下面的这种查询，查询缓存时，如果缓存中不存在，不会立即返回对象，有懒加载的功能
		 */
		Customer c1 = entityManager.getReference(Customer.class, 1);
		//释放资源
		entityManager.close();
		myJpa.close();//工厂关闭
		System.out.println("customer处于游离态......");
		System.out.println("myJpa = " + myJpa.isOpen());
		System.out.println("entityManager = " + entityManager.isOpen());
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
