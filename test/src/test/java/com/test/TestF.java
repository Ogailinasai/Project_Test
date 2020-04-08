package com.test;


import com.TestStart;
import com.test.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = TestStart.class)
public class TestF {

//    @Autowired
//    private RestTemplate restTemplate;


    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory){
        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(15000);
        factory.setReadTimeout(5000);
        return factory;
    }

    @Test
    public void test1(){

        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(15000);
        factory.setReadTimeout(5000);

        RestTemplate restTemplate = new RestTemplate(factory);

//        域名传值
        String url="http://localhost:8080/hp/test/11?name=hh";
        ResponseEntity<User> forEntity = restTemplate.getForEntity(url, User.class);

        System.out.println("\t"+"ResponseEntity:"+forEntity+"\n");

//        map传值
        String url1="http://localhost:8080/hp/test/11?name={name}";
        HashMap<String, String> map = new HashMap<>();
        map.put("name","hh");
        ResponseEntity<User> forEntity1=restTemplate.getForEntity(url1,User.class,map);

        User body = forEntity1.getBody();

        System.out.println("Get:"+body);


//        post请求
        String url2="http://localhost:8080/hp/testpost/11";
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("name","post");
        ResponseEntity<User> userResponseEntity = restTemplate.postForEntity(url2, map1, User.class);
        System.out.println("Post:"+userResponseEntity.getBody());
    }
}
