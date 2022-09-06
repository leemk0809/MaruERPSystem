package net.softsociety.maru.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Issue {
	private int issue_num;
	private int projects_num;
	private int position_num;
	private int rank;
	private String title;
	private String contents;
	private String input_date;
}
