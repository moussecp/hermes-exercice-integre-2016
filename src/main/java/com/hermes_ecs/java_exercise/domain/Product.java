package com.hermes_ecs.java_exercise.domain;

import static com.google.common.base.Preconditions.checkArgument;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Table(name="PRODUCT")
public class Product implements Identifiable<Long> {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false, unique=true)
	private String label;

	private String description;
	
	@Embedded
	@AttributeOverrides(value = {@AttributeOverride(name = "value", column=@Column(name="PRICE"))})
	private RepublicDactaryAmount price;
	
	Product() {}

	public Product(String label, RepublicDactaryAmount price) {
		checkArgument(!StringUtils.isEmpty(label), "label must not be null or empty");
		checkArgument(price != null, "price must not be null");		
		this.label = label;
		this.price = price;
	}

	public Product(String label, String description, RepublicDactaryAmount price) {
		this(label, price);
		this.description = description;
	}
	
	public String getLabel() {
		return label;
	}

	public String getDescription() {
		return description;
	}

	public RepublicDactaryAmount getPrice() {
		return price;
	}

	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof Product) {
			Product otherProduct = (Product) other;
			if (otherProduct.getId() != null && getId() != null) {
				return otherProduct.getId().equals(getId());
			}
			else {
				EqualsBuilder builder = new EqualsBuilder();
				builder.append(getLabel(), otherProduct.getLabel());
				builder.append(getDescription(), otherProduct.getDescription());
				builder.append(getPrice(), otherProduct.getPrice());
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
			return new HashCodeBuilder().append(getLabel())
					.append(getDescription())
					.append(getPrice()).toHashCode();
		}
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(RepublicDactaryAmount price) {
		this.price = price;
	}

	void setId(Long id) {
		this.id = id;
	}
	
}
