package org.example.guidelines;

import org.example.institutions.Institution;
import org.example.shares.Share;

import java.util.List;

public interface StockExchangeGuidelines {
    void registerShares(List<Share> obj);

    void registerShare(Share obj);

    void registerInstitutions(List<Institution> obj);

    void registerInstitution(Institution obj);

    void changePrice(String obj, int p);
}
