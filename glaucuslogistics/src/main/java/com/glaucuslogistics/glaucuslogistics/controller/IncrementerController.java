package com.glaucuslogistics.glaucuslogistics.controller;

import com.glaucuslogistics.glaucuslogistics.exceptions.GlaucusExceptionHandler;
import com.glaucuslogistics.glaucuslogistics.service.IncrementerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@Controller
public class IncrementerController extends GlaucusExceptionHandler {

    @Autowired
    private IncrementerService incrementerService;

    @RequestMapping(value = "/increment", method = RequestMethod.PUT)
    public ResponseEntity incrementValue() {
        try {
            incrementerService.incrementValue();
            return new ResponseEntity("Updated", HttpStatus.OK);
        } catch (SQLException ex) {
            return glaucusSqlExceptionHandler(ex);
        } catch (Exception ex) {
            return glaucusExceptionHandler(ex);
        }
    }


}
