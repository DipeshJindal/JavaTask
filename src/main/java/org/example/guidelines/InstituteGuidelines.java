package org.example.guidelines;

import org.example.exchange.StockExchange;

public interface InstituteGuidelines {
    void update(String name1,String name2,int a,int b);
    void registerExchange(StockExchange obj);
    void update(String institutionName,String shareName ,int quantity);
}
