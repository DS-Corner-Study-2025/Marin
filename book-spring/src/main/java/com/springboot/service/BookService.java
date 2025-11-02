package com.springboot.service;

import java.util.List;
import com.springboot.domain.Book;

public interface BookService {
    List<Book> getAllBookList();
    Book getBookById(String bookId);
    List<Book> getBookListByCategory(String category); // 3 도서 분야를 가져오는 메서드 정의
}
