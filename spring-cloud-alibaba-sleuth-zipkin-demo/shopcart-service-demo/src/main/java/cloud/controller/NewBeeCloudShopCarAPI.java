package cloud.controller;


import cloud.openfeign.NewBeeGoodsDemoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class NewBeeCloudShopCarAPI {

    @Value("${server.port}")
    private String port;

    @Resource
    private NewBeeGoodsDemoService newBeeGoodsDemoService;


    @GetMapping("/shop-cart/{cartId}")
    public String goodsDetail(@PathVariable("cartId") Integer cartId) {
        String result = newBeeGoodsDemoService.goodsDetail2(2025);
        if (cartId < 0 || cartId > 100000) {
            return "查询购物项为空，当前服务的端口号为 " + port;
        }
        String cartItem = "购物项" + cartId;
        return cartItem + ", 当前服务的端口号为 " + port;
    }



}
