package com.rjf.redis.web;

/*
 *
 *   Rene
 *   2020/6/27 20:25
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
class RedisController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/add")
    public String add(@RequestParam("key") String key, @RequestParam("value") String value){
        stringRedisTemplate.opsForValue().append(key, value);

        return "success";
    }

    @GetMapping("/get")
    public String get(@RequestParam("key") String key){
        String s = stringRedisTemplate.opsForValue().get(key);
        return "redis get : "+s;
    }
}
