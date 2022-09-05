package net.softsociety.maru.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class Material {
	private int material_num;
	private String material_name;
	private int count;
	private int price;
}
