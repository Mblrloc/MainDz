public class Figure {
private Point[] points;
Figure(int n){
points= new Point[n];
for (int i=0; i<n;i++){
points[i]=new Point();

}

}
public void checkit() throws PointException{
double l[]=new double[2];
int x[]=new int[2];
int y[]=new int[2];
int xx,yy;

for(int i=0;i<2;i++){
x[i]=points[i].getY();
y[i]=points[i].getX();

}

l[0]=Math.sqrt((x[0]*x[0]-x[1]*x[1])+(y[0]*y[0]-y[1]*y[1]));
l[1]=Math.sqrt((x[2]*x[2]-x[1]*x[1])+(y[2]*y[2]-y[1]*y[1]));
l[2]=Math.sqrt((x[0]*x[0]-x[2]*x[2])+(y[0]*y[0]-y[2]*y[2]));
if (l[0]+l[1]<l[2] && l[0]+l[2]<l[1] && l[2]+l[1]<l[0] ){}else 
throw new PointException();
}






public void setCoord(int t,int xx,int yy) {

points[t].setX(xx);
points[t].setY(yy);

}


}