package day11.io;

public interface RootPath {
    // public static final 생략
    // 인터페이스는 필드를 못가짐, 모든 변수가 상속화
    String ROOT_PATH = "D:/exercise";
    String MEMBER_SAVE_PATH = ROOT_PATH + "/member";
}
