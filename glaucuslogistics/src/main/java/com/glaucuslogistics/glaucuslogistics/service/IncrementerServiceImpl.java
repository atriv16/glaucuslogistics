package com.glaucuslogistics.glaucuslogistics.service;

import com.glaucuslogistics.glaucuslogistics.repository.IncrementerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class IncrementerServiceImpl implements IncrementerService {

    private static final Logger LOGGER= LoggerFactory.getLogger(IncrementerService.class);
    @Autowired
    public IncrementerRepository incrementerRepository;

    @Override
    public void incrementValue() throws SQLException {
        try {
            int count = incrementerRepository.incrementValue();
            if (count != 1) {
                throw new SQLException("Error occurred while incrementing");
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw e;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }
}
