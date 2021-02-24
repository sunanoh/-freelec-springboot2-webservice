package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//Posts클래스로 Database를 접근하게 해줄 JpaRepository를 생성.
public interface PostsRepository extends JpaRepository<Posts, Long> { // JpaRepository<Entity클래스, PK타입>

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

}
