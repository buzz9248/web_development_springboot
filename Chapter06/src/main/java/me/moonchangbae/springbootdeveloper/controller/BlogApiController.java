package me.moonchangbae.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.moonchangbae.springbootdeveloper.domain.Article;
import me.moonchangbae.springbootdeveloper.dto.AddArticleRequest;
import me.moonchangbae.springbootdeveloper.dto.ArticleResponse;
import me.moonchangbae.springbootdeveloper.dto.UpdateArticleRequest;
import me.moonchangbae.springbootdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {

    private final BlogService blogService;

    // HTTP 메서드가 POST 일 때 URL 과 동일하면 지금 정의하는 메서드와 매핑
    @PostMapping("/api/articles")

    // @ResponseBody 로 요청 본문 값 매핑
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }

    /*

        1. @RestController : 클래스에 붙이면 HTTP 응답으로 객체 데이터를 "JSON" 형식으로 변환
        2. @PostMapping() : HTTP 메서드가 POST 일 때 요청 받은 URL 과 동일한 메서드와 매핑
            지금의 경우 /api/articles 는 addArticle() 메서드와 매핑.
        3. @RequestBody : HTTP 요청을 할 때, 응답에 해당하는 값을 @RequestBody 애너테이션이 붙은
            대상 객체는 AddArticleRequest 에 매핑.
        4. ResponseEntity.status().body() 는 응답 코드로 201, 즉 Created 를 응답하고,
            테이블에 저장된 객체를 반환합니다.

        200 OK : 요청이 성공적으로 수행되었음
        201 Created : 요청이 성공적으로 수행되었고, 새로운 리소스가 생성되었음
        400 Bad Request : 요청 값이 잘못되어 요청에 실패했음
        403 Forbidden : 권한이 없어 요청에 실패했음
        404 Not Found : 요청 값으로 찾은 리소스가 없어 요청에 실패했음
        500 Internal Server Error : 서버 상에 문제가 있어 요청에 실패했음

        API 가 잘 동작하는지 하나 테스트를 해볼 예정

            H2 콘솔 활성화

            application.yml

            결과값이 Body 에 pretty 모드로 결과를 보여줬습니다.
            -> 여기까지 성공했다면 스프링 부트 서버에 저장된 것을 의미합니다.

            여기까지가 HTTP 메서드 POST 로 서버에 요청을 한 후에 값을 저장하는 과정에 해당.

            이제 크롬 -> localhost:8080/h2-console

            SQL statement 입력창에
            SELECT * FROM article
            RUN 눌러서 실행
            h2 데이터베이스에 저장된 데이터 확인 가능
            애플리케이션을 실행하면 자동으로 생성한 엔티티 내용을 바탕으로
            테이블이 생성되고,
            우리가 요청한 POST 요청에 의해 INSERT 문이 실행되어
            실제로 데이터가 저장된 것임.

            내일은 반복작업을 줄여줄 테스트 코드들을 작성
                - 매번 h2 들어가는게 번거로워서
                    test 를 이용할 예정



     */

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok().body(articles);
    }

    /*
        /api/articles GET 요청이 들어오면 글 전체를 조회하는 findAll() 메서드를 호출
        -> 다음 응답용 객체인 ArticleResponse 로 파싱해서 body 에 담아
        클라이언트에게 전송합니다 -> 해당 코드에서는 stream 을 적용했습니다 -> 추후 설명


        * stream : 여러 데이터가 모여 있는 컬렉션을 간편하게 처리하기 위해서 사용하는 기능
            자바 8에 추가.

     */

    @GetMapping("/api/articles/{id}")
    // URL 경로에서 값을 추출
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id) { // URL 에서 {id} 에 해당하는 값이 id로 들어옴
        Article article = blogService.findById(id);

        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }
    /*
        @PathVariable : URL 에서 값을 가져오는 애너테이션.
            /api/articles/3 GET 요청을 받으면 id 에 3이 argument 로 들어오게 됩니다.
            그리고 이 값은 바로 전에 만든 서비스 클래스의 findById() 메서드로 넘어가서 3번 블로그
            글을 찾아옵니다. 그리고 그 글을 찾으면 3번 글의 정보(제목/내용)을 body 에 담아서
            웹브라우저로 가져 옵니다.

     */

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        blogService.delete(id);

        return ResponseEntity.ok()
                .build();

    }
    /*
        @PathVariable 통해서 {id}에 해당하는 값이 들어옴.
     */

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody UpdateArticleRequest request) {
        Article updateArticle = blogService.update(id, request);

        return ResponseEntity.ok().body(updateArticle);
    }
    /*
        /api/articles/{id} PUT 요청이 들어오면 Request Body 정보가 request 로 넘어옵니다.
        그리고 다시 서비스 클래스의 update() 메서드에 id 와 request 를 넘겨줍니다.
        응답 값은 body 에 담아 전송합니다.
     */





}
