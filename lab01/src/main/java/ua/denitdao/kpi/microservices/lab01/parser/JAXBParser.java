package ua.denitdao.kpi.microservices.lab01.parser;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import ua.denitdao.kpi.microservices.lab01.Main;
import ua.denitdao.kpi.microservices.lab01.entity.Knives;

public class JAXBParser implements Parser<Knives> {

    @Override
    public Knives parse(String path) {
        try {
            JAXBContext contextObj = JAXBContext.newInstance(Knives.class);

            Unmarshaller unmarshaller = contextObj.createUnmarshaller();

            return (Knives) unmarshaller.unmarshal(Main.class.getResourceAsStream(path));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
