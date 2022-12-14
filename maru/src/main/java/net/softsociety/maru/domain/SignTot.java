package net.softsociety.maru.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignTot {
	private int projects_tag_num;
	private int position_num;
	private int projects_num;
	private String tag_sign;
	private String Position;

	public SignTot(int projects_tag_num, int position_num, int projects_num, String tag_sign) {
		this.projects_tag_num = projects_tag_num;
		this.position_num = position_num;
		this.projects_num = projects_num;
		this.tag_sign = tag_sign;
	}

}
