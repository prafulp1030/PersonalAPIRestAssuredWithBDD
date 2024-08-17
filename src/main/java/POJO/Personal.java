package POJO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Personal {

	@JsonProperty("fullName")
	private String fullName;

	@JsonProperty("education")
	private Education education;

	@JsonProperty("dob")
	private Dob dob;

	@JsonProperty("address")
	private Address address;

	@JsonProperty("gender")
	private boolean gender;

}
