package com.springboot.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.springboot.domain.Book;

public interface BookRepository {
    List<Book> getAllBookList();
    Book getBookById(String bookId);
    List<Book> getBookListByCategory(String category); // 1 도서 분야를 가져오는 메서드 정의
}
