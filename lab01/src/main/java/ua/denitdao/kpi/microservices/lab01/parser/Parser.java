package ua.denitdao.kpi.microservices.lab01.parser;

public interface Parser<T> {

    T parse(String path);
}
