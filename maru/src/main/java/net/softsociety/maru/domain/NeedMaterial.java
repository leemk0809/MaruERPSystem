package net.softsociety.maru.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NeedMaterial {

	private int need_material_num;
	private int project_num;
	private int material_num;
	private int count;
	
}
