package lee.ocean.cloud.openfeign;


import lee.ocean.cloud.entity.NewBeeGoodsInfo;
import lee.ocean.cloud.param.ComplexObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "goods-service-demo", path = "/goods")
public interface NewBeeGoodsDemoService {

    @PutMapping("/{goodsId}")
    Boolean deStock(
            @PathVariable("goodsId") Integer goodsId
    );

}
