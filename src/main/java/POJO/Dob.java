package POJO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dob {

	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	@JsonProperty("date")
	private int date;
	
	@JsonProperty("month")
	private String month;
	
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	@JsonProperty("year")
	private int year;
	
	
	
}
