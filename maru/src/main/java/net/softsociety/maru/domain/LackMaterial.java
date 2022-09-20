package net.softsociety.maru.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LackMaterial {
	private int need_material_num;
	private int project_num;
	private String project_name;
	private int material_num;
	private String material_name;
	private int price;
	private int count;
	private String commit_date;
}
