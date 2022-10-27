package com.springboot.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController // 이게 붙어야 spring이 controller로 인식, dispatcherServlet이 매핑해줄 controller를 등록
@RequestMapping("/api/v1/get-api") // controller가 할당 된 후 어떤 method를 실행할지 연결해주는 어노테이션
public class HelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello() {
        return "Hello World";
    }

    @GetMapping(value = "/name")
    public String getName() {
        return "ajin";
    }
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }

    @GetMapping(value = "/request1")
    public String getVariable2(@RequestParam String name, @RequestParam String email, @RequestParam String organization) {

        return String.format("%s %s %s ", name, email, organization);
    }

}
