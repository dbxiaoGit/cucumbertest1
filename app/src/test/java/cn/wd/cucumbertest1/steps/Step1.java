package cn.wd.cucumbertest1.steps;

import io.cucumber.java8.Zh_cn;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Step1 implements Zh_cn {
    public Step1() {
        当("发送短信给手机号{string}" ,(String string) -> {
            //log.info("手机号码是：{}",string);
            System.out.println("手机号码是："+string);
        });
    }
}
