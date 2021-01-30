package com.lucky.chieftain.service;

import com.lucky.chieftain.domain.*;

/*
管理团队中所有成员
 */
public class TeamService {
    private int total = 0;
    private static int counter = 1;//TID赋值
    private final int MAX_MEMBER = 20;
    private Programmer[] team = new Programmer[MAX_MEMBER];//用来保存团队成员

    public Programmer[] getTeam() {
        Programmer[] tmp = new Programmer[total];
        if (total >= 0) System.arraycopy(team, 0, tmp, 0, total);
        return tmp;
    }

    public void addMember(Employee e) throws TeamException {
        if (total >= team.length) {
            throw new TeamException("成员已满，无法添加");
        }
        if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        for (int i = 0; i < total; i++) {
            if (e.getId() == team[i].getId()) {
                throw new TeamException("该成员已是开发人员");
            }
        }
        Programmer p = (Programmer) e;
        if (p.getStatus() == Status.VOCATION) {
            throw new TeamException("该成员正在休假");
        }

        int arcCount = 0;
        int desCount = 0;
        int proCount = 0;

        for (int i = 0; i < total; i++) {
            Programmer programmer = new Programmer();
            if (programmer instanceof Architect) {
                arcCount++;
            } else if (programmer instanceof Designer) {
                desCount++;
            } else {
                proCount++;
            }
        }
        if (p instanceof Architect) {
            if (arcCount >= 1) {
                throw new TeamException("团队内仅有一名架构师");
            }
        } else if (p instanceof Designer) {
            if (desCount >= 2) {
                throw new TeamException("团队内只有有两名设计师");
            }
        } else if (p instanceof Programmer) {
            if (proCount >= 3) {
                throw new TeamException("团队内只有三名程序员");
            }
        }
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
        team[total++] = p;
    }

    public void removeMember(int memberId) throws TeamException {
        int i;
        for (i = 0; i < total; i++) {
            if (team[i].getMemberId() == memberId) {
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if (i < total) {
            if (total - i >= 0) System.arraycopy(team, i + 1, team, i, total - i);
            team[total - 1] = null;
            total--;
        }else{
            throw new TeamException("没找到要删除的成员");
        }
    }
}
