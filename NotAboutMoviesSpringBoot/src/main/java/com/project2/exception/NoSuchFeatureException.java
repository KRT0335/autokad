package com.project2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * This @ResponseStatus annotation allows us to associate an exception with a certain
 * status code and message.
 */
@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="We haven't implemented this method yet.")
public class NoSuchFeatureException extends RuntimeException{
	
}
