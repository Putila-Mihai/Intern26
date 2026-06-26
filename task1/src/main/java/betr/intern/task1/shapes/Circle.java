package betr.intern.task1.shapes;

public final class Circle implements Shape {
    private final double radius;

    public Circle(final double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2d * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
