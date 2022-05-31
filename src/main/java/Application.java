import model.*;
import services.PostingService;
import utils.ListUtils;
import utils.PostingUtils;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        PostingService postingService = new PostingService();

        List<Posting> postingList = new ArrayList<>();

        postingList.addAll(PostingUtils.getPostings());

        System.out.println("---------------Ej1--------------------------------------------------");

        ListUtils listUtils = new ListUtils();
        List<String> listString = new ArrayList<>();

        listString.add("Funciona?");
        listString.add("Creo");
        listString.add("que");
        listString.add("si");

        listUtils.stringSeparator(listString);

        System.out.println("---------------Ej2--------------------------------------------------");
        Posting postDuplicated = new Posting(47439966, "departamento en venta en desarrllo", new Price(245000L, CurrencyEnum.DOLAR), RealestateTypeEnum.APARTMENT, OperationTypeEnum.SELL, PostingType.UNIT, 0.98);
        new PostingService().savePosting(postDuplicated);

        System.out.println("---------------Ej3--------------------------------------------------");
        new PostingUtils().add100FakePost();

        System.out.println("---------------Ej4--------------------------------------------------");

        postingService.filterListByOperationTypeEj(postingList);

        System.out.println("---------------Ej5--------------------------------------------------");
        postingService.separateList(postingList);
        System.out.println("---------------Ej6--------------------------------------------------");
        List<Posting> postingListFiltered = postingService.removePostingByRange(postingList);
        for (Posting post : postingListFiltered) {
            System.out.println(post);
        }
        System.out.println("---------------Ej7--------------------------------------------------");
        List<Posting> postingsD1 = new ArrayList<>();
        postingsD1.addAll(PostingUtils.getPostings());

        List<Posting> postingsD2 = new ArrayList<>();
        postingsD2.addAll(PostingUtils.getPostingsToRemove());

        List<Posting> duplicatedPosting = postingService.duplicatedPosting(postingsD1, postingsD2);
        System.out.println(duplicatedPosting.size());
    }
}
