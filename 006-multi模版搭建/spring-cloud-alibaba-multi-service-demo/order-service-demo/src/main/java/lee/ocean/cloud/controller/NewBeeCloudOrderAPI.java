package lee.ocean.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class NewBeeCloudOrderAPI {

    @Resource
    private RestTemplate restTemplate;

    private final String CLOUD_SHOPCART_SERVICE = "http://shopcart-service-demo";
    private final String CLOUD_GOODS_SERVICE = "http://goods-service-demo";

    @GetMapping("/order/saveOrder")
    public String saveOrder(
            @RequestParam("cartId") Integer cartId,
            @RequestParam("goodsId") Integer goodsId
    ) {
        String goodsResult = restTemplate.getForObject(CLOUD_GOODS_SERVICE + "/goods/" + goodsId, String.class);
        String shopCartResult = restTemplate.getForObject(CLOUD_SHOPCART_SERVICE + "/shop-cart/" + cartId, String.class);
        return "success! goodsResult={" + goodsResult + "}, shopCartResult={" + shopCartResult + "}";
    }


}
