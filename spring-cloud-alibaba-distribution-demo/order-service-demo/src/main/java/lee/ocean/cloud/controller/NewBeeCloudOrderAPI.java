package lee.ocean.cloud.controller;

import lee.ocean.cloud.openfeign.NewBeeGoodsDemoService;
import lee.ocean.cloud.openfeign.NewBeeShopCartDemoService;
import lee.ocean.cloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class NewBeeCloudOrderAPI {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/saveOrder")
    public Boolean saveOrder(
            @RequestParam("cartId") Integer cartId
    ) {
        return orderService.saveOrder(cartId);
    }

}
