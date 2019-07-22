package com.excersise.shortestroute.airline.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "airline", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "digit_code_2" }, name = "AIRLINE_DIGITCODE2"),
		@UniqueConstraint(columnNames = { "digit_code_3" }, name = "AIRLINE_DIGITCODE3")})
public class Airline {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Min(value = 1)
	@Column(name = "airline_id")
	private Long airlineId;
	
	@Column(name = "name", nullable = false, length = 128)
	@Size(min = 5, max = 128)
	private String name;
	
	@Column(name = "digit_code_2", nullable = false, length = 2)
	@Size(min = 2, max = 2)
	private String digitCode2;
	
	@Column(name = "digit_code_3", nullable = false, length = 2)
	@Size(min = 3, max = 3)
	private String digitCode3;
	
	@Column(name = "country", nullable = false, length = 128)
	@Size(min = 5, max = 128)
	private String country;

	public Long getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(Long airlineId) {
		this.airlineId = airlineId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDigitCode2() {
		return digitCode2;
	}

	public void setDigitCode2(String digitCode2) {
		this.digitCode2 = digitCode2;
	}

	public String getDigitCode3() {
		return digitCode3;
	}

	public void setDigitCode3(String digitCode3) {
		this.digitCode3 = digitCode3;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
