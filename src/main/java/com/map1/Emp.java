package com.map1;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Employee_details")
public class Emp {
    @Id
    private int empId;
    private String empName;
    @ManyToMany
    @JoinTable( name = "emp_learn",
    joinColumns = { @JoinColumn(name = "eid")},
    inverseJoinColumns = {@JoinColumn(name = "pid")})
    private List<Project> projects;

    public Emp() {

    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Emp(int empId, String empName, List<Project> projects) {
        this.empId = empId;
        this.empName = empName;
        this.projects = projects;
    }
}
