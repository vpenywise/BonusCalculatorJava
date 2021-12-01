
import java.util.Scanner;

public class Bonuses2 {

    public static void main(String[] args) {

        Employee[] employees = {
                new Employee("AA"),
                new Employee("VBI"),
                new Employee("VV"),
                new Employee("EP")
        };

        String[] employeeList = new String[employees.length];
        for (int i=0;i<employeeList.length;i++) {
            employeeList[i] = employees[i].toString();
        }
        employeeList.toString();
        System.out.println(employeeList);


//        String[] employeeList = Arrays.asList(employees).toArray(new String[0]);
//        System.out.println(Arrays.toString(employeeList));
//        System.arraycopy(employees, 0, employeeList, 0,employeeList.length);

        int totalSalary = 0;
        int totalSumWorkDays = 0;
        int workDaysMonth = 21;
        double bonusWorkDays;
        Scanner scan = new Scanner(System.in);

        for (Employee employee : employees) {
            System.out.println("Enter the salary for the employee " + employee.getName());
            employee.setSalary(scan.nextInt());
            totalSalary += employee.getSalary();

            System.out.println("Enter the work days for the employee " + employee.getName());
            employee.setWorkDaysInput(scan.nextInt());
            totalSumWorkDays += employee.getWorkDaysInput();
        }

        System.out.println("Please, enter the bonus percentage: ");
        bonusWorkDays = scan.nextInt();

//        for(int i = 0; i < daysEntered.length; i++) {
//            daysEntered[i] = scan.nextInt();
//            System.out.println(daysEntered[0]);
//            System.out.println(daysEntered[1]);
//            System.out.println(daysEntered[2]);
//            System.out.println(daysEntered[3]);
//        }

        for(Employee employee : employees) {
            employee.getBonusDays(totalSumWorkDays, workDaysMonth);
            bonusWorkDays = employee.getBonusDays(totalSumWorkDays, workDaysMonth);
            System.out.println(bonusWorkDays);
        }

    }

    private static class Employee {
        String name;
        int salary;
        double workDaysInput;

        public Employee() {  }

        public Employee(String name) {
            this.name = name;
        }

        static double getBonusDays(double workDaysInput, int workDays) {
            return (workDaysInput / workDays);
        }

        double baseBonus(double baseBonus) {
            return this.workDaysInput / baseBonus;
        }

        void setWorkDaysInput(double workDaysInput) {
            this.workDaysInput = workDaysInput;
        }

        public double getWorkDaysInput() {
            return workDaysInput;
        }

        public String getName() {
            return name;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public int getSalary() {
            return salary;
        }

    }
}

