package betr.intern;

public class Circle implements Shape{

    private double radius;

    public Circle(double radius){
        if(radius<0){
            throw new IllegalArgumentException("Nu putem avea raza negativa!");
        }
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter(){
        return Math.PI * 2 * radius;
    }
}

