package service;

import com.sun.net.httpserver.HttpExchange;

public interface IService {
    public void doGet(HttpExchange e);
    public void doPost(HttpExchange e);
    public void doPut(HttpExchange e);
    public void doDelete(HttpExchange e);
}
