package com.example.springbootjpademo.dao;

import com.example.springbootjpademo.po.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.List;

/**
 * @author wangning
 * @create 2021-03-03 10:13
 */
// 继承CrudRepository接口，<实体类, 主键类型>
// JPA根据实体类的类名去对应表名（可以使用@Entity的name属性？@Table进行修改）
public interface CustomerDao extends JpaRepositoryImplementation<Customer, Long> {
	Customer findByCustId(Long custId);

	List<Customer> findAll();

	Customer save(Customer customer);

	

}
