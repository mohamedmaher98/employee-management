package com.maher.employeemanagement.shared;

import lombok.Getter;
import org.springframework.http.*;

import java.util.List;

@Getter
public class GlobalErrorResponse<T>
{
	private final static String SUCCESS = "success";
	private final static String ERROR = "error";

	private String status;
	private T data;
	private List<ErrorItem> errors;

	public record ErrorItem(int code, String message)
	{
	}

	;

	public GlobalErrorResponse(List<ErrorItem> error)
	{
		this.status = ERROR;
		this.data = null;
		this.errors = error;
	}

	public GlobalErrorResponse(T data)
	{
		this.status = SUCCESS;
		this.data = data;
		this.errors = null;
	}

}
