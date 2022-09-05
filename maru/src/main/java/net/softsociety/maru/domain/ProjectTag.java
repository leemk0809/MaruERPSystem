package net.softsociety.maru.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectTag {
	private int project_tag_num;
	private int position_num;
	private int project_num;
	private String tag_sign;
}
