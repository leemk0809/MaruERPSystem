package net.softsociety.maru.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorkerTot {
	private int worker_num;
	private String name;
	private String start_date;
	private String end_date;
}
