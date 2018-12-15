package Default;

import java.util.Scanner;


	public class manya {

		public static Character wanderer;
		public static story story;
		
	public void main(String[] args) {

		Scanner in=new Scanner(System.in);
		wanderer=new Character();
		story=new story();
		while(true) {
		wanderer.Heat+=story.current.TekHeat;
		wanderer.Hunger+=story.current.TekHunger;
		wanderer.Wound+=story.current.TekWound;
		System.out.println(story.current.subject);
		if(story.isEnd()) {System.out.println("the end!");return;}
		story.go(in.nextInt());
		}
	}
	}




