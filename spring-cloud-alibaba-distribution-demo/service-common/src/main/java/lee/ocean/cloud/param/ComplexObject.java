package lee.ocean.cloud.param;

import lee.ocean.cloud.entity.NewBeeCartItem;
import lee.ocean.cloud.entity.NewBeeGoodsInfo;

import java.util.List;

public class ComplexObject {

    private Integer requestNum;

    private List<Integer> cartIds;

    private List<NewBeeGoodsInfo> newBeeGoodsInfos;

    private NewBeeCartItem newBeeCartItem;

    public Integer getRequestNum() {
        return requestNum;
    }

    public void setRequestNum(Integer requestNum) {
        this.requestNum = requestNum;
    }

    public List<Integer> getCartIds() {
        return cartIds;
    }

    public void setCartIds(List<Integer> cartIds) {
        this.cartIds = cartIds;
    }

    public List<NewBeeGoodsInfo> getNewBeeGoodsInfos() {
        return newBeeGoodsInfos;
    }

    public void setNewBeeGoodsInfos(List<NewBeeGoodsInfo> newBeeGoodsInfos) {
        this.newBeeGoodsInfos = newBeeGoodsInfos;
    }

    public NewBeeCartItem getNewBeeCartItem() {
        return newBeeCartItem;
    }

    public void setNewBeeCartItem(NewBeeCartItem newBeeCartItem) {
        this.newBeeCartItem = newBeeCartItem;
    }

    @Override
    public String toString() {
        return "ComplexObject{" +
                "requestNum=" + requestNum +
                ", cartIds=" + cartIds +
                ", newBeeGoodsInfos=" + newBeeGoodsInfos +
                ", newBeeCartItem=" + newBeeCartItem +
                '}';
    }
}
