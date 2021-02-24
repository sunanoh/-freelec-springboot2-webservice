package com.jojoldu.book.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication // 스프링부트 형태의 web 프로그램이 뜸, 이 어노테이션이 작성되어있는 부분부터 실행 됨.
public class Application {

    public static void main(String[] args){

        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.SERVLET); // 이코드와 아래 코드 한줄가 같은 의미. servlet을 쓰면 web으로 was가 뜸
        app.setBannerMode(Banner.Mode.OFF); //로그에 뜨는 배너를 끄는 방법
        app.run(args);

        //SpringApplication.run(Application.class, args); //내장되어있는 서버를 실행한다.

        //SpringBootApplication이라는 노테이션으로 이 프로젝트의 내장 was서버가 실행이되고 기본적으로 localhost:8080의 기본주소가 생김.

        // resource에 banner파일을 만들면 배너설정 가능함.
    }
}
