package opps;

// Shape class (Base Class)
class Shape {
    protected String color;
    protected double area;
    protected int perimeter; // Corrected "parameter" to "perimeter" for clarity

    // Constructor with color
    Shape(String color, double area, int perimeter) {
        this.color = color;
        this.area = area;
        this.perimeter = perimeter;
    }

    // Constructor without color
    Shape(double area, int perimeter) {
        this.area = area;
        this.perimeter = perimeter;
    }

    // Method to display shape details
    public void display() {
        System.out.println("Color: " + (color != null ? color : "Not specified"));
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);
    }
}

// Circle class (Derived from Shape)
class Circle extends Shape {
    private int radius;

    // Constructor with color
    Circle(String color, int radius) {
        super(color, Math.PI * radius * radius, (int) (2 * Math.PI * radius));
        this.radius = radius;
    }

    // Constructor without color
    Circle(int radius) {
        super(Math.PI * radius * radius, (int) (2 * Math.PI * radius));
        this.radius = radius;
    }

    @Override
    public void display() {
        System.out.println("Shape: Circle");
        super.display();
        System.out.println("Radius: " + radius);
    }
}

// Rectangle class (Derived from Shape)
class Rectangle extends Shape {
    private int length, breadth;

    // Constructor with color
    Rectangle(String color, int length, int breadth) {
        super(color, length * breadth, 2 * (length + breadth));
        this.length = length;
        this.breadth = breadth;
    }

    // Constructor without color
    Rectangle(int length, int breadth) {
        super(length * breadth, 2 * (length + breadth));
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public void display() {
        System.out.println("Shape: Rectangle");
        super.display();
        System.out.println("Length: " + length + ", Breadth: " + breadth);
    }
}

// Main Class
public class Inheritance {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle("Blue", 10, 20);
        Shape square = new Rectangle("Red", 10, 10);
        Shape circle = new Circle("Green", 7);

        // Display details
        rectangle.display();
        System.out.println();
        square.display();
        System.out.println();
        circle.display();
    }
}
