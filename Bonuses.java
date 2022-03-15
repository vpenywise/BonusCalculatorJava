/*
    The below program calculates the amount of the bonus, that each employee should receive;
    The specifications as presented by the customer explicitly say they want a final result in the integer format, not a double;
    This is the reason why the truncation that happens in integer division is producing a "somewhat incorrect result" - this is intended;
    The reason why "double" is used for the variables is due to number of days for each employee, which can be greater than the total work days;
        --> example: For an Employee with 23 working days in a month having a total of 21 work days, the math is:
            -----> int variable = 23 / 21 = 0; // which breaks all consequent calculations;
            -----> double variable 23 / 21 = 1.0952380952380953; // which is than casted into an (int);
 */

import java.text.SimpleDateFormat;
import java.util.*;

public class Bonuses {

    private static final int monthWorkDays = 21;
    private static int bonus;
    private static int totalWorkDays;
    private static int totalSalary;
    private static double difference;
    private static double totalEmployeeBonus;

    public static void main(String[] args) {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Employee e1 = new Employee("AA", 770);
        Employee e2 = new Employee("VBI", 660);
        Employee e3 = new Employee("VV", 890);
        Employee e4 = new Employee("EP", 750);

        List<Employee> employeeList = Arrays.asList(e1, e2, e3, e4);

        totalSalary = totalSalary(employeeList);

        Scanner scanner = new Scanner(System.in);

        inputWorkDays(scanner, employeeList);

        totalWorkDays = getTotalWorkingDays(employeeList);

        System.out.println("Please, enter the bonus percent: ");
        bonus = scanner.nextInt();
        System.out.println("------------------");

        System.out.println("The total amount of all salaries is: " + totalSalary + "lv");
        System.out.println("The bonus percentage is: " + bonus + "%");
        System.out.println("The total number of work days is: " + totalWorkDays + " days \n");

        calculateBonusDays(totalWorkDays, employeeList);

        calculateBaseBonus(employeeList);

        totalEmployeeBonus = calculateTotalEmployeeBonus(employeeList);

        difference = calculateBonusDays(getExtraBonus(totalSalary * bonus), 100) - getExtraBonus(totalEmployeeBonus);

        calculateExtraBonus(employeeList);

        calculateFinalBonus(employeeList);

        printFinalBonus(employeeList);

        System.out.println("The report is generated on: " + formatter.format(date));
    }

    private static void printFinalBonus(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            System.out.println("The bonus of " + employee.getName() + " is " + employee.getFinalBonus() + "lv");
        }
    }

    private static void calculateFinalBonus(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            employee.setFinalBonus(getFinalBonus(employee.getBaseBonus(), employee.getExtraBonus()));
        }
    }

    private static void calculateExtraBonus(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            employee.setExtraBonus((int) getExtraBonus(employee.getBonusDays()));
        }
    }

    private static double calculateTotalEmployeeBonus(List<Employee> employeeList) {
        double totalBonus = 0;
        for (Employee employee : employeeList) {
            totalBonus += employee.getBaseBonus();
        }
        return totalBonus;
    }

    private static void calculateBaseBonus(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            employee.setBaseBonus((int) getEmployeeBaseBonus(employee, bonus, employee.getWorkDays()));
        }
    }

    private static void calculateBonusDays(int totalWorkDays, List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            employee.setBonusDays((int) calculateBonusDays(employee.getWorkDays(), totalWorkDays));
        }
    }

    private static int getTotalWorkingDays(List<Employee> employeeList) {
        int totalWorkDays = 0;
        for (Employee employee : employeeList) {
            totalWorkDays += employee.getWorkDays();
        }
        return totalWorkDays;
    }

    private static void inputWorkDays(Scanner scanner, List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            System.out.println("Enter the work days for the employee " + employee.getName());
            employee.setWorkDays(scanner.nextInt());
        }
    }

    private static int getFinalBonus(double employeeBaseBonus, double extraBonus) {
        return (int) (employeeBaseBonus + extraBonus);
    }

    private static double getExtraBonus(double bonusDays) {
        return getDifference() * bonusDays;
    }

    private static double calculateBonusDays(double workDaysInput, int totalWorkDays) {
        return workDaysInput / totalWorkDays;
    }

//    double employee1 = (salaryInput1 * bonusPercent) / 100 / (monthWorkDays / workDaysInput1);

    private static double getEmployeeBaseBonus(Employee e1, int bonus, int workDaysInput1) {
        return (e1.getSalary() * bonus) / 100 / (Bonuses.monthWorkDays / workDaysInput1);
    }

    private static double getDifference() {
        return ((totalSalary * bonus) / 100) - (totalEmployeeBonus);
    }

    private static int totalSalary(List<Employee> employeeList) {
        int salary = 0;
        for (Employee employee : employeeList) {
            salary += employee.getSalary();
        }
        return salary;
    }

}
