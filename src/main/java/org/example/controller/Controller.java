package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.mappers.MyMapper;
import org.example.pojo.Block;
import org.example.pojo.Status;
import org.example.repository.*;
import org.example.pojo.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@Slf4j
@RestController
public class Controller {
    @Autowired
    private FraudRepo data;
    @Autowired
    private MyMapper myMapper;
//    @Autowired
//    private Mapper mapper;

    @PostMapping(value = "/block")
    public ResponseEntity<Object> block(@RequestBody Block block){
        if (data.findByNumber(block.getNumber())!=null) {
            FraudEntity fraudEntity = data.findByNumber(block.getNumber());
            FraudDAO fraudDAO = myMapper.EntityToDAO(fraudEntity);
            if (!fraudDAO.isFlagOfBlocking()) {
                fraudDAO.setFlagOfBlocking(true);
                fraudDAO.setTimeOfBlocking(OffsetDateTime.now());
                log.info("user with phone number "+ fraudDAO.getNumber()+" is blocked now ("+ fraudDAO.getTimeOfBlocking()+")");
                Status status = new Status(fraudDAO.getTimeOfBlocking(), "BLOCKED");
                data.save(myMapper.DAOToEntity(fraudDAO));
                return new ResponseEntity<>(status, HttpStatus.OK);
            } else {
                log.info("user with phone number "+ fraudDAO.getNumber()+" is already  blocked "+ fraudDAO.getTimeOfBlocking());
                Status status = new Status(fraudDAO.getTimeOfBlocking(), "ALREADY_BLOCKED");
                return new ResponseEntity<>(status, HttpStatus.OK);
            }
        }
        else{
            Error error= new Error(566,"Number not found in data base");
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

        }

    }
}
