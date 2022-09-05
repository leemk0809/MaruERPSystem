package net.softsociety.maru.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Worker {

	private int worker_num;
	private int division_num;
	private int position_num;
	private String id;
	private String password;
	private String name;
	private String phone;
	private int salary;
	
}
