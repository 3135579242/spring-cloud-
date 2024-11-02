package lee.ocean.cloud.openfeign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "shopcart-service-demo", path = "/shop-cart")
public interface NewBeeShopCartDemoService {

    @GetMapping("/getGoodsId")
    Integer getGoodsId(
            @RequestParam("cartId") Integer cartId
    );

    @DeleteMapping("/{cartId}")
    Boolean deleteItem(
            @PathVariable("cartId") Integer cartId
    );

}
