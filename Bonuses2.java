import java.util.Scanner;

public class Bonuses2 {

    public static void main(String[] args) {

        Employee[] employees = {
                new Employee("AA"),
                new Employee("VBI"),
                new Employee("VV"),
                new Employee("EP")
        };

        int totalSalary = 0;
        int workDays = 0;
        int workDaysMonth = 21;
        double bonusWorkDays;
        Scanner scan = new Scanner(System.in);

        for (Employee employee : employees) {
            System.out.println("Enter the salary for the employee " + employee.getName());
            employee.setSalary(scan.nextInt());
            totalSalary += employee.getSalary();

            System.out.println("Enter the work days for the employee " + employee.getName());
            employee.setWorkDaysInput(scan.nextInt());
            workDays += employee.getWorkDaysInput();
        }

        System.out.println("Please, enter the bonus percentage: ");
        bonusWorkDays = scan.nextInt();

        //е от тука надолу си ебало майката
        for(Employee employee : employees) {
            Employee.getBonusDays(workDays, workDaysMonth);
            bonusWorkDays = employee.getBonusDays(workDays, workDaysMonth);
            System.out.println(bonusWorkDays);
        }
        
    }

    private static class Employee {
        String name;
        int salary;
        double workDaysInput;

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

        public Employee(String name) {
            this.name = name;
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

