package com.exercise.shortestroute.route.dto;

public class VertexEdgeDto {
	
	private Integer origin;
	private Integer destination;
	
	public VertexEdgeDto() {
		super();
	}
	
	public VertexEdgeDto(Integer origin, Integer destination) {
		super();
		this.origin = origin;
		this.destination = destination;
	}
	
	public Integer getOrigin() {
		return origin;
	}
	
	public void setOrigin(Integer origin) {
		this.origin = origin;
	}
	
	public Integer getDestination() {
		return destination;
	}
	
	public void setDestination(Integer destination) {
		this.destination = destination;
	}

}
