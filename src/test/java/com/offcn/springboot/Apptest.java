package com.offcn.springboot;

import com.offcn.SpringbootApplication;
import com.offcn.pojo.MUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class Apptest {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void test(){
        redisTemplate.opsForValue().set("11","haha");
        redisTemplate.opsForValue().get("11");
        MUser user=new MUser();
        user.setId(1);
        user.setName("Rex");
        user.setPassword("666");
        user.setUsername("小王紫");
        redisTemplate.opsForValue().set("user",user);
        MUser user1=(MUser) redisTemplate.opsForValue().get("user");
        System.out.println(user1);

    }
}
