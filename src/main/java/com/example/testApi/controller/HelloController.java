package com.example.testApi.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RestController
@RequestMapping("/helloworld")
public class HelloController {
    /*
    1. 화면에 helloworld가 출력됩니다.
    */
    @GetMapping(value = "/helloworld/string")
    @ResponseBody
    public String helloworldString() {
        return "helloworld";
    }
    /*
    2. 화면에 {message:"helloworld"} 라고 출력됩니다.
    */
    @GetMapping(value = "/helloworld/json")
    @ResponseBody
    public Hello helloworldJson() {
        Hello hello = new Hello();
        hello.message = "helloworld";
        return hello;
    }
    /*
    3. 화면에 helloworld.ftl의 내용이 출력됩니다.
    */
    @GetMapping(value = "/helloworld/page")
    public String helloworld() {
        return "helloworld";
    }

    @GetMapping(value = "/helloworld/commentGet")
    @ResponseBody
    public String commentGet() {
        return "comment returned";
    }

    @PostMapping(value = "/helloworld/comment")
    @ResponseBody
    public String post(@RequestBody Map<String, String> requestData){

        final String[] keyy = {""};
        final String[] val = {""};
        requestData.forEach((key, value) -> {
            System.out.println("key : " + key);
            keyy[0] = key;
            System.out.println("value : " + value);
            val[0] = value;
        });
        return keyy[0] + " " + val[0];
        //return requestData;
    }

    @Setter
    @Getter
    public static class Hello {
        private String message;
    }
}
