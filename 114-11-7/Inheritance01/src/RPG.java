public class RPG {
    public static void main(String[] args){
    //建立劍士和魔法師角色
        SwordsMan swordsMan_light = new SwordsMan("吳喩蓉", 100, 15);
        SwordsMan sowordsMan_dark = new SwordsMan("蘭斯洛特", 90, 12);

        Magician magician_light = new Magician("梅林", 80, 10);
        Magician magician_darl = new Magician("莫甘娜", 70, 8, 25);


        //戰鬥過程
        System.out.println("戰鬥開始！");
        swordsMan_light.attack(sowordsMan_dark);
        magician_darl.attack(swordsMan_light);
        magician_light.heal(swordsMan_light);
        sowordsMan_dark.attack(swordsMan_light);

        // 顯示各角色情況
        System.out.println("--- 戰後狀態 ---");
        System.out.println(swordsMan_light.getName() + " 生命=" + swordsMan_light.getHealth());
        System.out.println(sowordsMan_dark.getName() + " 生命=" + sowordsMan_dark.getHealth());
        System.out.println(magician_light.getName() + " 生命=" + magician_light.getHealth());
        System.out.println(magician_darl.getName() + " 生命=" + magician_darl.getHealth());

        System.out.println("戰鬥結束！");


    }

//    @Override
//    public  String toSting(){
//        return "角色名稱:" + name + ", 生命值:" + health;
//
//
//    }
//    @Override
//    public String toString() {
//        return "RPG{}";
//    }
}
