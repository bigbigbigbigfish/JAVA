package com.cao.rest.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;




@RestController
@RequestMapping(value = "/")
public class HelloController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Map<String, String> index() {
        Map<String, String> data = new HashMap<>();
        data.put("date_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new
                Date()));
        Runtime runtime = Runtime.getRuntime();
        data.put("server_processor", String.valueOf(runtime.availableProcessors()));
        data.put("server_total_memory", runtime.totalMemory() / 1024 / 1024 + " MB");
        data.put("server_max_memory", runtime.maxMemory() / 1024 / 1024 + " MB");
        data.put("server_free_memory", runtime.freeMemory() / 1024 / 1024 + " MB");
        return data;
    }
}
