package net.softsociety.maru.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommitWorker {
	private int commit_worker_num; 
    private int projects_num; 
    private int worker_num;
    private String worker_detail;
    private String commit_date;
    private String end_date;
}
