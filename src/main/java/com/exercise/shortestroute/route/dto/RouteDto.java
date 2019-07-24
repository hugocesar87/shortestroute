package com.exercise.shortestroute.route.dto;

public class RouteDto {
	
	private String origin;
	private String destination;
	
	public RouteDto() {
		super();
	}
	
	public RouteDto(String origin, String destination) {
		super();
		this.origin = origin;
		this.destination = destination;
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

	@Override
	public String toString() {
		return "RouteDto [origin=" + origin + ", destination=" + destination + "]";
	}
	
}
