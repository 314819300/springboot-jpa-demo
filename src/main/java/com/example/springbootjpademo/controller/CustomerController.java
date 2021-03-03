package com.example.springbootjpademo.controller;

import com.example.springbootjpademo.po.Customer;
import com.example.springbootjpademo.service.CustomerService;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author wangning
 * @create 2021-03-03 10:25
 */
@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/find")
	@ResponseBody
	public Customer find() {
		Long custId = 1L;
		Customer customer = customerService.findByCustId(custId);
		System.out.println("customer = " + customer);
		return customer;
	}

	@RequestMapping("/findAll")
	@ResponseBody
	private List<Customer> findAll() {
		return customerService.findAll();
	}

	@RequestMapping("/save")
	@ResponseBody
	public Customer save() {
		Customer customer = new Customer();
		customer.setCustName("测试");
		customer.setCustAddress("测试地址");
		customer.setCustPhone("15555555555");
		return customerService.save(customer);
	}

	@RequestMapping("/update")
	@ResponseBody
	public Customer update() {
		Long custId = 3L;
		Customer customer = new Customer();
		customer.setCustId(6L);
		customer.setCustPhone("16666666666");

		return customerService.save(customer);
	}
}
