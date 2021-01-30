package com.lucky.chieftain.domain;

public class Architect extends Designer{
    private int stock;

    public Architect() {
        super();
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String toString(){
        return getEmployeeTo() + "\t架构师\t" + getStatus() + "\t" + getBonus() + "\t" + getStock() + "\t" + getEquipment().getDescription();
    }

    public String getMemberInfo() {
        return getMemberId() + "\t" + getId() + "\t" + getName() + "\t" + getAge()
                + "\t" + getSalary() + "\t架构师" + getBonus() + "\t" + getStock();
    }
}
