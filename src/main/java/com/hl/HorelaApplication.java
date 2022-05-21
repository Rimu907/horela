package com.hl;

import cn.dev33.satoken.SaManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Date:2022/3/24 10:55
 * @Author:NANDI_GUO
 */
@Slf4j
@SpringBootApplication
public class HorelaApplication {
    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(HorelaApplication.class,args);
        log.info("启动成功：Sa-Token配置如下：" + SaManager.getConfig());
    }
}
