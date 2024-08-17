package POJO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {

	@JsonProperty("country")
	private String country;

	@JsonProperty("permanentAddress")
	private PermanentAddress permanentAddress;

	@JsonProperty("currentAddress")
	private CurrentAddress currentAddress;

}
