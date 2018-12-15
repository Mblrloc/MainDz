package Default;

public class story {
public quest start;
public quest current;
story(){
	start= new quest("Первый ваш шаг","Вы только что отстали от походной группы, вы здесь новенький, так что вашего отсутствия никто не заметит но вы решаете"
			+"(1)Громоко кричать на помощь, в надежде что вас услышат\n"
			+"(2)Попытаться выйти к населенному пункту или дороге"
			,2,50,0,0); {
				start.direction[0]=new quest("Вы докричались","Вас услышали только волки, вы залезаете на дерево",0,-25,0,+25);
		start.direction[1]=new quest("Дорогу вы не нашли, но нашли дом лесника","В доме были консервы и камин",0,+25,0,0);
		current=start;
	}

}
public void go(int  num) {
	if (num<=current.direction.length)
		current=current.direction[num-1];
	else System.out.println("Вы можете выбрать из"+current.direction.length+"вариант");
}
public boolean isEnd() {
	return current.direction.length==0;
}
}
