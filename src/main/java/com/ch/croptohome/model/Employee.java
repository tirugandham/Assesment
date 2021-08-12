package com.ch.croptohome.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.opencsv.bean.CsvBindByPosition;

@Entity
@Table(name ="employee")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Employee implements Serializable {
	private static final long serialVersionUID = -9087386484833636274L;

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @CsvBindByPosition(position = 0)
	private Long employeeId;
	@CsvBindByPosition(position = 1)
	private String firstName;
	@CsvBindByPosition(position = 2)
	private String lastName;
	@CsvBindByPosition(position = 3)
	private String userName;
	@CsvBindByPosition(position = 4)
	private String email;
	@CsvBindByPosition(position = 5)
	private long salary;
	@CsvBindByPosition(position = 6)
	private int age;
	@CsvBindByPosition(position = 7)
	private int experience;
	@CsvBindByPosition(position = 8)
	private Date dateOfJoin;
	
	private String phoneNO;
	private Date createdDate;
	private Date updatedDate;
	
	
	
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNO() {
		return phoneNO;
	}
	public void setPhoneNO(String phoneNO) {
		this.phoneNO = phoneNO;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public Date getDateOfJoin() {
		return dateOfJoin;
	}
	public void setDateOfJoin(Date dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", userName=" + userName + ", email=" + email + ", salary=" + salary + ", age=" + age
				+ ", experience=" + experience + ", dateOfJoin=" + dateOfJoin + ", phoneNO=" + phoneNO
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", department=" +  "]";
	}
	
	
	
	
	

}
