package services;

import model.Posting;

import java.util.Comparator;

public class PostingSortByQuality implements Comparator<Posting> {
    @Override
    public int compare(Posting posting1, Posting posting2) {
        Double rest = (posting1.getQuality() - posting2.getQuality());
        if (rest<0) return 1;
        if (rest>0)return  -1;
        return 0;
    }
}
