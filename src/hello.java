import java.util.Scanner ;
public class hello {

    public static void main(String [] args)
    {
        Circle circle= new Circle(2);
        Rectangle rectangle=new Rectangle(1,2);
        display(circle);
        display(rectangle);
    }
    public static void display(Object object){
        if(object instanceof Circle)
            System.out.println(((Circle)object).getArea());
        else if(object instanceof  Rectangle)
            System.out.println(((Rectangle)object).getArea());
    }

}
class Circle{
    double radius;
    Circle(double radius){
        this.radius=radius;
    }
    double getArea(){
        return radius*radius*3.14;
    }
}
class Rectangle{
    double length;
    double width;
    Rectangle(double length,double width){
        this.length=length;
        this.width=width;
    }
    double getArea(){
        return length*width;
    }
}

