package pcKiosk;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class Ui extends JFrame {
	
	private TitlePanel titleP;				//���� ������ �� ��� �г�
	private SubPanel subP;					//���� ������ �� ��� �ٷ� �Ʒ� �г�
	private SelectMenuPanel selectmenuP;	//ȸ�� ��ȸ�� ��ư �г�
	private NonMemberPanel nonmemberP;		//��ȸ�� �ð� ��ư �г�
	private MemberPanel memberP;			//ȸ�� �ð� ��ư �г�
	private MemberLoginPanel memberloginP;	//ȸ�� �α��� �Է� �г�
	private MoneyInletPanel moneyinletP;	//�� ���Ա� �г�
	private ChangesPanel changesP;			//�ܵ� ��ȯ �г�
	private ScreenMoneyPanel screenmoneyP;
	private ScreenLoginPanel screenloginP;
	private AdditionalMenuPanel additionalmenuP;
	private AdminLogin adminlogin;
	
	private static int usermoneySum = 0;												//�� ���� sum ����
	private static final int USERMONEYSET = 0;
	private static JLabel labelSum = new JLabel(usermoneySum + "��");					//�� ���Ա� �г��� ���� �� �˷��ִ� ��
	private JLabel labelChanges = new JLabel("");
	private JTextField labelMemberInf = new JTextField("");	
	private JLabel timeLabel = new JLabel("");
	private static int num = 1;															//����� ���̵� num ����(1������)
	private int eventmoney = 0;
	private int memberincome = 0;
	private int nonmemberincome = 0;
	private int incometotal = 0;
	private int[] timepriceN = {1000,2000,3000,5000,10000,0,0,0};
	private int[] timepriceM = {1000,2000,3000,5000,10000,20000,0,0};
	private String[] timeN = {"00:50","01:40","02:30","04:10","08:20","","",""};
	private String[] timeM = {"01:00","02:00","03:00","05:00","11:00","24:00","",""};
	private PersonInfo personInfo = new PersonInfo();	//���
	private JButton[] btnNonmember1 = new JButton[8];
	private JButton[] btnMember1 = new JButton[8];
	private JButton dicebtn = new JButton("<html>ȸ���� �̺�Ʈ<br>(�ֻ���������)</html>");
	private String password = "1234";

	public Ui() {
		
		titleP = new TitlePanel();
		subP = new SubPanel();
		selectmenuP = new SelectMenuPanel();
		nonmemberP = new NonMemberPanel();
		memberP = new MemberPanel();
		memberloginP = new MemberLoginPanel();
		moneyinletP = new MoneyInletPanel();
		changesP = new ChangesPanel();
		screenmoneyP = new ScreenMoneyPanel();
		screenloginP = new ScreenLoginPanel();
		additionalmenuP = new AdditionalMenuPanel();
		adminlogin = new AdminLogin(this, "������ ��й�ȣ �Է�");
		
		setTitle("PC Ű����ũ"); 							//Ÿ��Ʋ�̸�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //���ᱸ��
		
		Container c = getContentPane(); 				//�����̳� ����
		c.setLayout(null); 								//����� ���� ���̾ƿ�	
		
		setSize(1500, 1000); 							//ũ�⼳��
		setResizable(false);							//ũ�����
		setLocationRelativeTo(null); 					//��� ����
		
		titleP.setBounds(0, 0, getWidth(), 150);		//�� �г� ��ġ ����
		subP.setBounds(0, 150, getWidth(), 50);
		selectmenuP.setBounds(0, 200, 500, 100);
		nonmemberP.setBounds(0, 300, 500, 500);
		memberP.setBounds(0, 300, 500, 500);
		memberloginP.setBounds(500, 200, 500, 600);
		additionalmenuP.setBounds(1000, 200, 500, 600);
		moneyinletP.setBounds(0, 800, getWidth(), 100);
		changesP.setBounds(0, 900, getWidth(), 100);
		screenmoneyP.setBounds(0, 800, getWidth(), 200);
		screenloginP.setBounds(500, 200, 500, 600);
		
		c.add(titleP); 									//�����̳ʿ� �� �г� �߰�
		c.add(subP);
		c.add(selectmenuP);
		c.add(nonmemberP);
		c.add(memberP);
		c.add(memberloginP);
		c.add(additionalmenuP);
		c.add(moneyinletP);
		c.add(changesP);
		c.add(screenmoneyP);
		c.add(screenloginP);
		
		setVisible(true);								//ȭ�麸���ֱ�
		
		//PersonInfo pI = new PersonInfo();
	}

	class TitlePanel extends JPanel{						//���� ������ �� ��� �г� Ŭ����
		
		private ImageIcon icon, icon2, icon3;
		private Image pclogoimg, fifaonline, overwatch;
		private JLabel l = new JLabel("<html>Peto<br>�Բ��ϴ�PC���ӹ�ȭ</html>");
		
		public TitlePanel() {
			icon = new ImageIcon("images\\�ǽù�ΰ�.jpg");		//�̹��� ������ ��ü ����
			pclogoimg = icon.getImage();					//���� �̹��� ������ pclogoimg ���� ����
			icon2 = new ImageIcon("images\\�����.jpg");	
			fifaonline = icon2.getImage();		
			icon3 = new ImageIcon("images\\������ġ.jpg");	
			overwatch = icon3.getImage();		
			this.setBackground(Color.white);
			l.setFont(new Font("BOLD", Font.BOLD, 50));
			l.setBounds(500, 0, 500, 150);
			this.add(l);
		}
		
		public void paintComponent(Graphics g) {			//�̹��� ������ ũ�� ���� �� ���
			super.paintComponent(g);
			g.drawImage(fifaonline, 0, 0, 250, 150, this);
			g.drawImage(pclogoimg, 250, 0, 250, 150, this);  
			g.drawImage(overwatch, 1000, 0, 500, 150, this);
		}
	}
	
	class SubPanel extends JPanel{			//���� ������ �� ��� �ٷ� �Ʒ� �г� Ŭ����
		private JLabel labelWelcom;
		
		public SubPanel() {
			labelWelcom = new JLabel("�ȳ��ϼ���! ����� ������� �������ּ���");
			labelWelcom.setHorizontalAlignment(JLabel.CENTER);
			labelWelcom.setFont(new Font("BOLD", Font.BOLD, 30));
			this.setBackground(Color.cyan);
			this.add(labelWelcom);
		}
		
	}
	
	class SelectMenuPanel extends JPanel implements Runnable{		//ȸ�� ��ȸ�� ��ư �г� Ŭ����
		private JButton btnNonMember;
		private JButton btnMember;
		
		public SelectMenuPanel() {
			btnNonMember = new JButton("��ȸ��");
			btnMember = new JButton("ȸ��");
			btnNonMember.setFont(new Font("�ü�ü", Font.BOLD, 35));	//�� ��ư ��Ʈ ����
			btnMember.setFont(new Font("�ü�ü", Font.BOLD, 35));
			
			this.setLayout(new GridLayout());
			this.add(btnNonMember);
			this.add(btnMember);
			
			btnNonMember.addActionListener(new NonmemberListener());	//��ȸ�� ��ư ������ �ޱ�
			btnMember.addActionListener(new MemberListener());			//ȸ�� ��ư ������ �ޱ�
			
		}
		
		@Override
		public void run() {
			try {
				Thread.sleep(100);
				usermoneySum = 0;
				labelSum.setText(USERMONEYSET+"��");
				labelChanges.setText("");
				timeLabel.setText(null);
				labelMemberInf.setText(null);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
		}
		
		class NonmemberListener implements ActionListener{	//��ȸ�� ������

			@Override
			public void actionPerformed(ActionEvent e) {
				memberP.setVisible(false);					//ȸ�� ��ư �г� �Ⱥ��̱�
				nonmemberP.setVisible(true);				//��ȸ�� ��ư �г� ���̱�
				memberloginP.setVisible(false);
				screenmoneyP.setVisible(false);
				moneyinletP.setVisible(true);
				changesP.setVisible(true);
				dicebtn.setEnabled(false);
				
				for(int i=0; i<btnNonmember1.length; i++) {
					btnNonmember1[i].setEnabled(true);			
				}
				
				if(e.getSource() == btnNonMember) {
					run();
				}
			}
			
		}
		
		class MemberListener implements ActionListener{		//ȸ�� ������

			@Override
			public void actionPerformed(ActionEvent e) {
				nonmemberP.setVisible(false);				//��ȸ�� ��ư �г� �Ⱥ��̱�
				memberP.setVisible(true);					//ȸ�� ��ư �г� ���̱�
				memberloginP.setVisible(true);
				screenmoneyP.setVisible(true);
				moneyinletP.setVisible(false);
				changesP.setVisible(false);
				dicebtn.setEnabled(false);
				
				for(int i=0; i<btnMember1.length; i++) {
					btnMember1[i].setEnabled(false);			
				}
				
				if(e.getSource() == btnMember) {
					run();
				}
			}
			
		}
	}
	
	class NonMemberPanel extends JPanel implements ActionListener{
		//private JButton[] btnNonmember = new JButton[8];
		
		public NonMemberPanel() {
			this.setLayout(new GridLayout(4, 2, 3, 3));
			
			for(int i = 0 ; i<btnNonmember1.length; i++) {
				switch(i) {
				case 0:
					btnNonmember1[i] = new JButton("<html>1000��<br>00:50</html>");
					break;
				case 1:
					btnNonmember1[i] = new JButton("<html>2000��<br>01:40</html>");
					break;
				case 2:
					btnNonmember1[i] = new JButton("<html>3000��<br>02:30</html>");
					break;
				case 3:
					btnNonmember1[i] = new JButton("<html>5000��<br>04:10</html>");
					break;
				case 4:
					btnNonmember1[i] = new JButton("<html>10000��<br>08:20</html>");
					break;
				default:
					btnNonmember1[i] = new JButton("�غ���");  
				}
				btnNonmember1[i].setFont(new Font("���", Font.BOLD, 35));
				this.add(btnNonmember1[i]);
				btnNonmember1[i].addActionListener(this);		
				btnNonmember1[i].setEnabled(false);
			}
		}
		

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Random r = new Random();
			int createNum = 0;
			String ranNum ="";
			String resultNum ="";
			
			for(int i=0; i<6; i++) {					//��ȸ�� ��й�ȣ ������ ����
				createNum = r.nextInt(9);
				ranNum = Integer.toString(createNum);
				resultNum += ranNum;
			}
			
			for (int i = 0; i < btnNonmember1.length; i++) {
				JLabel j = new JLabel("<html>��ȸ�� �α���<br>���̵�: C00000"+num+"<br>��й�ȣ: "+resultNum+"<br>�ð�: "+timeN[i]+"<br>��ſ� �ð���������!</html>");

				JButton b = (JButton) e.getSource();
				if (b == btnNonmember1[i]) {
					if (usermoneySum >= timepriceN[i]) {
						if(i<5) {
						NonMemberLoginFrame nml = new NonMemberLoginFrame();	//��ȸ���α����г� ��ü ����
						//nml.add(new JLabel("<html>��ȸ�� �α���<br>���̵�: 00000"+num+"<br>��й�ȣ: "+resultNum+"<br>�ð�: "+timeN[i]+"</html>"));
						j.setFont(new Font("BOLD", Font.BOLD, 35));
						nml.add(j);
						usermoneySum -= timepriceN[i];
						nonmemberincome += timepriceN[i];
						incometotal += timepriceN[i];
						labelSum.setText(usermoneySum + "��");
						num++;
						} else if (i > 4) {
							JOptionPane.showMessageDialog(null, "�غ����Դϴ�", "�غ���!", JOptionPane.ERROR_MESSAGE);
							break;
						}
						break;

					} else {
						JOptionPane.showMessageDialog(null, "�ݾ��� �����մϴ�! ���� �����ϼ���", "�ݾ� ����!",
								JOptionPane.ERROR_MESSAGE);
						break;
					}

				}

			}
			
			
		} //actionPerformed �޼��� ��
		
	} //NonMemberPanel Ŭ���� ��
	
	class MemberPanel extends JPanel implements ActionListener{					//ȸ���� ��ư �г� Ŭ����
		//private JButton[] btnMember = new JButton[8];
		
		public MemberPanel() {
			setLayout(new GridLayout(4, 2, 3, 3));
			
			for(int i = 0 ; i<btnMember1.length; i++ ) {
				switch(i) {
				case 0:
					btnMember1[i] = new JButton("<html>1000��<br>01:00</html>");
					break;
				case 1:
					btnMember1[i] = new JButton("<html>2000��<br>02:00</html>");
					break;
				case 2:
					btnMember1[i] = new JButton("<html>3000��<br>03:00</html>");
					break;
				case 3:
					btnMember1[i] = new JButton("<html>5000��<br>05:00</html>");
					break;
				case 4:
					btnMember1[i] = new JButton("<html>10000��<br>11:00</html>");
					break;
				case 5:
					btnMember1[i] = new JButton("<html>20000��<br>24:00</html>");
					break;
				default:
					btnMember1[i] = new JButton("�غ���");
				}
				btnMember1[i].setFont(new Font("���", Font.BOLD, 35));
				add(btnMember1[i]);
				btnMember1[i].addActionListener(this);
				btnMember1[i].setEnabled(false);
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i = 0 ; i<btnMember1.length; i++) {
				JLabel j = new JLabel();
				JButton b = (JButton) e.getSource();
				if (b == btnMember1[i]) {
					if (usermoneySum >= timepriceM[i]) {
						if (i < 6) {
							eventmoney += timepriceM[i];
							if(eventmoney >= 20000) {
								dicebtn.setEnabled(true);
								eventmoney = 0;
							}
							usermoneySum -= timepriceM[i];
							memberincome += timepriceM[i];
							incometotal += timepriceM[i];
							labelSum.setText(usermoneySum + "��");
							String id = labelMemberInf.getText();
							String sTime = personInfo.cal(id, timeM[i]);
							timeLabel.setText("<html>���̵�: " + id + "<br>���: ȸ����<br>���� �ð�: " + sTime + "</html>");
							MemberLoginFrame ml = new MemberLoginFrame();
							j.setFont(new Font("BOLD", Font.BOLD, 35));
							j.setText("<html>�ð��� �����Ǿ����ϴ�!<br>������ �ð�: "+timeM[i]+"<br>���ݱݾ�: "+timepriceM[i]+"<br>��ſ� �ð� ��������~</html>");
							ml.add(j);

						} else if (i > 5) {
							JOptionPane.showMessageDialog(null, "�غ����Դϴ�", "�غ���!", JOptionPane.ERROR_MESSAGE);
							break;
						}
						break;

					} else {
						JOptionPane.showMessageDialog(null, "�ݾ��� �����մϴ�! ���� �����ϼ���", "�ݾ� ����!",
								JOptionPane.ERROR_MESSAGE);
						break;
					}
				}
			}
			
		}
				
	}
	
	class MemberLoginPanel extends JPanel{		//ȸ�� �α��� �Է� ��� Ŭ����
		JLabel tfMemberId;
		JButton btnMemberLogin;
		JButton rstMemberLogin;

		public MemberLoginPanel() {
			this.setVisible(false);
			tfMemberId = new JLabel("���̵� �Է��ϼ���");					//ȸ�� �α��� �ؽ�Ʈ�ʵ�
			//labelMemberInf = new JTextField("");							//ȸ�� �α��� ��
			btnMemberLogin = new JButton("Ȯ��");								//ȸ�� �α��� ��ư
			rstMemberLogin = new JButton("�ʱ�ȭ");								//ȸ�� �α��� ��ư
			//timeLabel = new JLabel("");
			
			//tf.setEnabled(false);
			this.setBackground(Color.gray);									//ȸ�� �α��� �г� ���� ����
			tfMemberId.setFont(new Font("BOLD", Font.BOLD, 50));			//ȸ�� �α��� �г� �� ������Ʈ ��Ʈ ����
			labelMemberInf.setFont(new Font("BOLD", Font.BOLD, 30));
			btnMemberLogin.setFont(new Font("BOLD", Font.BOLD, 50));
			rstMemberLogin.setFont(new Font("BOLD", Font.BOLD, 50));
			labelMemberInf.setHorizontalAlignment(JTextField.CENTER);			//ȸ�� ���� �� ���� ��� ����
			timeLabel.setFont(new Font("BOLD", Font.BOLD, 40));
			timeLabel.setHorizontalAlignment(JTextField.CENTER);
			
			setLayout(null);
			
			
			tfMemberId.setBounds(0,0,500,100);
			
			labelMemberInf.setBounds(0,100, 500, 250);
				
			btnMemberLogin.setBounds(0,350,250,70);
			
			rstMemberLogin.setBounds(250,350,250,70);
			
			timeLabel.setBounds(0,420,500,180);
			
			this.add(tfMemberId);
			this.add(labelMemberInf);
			this.add(btnMemberLogin);
			this.add(rstMemberLogin);
			this.add(timeLabel);
			
			btnMemberLogin.addActionListener(new checkBtnListener());							//ȭ�� �α��� ��ư�� ������ �ޱ�
			rstMemberLogin.addActionListener(new resetBtnListener());							//ȭ�� �α��� ��ư�� ������ �ޱ�
		}
		
		class checkBtnListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				moneyinletP.setVisible(true);
				changesP.setVisible(true);
				
				if (e.getSource() == btnMemberLogin) {
					String id = labelMemberInf.getText();									//����� id�Է°� ��������id�� ����
					
					if (id == null || "".equals(id)) {
						timeLabel.setText("ID�� �Է����ּ���.");									//ȸ�� �α��� �гο� id���� ���
					}
					String inId = personInfo.getInfo(id);
					if(inId == null || "".equals(inId)) {
						timeLabel.setText("ID�� �������� �ʽ��ϴ�.");
						moneyinletP.setVisible(false);
						changesP.setVisible(false);
						dicebtn.setEnabled(false);
						for(int i=0; i<btnMember1.length; i++) {
							btnMember1[i].setEnabled(false);			
						}
					}else {
						for(int i=0; i<btnMember1.length; i++) {
							btnMember1[i].setEnabled(true);			
						}
						timeLabel.setText("<html>���̵�: "+id+"<br>���: ȸ����<br>���� �ð�: "+inId+"</html>");									//ȸ�� �α��� �гο� id���� ���
					}
					
				}	
			}
		}
		
		class resetBtnListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				screenmoneyP.setVisible(true);
				moneyinletP.setVisible(false);
				changesP.setVisible(false);
				dicebtn.setEnabled(false);
				for(int i=0; i<btnMember1.length; i++) {
					btnMember1[i].setEnabled(false);			
				}
				if (e.getSource() == rstMemberLogin) {
					labelMemberInf.setText(null);
					timeLabel.setText(null);
				}
			}
		}
	
		
	}
	
	class AdditionalMenuPanel extends JPanel{
		JButton firstbtn = new JButton("ó��ȭ��");
		JButton seatbtn = new JButton("�¼�Ȯ��");
		JButton registerbtn = new JButton("ȸ������");
		JButton incomebtn = new JButton("����׺���");
		JLabel infolabel = new JLabel("<html>����20000��<br>�����Ҷ�����<br>1����밡��<br>�ֻ���6��÷�Ǹ� 10�ð��߰�</html>");
		
		public AdditionalMenuPanel() {
			this.setLayout(null);
			firstbtn.setFont(new Font("BOLD", Font.BOLD, 30));
			seatbtn.setFont(new Font("BOLD", Font.BOLD, 30));
			registerbtn.setFont(new Font("BOLD", Font.BOLD, 30));
			incomebtn.setFont(new Font("BOLD", Font.BOLD, 30));
			dicebtn.setFont(new Font("BOLD", Font.BOLD, 30));
			infolabel.setFont(new Font("BOLD", Font.BOLD, 30));
			
			firstbtn.setBounds(0, 0, 250, 200);
			seatbtn.setBounds(250, 0, 250, 200);
			registerbtn.setBounds(0, 200, 250, 200);
			incomebtn.setBounds(250, 200, 250, 200);
			dicebtn.setBounds(0, 400, 250, 200);
			infolabel.setBounds(250, 400, 250, 200);
			
			dicebtn.setEnabled(false);
			this.add(firstbtn);
			this.add(seatbtn);
			this.add(registerbtn);
			this.add(incomebtn);
			this.add(dicebtn);
			this.add(infolabel);
			
			firstbtn.addActionListener(new FirstBtnListener());
			seatbtn.addActionListener(new SeatBtnListener());
			registerbtn.addActionListener(new RegisterBtnListener());
			incomebtn.addActionListener(new IncomeBtnListener());
			dicebtn.addActionListener(new DiceBtnListener());
		}
		
		class FirstBtnListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				screenloginP.setVisible(true);
				screenmoneyP.setVisible(true);
				memberloginP.setVisible(false);
				moneyinletP.setVisible(false);
				changesP.setVisible(false);
				nonmemberP.setVisible(true);
				memberP.setVisible(false);		
				dicebtn.setEnabled(false);
				
				for(int i=0; i<btnNonmember1.length; i++) {
					btnNonmember1[i].setEnabled(false);			
				}
			}
			
		}
		
		class SeatBtnListener implements ActionListener{
			private JButton[] btnseat = new JButton[63];
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SeatList sl = new SeatList();
				for (int i = 0; i < btnseat.length; i++) {
					if(i == 11 || i == 20 || i == 29 || i ==38) {
						btnseat[i] = new JButton();
					} else {
						btnseat[i] = new JButton(new ImageIcon("images/����.jpg"));
					}
					btnseat[i].setFont(new Font("���", Font.BOLD, 20));
					sl.add(btnseat[i]);
					switch(i+1) {
					case 2: case 5: case 8: case 11: case 14: case 17:
					case 20: case 23: case 26: case 29: case 32: case 35:
					case 38: case 41: case 44: case 46: case 47: case 48:
					case 49: case 50: case 51: case 52: case 53: case 54:
						btnseat[i].setVisible(false);
						break;
					case 12:
						btnseat[i].setBackground(Color.green);
						String time = personInfo.getInfo("leegeonju");
						btnseat[i].setText("<html>"+"�̰���<br>"+time+" ����<br>league of legends</html>");
						break;
					case 21:
						btnseat[i].setBackground(Color.green);
						String time1 = personInfo.getInfo("leegyuwon");
						btnseat[i].setText("<html>"+"�̱Կ�<br>"+time1+" ����<br>league of legends</html>");
						break;
					case 30:
						btnseat[i].setBackground(Color.green);
						String time2 = personInfo.getInfo("namtaewoo");
						btnseat[i].setText("<html>"+"���¿�<br>"+time2+" ����<br>league of legends</html>");
						break;
					case 39:
						btnseat[i].setBackground(Color.green);
						String time3 = personInfo.getInfo("shindonghoon");
						btnseat[i].setText("<html>"+"�ŵ���<br>"+time3+" ����<br>league of legends</html>");
						break;
					default:
						btnseat[i].setBackground(Color.lightGray);
					}
				}
				
			}
			
		}
		
		class RegisterBtnListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "ȸ�������� �ڸ����� �����մϴ�!", "ȸ������", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		class DiceBtnListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				dicebtn.setEnabled(false);
				int random = (int)(Math.random()*6)+1;
				EventFrame ef = new EventFrame(random);
						
			}
			
		}
		
		class IncomeBtnListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				adminlogin.setVisible(true);
				
			}
			
		}
	}
	
	class MoneyInletPanel extends JPanel implements ActionListener{			//�� ���Ա� �г� Ŭ����
		
		private JButton [] btnMoneyInlet = { new JButton("<html>10000��</html>"), new JButton("<html>5000��</html"),
								   			 new JButton("<html>1000��</html>"), new JButton("<html>500��</html>") };
		
		public MoneyInletPanel() {
			this.setVisible(false);
			this.setBackground(Color.gray);									//�� ���Ա� �г� ���ȭ�� ����					
			for(int i=0; i<btnMoneyInlet.length; i++) {
				switch(i) {													//4���� �� ���Ա� ��ư ���� ����(switch��)
				case 0:
					btnMoneyInlet[i].setBackground(Color.green);
					break;
				case 1:
					btnMoneyInlet[i].setBackground(Color.orange);
					break;
				case 2:
					btnMoneyInlet[i].setBackground(Color.blue);
					break;
				default:
					btnMoneyInlet[i].setBackground(Color.lightGray);
					break;
				}
				btnMoneyInlet[i].setFont(new Font("Arial", Font.BOLD, 40));	//4���� �� ���Ա� ��ư ��Ʈ ����
	            this.add(btnMoneyInlet[i]);									//�� ���Ա� �гο� 4���� �� ���Ա� ��ư �߰�
	            btnMoneyInlet[i].addActionListener(this);					//4���� �� ���Ա� ��ư�� ������ �ޱ�
			}
			labelSum.setFont(new Font("���", Font.BOLD, 40));				//�� ���� �� ��Ʈ ����
			this.add(labelSum);                           					//�� ���Ա� �гο� �� ���� �� �߰�                                
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();			//�̺�Ʈ �߻��� ������Ʈ �������� b���ٰ� ����
			if(b == btnMoneyInlet[0]) {					//b�� 10000����ư�� ������ 10000�� ����
				usermoneySum += 10000;
			} else if(b == btnMoneyInlet[1]) {			//b�� 5000����ư�� ������ 5000�� ����
				usermoneySum += 5000;
			} else if(b == btnMoneyInlet[2]) {			//b�� 1000����ư�� ������ 1000�� ����
				usermoneySum += 1000;
			} else {									//b�� 500����ư�� ������ 500�� ����
				usermoneySum += 500;
			}
			labelSum.setText(usermoneySum+"��");			//�� ���Ա� �󺧿� ������ �� ���
		}
	}
	
	class NonMemberLoginFrame extends JFrame {		//��ȸ���α��� ������ Ŭ����
	      public NonMemberLoginFrame() {
	         setTitle("��ȸ�� �α���");				//Ÿ��Ʋ�̸�
	         Container c = getContentPane();	//�����̳� ����
	         c.setLayout(new FlowLayout());		//���̾ƿ� ����(FlowLayout)
	         setSize(400,300);					//��ȸ�� �α��� ������ ũ��
	         setLocationRelativeTo(null);		//��� ����
	         setResizable(false);				//ũ�����
	         setVisible(true);					//ȭ�麸���ֱ�
	      }
	}
	
	class MemberLoginFrame extends JFrame {		//��ȸ���α��� ������ Ŭ����
	      public MemberLoginFrame() {
	         setTitle("ȸ�� �α���");				//Ÿ��Ʋ�̸�
	         Container c = getContentPane();	//�����̳� ����
	         c.setLayout(new FlowLayout());		//���̾ƿ� ����(FlowLayout)
	         setSize(400,300);					//��ȸ�� �α��� ������ ũ��
	         setLocationRelativeTo(null);		//��� ����
	         setResizable(false);				//ũ�����
	         setVisible(true);					//ȭ�麸���ֱ�
	      }
	}
	
	class EventFrame extends JFrame {			//�̺�Ʈ Ŭ����
		JButton okbtn = new JButton("10�ð��ޱ�");
		private JLabel[] l = new JLabel[6];
		private ImageIcon[] images = { new ImageIcon("images/�ֻ���1.jpg"), new ImageIcon("images/�ֻ���2.jpg"),
				new ImageIcon("images/�ֻ���3.jpg"), new ImageIcon("images/�ֻ���4.jpg"), new ImageIcon("images/�ֻ���5.jpg"),
				new ImageIcon("images/�ֻ���6.jpg") };
		
		public EventFrame(int random) {
	    	 
	         setTitle("�̺�Ʈâ");					//Ÿ��Ʋ�̸�
	         Container c = getContentPane();	//�����̳� ����
	         c.setLayout(new FlowLayout());		//���̾ƿ� ����(FlowLayout)
	         setSize(400,300);					//��ȸ�� �α��� ������ ũ��
	         setLocationRelativeTo(null);		//��� ����
	         setResizable(false);				//ũ�����
	         setVisible(true);					//ȭ�麸���ֱ�
	         int dice = random;
	         
	         for(int i=0; i<l.length; i++) {
	        	 l[i] = new JLabel(images[i]);	 
	        	 l[i].setFont(new Font("BOLD", Font.BOLD, 30));
	         }
	         
	         switch(dice) {
        	 case 1: c.add(l[0]); break;
        	 case 2: c.add(l[1]); break;
        	 case 3: c.add(l[2]); break;
        	 case 4: c.add(l[3]); break;
        	 case 5: c.add(l[4]); break;
        	 case 6: c.add(l[5]); break;
        	 }
	         
	         if (dice == 6) {
        		 JLabel pass = new JLabel("<html>�����մϴ�!!!<br>���� �ֻ��� ��: "+dice+"</html>");
        		 pass.setFont(new Font("BOLD", Font.BOLD, 30));
        		 c.add(pass);
        	 } else {
        		 JLabel fail = new JLabel("<html>�Ʊ����ϴ�.<br>���� �ֻ��� ��: "+dice+"</html>");	
        		 fail.setFont(new Font("BOLD", Font.BOLD, 30));
        		 c.add(fail);
        	 }
	         
	         okbtn.setFont(new Font("BOLD", Font.BOLD, 30));	
	         if(random(dice)) {
	        	 c.add(okbtn);
	         }
	         	         
	         okbtn.addActionListener(new ActionListener() {

	 			@Override
	 			public void actionPerformed(ActionEvent e) {
	 				String id = labelMemberInf.getText();
	 				String sTime = personInfo.cal(id, "10:00");
	 				timeLabel.setText("<html>���̵�: " + id + "<br>���: ȸ����<br>���� �ð�: " + sTime + "</html>");
	 				dispose();
	 			}	
	 		});
	         
	      }

		public boolean random(int dice) {
			if(dice == 6) {
				return true;
			}
			return false;
		}
		
	}
	
	class ChangesPanel extends JPanel implements ActionListener{	//�ܵ� ��ȯ �г� Ŭ����
		private JButton btnChanges;		//�ܵ� ��ȯ ��ư
		//private JLabel labelChanges;	//�ܵ� Ȯ�� ��
		
		public ChangesPanel() {
			this.setVisible(false);
			btnChanges = new JButton("�ܵ� ��ȯ");
			//labelChanges = new JLabel("");
			
			btnChanges.setFont(new Font("���", Font.BOLD, 30));	
			this.setBackground(Color.white);				//�ܵ� ��ȯ �г� ���� ����
			btnChanges.setBackground(Color.LIGHT_GRAY);		//�ܵ� ��ȯ ��ư ���� ����
			this.add(btnChanges);							//�ܵ� ��ȯ �гο� �ܵ� ��ȯ ��ư �߰�
			this.add(labelChanges);							//�ܵ� ��ȯ �гο� �ܵ� Ȯ�� �� �߰�
			
			btnChanges.addActionListener(this);				//�ܵ� ��ȯ ��ư�� ������ �ޱ�
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			labelChanges.setFont(new Font("���", Font.BOLD, 30));					//�ܵ� Ȯ�� �� ��Ʈ ����
           
			if(usermoneySum > 0) {													//����� �ݾ��� 0���̻� ������ ��ȯ ���� ���
				labelChanges.setText(usermoneySum+"�� ��ȯ! ������ּż� �����մϴ�~!");
				usermoneySum = 0;													//0������ ����
				labelSum.setText(usermoneySum+"��");
			} else {																//����� �ݾ��� 0���̸� ���� ���ٴ� ���� ���
				labelChanges.setText("��ȯ�� ���� �����ϴ�. �ٽ� Ȯ�����ּ���!");
			}
		}
	}
	
	class ScreenMoneyPanel extends JPanel{
		private ImageIcon icon;
		private Image henesis;
		
		public ScreenMoneyPanel() {
			icon = new ImageIcon("images\\��׽ý�.jpg");
			henesis = icon.getImage();
		}
		
		public void paintComponent(Graphics g) {			//�̹��� ������ ũ�� ���� �� ���
			super.paintComponent(g);
			g.drawImage(henesis, 0, 0, getWidth(), 200, this);  
		}
	}
	
	class ScreenLoginPanel extends JPanel{
		private ImageIcon icon;
		private ImageIcon icon1;
		private Image jingkeuseu;
		private Image garen;
		
		public ScreenLoginPanel() {
			icon = new ImageIcon("images\\¡ũ��.jpg");		//�̹��� ������ ��ü ����
			jingkeuseu = icon.getImage();					//���� �̹��� ������ jingkeuseu ���� ����
			icon1 = new ImageIcon("images\\����.jpg");
			garen = icon1.getImage();		
		}
		
		public void paintComponent(Graphics g) {			//�̹��� ������ ũ�� ���� �� ���
			super.paintComponent(g);
			g.drawImage(jingkeuseu, 0, 0, 500, 300, this);  
			g.drawImage(garen, 0, 300, 500, 300, this);  
		}
	}
	
	class SeatList extends JFrame{
		
		public SeatList() {
			setTitle("�¼� ��Ȳ");
			Container c = getContentPane();
			c.setLayout(new GridLayout(7, 9, 0, 0));
			setSize(1500, 1000);
			setLocationRelativeTo(null);
			setResizable(false);
			setVisible(true);
			
		}
	}
	
	class AdminLogin extends JDialog {

		private  JPasswordField tf = new  JPasswordField(10);
		private JButton okbtn = new JButton("Ȯ��");
		

		public AdminLogin(JFrame frame, String title) {

			super(frame, title);
			setLayout(new FlowLayout());
			add(tf);
			add(okbtn);
			setSize(300, 100);
			setLocationRelativeTo(null);
			setResizable(false);

			okbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					setVisible(false);
					if (password.equals(adminlogin.getInput())) {
						new Income();
						tf.setText("");
					} else if (tf.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է����� �ʾҽ��ϴ�. �Է��� �ּ���", "��й�ȣ ����!",
								JOptionPane.ERROR_MESSAGE);
						setVisible(true);
						tf.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "��й�ȣ�� Ʋ���ϴ�. �ٽ� �Է��� �ּ���", "��й�ȣ ����!",
								JOptionPane.ERROR_MESSAGE);
						setVisible(true);
						tf.setText("");
					}
				}
			});
		}

		public String getInput() {
			if (tf.getText().length() == 0)
				return null;
			else
				return tf.getText();
		}

	}
	
	class Income extends JFrame{
		private JLabel l = new JLabel("��ȸ�� �����: "+nonmemberincome);
		private JLabel l2 = new JLabel("ȸ�� �����: "+memberincome);
		private JLabel l3 = new JLabel("�Ѹ����: "+incometotal);
		
		public Income() {
			setTitle("�����");
			Container c = getContentPane();
			c.setLayout(null);
			l.setBounds(0, 0, 500, 100);
			l2.setBounds(0, 100, 500, 100);
			l3.setBounds(0, 200, 500, 100);
			setSize(500, 400);
			setLocationRelativeTo(null);
			setResizable(false);
			setVisible(true);
			
			l.setFont(new Font("���", Font.BOLD, 45));	
			l2.setFont(new Font("���", Font.BOLD, 45));
			l3.setFont(new Font("���", Font.BOLD, 45));
			
			add(l);
			add(l2);
			add(l3);
		}
		
	}
	
	public static void main(String[] args) {	//���� �޼���

		new Ui(); //���� ������ ����

	}

}
