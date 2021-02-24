package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class) // 스프링   부트 테스트와 jUnit사이의 연결자 역할.
@WebMvcTest(controllers = HelloController.class) //컨트롤러의 테스트를 할건데, 그 컨트롤러는 HelloController.class라는 클래스임.
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 bean을 주입받고
    private MockMvc mvc; // 웹 API를 테스트할 때 사용하는, 스프링 MVC테스트이 시작점이다. 이  클래스를 통해서 HTTP GET/POST등에 대한 API테스트를 수행할 수 있음

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) // /hello로 http get 요청을 하는데,
                .andExpect(status().isOk())  // mvc.perform의 결과를 검증한다음, 즉 http응답이 200이 맞는지 확인한 다음
                .andExpect(content().string(hello)); // 응답받은 본문의 내용이 hello가 맞는지 확인한다.
    }

    @Test
    public void helloDto가_리턴된다() throws  Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                    get("/hello/dto")
                                    .param("name",name)
                                    .param("amount", String.valueOf(amount))) // API테스트할 때 사용되 요청 파라미터를 설정하는데, 값은 String만 가능함.
                                    .andExpect(status().isOk()) //http응답 200이 리턴됐는지,
                                    .andExpect(jsonPath("$.name", is(name)))  //제이슨에서 name을 빼오고, 걔가 내가 입력한 name이 맞으면 오케이.
                                    .andExpect(jsonPath("$.amount", is(amount)));

    }
}
