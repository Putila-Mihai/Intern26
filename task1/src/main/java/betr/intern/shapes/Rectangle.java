package betr.intern.shapes;

public final class Rectangle extends Shape {
    private final double length;
    private final double width;

    public Rectangle(final double length, final double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getPerimeter() {
        return 2d * (length + width);
    }

    @Override
    public double getArea() {
        return length * width;
    }
}
