package com.example.day01.enumTest;

/**

 */
public class TestEmp {
    public static void main(String[] args) {
        Employee sz001 = Employee.getEmployeeById("sz001");

        sz001.doWork();
        System.out.println("sz001 = " + sz001);


        Employee cto = Employee.CTO;

        cto.doWork();
        System.out.println("cto = " + cto);

    }
}

