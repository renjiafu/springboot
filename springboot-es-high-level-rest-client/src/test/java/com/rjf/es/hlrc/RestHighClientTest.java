package com.rjf.es.hlrc;

/*
 *
 *   Rene
 *   2020/7/9 22:13
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EsRestApp.class)
public class RestHighClientTest {


    @Test
    public void print(){
        System.out.println("Hello Rene!");
    }
}
