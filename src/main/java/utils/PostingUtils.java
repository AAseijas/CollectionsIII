package utils;

import com.github.javafaker.Faker;
import model.CurrencyEnum;
import model.OperationTypeEnum;
import model.Posting;
import model.PostingType;
import model.Price;
import model.RealestateTypeEnum;
import services.PostingService;

import java.util.*;

public class PostingUtils {

    private static Collection<Posting> postings = null;
    private static Collection<Posting> postingsToRemove = null;

    public static Collection<Posting> getPostings() {
        postings = new ArrayList<>();
        postings.add(new Posting(49606924, "Departamento en venta", new Price(120000L, CurrencyEnum.DOLAR), RealestateTypeEnum.APARTMENT, OperationTypeEnum.SELL, PostingType.PROPERTY, 0.87));
        postings.add(new Posting(49146468, "Departamento en venta Belgrano", new Price(127500L, CurrencyEnum.DOLAR), RealestateTypeEnum.APARTMENT, OperationTypeEnum.SELL, PostingType.PROPERTY, 0.34));
        postings.add(new Posting(47345002, "Departamento en alquiler", new Price(24000L, CurrencyEnum.PESOS), RealestateTypeEnum.APARTMENT, OperationTypeEnum.RENT, PostingType.PROPERTY, 0.52));
        postings.add(new Posting(49601196, "casa en alquiler", new Price(35000L, CurrencyEnum.PESOS), RealestateTypeEnum.HOUSE, OperationTypeEnum.RENT, PostingType.PROPERTY, 0.13));
        postings.add(new Posting(48795670, "casa en venta", new Price(300000L, CurrencyEnum.DOLAR), RealestateTypeEnum.HOUSE, OperationTypeEnum.SELL, PostingType.UNIT, 0.22));
        postings.add(new Posting(47439966, "departamento en venta en desarrllo", new Price(245000L, CurrencyEnum.DOLAR), RealestateTypeEnum.APARTMENT, OperationTypeEnum.SELL, PostingType.UNIT, 0.98));
        postings.add(new Posting(47408356, "Desarrollo en pozo para inversion", new Price(175000L, CurrencyEnum.DOLAR), RealestateTypeEnum.APARTMENT, OperationTypeEnum.SELL, PostingType.DEVELOPMENT, 0.88));
        postings.add(new Posting(49240890, "Alquiler de departamento, oportunidad!", new Price(14000L, CurrencyEnum.PESOS), RealestateTypeEnum.APARTMENT, OperationTypeEnum.RENT, PostingType.PROPERTY, 0.75));
        postings.add(new Posting(48095851, "Alquiler de casa en Mar del plata", new Price(20000L, CurrencyEnum.PESOS), RealestateTypeEnum.HOUSE, OperationTypeEnum.RENT, PostingType.PROPERTY, 0.67));
        postings.add(new Posting(49132130, "Venta de casa en Cordoba", new Price(287000L, CurrencyEnum.DOLAR), RealestateTypeEnum.HOUSE, OperationTypeEnum.SELL, PostingType.PROPERTY, 0.39));
        return postings;
    }

    public static Collection<Posting> getPostingsToRemove() {
        postingsToRemove = new ArrayList<>();
        postingsToRemove.add(new Posting(49146468, "Departamento en venta Belgrano", new Price(127500L, CurrencyEnum.DOLAR), RealestateTypeEnum.APARTMENT, OperationTypeEnum.SELL, PostingType.PROPERTY, 0.34));
        postingsToRemove.add(new Posting(47439966, "departamento en venta en desarrllo", new Price(245000L, CurrencyEnum.DOLAR), RealestateTypeEnum.APARTMENT, OperationTypeEnum.SELL, PostingType.UNIT, 0.98));
        postingsToRemove.add(new Posting(49240890, "Alquiler de departamento, oportunidad!", new Price(14000L, CurrencyEnum.PESOS), RealestateTypeEnum.APARTMENT, OperationTypeEnum.RENT, PostingType.PROPERTY, 0.75));
        postingsToRemove.add(new Posting(49132130, "Venta de casa en Cordoba", new Price(287000L, CurrencyEnum.DOLAR), RealestateTypeEnum.HOUSE, OperationTypeEnum.SELL, PostingType.PROPERTY, 0.39));
        return postingsToRemove;
    }

    public Posting generateFakePosting(RealestateTypeEnum realestateTypeEnum, OperationTypeEnum operationTypeEnum) {
        List<CurrencyEnum> currencyEnumList = Arrays.asList(CurrencyEnum.values());
        List<PostingType> postingTypeList = Arrays.asList(PostingType.values());

        Faker faker = new Faker();

        return new Posting(new Random().nextInt(), faker.address().streetAddress(), new Price(((100 - 10) + 10 * (new Random().nextLong())), currencyEnumList.get(currencyEnumList.size() - 1)), realestateTypeEnum, operationTypeEnum, postingTypeList.get(new Random().nextInt(postingTypeList.size() - 1)), new Random().nextDouble())
                ;
    }

    public void add100FakePost() {
        List<Posting> postingList = new ArrayList<>();
        postingList.addAll(PostingUtils.getPostings());
        PostingUtils postingUtils = new PostingUtils();

        for (int i = 1; i <= 100; i++) {
            if (i <= 10) {
                postingList.add(postingUtils.generateFakePosting(RealestateTypeEnum.APARTMENT, OperationTypeEnum.RENT));
            }
            if (i > 10 && i <= 20) {
                postingList.add(postingUtils.generateFakePosting(RealestateTypeEnum.APARTMENT, OperationTypeEnum.SELL)
                );
            }
            if (i > 20 && i <= 30) {
                postingList.add(postingUtils.generateFakePosting(RealestateTypeEnum.APARTMENT, OperationTypeEnum.TEMPORAL));
            }
            if (i > 30 && i <= 40) {
                postingList.add(postingUtils.generateFakePosting(RealestateTypeEnum.HOUSE, OperationTypeEnum.RENT));

            }
            if (i > 40 && i <= 50) {
                postingList.add(postingUtils.generateFakePosting(RealestateTypeEnum.HOUSE, OperationTypeEnum.SELL));

            }
            if (i > 50 && i <= 60) {
                postingList.add(postingUtils.generateFakePosting(RealestateTypeEnum.HOUSE, OperationTypeEnum.TEMPORAL));

            }
            if (i > 60 && i <= 70) {
                postingList.add(postingUtils.generateFakePosting(RealestateTypeEnum.GARAGE, OperationTypeEnum.RENT));

            }
            if (i > 70 && i <= 80) {
                postingList.add(postingUtils.generateFakePosting(RealestateTypeEnum.GARAGE, OperationTypeEnum.SELL));

            }
            if (i > 80 && i <= 90) {
                postingList.add(postingUtils.generateFakePosting(RealestateTypeEnum.GARAGE, OperationTypeEnum.TEMPORAL));

            }
            if (i > 90 && i <= 100) {
                postingList.add(postingUtils.generateFakePosting(RealestateTypeEnum.COMERCIAL, OperationTypeEnum.RENT));

            }
        }
        System.out.println("Cantidad de postings: " + postingList.size());

    }
}
