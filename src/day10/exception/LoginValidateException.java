package day10.exception;

// 사용자 정의 익셉션,  1. 기본 생성자, 2. 에러 메시지를 받는 생성자를 작성
// 런타임 익셉션을 상속받자
public class LoginValidateException extends RuntimeException {

    // 기본 생성자
    public LoginValidateException() {
    }

    // 에러메시지를 받는 생성자
    public LoginValidateException(String message) {
        super(message);
    }
}
