package com.cao;

import redis.clients.jedis.Jedis;

import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println(jedis.get("hello"));
        jedis.set("hello",LocalDateTime.now().toString());
    }
}
