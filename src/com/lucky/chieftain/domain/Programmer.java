package com.lucky.chieftain.domain;

public class Programmer extends Employee{
    private int memberId;//TID
    private Status status = Status.FREE;//状态
    private Equipment equipment;//设备 给该属性赋值只能是该接口的实现类的对象

    public Programmer() {
        super();
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public String toString(){
        return getEmployeeTo() + "\t程序员\t" + getStatus() + "\t\t\t\t\t" + getEquipment().getDescription();
    }
    /*
    返回成员信息
     */
    public String getMemberInfo() {
        return getMemberId() + "\t" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\t程序员";
    }
}
