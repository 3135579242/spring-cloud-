package lee.ocean.cloud.api;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

@RestController
public class TestController {

    @Resource
    private DataSource dataSource;

    @GetMapping("/dataSource")
    public String dataSource() throws SQLException {
        String dataSourceClass = dataSource.getClass().toString();
        boolean haveConnection = dataSource.getConnection() == null ? false : true;
        return "数据源类型" + dataSource + ", 是否连接成功。" + haveConnection;
    }

}
