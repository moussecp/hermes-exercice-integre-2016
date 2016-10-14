package com.hermes_ecs.java_exercise.domain.constant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hermes_ecs.java_exercise.domain.Identifiable;

@Entity
@Table(name="CONSTANT")
public class Constant implements Identifiable<ConstantKey> {

	@Id
	@Enumerated(EnumType.STRING)
	@Column("NAME") // "key" is a reserved word in MySQL
	private ConstantKey key;

	private String value;

	Constant() {}
	
	public Constant(ConstantKey key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ConstantKey getKey() {
		return key;
	}

	@Override
	public ConstantKey getId() {
		return key;
	}	
}
