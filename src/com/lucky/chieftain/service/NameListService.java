package com.lucky.chieftain.service;

import com.lucky.chieftain.domain.*;
/*
获取员工
 */
public class NameListService {
    private Employee[] employees;
    /*
    1.初始化数组
    2.封装对象
     */
    public NameListService() {
        employees = new Employee[Data.EMPLOYEES.length];
        for (int i = 0; i < Data.EMPLOYEES.length; i++) {
            //获取工种
            String type = Data.EMPLOYEES[i][0];
            //读取数据
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);
            switch (Integer.parseInt(type)){
                case Data.EMPLOYEE:
                    Employee employee = new Employee(id,name,age,salary);
                    employees[i] = employee;
                    break;
                case Data.PROGRAMMER:
                    Programmer programmer = new Programmer(id,name,age,salary,createEquipment(i));
                    employees[i] = programmer;
                    break;
                case Data.DESIGNER:
                    Designer designer = new Designer(id,name,age,salary,createEquipment(i),
                            Double.parseDouble(Data.EMPLOYEES[i][5]));
                    employees[i] = designer;
                    break;
                case Data.ARCHITECT:
                    Architect architect = new Architect(id,name,age,salary,createEquipment(i),
                            Double.parseDouble(Data.EMPLOYEES[i][5]),Integer.parseInt(Data.EMPLOYEES[i][6]));
                    employees[i] = architect;
                    break;
            }
        }
    }

    private Equipment createEquipment(int index) {
        int type = Integer.parseInt(Data.EQUIPMENT[index][0]);
        switch (type){
            case Data.PC:
                return new PC(Data.EQUIPMENT[index][1],Data.EQUIPMENT[index][2]);
            case Data.NOTEBOOK:
                return new NoteBook(Data.EQUIPMENT[index][1], Double.parseDouble(Data.EQUIPMENT[index][2]));
            case Data.PRINTER:
                return new Printer(Data.EQUIPMENT[index][1],Data.EQUIPMENT[index][2]);
        }
        return null;
    }

    /*
    获取所有员工
     */
    public Employee[] getAllEmployees(){
        return employees;
    }
    /*
    根据指定id获取员工
     */
    public Employee getEmployee(int id) throws TeamException {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new TeamException("找不到该员工");
    }
}
