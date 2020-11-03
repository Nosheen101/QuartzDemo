package com.tenpearls.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class SampleJob2 implements Job {
    @Override
    public void execute(JobExecutionContext context) {
        System.out.println("Hello from SampleJob2!");
    }
}
