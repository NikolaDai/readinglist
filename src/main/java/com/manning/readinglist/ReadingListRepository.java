package com.manning.readinglist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//By extending JapRepository, ReadingListRepository inherits 18 methods.
public interface ReadingListRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(String reader);
}
