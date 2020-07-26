import java.util.ArrayList;

public class Manager extends Employee {
//    Employee[] employees = new Employee[]();
    ArrayList<Employee> employees = new ArrayList<>();

    public Manager(String first, String last, int pay, ArrayList<Employee> employees){
        super(first, last, pay);
        this.employees = employees;
    }

    public void add_emp(Employee emp){
        if(!this.employees.contains(emp)) {
            this.employees.add(emp);
        }
    }

    public void remove_emp(Employee emp){
        if(this.employees.contains(emp)){
            this.employees.remove(emp);
        }
    }

    public void print_emp(){
        for(Employee ee : employees){
            System.out.println("--->" + ee.fullname());
        }
    }
}
