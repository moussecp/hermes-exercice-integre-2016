package com.hermes_ecs.java_exercise.domain;

import static com.google.common.base.Preconditions.checkArgument;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name="BUYER")
public class Buyer implements Identifiable<Long> {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "FIRST_NAME", nullable=false)
	private String firstName;

	@Column(name = "LAST_NAME", nullable=false)
	private String lastName;
	
	@Column(name = "BIRTH_LOCATION", nullable=true)
	private String birthLocation;
	
	Buyer() {}

	public Buyer(String firstName, String lastName, String birthLocation) {
		this(firstName, lastName);
		this.birthLocation = birthLocation;
	}

	public Buyer(String firstName, String lastName) {
		checkArgument(!StringUtils.isEmpty(firstName), "firstName must not be null or empty");
		checkArgument(!StringUtils.isEmpty(lastName), "lastName must not be null or empty");
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getBirthLocation() {
		return birthLocation;
	}

	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof Buyer) {
			Buyer otherBuyer = (Buyer) other;
			if (otherBuyer.getId() != null && getId() != null) {
				return otherBuyer.getId().equals(getId());
			}
			else {
				EqualsBuilder builder = new EqualsBuilder();
				builder.append(getFirstName(), otherBuyer.getFirstName());
				builder.append(getLastName(), otherBuyer.getLastName());
				builder.append(getBirthLocation(), otherBuyer.getBirthLocation());
				return builder.isEquals();
			}
		}
		else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		if (getId() != null) {
			return getId().hashCode();
		}
		else {
			return new HashCodeBuilder().append(getFirstName())
					.append(getLastName())
					.append(getBirthLocation()).toHashCode();
		}
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBirthLocation(String birthLocation) {
		this.birthLocation = birthLocation;
	}

	void setId(Long id) {
		this.id = id;
	}
}
