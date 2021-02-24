package com.jojoldu.book.springboot.web.dto;


import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto { // Controller와 Service에서 사용할 Dto클래스
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder().title(title).content(content).author(author).build();
    }
}


// Entity클래스와 거의 유사함에도 Dto 클래스를 새로 생성함
// Entity클래스는 데이터베이스와 맞닿은 핵심 클래스이므로, 그 클래스에선 Request, Response 클래스를 사용해서는 안됨.