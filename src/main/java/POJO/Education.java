package POJO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Education {

	@JsonProperty("graduation")
	private String graduation;
	
	@JsonProperty("postGraduation")
	private String postGraduation;
	
	
}
