import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnitCycleQuiz {

    /*
        문제 03
        각각의 테스트를 시작하기 전에 "Hello!"를 출력하는 메서드와 모든 테스트를 끝마치고
        "Bye!"를 출력하는 메서드를 추가. 다음의 테스트가 있다고 가정
     */


    @Test
    public void junitQuiz3() {

        System.out.println("this is the first test.");

    }

    @Test
    public void junitQuiz4() {

        System.out.println("this is the second test.");

    }

    @BeforeEach
    public void beforeEach() {

        System.out.println("Hello!");

    }

    @AfterAll
    public static void afterAll() {

        System.out.println("Bye!");

    }

    /*
        여기에서 JUnitCycleQuiz 클래스를 전체 실행하면 콘솔에 다음과 같이 출력하려면
        어떻게 할지 작성

        실행 예시

        Hello!
        this is the first test.
        Hello!
        this is the second test.
        Bye!

     */




}
