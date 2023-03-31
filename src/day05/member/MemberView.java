package day05.member;


import java.util.Scanner;

// 역할: 회원과니 앱의 입출력을 담당
public class MemberView {

    Scanner sc;
    MemberRepository mr;

//    필드에 직접 초기화하지말자
//    생성자를 통해 주입하자
//    필드는 this를 붙혀주자
    public MemberView() {
        this.sc = new Scanner(System.in);
        this.mr = new MemberRepository();
    }
    /**
     * 초기 메인 화면을 출력
     */

    void mainView(){

        System.out.println("\n#### 회원 관리 시스템 ####");
        System.out.println("* 1. 회원 정보 등록하기");
        System.out.println("* 2. 개발회원 정보 조회하기");
        System.out.println("* 3. 전체회원 정보 조회하기");
        System.out.println("* 4. 회원 정보 수정하기");
        System.out.println("* 5. 회원 정보 삭제하기");
        System.out.println("* 6. 프로그램 끝내기");
        System.out.println("=============================");
    }

    /**
     * 프로그램 화면 흐름을 제어하는 기능
     */

    void viewProcess(){

        while (true) {  // ctrl + alt + t 감싸기 if while...
            mainView();
            String menuNum = input(">> ");   // ctrl + alt + m 메서드 생성
            switch (menuNum){
                case "1":
                    signUp(); break;
                case "2":
                    showDetailMember();
                    break;
                case "3":
                    mr.showMembers();
                    stop();
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    String answer = input("# 정말로 종료합니까? [y/n]");
                    if(answer.toLowerCase().charAt(0) == 'y'){
                        System.out.println("# 프로그램을 종료합니다.");
                        System.exit(0); // 프로그램 강제 종료
                    } else{
                        continue;
                    }

                    break;
                default:
                    System.out.println("\n# 메뉴 번호를 다시 입력하세요");
            }

        }
    }

    String input(String message) {
        System.out.print(message); // ctrl + alt + p 매개변수 빼기
        return sc.nextLine();
    }

    // 엔터를 누르기전까지 멈추는 기능
    void stop(){
        System.out.println("\n====== 엔터를 눌러서 계속...=========");
        sc.nextLine();
    }

    // 회원 등록 입력 처리
    void signUp(){
        System.out.println("\n# 회원 등록을 시작합니다!!");
        String email;
        while (true){
            email = input("# 이메일: ");
            if(!mr.isDuplicateEmail(email)){
               break;
            }
            System.out.println("# 중복된 이메일입니다 ㅋㅋ");
        }
        String name = input("# 이름: ");
        String password = input("# 패스워드: ");

        Gender gender;
        checkGender:while(true){
            String inputGender = input("# 성별[M/F]:");
            switch (inputGender.toUpperCase().charAt(0)){
                case 'M':
                    gender = Gender.MALE;
                    break checkGender;
                case 'F':
                    gender = Gender.FEMALE;
                    break checkGender;
                default:
                    System.out.println("# 성별을 M/F로 정확히 입력하세요");
            }
        }
        int age = Integer.parseInt(input("# 나이:"));

        // 실제 저장 명령
        Member newMember = new Member(
          mr.getLastMemberId() +1,
          email, password,
        name, gender, age
        );
        mr.addMember(newMember);
        System.out.println("\n# 회원 가입 성공!!");
        stop();
    }

    // 회원 개별조회를 위한 입출력처리
    void showDetailMember(){
        // 이메일 입력하세요!
        String email = input("# 이메일을 입력하세요");
        // 찾은 회원의 정보 ~~~
        Member showMember = mr.findByEmail(email);
        if(showMember!=null) {
            System.out.println(email + "을 찾은 정보입니다 ==== \n");
            System.out.println("찾은 맴버의 id " + showMember.memberId);
            System.out.println("찾은 맴버의 이름 " + showMember.memberName);
            System.out.println("찾은 맴버의 이메일 " + showMember.email);
            System.out.println("찾은 맴버의 성별 " + showMember.gender);
            System.out.println("찾은 맴버의 나이 " + showMember.age);
            System.out.println("찾은 맴버의 비밀번호 " + showMember.password);
        } else{
            System.out.println("\n# 조회된 회원이 없습니다");
        }
        stop();
    }


}
