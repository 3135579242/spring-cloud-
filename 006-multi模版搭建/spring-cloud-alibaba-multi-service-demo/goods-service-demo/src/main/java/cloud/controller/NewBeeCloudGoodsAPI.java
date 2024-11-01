package cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewBeeCloudGoodsAPI {

    @Value("${server.port}")
    private String port;

    @GetMapping("/goods/{goodsId}")
    public String goodsDetail(@PathVariable("goodsId") Integer goodsId) {
        if (goodsId < 1 || goodsId > 100000) {
            return "查询商品为空，当前服务的端口号为 " + port;
        }
        String goodsName = "商品" + goodsId;
        return goodsName + ", 当前服务的端口号为 " + port;
    }

}
