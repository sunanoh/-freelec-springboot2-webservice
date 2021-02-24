package com.jojoldu.book.springboot.web.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter  // 선언된 모든 필드의 get메소드를 생성해 주는 어노테이션
@RequiredArgsConstructor // 선언된 모든 final필드가 포함된 생성자를 생성해 줌. 생성자를 쓰지 않아도 됨// final이 없는 필드는 생성자에 포함되지 않음
public class HelloResponseDto { //dto : data transaction object, 데이터주고받는 객체

    private final String name;
    private final int amount;


}
