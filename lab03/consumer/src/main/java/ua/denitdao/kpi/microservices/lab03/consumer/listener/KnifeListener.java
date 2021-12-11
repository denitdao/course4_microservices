package ua.denitdao.kpi.microservices.lab03.consumer.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.denitdao.kpi.microservices.lab03.consumer.entity.Knife;
import ua.denitdao.kpi.microservices.lab03.consumer.repository.KnifeRepository;

import static ua.denitdao.kpi.microservices.lab03.consumer.ConsumerApplication.QUEUE_NAME;

@Slf4j
@EnableRabbit
@Component
public class KnifeListener {

    @Autowired
    private KnifeRepository repository;

    @RabbitListener(queues = QUEUE_NAME)
    public void receive(String message) {
        Knife knife = mapToKnife(message);
        repository.save(knife);
        log.info("Obj saved {}", knife);
    }

    static Knife mapToKnife(String xml) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            xmlMapper.registerModule(new JaxbAnnotationModule());
            return xmlMapper.readValue(xml, Knife.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
