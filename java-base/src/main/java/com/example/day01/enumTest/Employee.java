package com.example.day01.enumTest;

/**
 *  枚举类使用enum修饰，并且枚举类是final的，不能被继承
 *  不能继承其他类，但可以实现接口
 *  比较复杂的枚举类型
 *  员工类型
 */
public enum Employee implements Work {
    CEO("sz001","执行总裁","大拿"),
    CTO("sz002","技术总监","赵四"),
    MANAGER("sz003","经理","小宝");
    private String employeeId; // 员工编号
    private String job; // 员工职位
    private String name; // 员工名称

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    Employee(String employeeId, String job, String name) {
        this.employeeId = employeeId;
        this.job = job;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", job='" + job + '\'' +
                ", name='" + name + '\'' +
                "} " + super.toString();
    }

    /**
     *  枚举类自带一个 values() 方法 用于将本类中的所有属性 转化为一个数组
     * @param employeeId
     * @return
     */

    public static Employee getEmployeeById(String employeeId){
        Employee[] values = Employee.values();
        for (int i = 0; i < values.length; i++) {
            if(employeeId.equals(values[i].getEmployeeId())){
                return values[i];
            }
        }
        return null;
    }


    @Override
    public void doWork() {
        System.out.println(name + "在工作");
    }
}

