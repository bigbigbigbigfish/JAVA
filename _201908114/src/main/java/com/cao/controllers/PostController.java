package com.cao.controllers;

import com.cao.http.*;
import redis.clients.jedis.Jedis;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PostController extends Controller {
    @Override
    public void doPost(Request request, Response response) throws IOException {
        String id = UUID.randomUUID().toString();
        String title = request.getRequestParm("title");
        String author = request.getRequestParm("author");
        String content = request.getRequestParm("content");
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String data = sdf.format(new Date());

        Jedis jedis = new Jedis("localhost");

        String key = String.format("article_(%s)", id);
        Map<String,String> value = new HashMap<>();
        value.put("id",id);
        value.put("author",author);
        value.put("title",title);
        value.put("content",content);
        value.put("date",data);
        jedis.hmset(key,value);
        key = String.format("%article_(%s)_list",author);
        jedis.lpush("article_id_lise",id);
        response.println("发表成功");

    }
}
