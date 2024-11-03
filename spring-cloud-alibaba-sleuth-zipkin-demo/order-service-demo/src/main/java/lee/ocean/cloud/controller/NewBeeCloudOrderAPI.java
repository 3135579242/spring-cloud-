package lee.ocean.cloud.controller;

import lee.ocean.cloud.openfeign.NewBeeGoodsDemoService;
import lee.ocean.cloud.openfeign.NewBeeShopCartDemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class NewBeeCloudOrderAPI {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private NewBeeGoodsDemoService newBeeGoodsDemoService;

    @Resource
    private NewBeeShopCartDemoService newBeeShopCartDemoService;


    private final String CLOUD_SHOPCART_SERVICE = "http://shopcart-service-demo";
    private final String CLOUD_GOODS_SERVICE = "http://goods-service-demo";

    @GetMapping("/order/saveOrder")
    public String saveOrder(
            @RequestParam("cartId") Integer cartId,
            @RequestParam("goodsId") Integer goodsId
    ) {
        // String goodsResult = restTemplate.getForObject(CLOUD_GOODS_SERVICE + "/goods/" + goodsId, String.class);
        String goodsResult = newBeeGoodsDemoService.getGoodsDetail(goodsId);
        String shopCartResult = newBeeShopCartDemoService.getShopCart(cartId);
        return "success! goodsResult={" + goodsResult + "}, shopCartResult={" + shopCartResult + "}";
    }

    private static final Logger log = LoggerFactory.getLogger(NewBeeCloudOrderAPI.class);

    @GetMapping("/logTest")
    public String logTest() {
        log.info("test info log by sleuth");
        log.error("test error log by sleuth");

        try {
            int i = 1 / 0;
        } catch (Exception e) {
            log.error("test exception log by sleuth: ", e);
        }
        return "logTest";
    }


}
