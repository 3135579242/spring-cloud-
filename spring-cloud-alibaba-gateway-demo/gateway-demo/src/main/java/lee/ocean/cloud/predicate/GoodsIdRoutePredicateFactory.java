package lee.ocean.cloud.predicate;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
public class GoodsIdRoutePredicateFactory extends AbstractRoutePredicateFactory<GoodsIdRoutePredicateFactory.Config> {


    public GoodsIdRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("minValue", "maxValue");
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                String goodsId = serverWebExchange.getRequest().getQueryParams().getFirst("goodsId");
                if (goodsId != null) {
                    int numberId = Integer.parseInt(goodsId);
                    return numberId > config.getMinValue() && numberId < config.getMaxValue();
                }
                return false;
            }
        };
    }

    @Validated
    public static class Config {
        private int minValue;
        private int maxValue;

        public int getMinValue() {
            return minValue;
        }

        public void setMinValue(int minValue) {
            this.minValue = minValue;
        }

        public int getMaxValue() {
            return maxValue;
        }

        public void setMaxValue(int maxValue) {
            this.maxValue = maxValue;
        }
    }
}
