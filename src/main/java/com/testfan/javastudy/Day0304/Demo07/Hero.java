package com.testfan.javastudy.Day0304.Demo07;

/**
 * @author 孙珑瑜
 * @version 20210306
 */
public class Hero {
    private String name;
    private Skill skill;

    public Hero() {
    }

    public Hero(String name, Skill skill) {
        this.name = name;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
    public void attack(){
        System.out.println("我叫："+name);
        skill.user();//调用接口中的抽象方法
        System.out.println("技能释放完成");
    }
}
