package model;

import java.util.Objects;

public class Posting implements Comparable<Posting> {

    private Integer postingId;
    private String title;
    private Price price;
    private RealestateTypeEnum realestateType;
    private OperationTypeEnum operationType;
    private PostingType postingType;
    private Double quality;

    public Posting(Integer postingId, String title, Price price, RealestateTypeEnum realestateType,
                   OperationTypeEnum operationType, PostingType postingType, Double quality) {
        this.postingId = postingId;
        this.title = title;
        this.price = price;
        this.realestateType = realestateType;
        this.operationType = operationType;
        this.postingType = postingType;
        this.quality = quality;
    }

    public String getTitle() {
        return title;
    }

    public Price getPrice() {
        return price;
    }

    public RealestateTypeEnum getRealestateType() {
        return realestateType;
    }

    public OperationTypeEnum getOperationType() {
        return operationType;
    }

    public PostingType getPostingType() {
        return postingType;
    }

    public Integer getPostingId() {
        return postingId;
    }

    public Double getQuality() {
        return quality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posting posting = (Posting) o;
        return Objects.equals(postingId, posting.postingId) && Objects.equals(title, posting.title) && Objects.equals(price, posting.price) && realestateType == posting.realestateType && operationType == posting.operationType && postingType == posting.postingType && Objects.equals(quality, posting.quality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postingId, title, price, realestateType, operationType, postingType, quality);
    }

    @Override
    public String toString() {
        return "Posting{" +
                "postingId=" + postingId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", realestateType=" + realestateType +
                ", operationType=" + operationType +
                ", postingType=" + postingType +
                ", quality=" + quality +
                '}';
    }

    @Override
    public int compareTo(Posting posting) {
        return this.postingId-posting.getPostingId();
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRealestateType(RealestateTypeEnum realestateType) {
        this.realestateType = realestateType;
    }

    public void setOperationType(OperationTypeEnum operationType) {
        this.operationType = operationType;
    }

    public void setPostingType(PostingType postingType) {
        this.postingType = postingType;
    }

    public void setQuality(Double quality) {
        this.quality = quality;
    }
}
