package services;

import model.CurrencyEnum;
import model.OperationTypeEnum;
import model.Posting;
import model.Price;
import utils.ArrayPostingUtil;
import utils.PostingUtils;

import java.util.*;

public class PostingService {
    public List<Price> sortPostingByPriceParameters(List<Price> listPriceOfPosting) {
        Collections.sort(listPriceOfPosting, new PriceSortByParameters());
        return listPriceOfPosting;
    }

    public List<Posting> sortPosting(List<Posting> listPosting) {
        Collections.sort(listPosting, new PostingComparator());
        //        for (int i = 0; i < listPosting.size(); i++) {
//            for (int j = i + 1; j < listPosting.size(); j++) {
//                Price elementoActual = listPosting.get(i).getPrice();
//                Price elementoSiguiente = listPosting.get(j).getPrice();
//                if (new PriceSortByParameters().compare(elementoActual, elementoSiguiente) > 0) {
//                    listPosting.get(i).setPrice(elementoSiguiente);
//                    listPosting.get(j).setPrice(elementoActual);
//                }
//                if (new PriceSortByParameters().compare(elementoActual, elementoSiguiente) < 0) {
//                    listPosting.get(i).setPrice(elementoActual);
//                    listPosting.get(j).setPrice(elementoSiguiente);
//                }
//
//            }
//        }

        return listPosting;
    }

    public void savePosting(Posting postToSave) {
        List<Posting> postingList = new ArrayList<>();
        postingList.addAll(PostingUtils.getPostings());

        if (postingList.contains(postToSave)) {
            List<CurrencyEnum> currencyEnumList = Arrays.asList(CurrencyEnum.values());
            int indexPost = postingList.indexOf(postToSave);
            ;
            postToSave.setPrice(new Price(new Random().nextLong(), currencyEnumList.get(new Random().nextInt(currencyEnumList.size()))));
            postingList.set(indexPost, postToSave);
        } else {
            postingList.add(postToSave);
        }
        for (Posting post : postingList) {
            System.out.println(post);
        }
    }

    public void filterListByOperationTypeEj(List<Posting> postingsToFilter) {
        List<Posting> postingListFilteredRent = new ArrayList<>();
        List<Posting> postingListFilteredSell = new ArrayList<>();
        List<Posting> postingListFilteredTemporal = new ArrayList<>();

        for (Posting post : postingsToFilter) {
            if (OperationTypeEnum.RENT.equals(post.getOperationType())) {
                postingListFilteredRent.add(post);
            } else if (OperationTypeEnum.SELL.equals(post.getOperationType())) {
                postingListFilteredSell.add(post);
            } else {
                postingListFilteredTemporal.add(post);
            }
        }

        System.out.println(postingListFilteredRent.size());
        System.out.println(postingListFilteredSell.size());
        System.out.println(postingListFilteredTemporal.size());
    }

    public List<Posting> filterListByOperationType(List<Posting> postingsToFilter, OperationTypeEnum operationTypeEnum) {
        List<Posting> postingListFiltered = new ArrayList<>();

        for (Posting post : postingsToFilter) {
            if (operationTypeEnum.equals(post.getOperationType())) {
                postingListFiltered.add(post);
            }
        }

        return postingListFiltered;
    }

    public void separateList(List<Posting> postingList) {
        /** 1-METODO **/
        int mediumListIndex = (int) (postingList.size() / 2);

        List<Posting> onePartSizeList = new ArrayList<>();
        List<Posting> secondPartSizeList = new ArrayList<>();

//        for (int i = 0; i <= mediumListIndex; i++) {
//            onePartSizeList.add(postingList.get(i));
//        }
//        for (int j = mediumListIndex + 1; j < postingList.size(); j++) {
//            secondPartSizeList.add(postingList.get(j));
//        }

        /** 2-METODO **/
        onePartSizeList.addAll(postingList.subList(0, mediumListIndex + 1));
        secondPartSizeList.addAll(postingList.subList(mediumListIndex + 1, postingList.size()));

        System.out.println("1-LIST-SIZE: " + onePartSizeList.size());
        System.out.println("2-LIST-SIZE: " + secondPartSizeList.size());

    }

    public List<Posting> removePostingByRange(List<Posting> postingList) {
        List<Posting> postingsToFiltered = postingList;
        List<Posting> postingsFiltered = new ArrayList<>();
        List<Posting> subPostingList = new ArrayList<>();
        subPostingList.addAll(PostingUtils.getPostings());

        int fromIndex = postingsToFiltered.indexOf(subPostingList.get(0));
        int toIndex = postingsToFiltered.indexOf(subPostingList.get(subPostingList.size() - 1));

        /**Metodo 1**/

//        postingsToFiltered.subList(fromIndex, toIndex).clear();
//        postingsFiltered.addAll(postingsToFiltered);

        /**Metodo 2**/
        postingsFiltered.addAll(ArrayPostingUtil.removePosting(postingList, fromIndex, toIndex));

        return postingsFiltered;
    }

    public List<Posting> duplicatedPosting(List<Posting> postingList1, List<Posting> postingList2) {
        List<Posting> duplicatedListPosting = new ArrayList<>();
        List<Posting> postingListAnidade = new ArrayList<>();

        postingListAnidade.addAll(postingList1);
        postingListAnidade.addAll(postingList2);

        for (int i = 0; i < postingListAnidade.size(); i++) {
            for (int k = i + 1; k < postingListAnidade.size(); k++) {
                if (postingListAnidade.get(i).equals(postingListAnidade.get(k))) {
                    duplicatedListPosting.add(postingListAnidade.get(k));
                }
            }
        }
        return duplicatedListPosting;
    }

}
