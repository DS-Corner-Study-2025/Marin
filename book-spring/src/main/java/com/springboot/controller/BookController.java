package com.springboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.domain.Book;
import com.springboot.service.BookService;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/books")  // 클래스 레벨 매핑
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String requestBookList(Model model) {
        List<Book> list = bookService.getAllBookList();   // 서비스에서 도서 목록 가져오기
        model.addAttribute("bookList", list);             // 모델에 저장
        return "books";       // → templates/books.html로 매핑됨
    }

    @GetMapping("/all")
    public ModelAndView requestAllBooks() {
        ModelAndView modelAndView = new ModelAndView();
        List<Book> list = bookService.getAllBookList();

        modelAndView.addObject("bookList", list);  // 데이터 추가
        modelAndView.setViewName("books");         // 뷰 설정

        return modelAndView;
    }
}
