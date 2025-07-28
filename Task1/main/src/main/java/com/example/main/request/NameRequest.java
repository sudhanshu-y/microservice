package com.example.main.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NameRequest {

	@JsonProperty("Name")
	@NotBlank(message = "Name cannot be blank")
	private String name;

	@JsonProperty("Surname")
	@NotBlank(message = "Surname cannot be blank")
	private String surname;

}
