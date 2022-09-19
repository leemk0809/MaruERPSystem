package net.softsociety.maru.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class IssueTot {

	private int issue_num;
	private String issueTitle;
	private String projects_title;
	private String position;
	private String input_date;
	
}
