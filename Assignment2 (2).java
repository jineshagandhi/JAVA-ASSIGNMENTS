package assignment2;

class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    void displaySalary() {
        System.out.println("Employee Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

class FullTimeEmployee extends Employee {

    FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    void calculateSalary() {
        System.out.println("\nFull Time Employee:");
        System.out.println("Salary before hike: " + salary);
        salary = salary + (salary * 0.50);
        System.out.println("Salary after 50% hike: " + salary);
    }
}

class InternEmployee extends Employee {

    InternEmployee(String name, double salary) {
        super(name, salary);
    }

    void calculateSalary() {
        System.out.println("\nIntern Employee:");
        System.out.println("Salary before hike: " + salary);
        salary = salary + (salary * 0.25);
        System.out.println("Salary after 25% hike: " + salary);
    }
}

public class EmployeeHierarchy {
    public static void main(String[] args) {

        FullTimeEmployee f = new FullTimeEmployee("Jinesha", 20000);
        InternEmployee i = new InternEmployee("Rahul", 10000);

        f.displaySalary();
        f.calculateSalary();

        i.displaySalary();
        i.calculateSalary();
    }
}
