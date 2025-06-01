package com.maher.employeemanagement.dtos;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.UUID;

public record EmployeeCreateDTO(
		@NotBlank(message = "الاسم مطلوب")
		@Size(min = 2, max = 50, message = "الاسم يجب أن يكون بين 2 و50 حرفًا")
		String name,

		@NotBlank(message = "البريد الإلكتروني مطلوب")
		@Email(message = "صيغة البريد الإلكتروني غير صحيحة")
		String email,

		@NotBlank(message = "رقم الهاتف مطلوب")
		@Pattern(regexp = "^[0-9\\-\\+]{9,15}$", message = "صيغة رقم الهاتف غير صحيحة")
		String phone,

		@NotBlank(message = "المسمى الوظيفي مطلوب")
		String jobTitle,

		@NotBlank(message = "القسم مطلوب")
		String department,

		@NotNull(message = "تاريخ التعيين مطلوب")
		@PastOrPresent(message = "تاريخ التعيين يجب أن يكون في الماضي أو اليوم")
		LocalDate hireDate,

		@PositiveOrZero(message = "الراتب يجب أن يكون رقمًا موجبًا أو صفر")
		double salary,

		boolean active,

		@NotBlank(message = "العنوان مطلوب")
		String address,

		@NotBlank(message = "الرقم القومي مطلوب")
		@Size(min = 14, max = 14, message = "الرقم القومي يجب أن يحتوي على 14 رقمًا")
		@Pattern(regexp = "\\d{14}", message = "الرقم القومي يجب أن يحتوي على أرقام فقط")
		String nationalId,


		UUID departmentId
		)
{
}
