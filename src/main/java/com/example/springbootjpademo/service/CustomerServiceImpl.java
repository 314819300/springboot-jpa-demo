package com.example.springbootjpademo.service;

import com.example.springbootjpademo.dao.CustomerDao;
import com.example.springbootjpademo.po.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangning
 * @create 2021-03-03 10:17
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;

	@Override
	public Customer findByCustId(Long custId) {
		return customerDao.findByCustId(custId);
	}

	@Override
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	@Override
	public Customer save(Customer customer) {
		return customerDao.save(customer);
	}


}
