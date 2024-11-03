package cloud.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lee.ocean.cloud.entity.NewBeeGoodsInfo;
import lee.ocean.cloud.param.ComplexObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class NewBeeCloudGoodsAPI {

    @Value("${server.port}")
    private String port;

    @Resource
    private JdbcTemplate jdbcTemplate;

    @PutMapping("/goods/{goodsId}")
    public Boolean deStock(
            @PathVariable("goodsId") Integer goodsId
    ) {

        int result = jdbcTemplate.update("update tb_goods set goods_stock = goods_stock - 1 where goods_id = ?", goodsId);
//        try {
//            Thread.sleep(1000 * 10);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return (result > 0);
    }


}
