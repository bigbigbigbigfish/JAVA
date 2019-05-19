package com.cao;

public class EmpAction {
    private Emp emp = new Emp();
    public void setValue(String value) {
         BeanOperation.setBeanValue(this,value);
    }

    public Emp getEmp() {
        return emp;
    }
}
