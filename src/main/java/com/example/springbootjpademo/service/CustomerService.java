package com.example.springbootjpademo.service;

import com.example.springbootjpademo.po.Customer;

import java.util.List;

/**
 * @author wangning
 * @create 2021-03-03 10:17
 */
public interface CustomerService {
	Customer findByCustId(Long custId);

	List<Customer> findAll();

	Customer save(Customer customer);

}
