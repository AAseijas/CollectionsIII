package services;

import model.CurrencyEnum;
import model.Price;

import java.util.Comparator;

public class PriceSortByParameters implements Comparator<Price> {

    @Override
    public int compare(Price price, Price price2) {
        int restAmount = Long.compare(price.getAmount(), price2.getAmount());
        int restcurrencyEnum = price.getCurrency().name().compareTo(price2.getCurrency().name());
        return restcurrencyEnum == 0 ? restAmount : restcurrencyEnum;
    }
}
