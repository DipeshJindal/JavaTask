package org.example.exchange;

import org.example.guidelines.StockExchangeGuidelines;
import org.example.institutions.Institution;
import org.example.shares.Share;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StockExchange implements StockExchangeGuidelines {

    private String exchangeName;
    private List<Share> listOfShares;

    private List<Institution> institutions;

    public StockExchange(String name) {
        this.listOfShares = new ArrayList<>();
        this.institutions = new ArrayList<>();
        this.exchangeName = name;
    }

    @Override
    public void registerShares(List<Share> lst) {
        listOfShares.addAll(lst);
    }

    @Override
    public void registerShare(Share obj) {
        listOfShares.add(obj);
    }

    @Override
    public void registerInstitutions(List<Institution> lst) {
        institutions.addAll(lst);
    }

    @Override
    public void registerInstitution(Institution obj) {
        institutions.add(obj);
    }

    @Override
    public void changePrice(String share, int p) {
        Stream<Share> obj = getListOfShares().stream().filter(o -> share.equals(o.getName()));
        if (obj.count() != 0) {
            Share sh = obj.findFirst().get();
            int oldPrice = sh.getPrice();
            sh.setPrice(p);
            notifyInstitutions(share, oldPrice, p);
        } else {
            System.out.println("This Share is not Registered with Exchange");
        }
    }

    public void update(String name,String share, int p) {
        notifyInstitutions(name,share ,p);
    }

    private void notifyInstitutions(String institutionName, String shareName, int quantity) {
        for(Institution inst: getInstitutions()){
            if(!inst.getName().equals(institutionName)){
                inst.update(institutionName,shareName,quantity);
            }
        }
    }

    private void notifyInstitutions(String stockName, int oldPrice, int newPrice) {
        for (Institution inst : institutions) {
            inst.update(exchangeName,stockName, oldPrice, newPrice);
        }
    }

    public List<Share> getListOfShares() {
        return listOfShares;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public List<Institution> getInstitutions() {
        return institutions;
    }
}
