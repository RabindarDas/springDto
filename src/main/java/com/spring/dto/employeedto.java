package com.spring.dto;



import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class employeedto {
	private long id;
	@NotBlank
	private String firstname;
	@NotBlank
	private String lastname;
	@Email
	private String emailId;
}
