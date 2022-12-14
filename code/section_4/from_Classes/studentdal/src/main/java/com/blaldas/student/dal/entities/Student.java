package com.blaldas.student.dal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // maps the class to an table
@Table(name = "studenttab") // indicates the table's name that this class is mapped to
public class Student {

	@Id // marks the variable id as the class identifier
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates an unique id
	private Long id;

	@Column(name = "sname") // indicates the column's name that this variable represents (used when the
							// variable and column names are different)
	private String name;

	@Column(name = "scourse")
	private String course;

	@Column(name = "sfee")
	private double fee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + ", fee=" + fee + "]";
	}
}
