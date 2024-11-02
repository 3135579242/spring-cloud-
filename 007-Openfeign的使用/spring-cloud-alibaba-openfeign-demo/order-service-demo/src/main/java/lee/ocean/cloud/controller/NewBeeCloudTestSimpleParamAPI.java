package lee.ocean.cloud.controller;


import lee.ocean.cloud.openfeign.NewBeeGoodsDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class NewBeeCloudTestSimpleParamAPI {

    @Resource
    private NewBeeGoodsDemoService newBeeGoodsDemoService;

    @GetMapping("/order/goodsDetailByParams")
    public String goodsDetailByParams(
            @RequestParam("sellStatus") Integer sellStatus,
            @RequestParam("goodsId") Integer goodsId
    ) {
        return newBeeGoodsDemoService.goodsDetailByParams(sellStatus, goodsId);
    }

    @GetMapping("/order/listByIdArray")
    public String listByIdArray() {

        Integer[] goodsIds = new Integer[4];

        goodsIds[0] = 1;
        goodsIds[1] = 3;
        goodsIds[2] = 5;
        goodsIds[3] = 7;

        String[] result = newBeeGoodsDemoService.listByIdArray(goodsIds);
        String resultString = "";
        for (String s : result) {
            resultString += s + " ";
        }
        return resultString;

    }

    @GetMapping("/order/listByIdList")
    public String listByIdList() {

        List<Integer> goodsIds = new ArrayList<>();

        goodsIds.add(2);
        goodsIds.add(4);
        goodsIds.add(6);
        goodsIds.add(8);

        List<String> result = newBeeGoodsDemoService.listByIdList(goodsIds);
        StringBuilder resultString = new StringBuilder();

        for (String s : result) {
            resultString.append(s).append(" ");
        }

        return resultString.toString();
    }

}
