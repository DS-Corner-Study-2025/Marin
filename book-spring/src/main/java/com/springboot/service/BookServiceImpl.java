package com.springboot.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.domain.Book;
import com.springboot.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBookList() {
        return bookRepository.getAllBookList();
    }

    public Book getBookById(String bookId) {
        Book bookById = bookRepository.getBookById(bookId);
        return bookById;
    }

    // 6장 2-6
    @Override
    public void setNewBook(Book book) {
        bookRepository.setNewBook(book); // 리포지토리의 setNewBook 호출
    }

    // 2-4 도서 분야를 가져오는 메서드 작성
    public List<Book> getBookListByCategory(String category) { //
        List<Book> booksByCategory = bookRepository.getBookListByCategory(category); //
        return booksByCategory; //
    }

    // 3-4
    public Set<Book> getBookListByFilter(Map<String, List<String>> filter) {
        Set<Book> booksByFilter = bookRepository.getBookListByFilter(filter);
        return booksByFilter;
    }
}
