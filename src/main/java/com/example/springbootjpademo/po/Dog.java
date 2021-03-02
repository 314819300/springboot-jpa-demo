package com.example.springbootjpademo.po;

import javax.persistence.*;

/**
 * @author wangning
 * @create 2021-02-17 20:41
 */
@Entity
@Table
public class Dog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
}
