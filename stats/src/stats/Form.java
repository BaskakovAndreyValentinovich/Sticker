package stats;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Form {
	JFrame	frame;
	private String inputString="";//буфер для записки
		JTextField txtFld;
		JTextField txtFld2;
		JTextField txtFld3;
		JButton butOk;
		JButton butSave;
		JButton butRead;
		JButton butNight;
		JButton butOtsip;
		JButton butDay;
		JButton butVihod;
		JButton butTable;
		JLabel label;
		JLabel label2;
		JLabel label3;
		JLabel label4;
		JLabel tekDate;
		JPanel pan;
		JTable table;
	private int inputDay;
	private int inputMonth;
	private int inputYear;
	final int MAXYEAR=2030;		//верхний потолок рассчетов
	final int MINYEAR=2012;		//нижний потолок рассчетов
	int ostSmen;
	Date1 dt; 							//экземпляр класса Date1
	Menu menu;							//экземпляр класса Menu
	JTextArea txtarea;
	private	long summMonth=0;					//хранит кол-во дней с текущей до заданной даты.
	private	String otvet="  что-то пошло не так";
	JLabel pict=new JLabel();
	private	ImageIcon p=new ImageIcon("stats\\resurs\\22.GIF");
	private	ImageIcon p2=new ImageIcon("stats\\resurs\\about.jpg");
	private	ImageIcon p3=new ImageIcon("stats\\resurs\\ok.png");
	private	ImageIcon p4=new ImageIcon("stats\\resurs\\save.png");
	private	ImageIcon p5=new ImageIcon("stats\\resurs\\read.png");
	private	ImageIcon p7=new ImageIcon("stats\\resurs\\night.png");
	private	ImageIcon p8=new ImageIcon("stats\\resurs\\otsip.png");
	private	ImageIcon p9=new ImageIcon("stats\\resurs\\day.png");
	private	ImageIcon p10=new ImageIcon("stats\\resurs\\vihodn.png");
	private	ImageIcon p11=new ImageIcon("stats\\resurs\\table.png");
	private	int kolDnevSmen=0;//количество дневных смен
	private	int kolNochSmen=0;//количество ночных смен
	private	float talon;// талонов в выбранном месяце
	private	int budni;// количество дневных смен в будни
	//Конструктор
	
public Form (){
	
	menu=new Menu();
	 dt=new Date1();
	Otklik otkl=new Otklik();
	frame=new JFrame ("СТИКЕР v.0.8 beta");
	frame.setIconImage(Toolkit.getDefaultToolkit().getImage("stats\\resurs\\стикер.png"));//иконка на полосе перетаскивания
	txtFld=new JTextField ();
	txtFld3=new JTextField (""+dt.year);//по умолчанию в поле год ставим тек.год
	txtFld.setFont (new Font("Comic Sans MS",Font.BOLD,14));
	txtFld2=new JTextField();
	txtFld2.setFont (new Font("Comic Sans MS",Font.BOLD,14));
	txtFld3.setFont (new Font("Comic Sans MS",Font.BOLD,14));
	label=new JLabel("ч");
	label4=new JLabel("г");
	label.setFont (new Font("",Font.BOLD,15));
	label4.setFont (new Font("",Font.BOLD,15));
	label3=new JLabel();
	label3.setFont (new Font("",Font.BOLD,14));
	butOk=new JButton();
	butSave=new JButton();
	butRead=new JButton();
	butNight=new JButton();
	butOtsip=new JButton();
	butVihod=new JButton();
	butTable=new JButton();
	butDay=new JButton();
	butVihod.setIcon(p10);
	butOtsip.setIcon(p8);
	butNight.setIcon(p7);
	butDay.setIcon(p9);
	butOk.setIcon(p3);
	butSave.setIcon(p4);
	butRead.setIcon(p5);
	butTable.setIcon(p11);
	butSave.addActionListener(otkl);
	butRead.addActionListener(otkl);
	butTable.addActionListener(otkl);
	butOk.setToolTipText("Принять");
	tekDate=new JLabel(dt.day+"/"+dt.month+"/"+dt.year);
	tekDate.setFont(new Font("Comic Sans MS",Font.BOLD,11));
	label2=new JLabel("м");
	label2.setFont (new Font("",Font.BOLD,15));
	frame.setLayout(null);
	frame.setBounds(600, 260, 303, 280);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);//по центру экрана
	frame.setResizable(false);
	label.setBounds(0, 5, 240, 15);
	label4.setBounds(113, 5, 240, 15);
	label3.setBounds(0, 5, 240, 15);
	frame.add(label3);
	txtFld.setBounds(47, 5, 23, 18);
	txtFld2.setBounds(10, 5, 23, 18);
	txtFld3.setBounds(71, 5, 41, 18);
	butOk.setBounds(125, 2, 24, 24);
	butSave.setBounds(187, 2, 24, 24);
	butRead.setBounds(220, 2, 24, 24);
	butTable.setBounds(253, 2, 24, 24);
	butDay.setBounds(26, 3, 120, 120);//кнопки выбора текущей смены
	butNight.setBounds(152, 3, 120, 120);//размещаем на нашей
	butOtsip.setBounds(26, 129, 120, 120);//панели
	butVihod.setBounds(152, 129, 120, 120);//
	butSave.setToolTipText("Сохранить заметку");
	butRead.setToolTipText("Прочитать заметку");
	butTable.setToolTipText("Показать график дежурств");
	butOk.addActionListener(otkl);
	butDay.addActionListener(otkl);//вешаем 
	butNight.addActionListener(otkl);//слушателя
	butOtsip.addActionListener(otkl);//на наши
	butVihod.addActionListener(otkl);//кнопочки
	label2.setBounds(35, 5, 240, 15);
	txtarea=new JTextArea();	
	txtarea.setFont(new Font("Comic Sans MS",Font.BOLD,17));
	txtarea.setBackground(Color.pink);	
	txtarea.setLineWrap(true);//перенос текста в поле ввода
	txtarea.setWrapStyleWord(true);//перенос по словам
	txtarea.setBounds(1,27, 295, 215);
	txtarea.setEditable(true); //можно писать на стикере
	tekDate.setBounds(230, 221, 80, 50);
	frame.setAlwaysOnTop(true);//окно всегда сверху
	pan=new JPanel();
	pan.setLayout(null);
	pan.setBounds(0, 0, 303, 280);
	pan.add(butNight);
	pan.add(butOtsip);
	pan.add(butDay);
	pan.add(butVihod);
	frame.add(pan);
	
	
	
	frame.setVisible(true);
}

//=====================================================================
//обработчик нажатия ок
public	class Otklik implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == butOk) {
				
			try{
				//buffer =buffer.replaceAll("[^0-9]+", " "); отсортировывает цифры из типа стринг
				inputDay = Integer.parseInt(txtFld2.getText()); //введенный день переводим в int
				inputMonth=Integer.parseInt(txtFld.getText());//введенный месяц переводим в int
				inputYear=Integer.parseInt(txtFld3.getText());//введенный год переводим в int
			
				//далее проверка на правильность ввода==========================================
				if (inputYear>MAXYEAR||inputYear<MINYEAR){JOptionPane.showMessageDialog (frame, "А ты я вижу оптимист.","!!!" , JOptionPane.ERROR_MESSAGE);return;}
				if(inputMonth>12 || inputMonth<-1){JOptionPane.showMessageDialog (frame, "Вы ввели не существующий месяц.","!!!" , JOptionPane.ERROR_MESSAGE);return;}
				int q=dt.getKolDney(inputYear,inputMonth-1);
				if (inputDay>q||inputDay<1){JOptionPane.showMessageDialog (frame, "Нет такого дня в этом месяце.","!!!" , JOptionPane.ERROR_MESSAGE);return;}
	
				//считаем выбранный день==================================================================================

				summMonth=dt.summMonth(inputYear,inputMonth,inputDay);//метод возвращает кол-во дней с текущей до заданной даты.
		
			// считаем кол-во дневных и ночных смен===========================================================================
				table=new JTable (4,dt.getKolDney(inputYear,inputMonth-1));
		
				
			kolNochSmen=0;		//обнуляем переменные
			kolDnevSmen=0;		//чтобы никакого 
			long summM=0;		//мусора
			talon=0;
			budni=0;
			ostSmen=0;
				for (int loop=1;loop<=q;loop++){
				summM=dt.summMonth(inputYear,inputMonth,loop);
				table.setValueAt (loop,0,loop-1);//рисуем дни месяца
				//table.setValueAt (dt.getDayWeek(inputYear,(inputMonth)-1,loop),3,loop-1);//дни недели в таблице
				if(menu.calc(summM, inputYear, inputMonth, loop).equals ("ДЕНЬ")){
					kolDnevSmen++;
					table.setValueAt (" 11",1,loop-1);//заполняем дневные смены
					if(dt.getDayWeek(inputYear,(inputMonth)-1,loop).equals ("ПН")||dt.getDayWeek(inputYear,(inputMonth)-1,loop).equals ("ВТ")||dt.getDayWeek(inputYear,(inputMonth)-1,loop).equals ("СР")||dt.getDayWeek(inputYear,(inputMonth)-1,loop).equals ("ЧТ")||dt.getDayWeek(inputYear,(inputMonth)-1,loop).equals ("ПТ")){budni++;}
					}else
					if(menu.calc(summM, inputYear, inputMonth, loop).equals ("НОЧЬ")){kolNochSmen++;
					table.setValueAt("-11",1,loop-1);//заполняем ночные смены
					}
				
				
					else {table.setValueAt (" В",1,loop-1);}//заполняем выходные
				
				if(loop==inputDay){ostSmen=kolDnevSmen+kolNochSmen;}
				}
		
				
				
				talon=((kolDnevSmen+kolNochSmen)*11);// получаем кол-во часов в заданном месяце
				talon=talon/8; //получаем кол-во талонов
				ostSmen=(kolDnevSmen+kolNochSmen-ostSmen);
				//int  k=(int)tln;
			    //float res=tln-k;
//=================================================================================================================
				
				otvet=menu.calc(summMonth, inputYear, inputMonth, inputDay);
			}catch (NumberFormatException e1){
				pict.setVisible(false);	return;
			}
			}
			else 
				//сохранить записку
				if(e.getSource() == butSave){
					File fl = new File("stats\\resurs\\6.doc");
					
					FileWriter wrt;
					try {
						wrt = new FileWriter(fl);				 
						  wrt.append(txtarea.getText());
						   wrt.flush();
						   wrt.close();
					} catch (IOException e1) {	
						e1.printStackTrace();
						txtarea.setText("УПС что-то пошло не так.");
					}
									
					return;
			}else 
				// прочитать записку
				if(e.getSource() == butRead){
					Path path = Paths.get("stats\\resurs\\6.doc");
					byte[] data;//сюда сохраняем текст из файла
					txtarea.setText("");//CLS чистим стикер
					String inputString=null;
					try {
						data = Files.readAllBytes(path);//читаем файл 
					inputString= new String(data,"windows-1251");//конвертируем байты в сторки
					} catch (IOException e1) {
						txtarea.setText("УПС что-то пошло не так.");
					}
					txtarea.append(inputString);
					return;
				}
					if(e.getSource() == butTable){
						if (inputMonth>12||inputDay>dt.getKolDney(inputYear,inputMonth-1)){return;}//проверка на корректность ввода в поля  
						JFrame frame2=new JFrame("ГРАФИК НА /"+inputMonth+"/"+inputYear+"г");
						frame2.setIconImage(Toolkit.getDefaultToolkit().getImage("stats\\resurs\\стикер.png"));//иконка на полосе перетаскивания
						frame2.setResizable(false);
						frame2.setAlwaysOnTop(true);//окно всегда сверху
						table.setFont (new Font("",Font.BOLD,17));// шрифт таблицы.
					//	table.setSurrendersFocusOnKeystroke(true);
						frame2.setBounds(0,0,860,96);
						frame2.setLocationRelativeTo(null);//по центру экрана
						frame2.add(table);
						frame2.setVisible(true);
						return;
					}
			//==============================================================================================
					// проверка нажатия day
					if(e.getSource() == butDay){
						menu.setDayornight (0);

					}else
					// проверка нажатия night
					if(e.getSource() == butNight){
						menu.setDayornight (1);
						
					}else
					// проверка нажатия otsip
					if(e.getSource() == butOtsip){
						menu.setDayornight (2);
				
					}else
					// проверка нажатия vihod
					if(e.getSource() == butVihod){
						menu.setDayornight (3);
					}
						if (e.getSource() == butVihod||(e.getSource() == butDay)||(e.getSource() == butNight)||(e.getSource() == butOtsip))
					{
						frame.remove(pan);
						frame.repaint();
						txtFld.setText (""+dt.month); //забиваем поля тек. датой 
						txtFld2.setText (""+dt.day);  //и делаем клик 
						butOk.doClick(); 			//за юзера чтобы вывести инфу о сегодняшнем дне
						frame.add(label);
						frame.add(label4);
						frame.add(txtFld);						
						frame.add(txtFld2);
						frame.add(txtFld3);
						frame.add(butOk);
						frame.add(butSave);
						frame.add(butRead);
						frame.add(butTable);
						frame.add(label2);
						frame.add(tekDate);
						frame.add(txtarea);
						return;
					}	
						
			if(inputMonth==-1){
				pict.setVisible(true);
				pict.setBounds(0,0 , 295, 215);// @
				pict.setIcon(p2);
				txtarea.add(pict);
				
			}
			
			if(inputDay==31 && inputMonth==12||inputDay==23 && inputMonth==2||inputDay==8 && inputMonth==3||inputDay==9 && inputMonth==5){ //ПРАЗДНИКИ				
					pict.setVisible(true);
					pict.setBounds(1, 0, 295, 215);
					pict.setIcon(p);
					txtarea.add(pict);
					
			}
			
			if(summMonth==0){
				txtarea.setText ("        "+inputDay+" "+dt.monthName(inputMonth)+" "+inputYear+"г "+dt.getDayWeek(inputYear,(inputMonth)-1,inputDay)+"\n               сегодня"+"\n"+"        у Вас: "+otvet+"\n"+"-----------------------------"+"\n"+"талонов в месяце:"+talon+" (+-1)\n"+"дневных смен:"+kolDnevSmen+" (из них будни:"+budni +")\n"+"ночных смен:"+kolNochSmen+"\n"+"рабочих часов:"+(kolNochSmen+kolDnevSmen)*11+"\nосталось работать: "+ostSmen+" смен" );
				txtFld2.setText(null);
				txtFld.setText(null);
				return;
			}
			if(summMonth<0){
				txtarea.setText ("       "+inputDay+" "+dt.monthName(inputMonth)+" "+inputYear+"г "+dt.getDayWeek(inputYear,(inputMonth)-1,inputDay)+"\n           "+Math.abs(summMonth)+" дн. назад"+"\n"+"        у Вас: "+otvet+"\n"+"-----------------------------"+"\n"+"талонов в месяце:"+talon+" (+-1)\n"+"дневных смен:"+kolDnevSmen+" (из них будни:"+budni +")\n"+"ночных смен:"+kolNochSmen+"\n"+"рабочих часов:"+(kolNochSmen+kolDnevSmen)*11);
				txtFld2.setText(null);
				txtFld.setText(null);
				return;
			}
			else
			txtarea.setText ("        "+inputDay+" "+dt.monthName(inputMonth)+" "+inputYear+"г "+dt.getDayWeek(inputYear,(inputMonth)-1,inputDay)+"\n             через "+summMonth+" дн."+"\n"+"        у Вас будет: "+otvet+"\n"+"-----------------------------"+"\n"+"талонов в месяце:"+talon+" (+-1)\n"+"дневных смен:"+kolDnevSmen+" (из них будни:"+budni +")\n"+"ночных смен:"+kolNochSmen+"\n"+"рабочих часов:"+(kolNochSmen+kolDnevSmen)*11+"\nосталось работать: "+ostSmen+" смен");
			txtFld2.setText(null);
			txtFld.setText(null);
			return;
		}
	}


	

}
