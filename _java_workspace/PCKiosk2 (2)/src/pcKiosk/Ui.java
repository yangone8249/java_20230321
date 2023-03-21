package pcKiosk;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class Ui extends JFrame {
	
	private TitlePanel titleP;				//메인 프레임 맨 상단 패널
	private SubPanel subP;					//메인 프레임 맨 상단 바로 아래 패널
	private SelectMenuPanel selectmenuP;	//회원 비회원 버튼 패널
	private NonMemberPanel nonmemberP;		//비회원 시간 버튼 패널
	private MemberPanel memberP;			//회원 시간 버튼 패널
	private MemberLoginPanel memberloginP;	//회원 로그인 입력 패널
	private MoneyInletPanel moneyinletP;	//돈 투입구 패널
	private ChangesPanel changesP;			//잔돈 반환 패널
	private ScreenMoneyPanel screenmoneyP;
	private ScreenLoginPanel screenloginP;
	private AdditionalMenuPanel additionalmenuP;
	private AdminLogin adminlogin;
	
	private static int usermoneySum = 0;												//돈 누적 sum 변수
	private static final int USERMONEYSET = 0;
	private static JLabel labelSum = new JLabel(usermoneySum + "원");					//돈 투입구 패널의 넣은 돈 알려주는 라벨
	private JLabel labelChanges = new JLabel("");
	private JTextField labelMemberInf = new JTextField("");	
	private JLabel timeLabel = new JLabel("");
	private static int num = 1;															//비원원 아이디값 num 변수(1씩증가)
	private int eventmoney = 0;
	private int memberincome = 0;
	private int nonmemberincome = 0;
	private int incometotal = 0;
	private int[] timepriceN = {1000,2000,3000,5000,10000,0,0,0};
	private int[] timepriceM = {1000,2000,3000,5000,10000,20000,0,0};
	private String[] timeN = {"00:50","01:40","02:30","04:10","08:20","","",""};
	private String[] timeM = {"01:00","02:00","03:00","05:00","11:00","24:00","",""};
	private PersonInfo personInfo = new PersonInfo();	//기능
	private JButton[] btnNonmember1 = new JButton[8];
	private JButton[] btnMember1 = new JButton[8];
	private JButton dicebtn = new JButton("<html>회원제 이벤트<br>(주사위돌리기)</html>");
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
		adminlogin = new AdminLogin(this, "관리자 비밀번호 입력");
		
		setTitle("PC 키오스크"); 							//타이틀이름
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료구현
		
		Container c = getContentPane(); 				//컨테이너 생성
		c.setLayout(null); 								//사용자 지정 레이아웃	
		
		setSize(1500, 1000); 							//크기설정
		setResizable(false);							//크기고정
		setLocationRelativeTo(null); 					//가운데 맞춤
		
		titleP.setBounds(0, 0, getWidth(), 150);		//각 패널 위치 설정
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
		
		c.add(titleP); 									//컨테이너에 각 패널 추가
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
		
		setVisible(true);								//화면보여주기
		
		//PersonInfo pI = new PersonInfo();
	}

	class TitlePanel extends JPanel{						//메인 프레임 맨 상단 패널 클래스
		
		private ImageIcon icon, icon2, icon3;
		private Image pclogoimg, fifaonline, overwatch;
		private JLabel l = new JLabel("<html>Peto<br>함께하는PC게임문화</html>");
		
		public TitlePanel() {
			icon = new ImageIcon("images\\피시방로고.jpg");		//이미지 아이콘 객체 생성
			pclogoimg = icon.getImage();					//만든 이미지 아이콘 pclogoimg 변수 저장
			icon2 = new ImageIcon("images\\손흥민.jpg");	
			fifaonline = icon2.getImage();		
			icon3 = new ImageIcon("images\\오버워치.jpg");	
			overwatch = icon3.getImage();		
			this.setBackground(Color.white);
			l.setFont(new Font("BOLD", Font.BOLD, 50));
			l.setBounds(500, 0, 500, 150);
			this.add(l);
		}
		
		public void paintComponent(Graphics g) {			//이미지 아이콘 크기 설정 및 출력
			super.paintComponent(g);
			g.drawImage(fifaonline, 0, 0, 250, 150, this);
			g.drawImage(pclogoimg, 250, 0, 250, 150, this);  
			g.drawImage(overwatch, 1000, 0, 500, 150, this);
		}
	}
	
	class SubPanel extends JPanel{			//메인 프레임 맨 상단 바로 아래 패널 클래스
		private JLabel labelWelcom;
		
		public SubPanel() {
			labelWelcom = new JLabel("안녕하세요! 사용할 요금제를 선택해주세요");
			labelWelcom.setHorizontalAlignment(JLabel.CENTER);
			labelWelcom.setFont(new Font("BOLD", Font.BOLD, 30));
			this.setBackground(Color.cyan);
			this.add(labelWelcom);
		}
		
	}
	
	class SelectMenuPanel extends JPanel implements Runnable{		//회원 비회원 버튼 패널 클래스
		private JButton btnNonMember;
		private JButton btnMember;
		
		public SelectMenuPanel() {
			btnNonMember = new JButton("비회원");
			btnMember = new JButton("회원");
			btnNonMember.setFont(new Font("궁서체", Font.BOLD, 35));	//각 버튼 폰트 설정
			btnMember.setFont(new Font("궁서체", Font.BOLD, 35));
			
			this.setLayout(new GridLayout());
			this.add(btnNonMember);
			this.add(btnMember);
			
			btnNonMember.addActionListener(new NonmemberListener());	//비회원 버튼 리스너 달기
			btnMember.addActionListener(new MemberListener());			//회원 버튼 리스너 달기
			
		}
		
		@Override
		public void run() {
			try {
				Thread.sleep(100);
				usermoneySum = 0;
				labelSum.setText(USERMONEYSET+"원");
				labelChanges.setText("");
				timeLabel.setText(null);
				labelMemberInf.setText(null);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
		}
		
		class NonmemberListener implements ActionListener{	//비회원 리스너

			@Override
			public void actionPerformed(ActionEvent e) {
				memberP.setVisible(false);					//회원 버튼 패널 안보이기
				nonmemberP.setVisible(true);				//비회원 버튼 패널 보이기
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
		
		class MemberListener implements ActionListener{		//회원 리스너

			@Override
			public void actionPerformed(ActionEvent e) {
				nonmemberP.setVisible(false);				//비회원 버튼 패널 안보이기
				memberP.setVisible(true);					//회원 버튼 패널 보이기
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
					btnNonmember1[i] = new JButton("<html>1000원<br>00:50</html>");
					break;
				case 1:
					btnNonmember1[i] = new JButton("<html>2000원<br>01:40</html>");
					break;
				case 2:
					btnNonmember1[i] = new JButton("<html>3000원<br>02:30</html>");
					break;
				case 3:
					btnNonmember1[i] = new JButton("<html>5000원<br>04:10</html>");
					break;
				case 4:
					btnNonmember1[i] = new JButton("<html>10000원<br>08:20</html>");
					break;
				default:
					btnNonmember1[i] = new JButton("준비중");  
				}
				btnNonmember1[i].setFont(new Font("고딕", Font.BOLD, 35));
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
			
			for(int i=0; i<6; i++) {					//비회원 비밀번호 난수값 생성
				createNum = r.nextInt(9);
				ranNum = Integer.toString(createNum);
				resultNum += ranNum;
			}
			
			for (int i = 0; i < btnNonmember1.length; i++) {
				JLabel j = new JLabel("<html>비회원 로그인<br>아이디: C00000"+num+"<br>비밀번호: "+resultNum+"<br>시간: "+timeN[i]+"<br>즐거운 시간보내세요!</html>");

				JButton b = (JButton) e.getSource();
				if (b == btnNonmember1[i]) {
					if (usermoneySum >= timepriceN[i]) {
						if(i<5) {
						NonMemberLoginFrame nml = new NonMemberLoginFrame();	//비회원로그인패널 객체 생성
						//nml.add(new JLabel("<html>비회원 로그인<br>아이디: 00000"+num+"<br>비밀번호: "+resultNum+"<br>시간: "+timeN[i]+"</html>"));
						j.setFont(new Font("BOLD", Font.BOLD, 35));
						nml.add(j);
						usermoneySum -= timepriceN[i];
						nonmemberincome += timepriceN[i];
						incometotal += timepriceN[i];
						labelSum.setText(usermoneySum + "원");
						num++;
						} else if (i > 4) {
							JOptionPane.showMessageDialog(null, "준비중입니다", "준비중!", JOptionPane.ERROR_MESSAGE);
							break;
						}
						break;

					} else {
						JOptionPane.showMessageDialog(null, "금액이 부족합니다! 돈을 투입하세요", "금액 부족!",
								JOptionPane.ERROR_MESSAGE);
						break;
					}

				}

			}
			
			
		} //actionPerformed 메서드 끝
		
	} //NonMemberPanel 클래스 끝
	
	class MemberPanel extends JPanel implements ActionListener{					//회원제 버튼 패널 클래스
		//private JButton[] btnMember = new JButton[8];
		
		public MemberPanel() {
			setLayout(new GridLayout(4, 2, 3, 3));
			
			for(int i = 0 ; i<btnMember1.length; i++ ) {
				switch(i) {
				case 0:
					btnMember1[i] = new JButton("<html>1000원<br>01:00</html>");
					break;
				case 1:
					btnMember1[i] = new JButton("<html>2000원<br>02:00</html>");
					break;
				case 2:
					btnMember1[i] = new JButton("<html>3000원<br>03:00</html>");
					break;
				case 3:
					btnMember1[i] = new JButton("<html>5000원<br>05:00</html>");
					break;
				case 4:
					btnMember1[i] = new JButton("<html>10000원<br>11:00</html>");
					break;
				case 5:
					btnMember1[i] = new JButton("<html>20000원<br>24:00</html>");
					break;
				default:
					btnMember1[i] = new JButton("준비중");
				}
				btnMember1[i].setFont(new Font("고딕", Font.BOLD, 35));
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
							labelSum.setText(usermoneySum + "원");
							String id = labelMemberInf.getText();
							String sTime = personInfo.cal(id, timeM[i]);
							timeLabel.setText("<html>아이디: " + id + "<br>등급: 회원제<br>남은 시간: " + sTime + "</html>");
							MemberLoginFrame ml = new MemberLoginFrame();
							j.setFont(new Font("BOLD", Font.BOLD, 35));
							j.setText("<html>시간이 충전되었습니다!<br>충전된 시간: "+timeM[i]+"<br>현금금액: "+timepriceM[i]+"<br>즐거운 시간 보내세요~</html>");
							ml.add(j);

						} else if (i > 5) {
							JOptionPane.showMessageDialog(null, "준비중입니다", "준비중!", JOptionPane.ERROR_MESSAGE);
							break;
						}
						break;

					} else {
						JOptionPane.showMessageDialog(null, "금액이 부족합니다! 돈을 투입하세요", "금액 부족!",
								JOptionPane.ERROR_MESSAGE);
						break;
					}
				}
			}
			
		}
				
	}
	
	class MemberLoginPanel extends JPanel{		//회원 로그인 입력 페널 클래스
		JLabel tfMemberId;
		JButton btnMemberLogin;
		JButton rstMemberLogin;

		public MemberLoginPanel() {
			this.setVisible(false);
			tfMemberId = new JLabel("아이디를 입력하세요");					//회원 로그인 텍스트필드
			//labelMemberInf = new JTextField("");							//회원 로그인 라벨
			btnMemberLogin = new JButton("확인");								//회원 로그인 버튼
			rstMemberLogin = new JButton("초기화");								//회원 로그인 버튼
			//timeLabel = new JLabel("");
			
			//tf.setEnabled(false);
			this.setBackground(Color.gray);									//회원 로그인 패널 배경색 설정
			tfMemberId.setFont(new Font("BOLD", Font.BOLD, 50));			//회원 로그인 패널 각 컴포넌트 폰트 설정
			labelMemberInf.setFont(new Font("BOLD", Font.BOLD, 30));
			btnMemberLogin.setFont(new Font("BOLD", Font.BOLD, 50));
			rstMemberLogin.setFont(new Font("BOLD", Font.BOLD, 50));
			labelMemberInf.setHorizontalAlignment(JTextField.CENTER);			//회원 정보 라벨 글자 가운데 맞춤
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
			
			btnMemberLogin.addActionListener(new checkBtnListener());							//화원 로그인 버튼에 리스너 달기
			rstMemberLogin.addActionListener(new resetBtnListener());							//화원 로그인 버튼에 리스너 달기
		}
		
		class checkBtnListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				moneyinletP.setVisible(true);
				changesP.setVisible(true);
				
				if (e.getSource() == btnMemberLogin) {
					String id = labelMemberInf.getText();									//사용자 id입력값 전역변수id에 저장
					
					if (id == null || "".equals(id)) {
						timeLabel.setText("ID를 입력해주세요.");									//회원 로그인 패널에 id변수 출력
					}
					String inId = personInfo.getInfo(id);
					if(inId == null || "".equals(inId)) {
						timeLabel.setText("ID가 존재하지 않습니다.");
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
						timeLabel.setText("<html>아이디: "+id+"<br>등급: 회원제<br>남은 시간: "+inId+"</html>");									//회원 로그인 패널에 id변수 출력
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
		JButton firstbtn = new JButton("처음화면");
		JButton seatbtn = new JButton("좌석확인");
		JButton registerbtn = new JButton("회원가입");
		JButton incomebtn = new JButton("매출액보기");
		JLabel infolabel = new JLabel("<html>←←←20000원<br>충전할때마다<br>1번사용가능<br>주사위6당첨되면 10시간추가</html>");
		
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
						btnseat[i] = new JButton(new ImageIcon("images/엑스.jpg"));
					}
					btnseat[i].setFont(new Font("고딕", Font.BOLD, 20));
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
						btnseat[i].setText("<html>"+"이건주<br>"+time+" 남음<br>league of legends</html>");
						break;
					case 21:
						btnseat[i].setBackground(Color.green);
						String time1 = personInfo.getInfo("leegyuwon");
						btnseat[i].setText("<html>"+"이규원<br>"+time1+" 남음<br>league of legends</html>");
						break;
					case 30:
						btnseat[i].setBackground(Color.green);
						String time2 = personInfo.getInfo("namtaewoo");
						btnseat[i].setText("<html>"+"남태우<br>"+time2+" 남음<br>league of legends</html>");
						break;
					case 39:
						btnseat[i].setBackground(Color.green);
						String time3 = personInfo.getInfo("shindonghoon");
						btnseat[i].setText("<html>"+"신동훈<br>"+time3+" 남음<br>league of legends</html>");
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
				JOptionPane.showMessageDialog(null, "회원가입은 자리에서 가능합니다!", "회원가입", JOptionPane.ERROR_MESSAGE);
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
	
	class MoneyInletPanel extends JPanel implements ActionListener{			//돈 투입구 패널 클래스
		
		private JButton [] btnMoneyInlet = { new JButton("<html>10000원</html>"), new JButton("<html>5000원</html"),
								   			 new JButton("<html>1000원</html>"), new JButton("<html>500원</html>") };
		
		public MoneyInletPanel() {
			this.setVisible(false);
			this.setBackground(Color.gray);									//돈 투입구 패널 배경화면 설정					
			for(int i=0; i<btnMoneyInlet.length; i++) {
				switch(i) {													//4개의 돈 투입구 버튼 색깔 지정(switch문)
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
				btnMoneyInlet[i].setFont(new Font("Arial", Font.BOLD, 40));	//4개의 돈 투입구 버튼 폰트 지정
	            this.add(btnMoneyInlet[i]);									//돈 투입구 패널에 4개의 돈 투입구 버튼 추가
	            btnMoneyInlet[i].addActionListener(this);					//4개의 돈 투입구 버튼에 리스너 달기
			}
			labelSum.setFont(new Font("고딕", Font.BOLD, 40));				//돈 누적 라벨 폰트 설정
			this.add(labelSum);                           					//돈 투입구 패널에 돈 누적 라벨 추가                                
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();			//이벤트 발생시 컴포넌트 변수들을 b에다가 저장
			if(b == btnMoneyInlet[0]) {					//b가 10000원버튼이 맞으면 10000원 누적
				usermoneySum += 10000;
			} else if(b == btnMoneyInlet[1]) {			//b가 5000원버튼이 맞으면 5000원 누적
				usermoneySum += 5000;
			} else if(b == btnMoneyInlet[2]) {			//b가 1000원버튼이 맞으면 1000원 누적
				usermoneySum += 1000;
			} else {									//b가 500원버튼이 맞으면 500원 누적
				usermoneySum += 500;
			}
			labelSum.setText(usermoneySum+"원");			//돈 투입구 라벨에 누적된 돈 출력
		}
	}
	
	class NonMemberLoginFrame extends JFrame {		//비회원로그인 프레임 클래스
	      public NonMemberLoginFrame() {
	         setTitle("비회원 로그인");				//타이틀이름
	         Container c = getContentPane();	//컨테이너 생성
	         c.setLayout(new FlowLayout());		//레이아웃 지정(FlowLayout)
	         setSize(400,300);					//비회원 로그인 프레임 크기
	         setLocationRelativeTo(null);		//가운데 맞춤
	         setResizable(false);				//크기고정
	         setVisible(true);					//화면보여주기
	      }
	}
	
	class MemberLoginFrame extends JFrame {		//비회원로그인 프레임 클래스
	      public MemberLoginFrame() {
	         setTitle("회원 로그인");				//타이틀이름
	         Container c = getContentPane();	//컨테이너 생성
	         c.setLayout(new FlowLayout());		//레이아웃 지정(FlowLayout)
	         setSize(400,300);					//비회원 로그인 프레임 크기
	         setLocationRelativeTo(null);		//가운데 맞춤
	         setResizable(false);				//크기고정
	         setVisible(true);					//화면보여주기
	      }
	}
	
	class EventFrame extends JFrame {			//이벤트 클래스
		JButton okbtn = new JButton("10시간받기");
		private JLabel[] l = new JLabel[6];
		private ImageIcon[] images = { new ImageIcon("images/주사위1.jpg"), new ImageIcon("images/주사위2.jpg"),
				new ImageIcon("images/주사위3.jpg"), new ImageIcon("images/주사위4.jpg"), new ImageIcon("images/주사위5.jpg"),
				new ImageIcon("images/주사위6.jpg") };
		
		public EventFrame(int random) {
	    	 
	         setTitle("이벤트창");					//타이틀이름
	         Container c = getContentPane();	//컨테이너 생성
	         c.setLayout(new FlowLayout());		//레이아웃 지정(FlowLayout)
	         setSize(400,300);					//비회원 로그인 프레임 크기
	         setLocationRelativeTo(null);		//가운데 맞춤
	         setResizable(false);				//크기고정
	         setVisible(true);					//화면보여주기
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
        		 JLabel pass = new JLabel("<html>축하합니다!!!<br>나온 주사위 수: "+dice+"</html>");
        		 pass.setFont(new Font("BOLD", Font.BOLD, 30));
        		 c.add(pass);
        	 } else {
        		 JLabel fail = new JLabel("<html>아깝습니다.<br>나온 주사위 수: "+dice+"</html>");	
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
	 				timeLabel.setText("<html>아이디: " + id + "<br>등급: 회원제<br>남은 시간: " + sTime + "</html>");
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
	
	class ChangesPanel extends JPanel implements ActionListener{	//잔돈 반환 패널 클래스
		private JButton btnChanges;		//잔돈 반환 버튼
		//private JLabel labelChanges;	//잔돈 확인 라벨
		
		public ChangesPanel() {
			this.setVisible(false);
			btnChanges = new JButton("잔돈 반환");
			//labelChanges = new JLabel("");
			
			btnChanges.setFont(new Font("고딕", Font.BOLD, 30));	
			this.setBackground(Color.white);				//잔돈 반환 패널 배경색 설정
			btnChanges.setBackground(Color.LIGHT_GRAY);		//잔돈 반환 버튼 배경색 설정
			this.add(btnChanges);							//잔돈 반환 패널에 잔돈 반환 버튼 추가
			this.add(labelChanges);							//잔돈 반환 패널에 잔돈 확인 라벨 추가
			
			btnChanges.addActionListener(this);				//잔돈 반환 버튼에 리스너 달기
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			labelChanges.setFont(new Font("고딕", Font.BOLD, 30));					//잔돈 확인 라벨 폰트 설정
           
			if(usermoneySum > 0) {													//사용자 금액이 0원이상 있으면 반환 문구 출력
				labelChanges.setText(usermoneySum+"원 반환! 사용해주셔서 감사합니다~!");
				usermoneySum = 0;													//0원으로 리셋
				labelSum.setText(usermoneySum+"원");
			} else {																//사용자 금액이 0원이면 돈이 없다는 문구 출력
				labelChanges.setText("반환할 돈이 없습니다. 다시 확인해주세요!");
			}
		}
	}
	
	class ScreenMoneyPanel extends JPanel{
		private ImageIcon icon;
		private Image henesis;
		
		public ScreenMoneyPanel() {
			icon = new ImageIcon("images\\헤네시스.jpg");
			henesis = icon.getImage();
		}
		
		public void paintComponent(Graphics g) {			//이미지 아이콘 크기 설정 및 출력
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
			icon = new ImageIcon("images\\징크스.jpg");		//이미지 아이콘 객체 생성
			jingkeuseu = icon.getImage();					//만든 이미지 아이콘 jingkeuseu 변수 저장
			icon1 = new ImageIcon("images\\가렌.jpg");
			garen = icon1.getImage();		
		}
		
		public void paintComponent(Graphics g) {			//이미지 아이콘 크기 설정 및 출력
			super.paintComponent(g);
			g.drawImage(jingkeuseu, 0, 0, 500, 300, this);  
			g.drawImage(garen, 0, 300, 500, 300, this);  
		}
	}
	
	class SeatList extends JFrame{
		
		public SeatList() {
			setTitle("좌석 현황");
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
		private JButton okbtn = new JButton("확인");
		

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
						JOptionPane.showMessageDialog(null, "비밀번호를 입력하지 않았습니다. 입력해 주세요", "비밀번호 오류!",
								JOptionPane.ERROR_MESSAGE);
						setVisible(true);
						tf.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "비밀번호가 틀립니다. 다시 입력해 주세요", "비밀번호 오류!",
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
		private JLabel l = new JLabel("비회원 매출액: "+nonmemberincome);
		private JLabel l2 = new JLabel("회원 매출액: "+memberincome);
		private JLabel l3 = new JLabel("총매출액: "+incometotal);
		
		public Income() {
			setTitle("매출액");
			Container c = getContentPane();
			c.setLayout(null);
			l.setBounds(0, 0, 500, 100);
			l2.setBounds(0, 100, 500, 100);
			l3.setBounds(0, 200, 500, 100);
			setSize(500, 400);
			setLocationRelativeTo(null);
			setResizable(false);
			setVisible(true);
			
			l.setFont(new Font("고딕", Font.BOLD, 45));	
			l2.setFont(new Font("고딕", Font.BOLD, 45));
			l3.setFont(new Font("고딕", Font.BOLD, 45));
			
			add(l);
			add(l2);
			add(l3);
		}
		
	}
	
	public static void main(String[] args) {	//메인 메서드

		new Ui(); //메인 프레임 띄우기

	}

}
