package com.springboot.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.springboot.domain.Book;

public interface BookRepository {
    List<Book> getAllBookList();
    Book getBookById(String bookId);
    void setNewBook(Book book); // 6장 2-3
    List<Book> getBookListByCategory(String category); // 2-1 도서 분야를 가져오는 메서드 정의
    Set<Book> getBookListByFilter(Map<String, List<String>> filter); //3-1
}
