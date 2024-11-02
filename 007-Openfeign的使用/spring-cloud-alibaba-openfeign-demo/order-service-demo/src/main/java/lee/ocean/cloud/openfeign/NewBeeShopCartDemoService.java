package lee.ocean.cloud.openfeign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "shopcart-service-demo", path = "/shop-cart")
public interface NewBeeShopCartDemoService {

    @GetMapping("/{cartId}")
    String getShopCart(@PathVariable("cartId") Integer cartId);

}
