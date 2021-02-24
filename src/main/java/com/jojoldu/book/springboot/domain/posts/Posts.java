package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


// Entity 클래스에서는 절대 Setter메소드를 만들지 않음.

@Getter
@NoArgsConstructor // 기본 생성자 자동 추가
@Entity  //JPA어노테이션, 테이블과 링크될 클래스임을 나타냄 // 이클래스를 Entity로 만들고, db데이터에 작업할 경우 실제쿼리가 아닌 이 클래스의 수정을 통해 작업하게 됨.
public class Posts extends BaseTimeEntity {

    @Id // 해당 테이블이 PK필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 생성 규칙, GenerationType.IDENTITY이걸 추가해야만 AUTO_INCREMENT가 됨
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
    // 빌더를 사용하게되면, 어느 필드에 어떤 값을 채워야 할지 명확하게 인지할 수 있음.
    // Posts.builder().title(title).content(content).author(author).build(); 식으로 사용하여 생성자를 채움.

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
