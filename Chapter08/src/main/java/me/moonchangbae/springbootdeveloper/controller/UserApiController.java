package me.moonchangbae.springbootdeveloper.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import me.moonchangbae.springbootdeveloper.dto.AddUserRequest;
import me.moonchangbae.springbootdeveloper.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserApiController {

    private final UserService userService;

    @PostMapping("/user")
    public String signup(AddUserRequest request) {
        userService.save(request);  // 회원 가입 메서드 호출
        return "redirect:/login";   // 회원 가입 완료된 이후에 로그인 페이지로 이동
    }

    /*

        회원 가입 절차가 완료된 이후에 로그인 페이지로 이동하기 위해 'redirect' 접두사를 붙였습니다.
        이렇게 하면 회원 가입 절차가 끝났을 때 강제로 /login url 에 해당하는 화면으로 이동합니다.

        회원 가입, 로그인 뷰를 작성할겁니다.

            뷰 관련 컨트롤러를 구현할겁니다.
            동일 패키지에 UserViewController.java 생성

     */

    // 로그아웃 관련
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {

        new SecurityContextLogoutHandler().logout(request, response,
                SecurityContextHolder.getContext().getAuthentication());

        return "redirect:/login";
    }
    /*
        /logout GET 요청을 하면 로그아웃을 담당하는 핸들러인 SecurityLogoutHandler 의 logout()
        메서드를 호출해서 로그아웃합니다.

        templates > articleList.html 이동
     */


}











