import java.util.Scanner;
import java.lang.Math;

class Point {
    double x, y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Triangle {
    Point p1, p2, p3;

    Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    double distance(Point a, Point b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    double perimeter() {
        return distance(p1, p2) + distance(p2, p3) + distance(p3, p1);
    }

    String type() {
        double a = distance(p1, p2);
        double b = distance(p2, p3);
        double c = distance(p3, p1);

        if (a == b && b == c)
            return "Equilateral";
        else if (a == b || b == c || c == a)
            return "Isosceles";
        else
            return "Unknown";
    }
}

public class Geometry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Triangle[] triangles = new Triangle[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter the coordinates for Triangle " + (i+1) + ":");
            System.out.print("Point 1: ");
            Point p1 = new Point(scanner.nextDouble(), scanner.nextDouble());
            System.out.print("Point 2: ");
            Point p2 = new Point(scanner.nextDouble(), scanner.nextDouble());
            System.out.print("Point 3: ");
            Point p3 = new Point(scanner.nextDouble(), scanner.nextDouble());

            triangles[i] = new Triangle(p1, p2, p3);

            System.out.println("Perimeter of triangle " + (i+1) + ": " + triangles[i].perimeter());
            System.out.println("Type of Triangle " + (i+1) + ": " + triangles[i].type());
        }

        scanner.close();
    }
}
