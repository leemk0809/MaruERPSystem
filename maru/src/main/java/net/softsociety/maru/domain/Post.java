package net.softsociety.maru.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class Post {
	
	private int post_num;
	private String title;
	private int building_type_num;
	private int price;
	private int area;
	private int building_size;
}
