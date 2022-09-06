package net.softsociety.maru.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommitMaterial {

	private int commit_material_num;
	private int projects_num;
	private int material_num;
	private int count;
	private String commit_date;
}
