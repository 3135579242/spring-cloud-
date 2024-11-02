package cloud.controller;

import lee.ocean.cloud.entity.NewBeeGoodsInfo;
import lee.ocean.cloud.param.ComplexObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NewBeeCloudGoodsAPI {

    @Value("${server.port}")
    private String port;

    @GetMapping("/goods/{goodsId}")
    public String goodsDetail(@PathVariable("goodsId") Integer goodsId) {
        if (goodsId < 1 || goodsId > 100000) {
            return "查询商品为空，当前服务的端口号为 " + port;
        }
        String goodsName = "商品" + goodsId;
        return goodsName + ", 当前服务的端口号为 " + port;
    }

    @GetMapping("/goods/detail")
    public String goodsDetailByParams(
            @RequestParam("sellStatus") Integer sellStatus,
            @RequestParam("goodsId") Integer goodsId
    ) {
        if (goodsId < 1 || goodsId > 100000) {
            return "查询商品为空，当前服务的端口号为 " + port;
        }
        String goodsName = "商品 " + goodsId + ", 上架状态 " + sellStatus;
        return "goodsDetailByParams" + goodsName + ", 当前服务的端口号为 " + port;
    }

    @GetMapping("/goods/listByIdArray")
    public String[] listByIdArray(
            @RequestParam("goodsIds") Integer[] goodsIds
    ) {
        if (goodsIds.length < 1) {
            return null;
        }
        String[] goodsInfos = new String[goodsIds.length];

        for (int i = 0; i < goodsInfos.length; i++) {
            goodsInfos[i] = "商品 " + goodsIds[i];
        }
        return goodsInfos;
    }

    @GetMapping("/goods/listByIdList")
    public List<String> listByIdList(
            @RequestParam("goodsIds") List<Integer> goodsIds
    ) {
        if (CollectionUtils.isEmpty(goodsIds)) {
            return null;
        }
        List<String> goodsInfos = new ArrayList<>();
        for (Integer goodsId : goodsIds) {
            goodsInfos.add("商品 " + goodsId);
        }
        return goodsInfos;
    }

    @PostMapping("/goods/updNewBeeGoodsInfo")
    public NewBeeGoodsInfo updNewBeeGoodsInfo(
            @RequestBody NewBeeGoodsInfo newBeeGoodsInfo
    ) {
        if (newBeeGoodsInfo.getGoodsId() > 0) {
            Integer stock = newBeeGoodsInfo.getStock();
            stock = stock - 1;
            newBeeGoodsInfo.setStock(stock);
        }
        return newBeeGoodsInfo;
    }

    @PostMapping("/goods/complexObject")
    public ComplexObject complexObject(
            @RequestBody ComplexObject complexObject
    ) {
        Integer requestNum = complexObject.getRequestNum();
        requestNum = requestNum - 1;
        complexObject.setRequestNum(requestNum);
        return complexObject;
    }

    @PostMapping("/goods/page/{pageNum}")
    public String goodsList(
            @PathVariable("pageNum") Integer pageNum
    ) {
        return "请求goodsList, 当前服务端口号为 " + port;
    }

}
