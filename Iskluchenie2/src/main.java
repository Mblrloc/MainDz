
public class main {

	public static void main(String[] args) throws NullPoinetException {
Soil b=new Soil(false);
Soil a=new Soil(true);



if(Soil.plus(a,b)==false)
	throw new NullPointerException("No"); 
else {System.out.println("All right!");}

	


}

}
