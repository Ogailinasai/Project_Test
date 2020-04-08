package com.test.controller;


import com.test.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Map;

@Controller
@RequestMapping("/hp")
public class TestController {

    @RequestMapping("/test/{id}")
    public ResponseEntity<User> HpTest(
            @PathVariable(value = "id") String id,
            @RequestParam(value = "name",defaultValue = "") String name
    ){
        System.out.println("id:"+id);
        System.out.println("name:"+name);

        String str="参数错误";

        User user = new User();
        user.setName(name);
        user.setAge(13);
        user.setPhone("123456");
        user.setPhoto("asd.jpg");

        if("11".equals(id)&&"hh".equals(name)){
            return ResponseEntity.ok(user);
        }

        return null;
    }

    @RequestMapping("/testpost/{id}")
    public ResponseEntity<User> HpTestPost(@PathVariable("id") String id, @RequestBody Map<String,String> map){

        User user = new User();
        user.setName(map.get("name"));
        user.setAge(13);
        user.setPhone("123456");
        user.setPhoto("asd.jpg");

        if("11".equals(id)&&"post".equals(map.get("name"))){
            return ResponseEntity.ok(user);
        }

        return null;
    }
}
