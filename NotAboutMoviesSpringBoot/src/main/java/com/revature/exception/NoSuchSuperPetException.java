package com.revature.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * This @ResponseStatus annotation allows us to associate an exception with a certain
 * status code and message.
 */
@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="You're a clown.")
public class NoSuchSuperPetException extends RuntimeException{
	
}
