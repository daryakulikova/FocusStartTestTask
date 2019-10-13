import java.util.ArrayList;

public class Triangle {
    private Point point1;
    private Point point2;
    private Point point3;
    private double lenght1;
    private double lenght2;
    private double lenght3;
    private double S;

    public Triangle(ArrayList<Integer> triangleCoord) {
        this.point1 = new Point(triangleCoord.get(0),triangleCoord.get(1));
        this.point2 = new Point(triangleCoord.get(2),triangleCoord.get(3));
        this.point3 = new Point(triangleCoord.get(4),triangleCoord.get(5));
        lenght1= Math.sqrt(Math.pow((point2.getX()-point1.getX()),2)+Math.pow((point2.getY()-point1.getY()),2));
        lenght2= Math.sqrt(Math.pow((point3.getX()-point1.getX()),2)+Math.pow((point3.getY()-point1.getY()),2));
        lenght3= Math.sqrt(Math.pow((point2.getX()-point3.getX()),2)+Math.pow((point2.getY()-point3.getY()),2));
        double p = (lenght1+lenght2+lenght3)/2;
        S = Math.sqrt(p*(p-lenght1)*(p-lenght2)*(p-lenght3));
    }

    public boolean isIsosceles(){
        if (lenght1==lenght2 || lenght2==lenght3 || lenght1==lenght3){
            return true;
        }
        else{
            return false;
        }
    }

    public double getS() {
        return S;
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public Point getPoint3() {
        return point3;
    }

    @Override
    public String toString() {
        return point1 + " " + point2 +" " + point3;
    }
}
