package stats;



	public class Menu {	
		
    	private   	String otvet="  что-то не так";
	    private int dayornight;//ночна€ или дневна€ смена.
	    Date1 d=new Date1();
							 
	//=============================================================================
	   public int getDayornight (){ 
	   return dayornight;                               // гетер дл€ первый рабочий день.
	}
	
	   	public void setDayornight (int dayornight){    // сетер дл€ первый рабочий день в мес€це.
	   	this.dayornight=dayornight;
	}
	//=============================================================================
		public String calc (long summMonth,int inputYear,int inputMonth,int inputDay){
			int z=getDayornight();
			if(summMonth>=0){
				 long   temp2=summMonth%4;		//рассчет вперед
					for(int x=0;x<temp2;x++){
						z++;
						if(z>3){z=0;}
						}
			}					 
//---------------------------------------------------------------------------				
					if(summMonth<0)					//рассчет назад
					{long temp=Math.abs (summMonth);
			long	ostatok=temp%4;                                                                                                                                                                                        ;
						for(int x=0;x<ostatok;x++){
							z--;
							if(z<0){z=3;}
							}
					}
						if (z==0){otvet="ƒ≈Ќ№";}
						else
							if (z==1){otvet="Ќќ„№";}
							else
								if (z==2){otvet="ќ“—џѕЌќ…";}
								else
									if(z==3){otvet="¬џ’ќƒЌќ…";}
							
		
		return otvet;
			}
	   	

		
	}
	
	
		



