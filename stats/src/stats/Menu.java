package stats;



	public class Menu {	
		
    	private   	String otvet="  ���-�� �� ���";
	    private int dayornight;//������ ��� ������� �����.
	    Date1 d=new Date1();
							 
	//=============================================================================
	   public int getDayornight (){ 
	   return dayornight;                               // ����� ��� ������ ������� ����.
	}
	
	   	public void setDayornight (int dayornight){    // ����� ��� ������ ������� ���� � ������.
	   	this.dayornight=dayornight;
	}
	//=============================================================================
		public String calc (long summMonth,int inputYear,int inputMonth,int inputDay){
			int z=getDayornight();
			if(summMonth>=0){
				 long   temp2=summMonth%4;		//������� ������
					for(int x=0;x<temp2;x++){
						z++;
						if(z>3){z=0;}
						}
			}					 
//---------------------------------------------------------------------------				
					if(summMonth<0)					//������� �����
					{long temp=Math.abs (summMonth);
			long	ostatok=temp%4;                                                                                                                                                                                        ;
						for(int x=0;x<ostatok;x++){
							z--;
							if(z<0){z=3;}
							}
					}
						if (z==0){otvet="����";}
						else
							if (z==1){otvet="����";}
							else
								if (z==2){otvet="��������";}
								else
									if(z==3){otvet="��������";}
							
		
		return otvet;
			}
	   	

		
	}
	
	
		



