package com.exercise.shortestroute.route.model;

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
@Table(name = "route", uniqueConstraints = {
		 @UniqueConstraint(columnNames={"airline_id", "origin", "destination"},name = "ROUTE_AIRLINE_ORIGIN_DESTINATION") })
public class Route {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Min(value = 1)
	@Column(name = "route_id")
	private Long routeId;
	
	@Column(name = "airline_id")
	@Size(min = 2, max = 2)
	private String airlineId;
	
	@Column(name = "origin", nullable = false, length = 2)
	@Size(min = 3, max = 3)
	private String origin;
	
	@Column(name = "destination", nullable = false, length = 2)
	@Size(min = 3, max = 3)
	private String destination;

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public String getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(String airlineId) {
		this.airlineId = airlineId;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
}
