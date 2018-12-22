
public class Soil {
	public boolean solubility;
Soil(boolean a){
	this.solubility=a;
}

public static boolean plus(Soil a, Soil b) {
	if (a.solubility!=false && b.solubility!=false) return(true);
			else 
		return(false);
}


}
