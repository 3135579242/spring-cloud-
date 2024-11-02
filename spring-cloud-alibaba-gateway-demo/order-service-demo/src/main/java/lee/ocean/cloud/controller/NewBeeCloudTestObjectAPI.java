package lee.ocean.cloud.controller;

import lee.ocean.cloud.entity.NewBeeCartItem;
import lee.ocean.cloud.entity.NewBeeGoodsInfo;
import lee.ocean.cloud.openfeign.NewBeeGoodsDemoService;
import lee.ocean.cloud.param.ComplexObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class NewBeeCloudTestObjectAPI {

    @Resource
    private NewBeeGoodsDemoService newBeeGoodsDemoService;

    @GetMapping("/order/simpleObjectTest")
    public String simpleObjectTest() {
        NewBeeGoodsInfo newBeeGoodsInfo = new NewBeeGoodsInfo();
        newBeeGoodsInfo.setGoodsId(2024);
        newBeeGoodsInfo.setGoodsName("Spring Cloud Alibaba 微服务架构");
        newBeeGoodsInfo.setStock(2035);

        NewBeeGoodsInfo result = newBeeGoodsDemoService.updNewBeeGoodsInfo(newBeeGoodsInfo);

        return result.toString();
    }

    @GetMapping("/order/complexObjectTest")
    public String complexObjectTest() {

        ComplexObject complexObject = new ComplexObject();

        complexObject.setRequestNum(13);

        List<Integer> cartIds = new ArrayList<>();
        cartIds.add(2024);
        cartIds.add(13);
        complexObject.setCartIds(cartIds);

        NewBeeCartItem newBeeCartItem = new NewBeeCartItem();
        newBeeCartItem.setItemId(2025);
        newBeeCartItem.setCartString("newbee cloud");
        complexObject.setNewBeeCartItem(newBeeCartItem);

        List<NewBeeGoodsInfo> newBeeGoodsInfos = new ArrayList<>();

        NewBeeGoodsInfo newBeeGoodsInfo1 = new NewBeeGoodsInfo();
        newBeeGoodsInfo1.setGoodsName("Spring Cloud Alibaba 上");
        newBeeGoodsInfo1.setGoodsId(2024);
        newBeeGoodsInfo1.setStock(1000);

        NewBeeGoodsInfo newBeeGoodsInfo2 = new NewBeeGoodsInfo();
        newBeeGoodsInfo2.setGoodsName("Spring Cloud Alibaba 下");
        newBeeGoodsInfo2.setGoodsId(2025);
        newBeeGoodsInfo2.setStock(1000);

        newBeeGoodsInfos.add(newBeeGoodsInfo1);
        newBeeGoodsInfos.add(newBeeGoodsInfo2);

        complexObject.setNewBeeGoodsInfos(newBeeGoodsInfos);

        ComplexObject result = newBeeGoodsDemoService.complexObject(complexObject);

        return result.toString();
    }

}
