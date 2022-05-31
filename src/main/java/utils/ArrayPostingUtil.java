package utils;

import model.Posting;

import java.util.ArrayList;
import java.util.List;

public class ArrayPostingUtil extends ArrayList<Posting> {

    public static List<Posting> removePosting(List<Posting> postingsToFilter, int fromIndex, int toIndex) {
        ArrayPostingUtil postingList = new ArrayPostingUtil();
        postingList.addAll(postingsToFilter);
        postingList.removeRange(fromIndex, toIndex);
        return postingList;
    }

}
