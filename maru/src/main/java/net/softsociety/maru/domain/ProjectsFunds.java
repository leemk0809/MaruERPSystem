package net.softsociety.maru.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectsFunds {
	private int projects_funds_num;
	private int projects_num;
	private int funds_type_num;		
	private String funds_detail;
	private int price;		
	private String input_date;	
}