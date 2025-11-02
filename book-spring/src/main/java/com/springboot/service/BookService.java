package com.springboot.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.springboot.domain.Book;

public interface BookService {
    List<Book> getAllBookList();
    Book getBookById(String bookId);
    List<Book> getBookListByCategory(String category); // 2-3 도서 분야를 가져오는 메서드 정의
    Set<Book> getBookListByFilter(Map<String, List<String>> filter); // 3-3
    void setNewBook(Book book); // 6장 2-5 신규 도서 등록 메서드 추가
}
