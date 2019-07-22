package com.excersise.shortestroute.airport.model;

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
@Table(name = "airport", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "name" }, name = "AIRPORT_NAME"),
		@UniqueConstraint(columnNames = { "iata_3" }, name = "AIRPORT_IATA3")})
public class Airport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Min(value = 1)
	@Column(name = "airport_id")
	private Long airportId;
	
	@Column(name = "name", nullable = false, length = 200)
	@Size(min = 5, max = 200)
	private String name;
	
	@Column(name = "city", nullable = true, length = 128)
	@Size(min = 5, max = 128)
	private String city;
	
	@Column(name = "country", nullable = false, length = 128)
	@Size(min = 5, max = 128)
	private String country;
	
	@Column(name = "iata_3", nullable = false, length = 2)
	@Size(min = 3, max = 3)
	private String iata3;
	
	@Column(name = "latitude", nullable = false, length = 128)
	@Size(min = 5, max = 50)
	private String latitude;
	
	@Column(name = "longitude", nullable = false, length = 128)
	@Size(min = 5, max = 50)
	private String longitude;

	public Long getAirportId() {
		return airportId;
	}

	public void setAirportId(Long airportId) {
		this.airportId = airportId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIata3() {
		return iata3;
	}

	public void setIata3(String iata3) {
		this.iata3 = iata3;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
}
