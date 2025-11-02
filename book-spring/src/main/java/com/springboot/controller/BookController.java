package com.springboot.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.springboot.domain.Book;
import com.springboot.service.BookService;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/books")  // 클래스 레벨 매핑
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

    @GetMapping("/book") // @RequestMapping(value="/book", method=RequestMethod.GET)과 동일
    public String requestBookById(@RequestParam("id") String bookId, Model model) { // @RequestParam으로 요청 파라미터 'id'를 받음
        Book bookById = bookService.getBookById(bookId);
        model.addAttribute("book", bookById);
        return "book"; // book.html 템플릿으로 이동
    }

    // 2-5 도서 분야를 가져오는 요청 처리 메서드 작성
    @GetMapping("/{category}") // @RequestMapping(value = "/{category}", method = RequestMethod.GET)와 동일
    public String requestBooksByCategory(
            @PathVariable("category") String bookCategory, Model model) { //
        List<Book> booksByCategory = bookService.getBookListByCategory(bookCategory); //
        model.addAttribute("bookList", booksByCategory); //
        return "books"; //
    }

    //3-5
    @GetMapping("/filter/{bookFilter}")
    public String requestBooksByFilter(
            @MatrixVariable(pathVar="bookFilter") Map<String, List<String>> bookFilter, Model model) {

        Set<Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
        model.addAttribute("bookList", booksByFilter);
        return "books";
    }

    // #6장 1-1
    @GetMapping("/add")
    public String requestAddBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("newBook", book);
        return "addBook"; // 뷰 이름으로 "addBook"을 반환하여 addBook.html 파일을 출력합니다.
    }

    // #6장 2-7
    @PostMapping("/add")
    public String submitAddNewBook(@ModelAttribute("newBook") Book book, BindingResult result) {
    if (result.hasErrors()) { // 바인딩 오류가 발생하면 (ex: long에 빈 문자열)
        return "addBook"; // 400 에러 대신 폼 페이지를 다시 보여줍니다.
    }

    bookService.setNewBook(book);
    return "redirect:/books"; // 리포지토리의 setNewBook 호출
}

    // #6장 2-8
    // 모델에 공통 속성 추가 (도서 등록 페이지 제목)
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("addTitle", "신규 도서 등록");
    }
}
