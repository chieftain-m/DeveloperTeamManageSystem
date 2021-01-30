package com.lucky.chieftain.domain;

public class Designer extends Programmer{
    double bonus;

    public Designer() {
        super();
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String toString(){
        return getEmployeeTo() + "\t设计师\t" + getStatus() + "\t" + getBonus() + "\t\t\t"+ getEquipment().getDescription();
    }

    public String getMemberInfo() {
        return getMemberId() + "\t" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\t设计师" + getBonus();
    }
}
