package com.springboot.hello.controller;

import com.springboot.hello.domain.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController // 이게 붙어야 spring이 controller로 인식, dispatcherServlet이 매핑해줄 controller를 등록
@RequestMapping("/api/v1/get-api") // controller가 할당 된 후 어떤 method를 실행할지 연결해주는 어노테이션
@Slf4j
public class GetController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String gethello() {
        log.info("gethello으로 요청이 들어왔습니다");
        return "Hello World";
    }

    @GetMapping(value = "/name")
    public String getName() {
        log.info("getName으로 요청이 들어왔습니다");
        return "ajin";
    }
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        log.info("getVariable1으로 요청이 들어왔습니다. variable1:{}", variable);
        return variable;
    }

    @GetMapping(value = "/request1")
    public String getVariable1(@RequestParam String name, @RequestParam String email, @RequestParam String organization) {
        log.info("getVariable1으로 요청이 들어왔습니다");
        return String.format("%s %s %s ", name, email, organization);
    }
    @GetMapping(value = "/request2")
    public String getVariable2(@RequestParam Map<String, String> param){
        param.entrySet().forEach((map)->{
            System.out.printf("key : %s ,value : %s\n", map.getKey(), map.getValue());
        });
        log.info("getVariable2으로 요청이 들어왔습니다");
        return "request2가 호출 완료 되었습니다";
    }
    @GetMapping(value = "/request3")
    public String getRequestParam(MemberDto memberDto){
        log.info("getRequestParam으로 요청이 들어왔습니다");
        return memberDto.toString();
    }
}
