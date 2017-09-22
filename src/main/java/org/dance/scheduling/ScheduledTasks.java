package org.dance.scheduling;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ScheduledTasks {
	 private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	    @Scheduled(fixedRate = 5000)
	    public void reportCurrentTime() {
	        log.info("The time is now {}" , dateFormat.format(new Date()));
	    }
	    
	    @Scheduled(cron="0 */1 * * * *",zone="IST")
	    public void reportAfterAMinute() {
	        log.info("The time after Minute is now {}" , dateFormat.format(new Date()));
	    }
}
