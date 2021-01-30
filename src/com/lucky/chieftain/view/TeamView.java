package com.lucky.chieftain.view;

import com.lucky.chieftain.domain.Employee;
import com.lucky.chieftain.domain.Programmer;
import com.lucky.chieftain.service.NameListService;
import com.lucky.chieftain.service.TeamException;
import com.lucky.chieftain.service.TeamService;
import com.lucky.chieftain.utils.TSUtility;

public class TeamView {
    private NameListService listService = new NameListService();
    private TeamService teamService = new TeamService();
    /*
    展示所有员工
     */
    public void enterMainMenu(){
        boolean flag = true;
        do {
            System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
            listAllEmployees();
            System.out.println("--------------");
            System.out.print("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择（1-4）：");
            char menuSelection = TSUtility.readMenuSelection();
            switch (menuSelection){
                case '1':
                    listAllMember();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':

                    break;
                case '4':
                    System.out.print("确认是否退出(Y/N):");
                    char confirmSection = TSUtility.readConfirmSelection();
                    if(confirmSection == 'Y'){
                        flag = false;
                        System.out.println("退出成功");
                    }
                    break;
            }
        }while(flag);
    }

    private void listAllMember() {
        Programmer[] programmers = teamService.getTeam();
        for (Programmer programmer : programmers) {
            //多态，对象是谁调用谁的getMemberInfo
            System.out.println(programmer.getMemberInfo());
        }
    }

    /*
    展示所有员工
     */
    public void listAllEmployees(){
        Employee[] employees = listService.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }
    /*
    添加成员
     */
    public void addMember(){
        System.out.println("请输入要添加的员工ID：");
        int id = TSUtility.readInt();
        //添加成员
        try {
            Employee e = listService.getEmployee(id);
            teamService.addMember(e);
            System.out.println("添加成功");

        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }
    /*
    删除成员
     */
    public void deleteMember(){
        System.out.println("请输入要删除的员工ID");
        int tid = TSUtility.readInt();
        System.out.print("确认是否删除(Y/N):");
        char confirmSection = TSUtility.readConfirmSelection();
        if(confirmSection == 'Y'){
            try {
                teamService.removeMember(tid);
                System.out.println("删除成功");
            } catch (TeamException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }
}
