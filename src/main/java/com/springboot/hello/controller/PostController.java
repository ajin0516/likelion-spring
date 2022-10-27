package com.springboot.hello.controller;

import com.springboot.hello.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample(){
        return "Hello Post API";
    }

    @PostMapping ("/member")// json(등)형태로 넘어온 데이터를 사용할 수 있게 해줌
    public String postMember(@RequestBody Map<String , Objects> postData){
        StringBuilder sb = new StringBuilder(); // Builder Pattern

        postData.entrySet().forEach(mep -> sb.append(mep.getKey()+":"+mep.getValue()+"\n"));
        return sb.toString();
    }

    @PostMapping ("/member2")// json(등)형태로 넘어온 데이터를 사용할 수 있게 해줌
    public String postMember(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }
}
