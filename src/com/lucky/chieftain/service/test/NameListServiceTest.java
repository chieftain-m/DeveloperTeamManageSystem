package com.lucky.chieftain.service.test;

import com.lucky.chieftain.domain.Employee;
import com.lucky.chieftain.domain.Equipment;
import com.lucky.chieftain.domain.Programmer;
import com.lucky.chieftain.service.NameListService;
import com.lucky.chieftain.service.TeamException;
import org.junit.Test;

public class NameListServiceTest {
    @Test
    public void getAllEmployeesTest(){
        NameListService service = new NameListService();
        Employee[] allEmployees = service.getAllEmployees();
        for (Employee employee : allEmployees) {
            //获取数组中的对象
            System.out.println(employee.getName() + " ");
            if (employee instanceof Programmer) {
                Programmer programmer = (Programmer) employee;
                System.out.println(programmer.getEquipment().getDescription());
            }
        }
    }

}
