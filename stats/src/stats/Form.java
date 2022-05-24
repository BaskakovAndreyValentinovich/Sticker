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
	private String inputString="";//����� ��� �������
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
	final int MAXYEAR=2030;		//������� ������� ���������
	final int MINYEAR=2012;		//������ ������� ���������
	int ostSmen;
	Date1 dt; 							//��������� ������ Date1
	Menu menu;							//��������� ������ Menu
	JTextArea txtarea;
	private	long summMonth=0;					//������ ���-�� ���� � ������� �� �������� ����.
	private	String otvet="  ���-�� ����� �� ���";
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
	private	int kolDnevSmen=0;//���������� ������� ����
	private	int kolNochSmen=0;//���������� ������ ����
	private	float talon;// ������� � ��������� ������
	private	int budni;// ���������� ������� ���� � �����
	//�����������
	
public Form (){
	
	menu=new Menu();
	 dt=new Date1();
	Otklik otkl=new Otklik();
	frame=new JFrame ("������ v.0.8 beta");
	frame.setIconImage(Toolkit.getDefaultToolkit().getImage("stats\\resurs\\������.png"));//������ �� ������ ��������������
	txtFld=new JTextField ();
	txtFld3=new JTextField (""+dt.year);//�� ��������� � ���� ��� ������ ���.���
	txtFld.setFont (new Font("Comic Sans MS",Font.BOLD,14));
	txtFld2=new JTextField();
	txtFld2.setFont (new Font("Comic Sans MS",Font.BOLD,14));
	txtFld3.setFont (new Font("Comic Sans MS",Font.BOLD,14));
	label=new JLabel("�");
	label4=new JLabel("�");
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
	butOk.setToolTipText("�������");
	tekDate=new JLabel(dt.day+"/"+dt.month+"/"+dt.year);
	tekDate.setFont(new Font("Comic Sans MS",Font.BOLD,11));
	label2=new JLabel("�");
	label2.setFont (new Font("",Font.BOLD,15));
	frame.setLayout(null);
	frame.setBounds(600, 260, 303, 280);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);//�� ������ ������
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
	butDay.setBounds(26, 3, 120, 120);//������ ������ ������� �����
	butNight.setBounds(152, 3, 120, 120);//��������� �� �����
	butOtsip.setBounds(26, 129, 120, 120);//������
	butVihod.setBounds(152, 129, 120, 120);//
	butSave.setToolTipText("��������� �������");
	butRead.setToolTipText("��������� �������");
	butTable.setToolTipText("�������� ������ ��������");
	butOk.addActionListener(otkl);
	butDay.addActionListener(otkl);//������ 
	butNight.addActionListener(otkl);//���������
	butOtsip.addActionListener(otkl);//�� ����
	butVihod.addActionListener(otkl);//��������
	label2.setBounds(35, 5, 240, 15);
	txtarea=new JTextArea();	
	txtarea.setFont(new Font("Comic Sans MS",Font.BOLD,17));
	txtarea.setBackground(Color.pink);	
	txtarea.setLineWrap(true);//������� ������ � ���� �����
	txtarea.setWrapStyleWord(true);//������� �� ������
	txtarea.setBounds(1,27, 295, 215);
	txtarea.setEditable(true); //����� ������ �� �������
	tekDate.setBounds(230, 221, 80, 50);
	frame.setAlwaysOnTop(true);//���� ������ ������
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
//���������� ������� ��
public	class Otklik implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == butOk) {
				
			try{
				//buffer =buffer.replaceAll("[^0-9]+", " "); ��������������� ����� �� ���� ������
				inputDay = Integer.parseInt(txtFld2.getText()); //��������� ���� ��������� � int
				inputMonth=Integer.parseInt(txtFld.getText());//��������� ����� ��������� � int
				inputYear=Integer.parseInt(txtFld3.getText());//��������� ��� ��������� � int
			
				//����� �������� �� ������������ �����==========================================
				if (inputYear>MAXYEAR||inputYear<MINYEAR){JOptionPane.showMessageDialog (frame, "� �� � ���� ��������.","!!!" , JOptionPane.ERROR_MESSAGE);return;}
				if(inputMonth>12 || inputMonth<-1){JOptionPane.showMessageDialog (frame, "�� ����� �� ������������ �����.","!!!" , JOptionPane.ERROR_MESSAGE);return;}
				int q=dt.getKolDney(inputYear,inputMonth-1);
				if (inputDay>q||inputDay<1){JOptionPane.showMessageDialog (frame, "��� ������ ��� � ���� ������.","!!!" , JOptionPane.ERROR_MESSAGE);return;}
	
				//������� ��������� ����==================================================================================

				summMonth=dt.summMonth(inputYear,inputMonth,inputDay);//����� ���������� ���-�� ���� � ������� �� �������� ����.
		
			// ������� ���-�� ������� � ������ ����===========================================================================
				table=new JTable (4,dt.getKolDney(inputYear,inputMonth-1));
		
				
			kolNochSmen=0;		//�������� ����������
			kolDnevSmen=0;		//����� �������� 
			long summM=0;		//������
			talon=0;
			budni=0;
			ostSmen=0;
				for (int loop=1;loop<=q;loop++){
				summM=dt.summMonth(inputYear,inputMonth,loop);
				table.setValueAt (loop,0,loop-1);//������ ��� ������
				//table.setValueAt (dt.getDayWeek(inputYear,(inputMonth)-1,loop),3,loop-1);//��� ������ � �������
				if(menu.calc(summM, inputYear, inputMonth, loop).equals ("����")){
					kolDnevSmen++;
					table.setValueAt (" 11",1,loop-1);//��������� ������� �����
					if(dt.getDayWeek(inputYear,(inputMonth)-1,loop).equals ("��")||dt.getDayWeek(inputYear,(inputMonth)-1,loop).equals ("��")||dt.getDayWeek(inputYear,(inputMonth)-1,loop).equals ("��")||dt.getDayWeek(inputYear,(inputMonth)-1,loop).equals ("��")||dt.getDayWeek(inputYear,(inputMonth)-1,loop).equals ("��")){budni++;}
					}else
					if(menu.calc(summM, inputYear, inputMonth, loop).equals ("����")){kolNochSmen++;
					table.setValueAt("-11",1,loop-1);//��������� ������ �����
					}
				
				
					else {table.setValueAt (" �",1,loop-1);}//��������� ��������
				
				if(loop==inputDay){ostSmen=kolDnevSmen+kolNochSmen;}
				}
		
				
				
				talon=((kolDnevSmen+kolNochSmen)*11);// �������� ���-�� ����� � �������� ������
				talon=talon/8; //�������� ���-�� �������
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
				//��������� �������
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
						txtarea.setText("��� ���-�� ����� �� ���.");
					}
									
					return;
			}else 
				// ��������� �������
				if(e.getSource() == butRead){
					Path path = Paths.get("stats\\resurs\\6.doc");
					byte[] data;//���� ��������� ����� �� �����
					txtarea.setText("");//CLS ������ ������
					String inputString=null;
					try {
						data = Files.readAllBytes(path);//������ ���� 
					inputString= new String(data,"windows-1251");//������������ ����� � ������
					} catch (IOException e1) {
						txtarea.setText("��� ���-�� ����� �� ���.");
					}
					txtarea.append(inputString);
					return;
				}
					if(e.getSource() == butTable){
						if (inputMonth>12||inputDay>dt.getKolDney(inputYear,inputMonth-1)){return;}//�������� �� ������������ ����� � ����  
						JFrame frame2=new JFrame("������ �� /"+inputMonth+"/"+inputYear+"�");
						frame2.setIconImage(Toolkit.getDefaultToolkit().getImage("stats\\resurs\\������.png"));//������ �� ������ ��������������
						frame2.setResizable(false);
						frame2.setAlwaysOnTop(true);//���� ������ ������
						table.setFont (new Font("",Font.BOLD,17));// ����� �������.
					//	table.setSurrendersFocusOnKeystroke(true);
						frame2.setBounds(0,0,860,96);
						frame2.setLocationRelativeTo(null);//�� ������ ������
						frame2.add(table);
						frame2.setVisible(true);
						return;
					}
			//==============================================================================================
					// �������� ������� day
					if(e.getSource() == butDay){
						menu.setDayornight (0);

					}else
					// �������� ������� night
					if(e.getSource() == butNight){
						menu.setDayornight (1);
						
					}else
					// �������� ������� otsip
					if(e.getSource() == butOtsip){
						menu.setDayornight (2);
				
					}else
					// �������� ������� vihod
					if(e.getSource() == butVihod){
						menu.setDayornight (3);
					}
						if (e.getSource() == butVihod||(e.getSource() == butDay)||(e.getSource() == butNight)||(e.getSource() == butOtsip))
					{
						frame.remove(pan);
						frame.repaint();
						txtFld.setText (""+dt.month); //�������� ���� ���. ����� 
						txtFld2.setText (""+dt.day);  //� ������ ���� 
						butOk.doClick(); 			//�� ����� ����� ������� ���� � ����������� ���
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
			
			if(inputDay==31 && inputMonth==12||inputDay==23 && inputMonth==2||inputDay==8 && inputMonth==3||inputDay==9 && inputMonth==5){ //���������				
					pict.setVisible(true);
					pict.setBounds(1, 0, 295, 215);
					pict.setIcon(p);
					txtarea.add(pict);
					
			}
			
			if(summMonth==0){
				txtarea.setText ("        "+inputDay+" "+dt.monthName(inputMonth)+" "+inputYear+"� "+dt.getDayWeek(inputYear,(inputMonth)-1,inputDay)+"\n               �������"+"\n"+"        � ���: "+otvet+"\n"+"-----------------------------"+"\n"+"������� � ������:"+talon+" (+-1)\n"+"������� ����:"+kolDnevSmen+" (�� ��� �����:"+budni +")\n"+"������ ����:"+kolNochSmen+"\n"+"������� �����:"+(kolNochSmen+kolDnevSmen)*11+"\n�������� ��������: "+ostSmen+" ����" );
				txtFld2.setText(null);
				txtFld.setText(null);
				return;
			}
			if(summMonth<0){
				txtarea.setText ("       "+inputDay+" "+dt.monthName(inputMonth)+" "+inputYear+"� "+dt.getDayWeek(inputYear,(inputMonth)-1,inputDay)+"\n           "+Math.abs(summMonth)+" ��. �����"+"\n"+"        � ���: "+otvet+"\n"+"-----------------------------"+"\n"+"������� � ������:"+talon+" (+-1)\n"+"������� ����:"+kolDnevSmen+" (�� ��� �����:"+budni +")\n"+"������ ����:"+kolNochSmen+"\n"+"������� �����:"+(kolNochSmen+kolDnevSmen)*11);
				txtFld2.setText(null);
				txtFld.setText(null);
				return;
			}
			else
			txtarea.setText ("        "+inputDay+" "+dt.monthName(inputMonth)+" "+inputYear+"� "+dt.getDayWeek(inputYear,(inputMonth)-1,inputDay)+"\n             ����� "+summMonth+" ��."+"\n"+"        � ��� �����: "+otvet+"\n"+"-----------------------------"+"\n"+"������� � ������:"+talon+" (+-1)\n"+"������� ����:"+kolDnevSmen+" (�� ��� �����:"+budni +")\n"+"������ ����:"+kolNochSmen+"\n"+"������� �����:"+(kolNochSmen+kolDnevSmen)*11+"\n�������� ��������: "+ostSmen+" ����");
			txtFld2.setText(null);
			txtFld.setText(null);
			return;
		}
	}


	

}
