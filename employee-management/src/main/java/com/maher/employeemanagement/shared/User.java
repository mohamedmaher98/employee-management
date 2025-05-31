package com.maher.employeemanagement.shared;

//مثال علي
//method Factory
public class User
{
	private final String name;
	private final String role;

	private User(String name, String role)
	{
		this.name=name;
		this.role=role;
	}

	public static User createAdmin(String name)
	{
		return new User(name,"Admin");
	}

	public static User createUser(String name)
	{
		return new User(name,"Customer");
	}
}
