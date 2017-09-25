package com.mifinity.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "ROLE")
public class Role implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable=false, name="ROLE_NAME")
	private String roleNane;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleNane() {
		return roleNane;
	}

	public void setRoleNane(String roleNane) {
		this.roleNane = roleNane;
	}

}
