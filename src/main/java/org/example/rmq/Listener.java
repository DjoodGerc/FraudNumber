package org.example.rmq;


import org.example.mappers.MyMapper;
import org.example.pojo.Call;
import org.example.repository.FraudDAO;
import org.example.repository.FraudRepo;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@EnableRabbit
public class Listener {
    @Autowired
    private FraudRepo data;
    @Autowired
    private MyMapper myMapper;

    @RabbitListener(queues = "fraud_numbers")
    public void listener(@Payload Call call) throws IOException {
        FraudDAO fraudDAO =new FraudDAO(call.getCallerPhoneNumber());
        if (data.countAllByNumber(fraudDAO.getNumber())==0){
            data.save(myMapper.DAOToEntity(fraudDAO));
        }
    }
}