package lee.ocean.cloud.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerTestController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/nacosRegTest")
    public String nacosRegTest() {
        return restTemplate.getForObject("http://ocean-cloud-goods-service/goodsServiceTest", String.class);
    }

}
