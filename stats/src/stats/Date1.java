package stats;
import java.util.Calendar;


    public class Date1 {
    	
    	private    	Calendar c1=Calendar.getInstance();
    	private    	Calendar c2=Calendar.getInstance();
    	private  	Calendar c=Calendar.getInstance();
		int dayYear=c.get(c.DAY_OF_YEAR);//кол-во дней с начала года
    	int year=c.get(c.YEAR);       // текущий год
    	int month=c.get(c.MONTH)+1;   // текущий мес€ц
    	int day=c.get(c.DAY_OF_MONTH);// текущий день
	 	int week=c.get(c.DAY_OF_WEEK);
 
//возвращает кол-во дней в мес€це
public int getKolDney (int year, int month){
			c.clear();
        	c.set (c.YEAR, year);
        	c.set(c.MONTH, month);	
        	return c.getActualMaximum(c.DAY_OF_MONTH);
        }
//конвертирует и возвращает день недели  тип String
public String getDayWeek (int year, int month,int day){
	String denNedel=null;
			c.set (c.YEAR, year);
			c.set(c.MONTH, month);
			c.set(c.DAY_OF_MONTH,day);
			if (c.get(c.DAY_OF_WEEK)==1){return denNedel="¬—";}
			else
				if (c.get(c.DAY_OF_WEEK)==2){return denNedel="ѕЌ";}
				else
					if (c.get(c.DAY_OF_WEEK)==3){return denNedel="¬“";}
					else
						if (c.get(c.DAY_OF_WEEK)==4){return denNedel="—–";}
						else
							if (c.get(c.DAY_OF_WEEK)==5){return denNedel="„“";}
							else
								if (c.get(c.DAY_OF_WEEK)==6){return denNedel="ѕ“";}
								else
									if (c.get(c.DAY_OF_WEEK)==7){return denNedel="—Ѕ";}
			
			return denNedel;	
}
//возвращает кол-во дней от текущей до заданной даты.-----------------------------------------
public long summMonth(int inputYear, int inputMonth,int inputDay){
	c2.set(inputYear,inputMonth-1,inputDay);
	return	((c2.getTimeInMillis()-c1.getTimeInMillis())/1000/3600/24);
}
public String monthName(int date){
	String d="";
	if (date==1){return d="яЌ¬ј–я";}
	else
		if (date==2){return d="‘≈¬–јЋя";}
		else
			if (date==3){return d="ћј–“ј";}
			else
				if (date==4){return d="јѕ–≈Ћя";}
				else
					if (date==5){return d="ћјя";}
					else
						if (date==6){return d="»ёЌя";}
						else
							if (date==7){return d="»ёЋя";}
							else
								if (date==8){return d="ј¬√”—“ј";}
								else
									if (date==9){return d="—≈Ќ“яЅ–я";}
									else
										if (date==10){return d="ќ “яЅ–я";}
										else
											if (date==11){return d="ЌќяЅ–я";}
											else
												if (date==12){return d="ƒ≈ јЅ–я";}
												
	
	return d;
}
}
	
	


 
