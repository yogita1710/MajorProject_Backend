package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table
	public class Student implements Serializable {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		
		@Column
		private String name;
		
		@Column
		private String course;
		
		@Column
		private int marks;
		
		@Column
		private int fee;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
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
		public int getMarks() {
			return marks;
		}
		public void setMarks(int marks) {
			this.marks = marks;
		}
		public int getFee() {
			return fee;
		}
		public void setFee(int fee) {
			this.fee = fee;
		}
		
		
}
