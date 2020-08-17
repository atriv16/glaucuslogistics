package com.glaucuslogistics.glaucuslogistics;

import com.glaucuslogistics.glaucuslogistics.model.Incrementer;
import com.glaucuslogistics.glaucuslogistics.repository.IncrementerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GlaucuslogisticsApplication implements CommandLineRunner {

    private static Logger LOGGER = LoggerFactory.getLogger(GlaucuslogisticsApplication.class);

    @Autowired
    private IncrementerRepository incrementerRepository;

    public static void main(String[] args) {
        SpringApplication.run(GlaucuslogisticsApplication.class, args);
    }

    @Override
    public void run(String... args) {
        LOGGER.info("SETTING INTEGER VALUE TO 0");
        try {
            Incrementer incrementer = new Incrementer();
            incrementerRepository.save(incrementer);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }


    }
}
