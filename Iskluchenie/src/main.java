import java.util.Scanner;

public class main {

public static void main(String[] args) {
Scanner scan = new Scanner(System.in);
try{
Figure f = new Figure(3);
System.out.println("Point1");
f.setCoord(0, 1, 1);
System.out.println("Point2");
f.setCoord(1, 3, 2);
System.out.println("Point3");
f.setCoord(2, 4, 5);
f.checkit();
} catch(PointException e){

}

} 
}