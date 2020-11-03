package com.tenpearls.quartz.config;

import com.tenpearls.quartz.job.SampleJob1;
import com.tenpearls.quartz.job.SampleJob2;
import org.quartz.*;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
// commenting this class to check if needed or not
public class QuartzConfiguration {
//    @Bean
//    public JobDetail jobADetails() {
//        return JobBuilder.newJob(SampleJob1.class).withIdentity("sampleJob1-A")
//                .storeDurably().build();
//    }
//
//    @Bean
//    public Trigger jobATrigger(JobDetail jobADetails) {
//
//        return TriggerBuilder.newTrigger().forJob(jobADetails)
//
//                .withIdentity("TriggerA")
//                .withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * ? * * *"))
//                .build();
//    }


//    @Bean
//    public JobDetail jobBDetails() {
//        return JobBuilder.newJob(SampleJob2.class).withIdentity("sampleJobB")
//                .storeDurably().build();
//    }
//
//    @Bean
//    public Trigger jobBTrigger(JobDetail jobBDetails) {
//
//        JobDataMap jobDataMap = new JobDataMap();
//
//        jobDataMap.put("somedata", UUID.randomUUID().toString());
//
//        return TriggerBuilder.newTrigger().forJob(jobBDetails)
//
//                .withIdentity("TriggerB")
//
//                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * ? * * *"))
//                .usingJobData(jobDataMap)
//                .build();
//    }
}
