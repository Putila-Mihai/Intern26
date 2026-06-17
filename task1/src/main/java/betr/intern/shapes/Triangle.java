package betr.intern.shapes;

import static java.lang.Math.sqrt;

public final class Triangle implements Shape {
    private final double side1;
    private final double side2;
    private final double side3;

    public Triangle(final double side1, final double side2, final double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public double getArea() {
        double sp = (side1 + side2 + side3) / 2d;
        return sqrt(sp * (sp-side1) * (sp-side2) * (sp-side3));
    }
}
