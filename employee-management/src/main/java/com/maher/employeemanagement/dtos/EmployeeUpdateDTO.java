package com.maher.employeemanagement.dtos;

import jakarta.validation.constraints.*;

public record EmployeeUpdateDTO(
		@Size(min = 2, max = 50, message = "الاسم يجب أن يكون بين 2 و50 حرفًا")
		String name,

		@Pattern(regexp = "^[0-9\\-\\+]{9,15}$", message = "صيغة رقم الهاتف غير صحيحة")
		String phone,

		String jobTitle,

		@PositiveOrZero(message = "الراتب يجب أن يكون رقمًا موجبًا أو صفر")
		Double salary,

		Boolean active,

		String address)
{
}
