package com.tenpearls.quartz.rest.controller;

import com.tenpearls.quartz.job.SampleJob1;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.quartz.SimpleScheduleBuilder.*;

import java.util.UUID;
// this is for testing purpose for starting schedule job..
@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private Scheduler scheduler;

    @GetMapping()
    public ResponseEntity<?> getJob(){
        try {

           // scheduler.scheduleJob(jobADetails(),jobATrigger());  this is cron example
            scheduler.scheduleJob(jobADetails(),jobASimpleTrigger());
            //scheduler.shutdown(true);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("job executed");
    }

    private JobDetail jobADetails() {
        return JobBuilder.newJob(SampleJob1.class).withIdentity("sampleJob1-A", "group1")
                .storeDurably().build();
    }


    private Trigger jobATrigger() {

        return TriggerBuilder.newTrigger()
                //.forJob(jobADetails)

                .withIdentity("Trigger-A")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * ? * * *")
                        .withMisfireHandlingInstructionFireAndProceed()) // every 20 second
                .build();
    }

    private Trigger jobASimpleTrigger() {

        return TriggerBuilder.newTrigger()
                  .withIdentity("Trigger-A-Simple","group2")
                .withSchedule(simpleSchedule().
                        withRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY).
                        withIntervalInSeconds(10).
                        withMisfireHandlingInstructionIgnoreMisfires() )//or other
                .build();
    }


}
