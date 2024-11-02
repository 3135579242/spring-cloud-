package cloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewBeeCloudShopCarAPI {

    @Value("${server.port}")
    private String port;

    @GetMapping("/shop-cart/{cartId}")
    public String goodsDetail(@PathVariable("cartId") Integer cartId) {
        if (cartId < 0 || cartId > 100000) {
            return "查询购物项为空，当前服务的端口号为 " + port;
        }
        String cartItem = "购物项" + cartId;
        return cartItem + ", 当前服务的端口号为 " + port;
    }

    @GetMapping("/shop-cart/page/{pageNum}")
    public String shopCartList(
            @PathVariable("pageNum") Integer pageNum
    ) {
        return "请求shopCartList, 当前服务端口号为 " + port;
    }

}
