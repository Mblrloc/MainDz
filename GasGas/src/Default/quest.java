package Default;

public class quest {
public quest[] direction;
public String subject;
public String text;
public int TekHeat;
public int TekWound;
public int TekHunger;
public quest(String subject, String text, int variants, int TekHEat, int TekWOund, int TekHUnger){
	this.subject=subject;
	this.text=text;
	TekHeat=TekHEat;
	TekWound=TekWOund;
TekHunger=TekHUnger;	
direction=new quest[variants];
}

}
