package com.bigcorp.crm.rest.exceptionmapper;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

	@Override
	public Response toResponse(final ConstraintViolationException exception) {
		return Response.status(Response.Status.BAD_REQUEST).entity(prepareMessage(exception)).type("text/plain")
				.build();
	}

	private String prepareMessage(ConstraintViolationException exception) {
		StringBuilder msg = new StringBuilder();
		for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {
			msg.append(cv.getPropertyPath() + " with value " + cv.getInvalidValue() + " " + cv.getMessage() + "\n");
		}
		return msg.toString();
	}
}