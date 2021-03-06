package com.testfan.javastudy.Day0304.Demo07;

/**
 * @author 孙珑瑜
 * @version 20210306
 */
public class Demo01Main {
    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.setName("缪斯");//设置英雄的技能

//        //方法一：
//        SkillImpl skillimpl = new SkillImpl();
//        hero.setSkill(skillimpl);//子类就是一个父类，多态
//
//        //方法二：
//        Skill skill = new SkillImpl();//左父右子，多态
//        hero.setSkill(skill);

        //方法二的简写，方法三
//        hero.setSkill(new SkillImpl());

        //使用匿名内部类
//        Skill skill = new Skill() {
//            @Override
//            public void user() {
//                System.out.println("匿名内部类，使用英雄的技能");
//            }
//        };
//        hero.setSkill(skill);

        //使用匿名对象
        hero.setSkill(new Skill() {
            @Override
            public void user() {
                System.out.println("使用匿名内部类，使用技能");
            }
        });

        hero.attack();

    }
}
