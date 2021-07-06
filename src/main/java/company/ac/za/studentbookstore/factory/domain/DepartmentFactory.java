package company.ac.za.studentbookstore.factory.domain;

import company.ac.za.studentbookstore.domain.Department;
import company.ac.za.studentbookstore.util.MyIdGenerator;

public class DepartmentFactory
{
    public static Department getDepartment(String department_Name,String description)
    {
        return new Department.Builder()
                             .Id(MyIdGenerator.getId(DepartmentFactory.class))
                             .DepartmentName(department_Name)
                             .Description(description)
                             .build();
    }
}
