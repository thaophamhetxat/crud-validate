//package validate;
//
//import moduls.Employee;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//import service.IEmployeeService;
//
//import java.util.ArrayList;
//
//public class ValidateAge implements Validator {
//    @Autowired
//    IEmployeeService iEmployeeService;
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return false;
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        ArrayList<Employee> list = iEmployeeService.findAll();
//        Employee employee = (Employee) target;
//
//        for (Employee e:list) {
//            if (e.getAge() < 18){
//                errors.rejectValue("age", "age");
//                break;
//            }
//        }
//    }
//}
