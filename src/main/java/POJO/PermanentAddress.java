package POJO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermanentAddress {

	@JsonProperty("pincode")
	private int pincode;

	@JsonProperty("state")
	private String state;

	@JsonProperty("city")
	private String city;

}
