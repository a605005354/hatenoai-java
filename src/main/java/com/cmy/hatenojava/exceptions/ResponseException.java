package com.cmy.hatenojava.exceptions;

/**
 * @projectName: hateno-java
 * @package: com.cmy.hatenojava.exceptions
 * @className: UserAlreadyExistException
 * @author: Terry Cai
 * @description: Handles User Already Exist
 * @date: 2/28/24 8:25 PM
 * @version: 1.0
 */
public class ResponseException extends RuntimeException {

    public ResponseException(String message) {
        super(message);
    }

    // You can also add constructors for throwable causes or other details as needed
}