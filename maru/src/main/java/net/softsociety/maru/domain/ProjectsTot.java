package net.softsociety.maru.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectsTot {
	private String Projects_name;
	private String d_day;
	private int progress;
	private String State;
	private int issueCnt;
}
