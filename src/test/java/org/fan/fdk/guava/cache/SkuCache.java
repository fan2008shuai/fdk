package org.fan.fdk.guava.cache;

/**
 * Created by fan.shuai on 2019/12/9.
 */
public class SkuCache {
    private String skuId;
    private String skuCode;
    private Long realQuantity;

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public Long getRealQuantity() {
        return realQuantity;
    }

    public void setRealQuantity(Long realQuantity) {
        this.realQuantity = realQuantity;
    }

    @Override
    public String toString() {
        return "SkuCache{" +
                "skuId='" + skuId + '\'' +
                ", skuCode='" + skuCode + '\'' +
                ", realQuantity=" + realQuantity +
                '}';
    }
}
