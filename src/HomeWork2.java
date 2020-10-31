import java.util.Scanner;
public class HomeWork2 {
    public static void main(String[] args) {
        Hero h = new Hero();
        Monster m = new Monster();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入主角名称:");
        String name = sc.nextLine();
        System.out.println("请输入生命值:");
        int health = sc.nextInt();
        System.out.println("请输入防御力:");
        int defense = sc.nextInt();
        h.setName(name);
        h.setHealth(health);
        h.setDefense(defense);
        System.out.println("----------------");
        Scanner sc1 = new Scanner(System.in);
        System.out.println("请输入怪物名字:");
        String name1 = sc1.nextLine();
        System.out.println("请输入怪物生命值:");
        int health1 = sc1.nextInt();
        m.setName(name1);
        m.setHealth(health1);
        for (int a = 1; a < 1000; a++) {
            if (m.getHealth() > 0 && h.getHealth() > 0) {
                if (a % 2 == 0) {
                    h.Hit(m);
                } else {
                    m.Hit(h);
                }
            }
        } if (m.getHealth() > 0 && h.getHealth() <= 0) {
                System.out.println(m.getName() + "获胜");
            } else {
                System.out.println(h.getName() + "获胜");
                System.out.println("游戏结束");
            }
        }
        static class Hero {
        private String name;
        private int health;
        private int defense;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public int getHealth() {
            return health;
        }

        public void setDefense(int defense) {
            this.defense = defense;
        }

        public int getDefense() {
            return defense;
        }

        public void Hit(Monster c) {
            int value = (int) (Math.random() * 30);
            c.setHealth(c.getHealth() - value);
            if (value>=0&&value<=10)
                System.out.println(name+"施展了雷遁--千鸟");
            else if (value>10&&value<=20)
                System.out.println(name+"施展了风遁--螺旋手里剑");
            else
                System.out.println(name+"喊出了古娜拉黑暗之神--竟拉拉--黑旋风");
            if(c.getHealth()>0)
            System.out.println("对" + c.getName() + "造成了" + value + "点伤害,"+c.getName()+"还剩"+c.getHealth()+"点血量");
            else
                System.out.println("对" + c.getName() + "造成了" + value + "点伤害,"+c.getName()+"还剩0点血量");
        }
    }
        static class Monster {
        private String name;
        private int health;

        public void setName(String name1) {
            this.name = name1;
        }

        public String getName() {
            return this.name;
        }

        public void setHealth(int health1) {
            this.health = health1;
        }

        public int getHealth() {
            return health;
        }

        public void Hit(Hero c) {
            int hurt;
            int value = (int) (Math.random() * 40);
            if(value<=10) {
                hurt = 0;
                System.out.println("当"+name+"想要攻击"+c.getName()+"时，"+c.getName() + "施展了土遁--土流壁，抵挡住了一次伤害");
            }else {
                hurt = value - c.getDefense();
                if (hurt > 0 && hurt <= 10) {
                    System.out.println(name + "施展了火遁--豪火球之术");
                } else if (hurt > 10 && hurt <= 20)
                    System.out.println(name+ "施展了水遁--水龙弹之术");
                else
                    System.out.println(name + "喊出了:巴啦啦能量--迪卡斯--破!!");
            }c.setHealth(c.getHealth() - hurt);
            if(c.getHealth()>0)
            System.out.println("对" + c.getName() + "造成了" + hurt + "点伤害,"+c.getName()+"还剩"+c.getHealth()+"点血量");
            else
                System.out.println("对" + c.getName() + "造成了" + hurt + "点伤害,"+c.getName()+"还剩0点血量");
        }
    }
}
