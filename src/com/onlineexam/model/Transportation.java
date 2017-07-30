package com.onlineexam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Formula;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="transportation")
public class Transportation implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name ="vechile_no")
	private Integer vechileNumber;
	
	@Column(name="vechile_type")
	private String vechileType;

	@Column(name ="student_Id")
	private Integer studentId;

	@Column(name="picked_location")
	private String pickedLocation;
	
	@Column(name="drop_location")
	private String dropLocation;
	
	@ManyToOne
	@JoinColumn(name="school_id")
	private User schoolId;
	
	@ManyToOne
	@JoinColumn(name="admin_id")
	private User adminId;
	
	

	public User getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(User schoolId) {
		this.schoolId = schoolId;
	}

	public User getAdminId() {
		return adminId;
	}

	public void setAdminId(User adminId) {
		this.adminId = adminId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVechileNumber() {
		return vechileNumber;
	}

	public void setVechileNumber(Integer vechileNumber) {
		this.vechileNumber = vechileNumber;
	}

	public String getVechileType() {
		return vechileType;
	}

	public void setVechileType(String vechileType) {
		this.vechileType = vechileType;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getPickedLocation() {
		return pickedLocation;
	}

	public void setPickedLocation(String pickedLocation) {
		this.pickedLocation = pickedLocation;
	}

	public String getDropLocation() {
		return dropLocation;
	}

	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}

}
