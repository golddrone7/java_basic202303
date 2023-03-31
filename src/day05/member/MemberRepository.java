package day05.member;


// 역할 : 회원 저장소 역할
public class MemberRepository {

    Member[] memberList;
    public MemberRepository(){
        this.memberList = new Member[3];
        memberList[0] = new Member(1, "aaa@bbb.com", "1234", "콩벌레", Gender.MALE, 50);
        memberList[1] = new Member(2, "xxx@zzz.com", "9999", "팥죽이", Gender.FEMALE, 30);
        memberList[2] = new Member(3, "hhh@qwe.com", "5678", "카레왕", Gender.FEMALE, 44);

    }

    /**
     * 모든 회원 정보를 출력해주는 메서드
     */
    void showMembers(){
        System.out.printf("========== 현재 회원정보 (총 %d명) ===========\n", memberList.length);
        for (Member m : memberList) {
            System.out.println(m.inform());
        }
    }

    /**
     * 회원 가입 기능
     * @param1 = newMember: 새롭게 회원가입하는 회원의 정보
     * @return : 회원가입 성공 여부
     *            성공시 true, 이메일이 중복되어 실패시 fail
     */


    /**
     * 이메일의 중복여부를 확인하는 기능
     * @param targetEmail : 검사 대상 이메일
     * @return : 중복되었을 시 true, 사용가능할 시 false
     */
    boolean isDuplicateEmail(String targetEmail){
        for (int i = 0; i < memberList.length; i++) {
            if(targetEmail.equals(memberList[i].email)) {
                return true;
            }
        }
        return false;
    }

    boolean addMember(Member newMember){

        // 이메일이 중복인가?
       if(isDuplicateEmail(newMember.email)) return false;

        // 실제로 멤버를 추가하는 코드
        Member[] temp = new Member[memberList.length+1];
        for (int i = 0; i < memberList.length; i++) {
            temp[i] = memberList[i];
        }
        temp[temp.length -1 ] = newMember;
        memberList = temp;
        return true;
    }
    /**
     * 이메일을 통해 특정 회원 객체를 찾아서 반환하는 기능
     * @param1 email : 찾고 싶은 회원의 이메일
     * @return : 찾은 회원의 객체정보, 못찾으면 null반환
     */

    Member findByEmail(String email){
        for (int i = 0; i < memberList.length; i++) {
            if(memberList[i].email.equals(email)){
                return memberList[i];
            }
        }
        return null;
    }

    /** 마지막 회원을 찾아서 회원 번호를 반환하는 기능
     * @return : 마지막 회원의 회원 번호를 반환, 비었을 경우 0을 반환
     */
    int getLastMemberId(){
        if(memberList.length==0) return 0;
        return memberList[memberList.length-1].memberId;
    }

}
