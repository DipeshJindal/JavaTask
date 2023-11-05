package org.example;

import org.example.exchange.StockExchange;
import org.example.institutions.Institution;
import org.example.shares.Share;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Share sh1 = new Share("C1-Share-1",100);
        Share sh2 = new Share("C1-Share-2",100);
        Share sh3 = new Share("C2-Share-1",100);
        Share sh4 = new Share("C2-Share-2",100);

        Institution inst1 = new Institution("inst1");
        Institution inst2 = new Institution("inst2");
        Institution inst3 = new Institution("inst3");

        StockExchange exchange = new StockExchange("123");
        exchange.registerInstitutions(Arrays.asList(inst1,inst2,inst3));
        exchange.registerShares(Arrays.asList(sh1, sh2, sh3, sh4));



    }
}