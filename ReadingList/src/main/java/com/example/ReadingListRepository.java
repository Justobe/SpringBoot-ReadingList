package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by YanMing on 2017/3/14.
 */
public interface ReadingListRepository extends JpaRepository<Book,Long> {
    List<Book> findByReader(String reader);
}
