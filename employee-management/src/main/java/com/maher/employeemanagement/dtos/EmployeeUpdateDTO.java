package com.maher.employeemanagement.dtos;

import jakarta.validation.constraints.*;

public record EmployeeUpdateDTO(
		@NotBlank(message = "الاسم مطلوب")
		@Size(min = 2, max = 50, message = "الاسم يجب أن يكون بين 2 و50 حرفًا")
		String name,

		@NotBlank(message = "رقم الهاتف مطلوب")
		@Pattern(regexp = "^[0-9\\-\\+]{9,15}$", message = "صيغة رقم الهاتف غير صحيحة")
		String phone,

		@NotBlank(message = "المسمى الوظيفي مطلوب")
		String jobTitle,

		@PositiveOrZero(message = "الراتب يجب أن يكون رقمًا موجبًا أو صفر")
		double salary,

		boolean active,

		@NotBlank(message = "العنوان مطلوب") String address
)
{
}
