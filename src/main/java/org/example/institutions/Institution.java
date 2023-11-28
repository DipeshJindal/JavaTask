package org.example.institutions;

import org.example.exchange.StockExchange;
import org.example.guidelines.InstituteGuidelines;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Institution implements InstituteGuidelines {
    private String name;
    private List<StockExchange> exchanges;

    public Institution(String name) {
        this.exchanges = new ArrayList<>();
        this.name = name;
    }

    @Override
    public void registerExchange(StockExchange obj) {
        exchanges.add(obj);
    }

    public List<StockExchange> getExchanges() {
        return exchanges;
    }

    public String getName() {
        return name;
    }
    @Override
    public void update(String exchangeName, String shareName, int oldPrice, int newPrice) {
        if (newPrice > oldPrice) {
            notifyExchange(exchangeName,shareName, 10);
        }
    }

    private void notifyExchange(String exchangeName, String shareName, int quantity) {
        Optional<StockExchange> obj = getExchanges().stream().filter(o -> exchangeName.equals(o.getExchangeName())).findFirst();
        if (obj.isPresent()) {
            StockExchange ex = obj.get();
            ex.update(getName(), shareName ,quantity);
        }
    }

    @Override
    public void update(String institutionName,String shareName, int quantity) {
        System.out.println(String.format("From %s : %s bought %d share of %s",getName(),institutionName,quantity,shareName));
    }
}
