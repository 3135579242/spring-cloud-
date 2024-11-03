package cloud.openfeign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "goods-service-demo", path = "/goods")
public interface NewBeeGoodsDemoService {

    @GetMapping("/goodsDetail2/{goodsId}")
    String goodsDetail2(
            @PathVariable("goodsId") Integer goodsId
    );

}
