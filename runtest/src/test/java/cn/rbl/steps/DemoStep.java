package cn.rbl.steps;

import io.cucumber.java8.Scenario;
import io.cucumber.java8.Zh_cn;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoStep implements Zh_cn {
    public DemoStep(){
        当("打印数字{int}",(Integer i)->{
            log.info("数字:{}",i);
        });

        After((Scenario scenario) -> {
            log.info("after");
        });
    }
}
