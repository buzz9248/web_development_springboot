package me.moonchangbae.me.moonchangbae.springbootdeveloper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
    모든 프로젝트에는 main에 해당하는 클래스가 존재합니다 -> 실행용 클래스


 */
@SpringBootApplication
public class SpringBootDeveloperApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDeveloperApplication.class, args);
    }
}

/*
    처음으로 SpringBootDeveloperApplication 파일을 실행시키면 whitelabel error page가 뜹니다.
    현재 요청에 해당하는 페이지가 존재하지 않기 때문에 생겨난 문제입니다.
    -> 하지만 스프링 애플리케이션은 실행됨

    그래서 Error 페이지가 기분 나쁘니까 기본적으로 실행될 때의 default 페이지를 하나 생성하겠습니다.

    2024.12.23(월)
        1. IntelliJ Community Version 설치 -> bin.PATH 체크하고 나머지는 전부 디폴트
        2. Git 설치
        3. Github 연동 -> web.development_springboot -> 문제있음
        4. IntelliJ에 Gradle 및 SpringBoot 프로젝트를 생성
        5. POSTMAN을 설치


 */
