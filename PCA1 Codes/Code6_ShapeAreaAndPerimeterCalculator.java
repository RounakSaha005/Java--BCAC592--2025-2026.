import java.util.Scanner;
abstract class Shape {
    private final String shapeName;
    Shape(String shapeName) {
        this.shapeName = shapeName;
    }
    public String getShapeName() {
        return shapeName;
    }
    abstract double calculateArea();
    abstract double calculatePerimeter();
}
class Circle extends Shape {
    private double radius;
    Circle() {
        super("CIRCLE");
    }
    public void setDimensions(double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    double calculateArea() {
        return Math.PI * radius * radius;
    }
    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}
class Rectangle extends Shape {
    private double length;
    private double breadth;
    Rectangle() {
        super("RECTANGLE");
    }
    public void setDimensions(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }
    public double getLength() {
        return length;
    }
    public double getBreadth() {
        return breadth;
    }
    double calculateArea() {
        return length * breadth;
    }
    double calculatePerimeter() {
        return 2 * (length + breadth);
    }
}
public class Code6_ShapeAreaAndPerimeterCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("SHAPE AREA & PERIMETER CALCULATOR: -");
        System.out.println("1. CIRCLE");
        System.out.println("2. RECTANGLE");
        System.out.println("0. EXIT");
        System.out.print("ENTER YOUR CHOICE: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                Circle circle = new Circle();
                System.out.print("ENTER RADIUS: ");
                double radius = input.nextDouble();
                circle.setDimensions(radius);
                System.out.println("\nRESULT: -");
                System.out.println("SHAPE: " + circle.getShapeName());
                System.out.println("RADIUS: " + circle.getRadius());
                System.out.println("AREA: " + circle.calculateArea());
                System.out.println("PERIMETER: " + circle.calculatePerimeter());
                break;
            case 2:
                Rectangle rectangle = new Rectangle();
                System.out.print("ENTER LENGTH: ");
                double length = input.nextDouble();
                System.out.print("ENTER BREADTH: ");
                double breadth = input.nextDouble();
                rectangle.setDimensions(length, breadth);
                System.out.println("\nRESULT: -");
                System.out.println("SHAPE: " + rectangle.getShapeName());
                System.out.println("LENGTH: " + rectangle.getLength());
                System.out.println("BREADTH: " + rectangle.getBreadth());
                System.out.println("AREA: " + rectangle.calculateArea());
                System.out.println("PERIMETER: " + rectangle.calculatePerimeter());
                break;
            case 0:
                System.out.println("EXITING...");
                System.exit(0);
            default:
                System.out.println("INVALID CHOICE!");
        }
    }
}
/*Output: -
SHAPE AREA & PERIMETER CALCULATOR: -
1. CIRCLE
2. RECTANGLE
0. EXIT
ENTER YOUR CHOICE: 1
ENTER RADIUS: 5

RESULT: -
SHAPE: CIRCLE
RADIUS: 5.0
AREA: 78.53981633974483
PERIMETER: 31.41592653589793

SHAPE AREA & PERIMETER CALCULATOR: -
1. CIRCLE
2. RECTANGLE
0. EXIT
ENTER YOUR CHOICE: 2
ENTER LENGTH: 10
ENTER BREADTH: 5

RESULT: -
SHAPE: RECTANGLE
LENGTH: 10.0
BREADTH: 5.0
AREA: 50.0
PERIMETER: 30.0
 */