package com.jojoldu.book.springboot.web.dto;

import org.junit.Test;
import static  org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void HelloResponseDtoTest(){
    //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount); // HelloResponseDto클래스에서 생성자를 만들지 않았어도 @RequiredArgsConstructor 어노테이션으로 이미 생성되어있음.

        //then   -> 테스트 검증 라이브러리 메소드
        assertThat(dto.getName()).isEqualTo(name); //HelloResponseDto객체에서 getName을 해온게, 이 메소드 안에있는 name과 같으냐. 즉, 생성자가제대로 들어갔고? getName도 잘 생성됐느냐!
        assertThat(dto.getAmount()).isEqualTo(amount);

        // assertThat : assertj라는 테스트 검증 라이브러리의 검증 메소드로 검증하고 싶은 대상을 메소드 인자로 받아온다.



    }
}

