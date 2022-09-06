package net.softsociety.maru.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Projects {
	
	private int projects_num;
	private int post_num;
	private String title;
	private String start_date;
	private String end_date;
	private String status;
	private int need_worker;
	private int amount;
	private String blueprint_path;
	private String airview_path;
}
