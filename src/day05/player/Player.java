package day05.player;

public class Player {

    // 필드
    String nickName; // 캐릭터 닉네임
    int level; // 레벨
    int hp; // 체력

    public Player(){
        this("이름없음"); // 나의 또다른 생성자를 불러주세요
        System.out.println("1번 생성자 호출!");
//        this.nickName = "이름없음";
//        this.level = 1;
//        this.hp = 50;
    }

    // alt insert 편리한 생성 기능
    // shift * 2 통합검색

    // 생성자
    public Player(String nickName) {
        this(nickName, 1, 50);
        System.out.println("2번 생성자 호출!");
    }
    public Player(String nickName, int level, int hp) {
        this.nickName = nickName;
        this.level = level;
        this.hp = hp;
    }

    // Player this가 생략됨
    void levelUp(Player this){

    }


    // 현재변경사항 | 수정 변경사항 | 두 변경 사항


    // 기능 - 메서드
    void attack(Player this, Player target){

        if(this== target) return;
        System.out.println("target의 주소: " + target);
        System.out.println("this의 주소 : " + this);
        int damage = (int)(Math.random()*6+10);
        // 맞은녀석의 체력을 10~15 랜덤으로 감소시킬거임
        // 전투로그를 출력할거임
        target.hp-=damage;
//        System.out.println(this.nickName + "가 " + target.nickName +"를 공격해서 " + damage + "의 피해를 입힘");
        // 가해자가 피해자를 공격해서 xx의 피해를 입힘
        System.out.printf("%s님을 %s님을 공격해서 %d의 피해를 입힘!\n", this.nickName, target.nickName, damage);

    }



}
