package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController // 이클래스는 스프링 부트가 지원하는 MVC중, Controller임. 어노테이션을 보고 이 컨트롤러를 확인 함
public class HelloController {

    @GetMapping("/hello") // /hello 로 요청이 오면 문자열 hello로 반환
    public String hello(){
        return "hello"; //스프링부트는 뷰 구현안해도 리턴한 값으로 보여짐. 원래는 뷰 구현해야 보임
    }

    @GetMapping("/hello/dto")
   public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount); //제이슨 처리를 해서 보여줌
        //localhost:8080/hello/dto?name=노수경&amount=1000

        //@RequestParam은 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
    }


}
