package pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ReqPlaceData {
	
	private LocationChild location;
	private int accuracy;
	private String name;
	private String phone_number;
	private String address;
	private List<String> types;
	private String website;
	private String language;
	
	
	

	
	
	
	
	
	

}
