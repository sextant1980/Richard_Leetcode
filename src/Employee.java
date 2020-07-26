import java.time.DayOfWeek;
import java.time.LocalDate;

public class Employee {
    private String first;
    private String last;
    private int pay;
    private String email;
    private static double raise_amount_base = 1.04;
    private double raise_amount = raise_amount_base;
    private static int num_of_emps = 0;

    public Employee(String first, String last, int pay) {
        this.first = first;
        this.last = last;
        this.pay = pay;
        this.email = first + "." + last + "@company.com";
        num_of_emps += 1;
    }

    public void setPay(int pay){
        this.pay = pay;
    }
    public int getPay(){
        return this.pay;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getRaise_amount() {
        return this.raise_amount;
    }

    public void setRaise_amount(double raise_amount) {
        this.raise_amount = raise_amount;
    }

    public static double getRaise_amount_base() {
        return raise_amount_base;
    }

    public static void setRaise_amount_base(double raise_amount_base) {
        Employee.raise_amount_base = raise_amount_base;
    }

    public static int getNum_of_emps() {
        return num_of_emps;
    }

    public String fullname(){
        return this.getFirst() + " " + this.getLast();
    }

    public void apply_raise(){
        this.pay = (int) (this.pay * raise_amount);
    }

    public static boolean is_workday(LocalDate localDate){
        DayOfWeek dayOfWeek = DayOfWeek.from(localDate);
        if(dayOfWeek.getValue() == 5 || dayOfWeek.getValue() == 6){
            return false;
        }
        return true;
    }

}

