package com.example.springbootjpademo.po;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author wangning
 * @create 2021-02-17 21:19
 */
@Entity
@Table(name = "t_person")
public class Person implements Serializable {

	private static final long serialVersionUID = 3266569350049420373L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "p_id")
	private Long pid;

	@Column(name = "p_name")
	private String pname;

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}
}
