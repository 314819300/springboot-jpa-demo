package com.example.springbootjpademo.po;

import ch.qos.logback.classic.db.names.ColumnName;
import org.hibernate.annotations.Columns;
import org.hibernate.boot.model.naming.ImplicitAnyDiscriminatorColumnNameSource;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author wangning
 * @create 2021-02-15 22:30
 * 使用jpa开发需要一套注解来映射一下实体来与表字段的关系
 */
@Entity //声明这个是个实体类
/**
 * name-表名
 * catalog-数据库名，可以指定数据库的名字
 * schema-也是指定数据库名的
 * uniqueConstraints-用于设置约束条件，设置哪些属性为唯一约束
 */
@Table(name = "cst_customer",catalog = "jpa", uniqueConstraints = {@UniqueConstraint(columnNames={"cust_id", "cust_phone"})})//建立实体类和表的映射关系
public class Customer implements Serializable {
	@Id//表示是主键id
	/**
	 * @GeneratedValue 主键的生成策略，通过strategy属性指定
	 * 默认情况下，JPA自动选择一个最适合底层数据库的主键生成策略SqlServer对应IDENTITY
	 * mysql对应auto_increment
	 * 在javax.persistence.GenerationType
	 * IDENTITY,采用数据库ID自增长的方式来自增主键字段，Oracle不支持这种方式
	 * Auto，JPA自动选择合适的策略，是默认选项，设置成自动会额外生成一张表，用来保存主键的自增数据
	 * SEQUENCE:序列适用于oracle数据库，通过序列产生主键，通过@SequenceGenerator注解指定序列名，mysql不支持这种方式
	 * TABLE：通过表产生主键，框架借由模拟序列产生主键，使用该策略可以使应用于数据量移植
	 */
	@GeneratedValue(strategy = GenerationType.IDENTITY)//配置主键的生成策略
	@Column(name = "cust_id")//表示字段与属性的映射关系，其中的其它属性是用来自动创建表的时候进行约束的
	private Long custId;
	/**
	 * 其中可以配置name，length，unique，nullable等
	 * columnDefinition属性：表示该字段在数据库中的实际类型，通常ORM框架可以根据属性类型自动判断
	 * 数据库中字段的类型，但是对于Date类型仍无法确定数据库中字段类型究竟是DATE，TIME还是TIMESTAMP
	 * 此外，String的默认是varchar，如果将String类型映射到指定的数据库的BOLB或TEXT类型
	 */
	@Column(name = "cust_name",length = 100)
	private String custName;
	@Column(name = "cust_source")
	private String custSource;
	@Column(name = "cust_industry")
	private String custIndustry;
	@Column(name = "cust_level")
	private String custLevel;
	@Column(name = "cust_address")
	private String custAddress;
	@Column(name = "cust_phone")
	private String custPhone;



	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustSource() {
		return custSource;
	}

	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}

	public String getCustIndustry() {
		return custIndustry;
	}

	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}

	public String getCustLevel() {
		return custLevel;
	}

	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"custId=" + custId +
				", custName='" + custName + '\'' +
				", custSource='" + custSource + '\'' +
				", custIndustry='" + custIndustry + '\'' +
				", custLevel='" + custLevel + '\'' +
				", custAddress='" + custAddress + '\'' +
				", custPhone='" + custPhone + '\'' +
				'}';
	}
}
