package net.softsociety.maru.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Calender {
	private String title;
	private String start;
	private String end;
}
