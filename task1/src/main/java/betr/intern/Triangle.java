package betr.intern;

public class Triangle implements Shape{

    private double a;
    private double b;
    private double c;

    public Triangle (double a, double b, double c){
        if(a<0 || b<0 || c<0){
            throw new IllegalArgumentException("Nu pot fi laturile unui triunghi deoarece sunt negative!");
        }
        if(a+c<=b || a+b <=c || b+c<= a){
            throw new IllegalArgumentException("Nu pot fi laturile unui triunghi!");
        }

        this.a=a;
        this.b=b;
        this.c=c;
    }
    public double getArea() {
        double semi = (a+b+c)/2;
        return Math.sqrt(semi*(semi-a)*(semi-b)*(semi-c));
    }

    public double getPerimeter(){
        return a+b+c;
    }



}
