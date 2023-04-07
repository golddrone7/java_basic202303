package day10.friends;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        People kim = new People("김철수");
        People park = new People("박영희");
        People hong = new People("홍길동");

        kim.addFollowerWaitList(park);
        kim.addFollowerWaitList(hong);
        kim.addFollower(park);

        park.addFollowerWaitList(kim);
        park.addFollower(kim);  // 맞팔여부 확인하는 방법, target과 자신의 팔로우 목록을 확인 함


        List<String> kimWaitList = kim.showFollowerWaitPerson();
        System.out.println("kimWaitList= " + kimWaitList);
        List<String> followerNames = kim.showFollower();
        System.out.println("follwerNames = " + followerNames);
        List<String> followerNames1 = park.showFollower();
        System.out.println("park follower = " + followerNames1);


        System.out.println(kim.isFollowUp(park));


    }

}
