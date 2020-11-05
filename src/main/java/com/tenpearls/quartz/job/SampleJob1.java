package com.tenpearls.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.util.Date;

public class SampleJob1 implements Job {
    @Override
    public void execute(JobExecutionContext context) {

        System.out.println("Hello from SampleJob1!"+ new Date());
    }
}
