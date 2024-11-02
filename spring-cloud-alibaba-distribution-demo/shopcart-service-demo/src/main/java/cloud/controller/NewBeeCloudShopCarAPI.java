package cloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class NewBeeCloudShopCarAPI {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/shop-cart/getGoodsId")
    public Integer getGoodsId(
            @RequestParam("cartId") Integer cartId
    ) {
        Map<String, Object> cartItemObject = jdbcTemplate.queryForMap("select * from tb_cart_item where cart_id = " + cartId + " limit 1");
        if (cartItemObject.containsKey("goods_id")) {
            return (Integer) cartItemObject.get("goods_id");
        }
        return 0;
    }

    @DeleteMapping("/shop-cart/{cartId}")
    public Boolean deleteItem(
            @PathVariable("cartId") Integer cartId
    ) {
        int result = jdbcTemplate.update("delete from tb_cart_item where cart_id = " + cartId);
        return result > 0;
    }


}
