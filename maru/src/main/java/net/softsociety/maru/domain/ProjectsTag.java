package net.softsociety.maru.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectsTag {
	private int projects_tag_num;
	private int position_num;
	private int projects_num;
	private String tag_sign;
}
