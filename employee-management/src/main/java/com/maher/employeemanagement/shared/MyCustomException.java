package com.maher.employeemanagement.shared;

import lombok.*;
import org.aspectj.bridge.Message;

import java.awt.*;

@Getter
@AllArgsConstructor
public class MyCustomException extends RuntimeException
{
	private int code;
	private String message;

	public static MyCustomException handleNotfoundInDb(String message)
	{
		return new MyCustomException(404,message);
	}

	public static MyCustomException handleValidation(String message)
	{
		return new MyCustomException(112,message);
	}

}
