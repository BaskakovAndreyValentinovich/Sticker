package stats;
import java.util.Calendar;


    public class Date1 {
    	
    	private    	Calendar c1=Calendar.getInstance();
    	private    	Calendar c2=Calendar.getInstance();
    	private  	Calendar c=Calendar.getInstance();
		int dayYear=c.get(c.DAY_OF_YEAR);//���-�� ���� � ������ ����
    	int year=c.get(c.YEAR);       // ������� ���
    	int month=c.get(c.MONTH)+1;   // ������� �����
    	int day=c.get(c.DAY_OF_MONTH);// ������� ����
	 	int week=c.get(c.DAY_OF_WEEK);
 
//���������� ���-�� ���� � ������
public int getKolDney (int year, int month){
			c.clear();
        	c.set (c.YEAR, year);
        	c.set(c.MONTH, month);	
        	return c.getActualMaximum(c.DAY_OF_MONTH);
        }
//������������ � ���������� ���� ������  ��� String
public String getDayWeek (int year, int month,int day){
	String denNedel=null;
			c.set (c.YEAR, year);
			c.set(c.MONTH, month);
			c.set(c.DAY_OF_MONTH,day);
			if (c.get(c.DAY_OF_WEEK)==1){return denNedel="��";}
			else
				if (c.get(c.DAY_OF_WEEK)==2){return denNedel="��";}
				else
					if (c.get(c.DAY_OF_WEEK)==3){return denNedel="��";}
					else
						if (c.get(c.DAY_OF_WEEK)==4){return denNedel="��";}
						else
							if (c.get(c.DAY_OF_WEEK)==5){return denNedel="��";}
							else
								if (c.get(c.DAY_OF_WEEK)==6){return denNedel="��";}
								else
									if (c.get(c.DAY_OF_WEEK)==7){return denNedel="��";}
			
			return denNedel;	
}
//���������� ���-�� ���� �� ������� �� �������� ����.-----------------------------------------
public long summMonth(int inputYear, int inputMonth,int inputDay){
	c2.set(inputYear,inputMonth-1,inputDay);
	return	((c2.getTimeInMillis()-c1.getTimeInMillis())/1000/3600/24);
}
public String monthName(int date){
	String d="";
	if (date==1){return d="������";}
	else
		if (date==2){return d="�������";}
		else
			if (date==3){return d="�����";}
			else
				if (date==4){return d="������";}
				else
					if (date==5){return d="���";}
					else
						if (date==6){return d="����";}
						else
							if (date==7){return d="����";}
							else
								if (date==8){return d="�������";}
								else
									if (date==9){return d="��������";}
									else
										if (date==10){return d="�������";}
										else
											if (date==11){return d="������";}
											else
												if (date==12){return d="�������";}
												
	
	return d;
}
}
	
	


 
