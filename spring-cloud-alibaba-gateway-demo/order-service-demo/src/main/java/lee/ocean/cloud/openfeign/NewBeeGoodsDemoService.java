package lee.ocean.cloud.openfeign;


import lee.ocean.cloud.entity.NewBeeGoodsInfo;
import lee.ocean.cloud.param.ComplexObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "goods-service-demo", path = "/goods")
public interface NewBeeGoodsDemoService {

    @GetMapping("/{goodsId}")
    String getGoodsDetail(@PathVariable("goodsId") Integer goodsId);

    @GetMapping("/detail")
    String goodsDetailByParams(
            @RequestParam("sellStatus") Integer sellStatus,
            @RequestParam("goodsId") Integer goodsId
    );

    @GetMapping("/listByIdArray")
    String[] listByIdArray(
            @RequestParam("goodsIds") Integer[] goodsIds
    );

    @GetMapping("/listByIdList")
    List<String> listByIdList(
            @RequestParam("goodsIds") List<Integer> goodsIds
    );

    @GetMapping("/updNewBeeGoodsInfo")
    NewBeeGoodsInfo updNewBeeGoodsInfo(
            @RequestBody NewBeeGoodsInfo newBeeGoodsInfo
    );

    @PostMapping("/complexObject")
    ComplexObject complexObject(
            @RequestBody ComplexObject complexObject
    );


}
