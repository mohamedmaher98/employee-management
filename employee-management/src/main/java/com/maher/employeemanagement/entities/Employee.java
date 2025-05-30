package com.maher.employeemanagement.entities;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Employee
{
	private UUID uuid;
	@NotBlank(message = "الاسم مطلوب")
	@Size(min = 2, max = 50, message = "الاسم يجب أن يكون بين 2 و50 حرفًا")
	private String name;

	@NotBlank(message = "البريد الإلكتروني مطلوب")
	@Email(message = "صيغة البريد الإلكتروني غير صحيحة")
	private String email;

	@NotBlank(message = "رقم الهاتف مطلوب")
	@Pattern(regexp = "^[0-9\\-\\+]{9,15}$", message = "صيغة رقم الهاتف غير صحيحة")
	private String phone;

	@NotBlank(message = "المسمى الوظيفي مطلوب")
	private String jobTitle;

	@NotBlank(message = "القسم مطلوب")
	private String department;

	@NotNull(message = "تاريخ التعيين مطلوب")
	@PastOrPresent(message = "تاريخ التعيين يجب أن يكون في الماضي أو اليوم")
	private LocalDate hireDate;

	@PositiveOrZero(message = "الراتب يجب أن يكون رقمًا موجبًا أو صفر")
	private double salary;

	private boolean active;

	@NotBlank(message = "العنوان مطلوب")
	private String address;

	@NotBlank(message = "الرقم القومي مطلوب")
	@Size(min = 14, max = 14, message = "الرقم القومي يجب أن يحتوي على 14 رقمًا")
	@Pattern(regexp = "\\d{14}", message = "الرقم القومي يجب أن يحتوي على أرقام فقط")
	private String nationalId;
}
