package al.ocean.mall.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ELKTestController {

    private static final Logger log = LoggerFactory.getLogger(ELKTestController.class);

    @GetMapping("/elk-logs")
    @ResponseBody
    public String elkTest() {
        log.debug("DEBUG级别日志输出 --> ELK");
        log.info("INFO级别日志输出 --> ELK");
        log.error("ERROR级别日志输出 --> ELK");

        return "hello,elk!";
    }

}
