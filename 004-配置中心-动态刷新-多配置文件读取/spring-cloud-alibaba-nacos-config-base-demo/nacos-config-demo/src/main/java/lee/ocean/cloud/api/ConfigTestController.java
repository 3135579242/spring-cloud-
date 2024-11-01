package lee.ocean.cloud.api;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigTestController {

    @Value("${activitySwitch.val:false}")
    private Boolean activitySwitch;

    @GetMapping("/configTest")
    public String configTest() {
        if (activitySwitch) {
            return "页面渲染数据完成!!!";
        } else {
            return "活动未开启!!!";
        }
    }

}
