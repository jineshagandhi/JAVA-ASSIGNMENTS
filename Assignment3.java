package mpj3;

import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter radius: ");
        double radius = scanner.nextDouble();
        Circle circle = new Circle(radius);

        System.out.print("Enter length: ");
        double length = scanner.nextDouble();
        System.out.print("Enter width: ");
        double width = scanner.nextDouble();
        Rectangle rect = new Rectangle(length, width);

        System.out.print("Enter base: ");
        double base = scanner.nextDouble();
        System.out.print("Enter height: ");
        double height = scanner.nextDouble();
        Triangle tri = new Triangle(base, height);

        // Method overloading
        AreaCalculator calc = new AreaCalculator();
        System.out.println("\nUsing method overloading:");
        System.out.println("Circle Area: " + calc.area(radius));
        System.out.println("Rectangle Area: " + calc.area(length, width));
        System.out.println("Triangle Area: " + calc.area(base, height, true));

        // Runtime polymorphism
        Shape[] shapes = {circle, rect, tri};
        System.out.println("\nUsing runtime polymorphism:");
        for (Shape s : shapes) {
            System.out.println(s.getClass().getSimpleName() + " Area: " + s.area());
        }

        // Method overriding using parent reference
        Hillstations h;

        h = new Shimla();
        display(h);

        h = new Manali();
        display(h);

        h = new Darjeeling();
        display(h);
    }

    public static void display(Hillstations h) {
        System.out.println("\nHillstation: " + h.getName());
        h.famousfood();
        h.famousfor();
    }
}

abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    double radius;

    Circle() {
        this(1.0);
    }

    Circle(double r) {
        radius = r;
    }

    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double length, width;

    Rectangle() {
        this(1.0, 1.0);
    }

    Rectangle(double l, double w) {
        length = l;
        width = w;
    }

    double area() {
        return length * width;
    }
}

class Triangle extends Shape {
    double base, height;

    Triangle() {
        this(1.0, 1.0);
    }

    Triangle(double b, double h) {
        base = b;
        height = h;
    }

    double area() {
        return 0.5 * base * height;
    }
}

class AreaCalculator {
    double area(double r) {
        return Math.PI * r * r;
    }

    double area(double l, double w) {
        return l * w;
    }

    double area(double b, double h, boolean t) {
        return 0.5 * b * h;
    }
}

class Hillstations {
    String getName() {
        return "Hillstation";
    }

    void famousfood() {
        System.out.println("Famous Food: Local dishes");
    }

    void famousfor() {
        System.out.println("Famous For: Natural beauty");
    }
}

class Shimla extends Hillstations {
    String getName() {
        return "Shimla";
    }

    void famousfood() {
        System.out.println("Famous Food: Sidu");
    }

    void famousfor() {
        System.out.println("Famous For: Mall Road");
    }
}

class Manali extends Hillstations {
    String getName() {
        return "Manali";
    }

    void famousfood() {
        System.out.println("Famous Food: Trout Fish");
    }

    void famousfor() {
        System.out.println("Famous For: Solang Valley");
    }
}

class Darjeeling extends Hillstations {
    String getName() {
        return "Darjeeling";
    }

    void famousfood() {
        System.out.println("Famous Food: Momos");
    }

    void famousfor() {
        System.out.println("Famous For: Tea Gardens");
    }
}