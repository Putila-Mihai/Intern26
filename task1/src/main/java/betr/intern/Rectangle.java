package betr.intern;

public class Rectangle implements Shape{

    private double length;
    private double width;


    public Rectangle(double length, double width){
        if(length<0 || width<0){
            throw new IllegalArgumentException("Nu pot fi laturile unui Rectangle deoarece sunt negative!");
        }
        this.length= length;
        this.width=width;
    }
    public double getArea(){
        return length*width;
    }

    public double getPerimeter(){
        return 2*length + 2*width;
    }


}
