package lee.ocean.cloud.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import io.seata.spring.annotation.GlobalTransactional;
import lee.ocean.cloud.openfeign.NewBeeGoodsDemoService;
import lee.ocean.cloud.openfeign.NewBeeShopCartDemoService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class OrderService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private NewBeeGoodsDemoService newBeeGoodsDemoService;

    @Resource
    private NewBeeShopCartDemoService newBeeShopCartDemoService;

    @Transactional
    @GlobalTransactional
    public Boolean saveOrder(Integer cartId) {

        Integer goodsId = newBeeShopCartDemoService.getGoodsId(cartId);

        Boolean deStockResult = newBeeGoodsDemoService.deStock(goodsId);

        Boolean cartResult = newBeeShopCartDemoService.deleteItem(cartId);

        if (deStockResult && cartResult) {
            int result = jdbcTemplate.update("insert into tb_order(cart_id) value (?)", cartId);
            return (result > 0);
        }
        return false;
    }

}
