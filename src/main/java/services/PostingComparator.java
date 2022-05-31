package services;

import model.Posting;
import model.Price;

import java.util.Comparator;

public class PostingComparator implements Comparator<Posting> {

    @Override
    public int compare(Posting posting, Posting posting2) {
        Price pricePosting1 = posting.getPrice();
        Price pricePosting2 = posting2.getPrice();
        return new PriceSortByParameters().compare(pricePosting1, pricePosting2);
    }

}
