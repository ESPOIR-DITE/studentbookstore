package company.ac.za.studentbookstore.service;

import company.ac.za.studentbookstore.domain.Department;
import company.ac.za.studentbookstore.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements IService<Department,String> {
    private static DepartmentService departmentService;

    @Autowired
    private DepartmentRepository departmentRepository;

    public static DepartmentService getDepartmentService()
    {
       if(departmentService==null)
       {
           departmentService = new DepartmentService();
       }
       return departmentService;
    }

    @Override
    public Department create(Department department)
    {
        return departmentRepository.save(department);
    }

    @Override
    public Department delete(Department department) {
        Department result = getDepartment(department.getId());
        if(result!=null) {
            departmentRepository.delete(department);
            return result;
        }
        return null;
    }

    @Override
    public Department read(String id) {
      return getDepartment(id);
    }

    @Override
    public Department update(Department department) {
        Department department1 = read(department.getId());
        if(department1!=null) {
            delete(department1);
            return create(department);
        }
        return null;
    }
    public Department getDepartment(String id){
        Optional<Department> result = departmentRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<Department> readAll()
    {
        return departmentRepository.findAll();
    }
}
