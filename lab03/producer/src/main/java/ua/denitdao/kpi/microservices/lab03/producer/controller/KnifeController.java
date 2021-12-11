package ua.denitdao.kpi.microservices.lab03.producer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.denitdao.kpi.microservices.lab03.producer.validation.XsdValidator;

@Slf4j
@RestController
@RequestMapping(value = "/knife")
public class KnifeController {

    @Autowired
    private XsdValidator validator;

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Exchange exchange;

    @PostMapping
    public String createKnife(@RequestBody String message) {
        validator.validateXMLSchema(message);
        template.convertAndSend(exchange.getName(), "knife.created", message);
        return "Success";
    }
}
