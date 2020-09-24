package net.xdclass.demoproject.controller;

import net.xdclass.demoproject.config.WXConfig;
import net.xdclass.demoproject.task.AsyncTask;
import net.xdclass.demoproject.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/test")
@PropertySource({"classpath:pay.properties"})
public class TestController {


    @Value("${wxpay.appid}")
    private String payAppid;

    @Value("${wxpay.secret}")
    private String paySecret;



    @Autowired
    private WXConfig wxConfig;


    @GetMapping("get_config")
    public JsonData testConfig(){


       Map<String,String> map = new HashMap<>();
//        map.put("appid",payAppid);
//        map.put("secret",paySecret);
//
//        return JsonData.buildSuccess(map);


        map.put("appid",wxConfig.getPayAppid());
        map.put("secret",wxConfig.getPaySecret());
        map.put("mechid",wxConfig.getPayMechId());

        return JsonData.buildSuccess(map);

    }

    /**
     * 同一异常处理验证
     * @return
     */
    @GetMapping("list")
    public JsonData testExt(){
        int i=1/0;
        return JsonData.buildSuccess("");
    }

    @Autowired
    private AsyncTask asyncTask;
    @GetMapping("async")
    public JsonData testAsync(){
        long begin =System.currentTimeMillis();
        asyncTask.task1();
        asyncTask.task2();
        asyncTask.task3();
        asyncTask.task4();
        asyncTask.task5();
        long end =System.currentTimeMillis();
        return JsonData.buildSuccess(end-begin);
    }

}
