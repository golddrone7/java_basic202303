package day07.inherit;

import static day07.util.Utility.*;

public class Mage extends Player {


    int mana; // 마력 게이지

    public Mage(String nickName) {
        super(nickName);
        this.mana = 100;
    }


    // 썬더볼트
    public void thunderBolt(Player a, Player ...b) {
        System.out.println("# " + a.nickName+"님 썬더볼트 시전!!!");
        makeLine();
        for (Player player : b) {
            damage(player, (int)(Math.random()*5)+11);
        }
    }

    @Override
    public void showStatus() {
        super.showStatus();
        System.out.println("# mana: " + this.mana);
    }
}
