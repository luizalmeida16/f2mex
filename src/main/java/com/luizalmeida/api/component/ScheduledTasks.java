package com.luizalmeida.api.component;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.luizalmeida.api.service.DataFromEndpoint;

@Component
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    
    
    public void scheduleTaskWithFixedRate() {}
    
    @Scheduled(fixedRateString = "#{${interval} * 1000}")
    public void scheduleTaskWithFixedDelay() throws MalformedURLException, IOException {
        logger.info("Fixed Delay Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
        
        DataFromEndpoint data = DataFromEndpoint.getInstance();
		BufferedReader reader = data.getBufferDataFromUrl("http://challenge.carjump.net/A");
		data.setData(reader);
		reader.close();
    }
}
