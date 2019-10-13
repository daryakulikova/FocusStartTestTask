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
        lenght1= Math.sqrt(Math.pow((point2.x-point1.x),2)+Math.pow((point2.y-point1.y),2));
        lenght2= Math.sqrt(Math.pow((point3.x-point1.x),2)+Math.pow((point3.y-point1.y),2));
        lenght3= Math.sqrt(Math.pow((point2.x-point3.x),2)+Math.pow((point2.y-point3.y),2));
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
}
