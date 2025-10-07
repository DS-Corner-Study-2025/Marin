package com.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class WelcomController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String welcomeMethod() {
        String outHtml = """
<!DOCTYPE html>
            <html lang="ko">
            <head>
              <meta charset="UTF-8">
              <title>Welcome</title>
              <!-- CDN 쓰면 integrity 빼고 먼저 테스트 -->
              <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
              <!-- 또는 로컬 정적 파일 사용 -->
              <!-- <link rel="stylesheet" href="/css/bootstrap.min.css"> -->
            </head>
            <body>
              <div class="container py-4">
                <header class="pb-3 mb-4 border-bottom">
                  <a href="/BookMarket/home" class="d-flex align-items-center text-body-emphasis text-decoration-none">
                    <span class="fs-4">BookMarket</span>
                  </a>
                </header>

                <div class="p-5 mb-4 bg-body-tertiary rounded-3">
                  <div class="container-fluid py-5">
                    <h1 class="display-5 fw-bold">도서 쇼핑몰에 오신 것을 환영합니다</h1>
                    <p class="col-md-8 fs-4">BookMarket</p>
                  </div>
                </div>

                <div class="row align-items-md-stretch text-center">
                  <div class="col-md-12">
                    <div class="h-100 p-5">
                      <h2>Welcome to Web Market!</h2>
                    </div>
                  </div>
                </div>

                <footer class="pt-3 mt-4 text-body-secondary border-top">
                  <span>&copy; BookMarket</span>
                </footer>
              </div>
            </body>
            </html>
            """;
        return outHtml;
    }
}
