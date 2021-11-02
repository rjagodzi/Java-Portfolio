package com.premiereManager.springboot.web.model;

import java.util.Date;

import javax.validation.constraints.Size;

/**
 * Creates the Premiere object, the necessary getters and setters and the
 * toString() method
 * 
 * @author Rafal Jagodzinski
 *
 */

public class Premiere {
	private int id;
	private String user;

	@Size(min = 4, message = "Enter at least 4 characters...")
	private String desc;

	private Date targetDate;
	private String type;

	public Premiere() {
		super();
	}

	/**
	 * Creates the Premiere object
	 * 
	 * @author Rafal Jagodzinski
	 * 
	 */

	public Premiere(int id, String user, String desc, Date targetDate, String type) {
		super();
		this.id = id;
		this.user = user;
		this.desc = desc;
		this.targetDate = targetDate;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Method creating unique hash code to the object to distinguish between two
	 * objects with the same values.
	 * 
	 * @author Rafal Jagodzinski
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		System.out.println(result);
		System.out.println(id);
		return result;
	}

	/**
	 * Enables the update of the Premiere object without creating a new list entry
	 * 
	 * @author Rafal Jagodzinski
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Premiere other = (Premiere) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

	/**
	 * The method is used to get a String object representing the value of the
	 * Number Object
	 * 
	 * @author Rafal Jagodzinski
	 * 
	 */

	@Override
	public String toString() {
		return String.format("Premiere [id=%s, user=%s, desc=%s, targetDate=%s, type=%s]", id, user, desc, targetDate,
				type);
	}

}