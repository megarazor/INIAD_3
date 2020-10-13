public class Circle {
    double radius;
    String color;
    int pointX;
    int pointY;
    public Circle(){
        radius= 1.0;
        color= "red";
        pointX= 0;
        pointY= 0;
    }
    public Circle(double radius){
        this.radius= radius;
        color= "red";
        pointX= 0;
        pointY= 0;
    }
    public Circle(double radius, String color){
        this.radius= radius;
        this.color= color;
        pointX= 0;
        pointY= 0;
    }
    public Circle(int pointX, int pointY){
        this.pointX= pointX;
        this.pointY= pointY;
        radius= 1.0;
        color= "red";
    }
    public Circle(double radius, String color, int pointX, int pointY){
        this.radius= radius;
        this.color= color;
        this.pointX= pointX;
        this.pointY= pointY;        
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }
    public double getCircumference(){
        return Math.PI * radius * 2.0;
    }
    public double getDistance(Circle c){
        double d= Math.sqrt(Math.pow(this.pointX - c.pointX, 2) + Math.pow(this.pointY - c.pointY, 2)) - (this.radius + c.radius);
        if (d < 0){
            return 0.0;
        }        
        else {
            return d;
        }
    }
}
