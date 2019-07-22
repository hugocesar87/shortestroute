package com.excersise.shortestroute.route.exception;

import com.excersise.shortestroute.commons.exception.BadRequestException;

public class DestinationNotFoundException extends BadRequestException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String CODE_EXCEPTION = "SHORTEST_ROUTE_ERROR_002";
	
	public DestinationNotFoundException() {
		super(CODE_EXCEPTION);
	}

}