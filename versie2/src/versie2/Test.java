package versie2;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Test extends JFrame{
	
	private JPanel screenPanel = new JPanel();	
	private JPanel Windows = new JPanel();
	private JPanel PinCode = new JPanel();
	private JLabel timeLabel = new JLabel("00:00:00");
    private JLabel dateLabel = new JLabel("Sun, 22 Oct");
    private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("E, MMM dd yyyy");  
    private DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
    private Timer timer = new Timer("Timer");	
    private CardLayout cardLayout = new CardLayout(0,0);
    private JLabel lblPin1 = new JLabel("x            ", SwingConstants.CENTER);
    private JLabel lblPin2 = new JLabel("   x       ", SwingConstants.CENTER);
    private JLabel lblPin3 = new JLabel("       x   ", SwingConstants.CENTER);
    private JLabel lblPin4 = new JLabel("            x", SwingConstants.CENTER);
    private JLabel Attempt = new JLabel("Attempts left: #");
    private int clientBalance;
    private JLabel balance = new JLabel("\u20AC " + clientBalance);
    private String account;
    private JLabel lblAccount_1 = new JLabel(account);
    private JLabel lblTransactionComplete = new JLabel("", SwingConstants.CENTER);
    private JLabel label_15 = new JLabel("");
    private JLabel error = new JLabel("Please contact your bank", SwingConstants.CENTER);
    private Boolean Language = true;
    
    
    
    //welcome scherm
    private JButton btnVeranderTaal = new JButton("Change Language");
    private JLabel lblInsertCard = new JLabel("Please Insert Your Card", SwingConstants.CENTER);
    //inlog scherm
    private JButton btnContinue_1 = new JButton("Continue");
    private JButton btnClear_1 = new JButton("Clear");
    private JButton button_10 = new JButton("Abort");
    private JButton button_9 = new JButton("Change Language");
    private JLabel lblInsertPin = new JLabel("Please Insert Your Pin Code", SwingConstants.CENTER);
    //Home Screen
    private JLabel option = new JLabel("Please select an option", SwingConstants.CENTER);
    private JButton btnNewButton = new JButton("Balance");
    private JButton btnWithdraw = new JButton("Withdraw");
    private JButton btnFast = new JButton("Fast \u20AC 70");
    private JButton btnStop = new JButton("Abort");
  //Balance Screen
    private JButton btnHome2 = new JButton("Home");
    private JButton button_1 = new JButton("Withdraw");
    private JButton button_6 = new JButton("Fast \u20AC 70");
    private JButton button_7 = new JButton("Abort");
    private JLabel lblBalance = new JLabel("Balance:");
    private JLabel lblAccount = new JLabel("Account:");
  //Withdrawal Screen
    private JButton btnHome3 = new JButton("Home");
    private JLabel lblPleaseSelectAn = new JLabel("Please select an amount", SwingConstants.CENTER);
    private JLabel lblPressDTo = new JLabel("Press D to enter a custom amount");
    private JButton btnOther = new JButton("Other");
    private JButton button_5 = new JButton("Abort");
  //Custom Amount Screen
    private JButton btnHome4 = new JButton("Home");
    private JLabel PEA = new JLabel("Please enter an amount", SwingConstants.CENTER);
    private JButton btnContinue = new JButton("Continue");
    private JButton btnClear = new JButton("Clear");
    private JButton button_12 = new JButton("Abort");
    private JLabel lblAmount = new JLabel("Amount:");
    private JLabel lblNoteThisAtm = new JLabel("NOTE: This ATM only returns 10, 20 and 50 euro bills.");
  //Thanks Screen
    private JLabel ThanksFor = new JLabel("Thank you for choosing De Bank!");
    private JLabel lblNiceday = new JLabel("Have a nice day!");
    private JButton billChoice1 = new JButton("10€");
    private JButton billChoice2 = new JButton("20€");
    private JButton billChoice3 = new JButton("50€");
    
    
	public Test() {
		super("De Bank");

		setContentPane(screenPanel);
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1450, 800);
		setUndecorated(true);;
		getContentPane().setLayout(null);


		dateLabel.setForeground(Color.ORANGE);
		dateLabel.setFont(new Font("Arial", Font.BOLD, 36));
		dateLabel.setBounds(1100, 70, 280, 70);
		getContentPane().add(dateLabel);

		TimerTask repeatedTask = new TimerTask() {
	        public void run() {
	        	LocalDateTime localDateTime = LocalDateTime.now();  
	            
	            timeLabel.setText(localDateTime.format(timeFormat));
	            dateLabel.setText(localDateTime.format(dateFormat));
	        }
	    };
    
	    timer.scheduleAtFixedRate(repeatedTask, 0L, 1000L);
	    		timeLabel.setBounds(1200, 5, 163, 109);
	    		screenPanel.add(timeLabel);
	    
	    
	    		timeLabel.setForeground(Color.ORANGE);
	    		timeLabel.setFont(new Font("Arial", Font.BOLD, 36));

	
	    Windows.setBounds(0, 0, 1450, 800);
	    getContentPane().add(Windows);
	    Windows.setLayout(cardLayout);
	    
		
		//Welcome Screen
		JPanel Welcome = new JPanel();
		Windows.add(Welcome, "Welcome");
		Welcome.setLayout(null);
	
		JLabel label_D = new JLabel("D", SwingConstants.CENTER);
		label_D.setOpaque(true);
		label_D.setForeground(Color.WHITE);
		label_D.setFont(new Font("Arial", Font.PLAIN, 40));
		label_D.setBackground(Color.LIGHT_GRAY);
		label_D.setBounds(1300, 700, 75, 75);
		Welcome.add(label_D);
		
		btnVeranderTaal.setFont(new Font("Arial", Font.PLAIN, 24));
		btnVeranderTaal.setFocusPainted(false);
		btnVeranderTaal.setBounds(1050, 700, 230, 80);
		Welcome.add(btnVeranderTaal);
	
	
		lblInsertCard.setBounds(450, 170, 600, 200);
		Welcome.add(lblInsertCard);
		lblInsertCard.setFont(new Font("Arial", Font.PLAIN, 50));
		lblInsertCard.setForeground(Color.CYAN);
	
		JLabel lblNfc = new JLabel("NFC LOGO");
		//lblNfc.setIcon(new ImageIcon(Test.class.getResource("/img/NFC.png")));
		lblNfc.setBounds(700, 400, 150, 100);
		Welcome.add(lblNfc);
		
		JLabel lblNewLabel = new JLabel("LOGO", SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(650, 80, 150, 100);
		Welcome.add(lblNewLabel);
		//lblNewLabel.setIcon(new ImageIcon(Test.class.getResource("LOGO")));
		lblNewLabel.setOpaque(true);
		
		//PINCODE SCHERM
		
		Windows.add(PinCode, "PinCode");
		PinCode.setLayout(null);
		
		
		btnContinue_1.setForeground(Color.BLACK);
		btnContinue_1.setBackground(Color.BLACK);
		btnContinue_1.setFont(new Font("Arial", Font.PLAIN, 25));
		btnContinue_1.setFocusPainted(false);
		btnContinue_1.setBounds(1050, 400, 230, 80);
		PinCode.add(btnContinue_1);
		
		
		btnClear_1.setForeground(Color.BLACK);
		btnClear_1.setFont(new Font("Arial", Font.PLAIN, 25));
		btnClear_1.setFocusPainted(false);
		btnClear_1.setBackground(Color.BLACK);
		btnClear_1.setBounds(1050, 500, 230, 80);
		PinCode.add(btnClear_1);
		
		
		button_10.setForeground(Color.BLACK);
		button_10.setFont(new Font("Arial", Font.PLAIN, 25));
		button_10.setBackground(Color.BLACK);
		button_10.setBounds(130, 500, 230, 80);
		PinCode.add(button_10);
		
		
		//button_9.setIcon(new ImageIcon(Test.class.getResource("/img/Image 045.jpg")));
		button_9.setFont(new Font("Arial", Font.PLAIN, 25));
		button_9.setFocusPainted(false);
		button_9.setBounds(1050, 700, 230, 80);
		PinCode.add(button_9);
		
		JLabel label_A = new JLabel("A", SwingConstants.CENTER);
		label_A.setOpaque(true);
		label_A.setForeground(Color.WHITE);
		label_A.setFont(new Font("Arial", Font.PLAIN, 40));
		label_A.setBackground(Color.LIGHT_GRAY);
		label_A.setBounds(1300, 400, 75, 75);
		PinCode.add(label_A);
		
		
		JLabel label_28 = new JLabel("B", SwingConstants.CENTER);
		label_28.setOpaque(true);
		label_28.setForeground(Color.WHITE);
		label_28.setFont(new Font("Arial", Font.PLAIN, 40));
		label_28.setBackground(Color.LIGHT_GRAY);
		label_28.setBounds(1300, 500, 75, 75);
		PinCode.add(label_28);
		
		JLabel label_29 = new JLabel("C", SwingConstants.CENTER);
		label_29.setOpaque(true);
		label_29.setForeground(Color.WHITE);
		label_29.setFont(new Font("Arial", Font.PLAIN, 40));
		label_29.setBackground(Color.LIGHT_GRAY);
		label_29.setBounds(1300, 600, 75, 75);
		//PinCode.add(label_29);
		
		JLabel label_30 = new JLabel("D", SwingConstants.CENTER);
		label_30.setOpaque(true);
		label_30.setForeground(Color.WHITE);
		label_30.setFont(new Font("Arial", Font.PLAIN, 40));
		label_30.setBackground(Color.LIGHT_GRAY);
		label_30.setBounds(1300, 700, 75, 75);
		PinCode.add(label_30);
	
		
		JLabel label_31 = new JLabel("#", SwingConstants.CENTER);
		label_31.setVerticalAlignment(SwingConstants.BOTTOM);
		label_31.setOpaque(true);
		label_31.setForeground(Color.WHITE);
		label_31.setFont(new Font("Arial", Font.PLAIN, 50));
		label_31.setBackground(Color.LIGHT_GRAY);
		label_31.setBounds(30, 500, 75, 75);
		PinCode.add(label_31);
		
		JLabel Hash6 = new JLabel("*", SwingConstants.CENTER);
		Hash6.setVerticalAlignment(SwingConstants.BOTTOM);
		Hash6.setOpaque(true);
		Hash6.setForeground(Color.WHITE);
		Hash6.setFont(new Font("Arial", Font.PLAIN, 50));
		Hash6.setBackground(Color.LIGHT_GRAY);
		Hash6.setBounds(30, 600, 75, 75);
		//PinCode.add(Hash6);
		
		
		lblInsertPin.setFont(new Font("Arial", Font.PLAIN, 70));
		lblInsertPin.setBounds(0, 100, 1450, 194);
		lblInsertPin.setForeground(Color.RED);
		PinCode.add(lblInsertPin);
		
		
		lblPin1.setForeground(new Color(255, 255, 255));
		lblPin1.setFont(new Font("Arial", Font.PLAIN, 70));
		lblPin1.setBounds(0, 180, 1450, 230);
		PinCode.add(lblPin1);
		lblPin1.setVisible(false);
		
		lblPin2.setForeground(new Color(255, 255, 255));
		lblPin2.setFont(new Font("Arial", Font.PLAIN, 70));
		lblPin2.setBounds(0, 180, 1450, 230);
		PinCode.add(lblPin2);
		lblPin2.setVisible(false);
		
		
		lblPin3.setForeground(new Color(255, 255, 255));
		lblPin3.setFont(new Font("Arial", Font.PLAIN, 70));
		lblPin3.setBounds(0, 180, 1450, 230);
		PinCode.add(lblPin3);
		lblPin3.setVisible(false);
		
		lblPin4.setForeground(new Color(255, 255, 255));
		lblPin4.setFont(new Font("Arial", Font.PLAIN, 70));
		lblPin4.setBounds(0, 180, 1450, 230);
		PinCode.add(lblPin4);
		lblPin4.setVisible(false);
		JLabel lblUnderScore = new JLabel("_  _  _  _", SwingConstants.CENTER);
		lblUnderScore.setForeground(new Color(255, 255, 255));
		lblUnderScore.setFont(new Font("Arial", Font.PLAIN, 70));
		lblUnderScore.setBounds(0, 200, 1450, 230);
		PinCode.add(lblUnderScore);
		
		Attempt.setForeground(Color.RED);
		Attempt.setFont(new Font("Arial", Font.PLAIN, 50));
		Attempt.setHorizontalAlignment(SwingConstants.CENTER);
		Attempt.setBounds(0, 497, 1450, 100);
		PinCode.add(Attempt);
		
		JLabel lblBackground = new JLabel("Background");
		lblBackground.setBounds(700,0,1450, 800);
		PinCode.add(lblBackground);
		//lblBackground.setIcon(new ImageIcon(Test.class.getResource("/img/PinCodeBG.jpg")));
		lblBackground.setOpaque(true);
		
		//Bill choice
		JPanel Bills = new JPanel();
		Windows.add(Bills, "Bills");
		Bills.setLayout(null);
		
		billChoice1.setForeground(Color.BLACK);
		billChoice1.setFocusPainted(false);
		billChoice1.setFont(new Font("Arial", Font.PLAIN, 25));
		billChoice1.setBounds(1050, 400, 230, 75);
		Bills.add(billChoice1);
		billChoice1.setOpaque(true);
		
		billChoice2.setForeground(Color.BLACK);
		billChoice2.setFocusPainted(false);
		billChoice2.setFont(new Font("Arial", Font.PLAIN, 25));
		billChoice2.setBounds(1050, 500, 230, 75);
		Bills.add(billChoice2);
		billChoice2.setOpaque(true);
		
		billChoice3.setForeground(Color.BLACK);
		billChoice3.setFocusPainted(false);
		billChoice3.setFont(new Font("Arial", Font.PLAIN, 25));
		billChoice3.setBounds(1050, 600, 230, 75);
		Bills.add(billChoice3);
		billChoice3.setOpaque(true);
		
		JLabel bA = new JLabel("A", SwingConstants.CENTER);
		bA.setForeground(Color.BLACK);
		bA.setBackground(Color.LIGHT_GRAY);
		bA.setFont(new Font("Arial", Font.PLAIN, 40));
		bA.setBounds(1300, 400, 75, 75);
		Bills.add(bA);
		bA.setOpaque(true);
		
		JLabel bB = new JLabel("B", SwingConstants.CENTER);
		bB.setForeground(Color.BLACK);
		bB.setBackground(Color.LIGHT_GRAY);
		bB.setFont(new Font("Arial", Font.PLAIN, 40));
		bB.setBounds(1300, 500, 75, 75);
		Bills.add(bB);
		bB.setOpaque(true);
		
		JLabel bC = new JLabel("C", SwingConstants.CENTER);
		bC.setForeground(Color.BLACK);
		bC.setBackground(Color.LIGHT_GRAY);
		bC.setFont(new Font("Arial", Font.PLAIN, 40));
		bC.setBounds(1300, 600, 75, 75);
		Bills.add(bC);
		bC.setOpaque(true);
		
		JLabel bD = new JLabel("D", SwingConstants.CENTER);
		bD.setForeground(Color.BLACK);
		bD.setBackground(Color.LIGHT_GRAY);
		bD.setFont(new Font("Arial", Font.PLAIN, 40));
		bD.setBounds(1300, 700, 75, 75);
		//Bills.add(bD);
		bD.setOpaque(true);
		
		JLabel bAst = new JLabel("#", SwingConstants.CENTER);
		bAst.setForeground(Color.BLACK);
		bAst.setBackground(Color.LIGHT_GRAY);
		bAst.setFont(new Font("Arial", Font.PLAIN, 40));
		bAst.setBounds(30, 500, 75, 75);
		Bills.add(bAst);
		bAst.setOpaque(true);
		
		JLabel Hash5 = new JLabel("*", SwingConstants.CENTER);
		Hash5.setVerticalAlignment(SwingConstants.BOTTOM);
		Hash5.setOpaque(true);
		Hash5.setForeground(Color.BLACK);
		Hash5.setFont(new Font("Arial", Font.PLAIN, 50));
		Hash5.setBackground(Color.LIGHT_GRAY);
		Hash5.setBounds(30, 600, 75, 75);
		Bills.add(Hash5);
		
		JLabel naam = new JLabel("De Bank", SwingConstants.CENTER);
		naam.setForeground(new Color(100, 149, 237));
		naam.setFont(new Font("Arial", Font.PLAIN, 99));
		naam.setBounds(0, 50, 1450, 150);
		Bills.add(naam);
		
		JButton bthH = new JButton("Abort");
		bthH.setForeground(Color.BLACK);
		bthH.setBackground(new Color(0,0,0));
		bthH.setFont(new Font("Arial", Font.PLAIN, 25));
		bthH.setBounds(130, 500, 150, 75);
		Bills.add(bthH);
		
		JButton bthHome = new JButton("Home");
		bthHome.setForeground(Color.BLACK);
		bthHome.setBackground(new Color(255, 51, 51));
		bthHome.setFont(new Font("Arial", Font.PLAIN, 25));
		bthHome.setBounds(130, 600, 150, 75);
		Bills.add(bthHome);
		
		
		JLabel lblBackground2 = new JLabel("Background");
		lblBackground2.setBounds(700, 400, 100, 50);
		Bills.add(lblBackground2);
		//lblBackground2.setIcon(new ImageIcon(Test.class.getResource("/img/BlankBG.jpg")));
		lblBackground2.setOpaque(true);
		
		JLabel choice = new JLabel("Please select a choice of bills", SwingConstants.CENTER);
		choice.setForeground(Color.BLACK);
		choice.setFont(new Font("Arial", Font.PLAIN, 70));
		choice.setBounds(0, 250, 1450, 113);
		Bills.add(choice);
		
		//Home Screen
		JPanel Home = new JPanel();
		Windows.add(Home, "Home");
		Home.setLayout(null);
		
		JLabel A = new JLabel("A", SwingConstants.CENTER);
		A.setOpaque(true);
		A.setForeground(Color.WHITE);
		A.setBackground(Color.LIGHT_GRAY);
		A.setFont(new Font("Arial", Font.PLAIN, 40));
		A.setBounds(1300, 400, 75, 75);
		Home.add(A);
		
				
		JLabel B = new JLabel("B", SwingConstants.CENTER);
		B.setOpaque(true);
		B.setForeground(Color.WHITE);
		B.setFont(new Font("Arial", Font.PLAIN, 40));
		B.setBackground(Color.LIGHT_GRAY);
		B.setBounds(1300, 500, 75, 75);
		Home.add(B);
		
		JLabel C = new JLabel("C", SwingConstants.CENTER);
		C.setOpaque(true);
		C.setForeground(Color.WHITE);
		C.setFont(new Font("Arial", Font.PLAIN, 40));
		C.setBackground(Color.LIGHT_GRAY);
		C.setBounds(1300, 600, 75, 75);
		Home.add(C);
		
		JLabel D = new JLabel("D", SwingConstants.CENTER);
		D.setOpaque(true);
		D.setForeground(Color.WHITE);
		D.setFont(new Font("Arial", Font.PLAIN, 40));
		D.setBackground(Color.LIGHT_GRAY);
		D.setBounds(1300, 700, 75, 75);
		//Home.add(D);
		
		JLabel Asterisk = new JLabel("#", SwingConstants.CENTER);
		Asterisk.setVerticalAlignment(SwingConstants.BOTTOM);
		Asterisk.setOpaque(true);
		Asterisk.setForeground(Color.WHITE);
		Asterisk.setFont(new Font("Arial", Font.PLAIN, 50));
		Asterisk.setBackground(Color.LIGHT_GRAY);
		Asterisk.setBounds(30, 500, 75, 75);
		Home.add(Asterisk);
		
		JLabel Hash = new JLabel("*", SwingConstants.CENTER);
		Hash.setVerticalAlignment(SwingConstants.BOTTOM);
		Hash.setOpaque(true);
		Hash.setForeground(Color.WHITE);
		Hash.setFont(new Font("Arial", Font.PLAIN, 50));
		Hash.setBackground(Color.LIGHT_GRAY);
		Hash.setBounds(30, 600, 75, 75);
		//Home.add(Hash);
		
		JLabel name = new JLabel("De Bank", SwingConstants.CENTER);
		name.setForeground(new Color(100, 149, 237));
		name.setFont(new Font("Arial", Font.PLAIN, 99));
		name.setBounds(0, 50, 1450, 150);
		Home.add(name);
		
		
		option.setForeground(new Color(224, 255, 255));
		option.setFont(new Font("Arial", Font.PLAIN, 70));
		option.setBounds(0, 300, 1450, 113);
		Home.add(option);
		
		
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 25));
		btnNewButton.setBounds(1050, 400, 230, 80);
		Home.add(btnNewButton);
		
		btnWithdraw.setForeground(Color.BLACK);
		btnWithdraw.setFocusPainted(false);
		btnWithdraw.setBackground(Color.BLACK);
		btnWithdraw.setFont(new Font("Arial", Font.PLAIN, 25));
		btnWithdraw.setBounds(1050, 500, 230, 80);
		Home.add(btnWithdraw);
		
		btnFast.setForeground(Color.BLACK);
		btnFast.setFocusPainted(false);
		btnFast.setBackground(Color.BLACK);
		btnFast.setFont(new Font("Arial", Font.PLAIN, 25));
		btnFast.setBounds(1050, 600, 230, 80);
		Home.add(btnFast);
		
		
		btnStop.setForeground(Color.BLACK);
		btnStop.setBackground(Color.BLACK);
		btnStop.setFont(new Font("Arial", Font.PLAIN, 25));
		btnStop.setBounds(130, 500, 230, 80);
		Home.add(btnStop);
		
		JLabel BlankBG = new JLabel("BlankBackGround");
		BlankBG.setBounds(700,0,1450,800);
		//BlankBG.setIcon(new ImageIcon(Test.class.getResource("/img/BlankBG.jpg")));
		BlankBG.setOpaque(true);
		Home.add(BlankBG);
		
		
		//Show Screen
		
		
		JPanel Balance = new JPanel();
		Windows.add(Balance, "Balance");
		Balance.setLayout(null);
		
		JLabel label = new JLabel("A", SwingConstants.CENTER);
		label.setOpaque(true);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.PLAIN, 40));
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(1300, 400, 75, 75);
		Balance.add(label);
		
		JLabel label_1 = new JLabel("B", SwingConstants.CENTER);
		label_1.setOpaque(true);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Arial", Font.PLAIN, 40));
		label_1.setBackground(Color.LIGHT_GRAY);
		label_1.setBounds(1300, 500, 75, 75);
		Balance.add(label_1);
		
		JLabel label_2 = new JLabel("C", SwingConstants.CENTER);
		label_2.setOpaque(true);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Arial", Font.PLAIN, 40));
		label_2.setBackground(Color.LIGHT_GRAY);
		label_2.setBounds(1300, 600, 75, 75);
		Balance.add(label_2);
		
		JLabel label_3 = new JLabel("D", SwingConstants.CENTER);
		label_3.setOpaque(true);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Arial", Font.PLAIN, 40));
		label_3.setBackground(Color.LIGHT_GRAY);
		label_3.setBounds(1300, 700, 75, 75);
		Balance.add(label_3);
		
		JLabel label_4 = new JLabel("#", SwingConstants.CENTER);
		label_4.setVerticalAlignment(SwingConstants.BOTTOM);
		label_4.setOpaque(true);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Arial", Font.PLAIN, 50));
		label_4.setBackground(Color.LIGHT_GRAY);
		label_4.setBounds(30, 500, 75, 75);
		Balance.add(label_4);
		
		JLabel Hash2 = new JLabel("*", SwingConstants.CENTER);
		Hash2.setVerticalAlignment(SwingConstants.BOTTOM);
		Hash2.setOpaque(true);
		Hash2.setForeground(Color.WHITE);
		Hash2.setFont(new Font("Arial", Font.PLAIN, 50));
		Hash2.setBackground(Color.LIGHT_GRAY);
		Hash2.setBounds(30, 600, 75, 75);
		Balance.add(Hash2);
		
		JLabel name2 = new JLabel("De Bank ", SwingConstants.CENTER);
		name2.setForeground(new Color(100, 149, 237));
		name2.setFont(new Font("Arial", Font.PLAIN, 99));
		name2.setBounds(0, 50, 1450, 150);
		Balance.add(name2);
		
		btnHome2.setForeground(Color.BLACK);
		btnHome2.setBackground(new Color(255, 51, 51));
		btnHome2.setFont(new Font("Arial", Font.PLAIN, 25));
		btnHome2.setBounds(130, 600, 230, 75);
		Balance.add(btnHome2);
		
		button_1.setFocusPainted(false);
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Arial", Font.PLAIN, 25));
		button_1.setBackground(new Color(255, 204, 51));
		button_1.setBounds(1050, 500, 230, 75);
		Balance.add(button_1);
		
		button_6.setFocusPainted(false);
		button_6.setForeground(Color.BLACK);
		button_6.setFont(new Font("Arial", Font.PLAIN, 25));
		button_6.setBackground(new Color(153, 0, 204));
		button_6.setBounds(1050, 600, 230, 75);
		Balance.add(button_6);
		
		
		button_7.setFocusPainted(false);
		button_7.setForeground(Color.BLACK);
		button_7.setFont(new Font("Arial", Font.PLAIN, 25));
		button_7.setBackground(new Color(0,0,0));
		button_7.setBounds(130, 500, 230, 75);
		Balance.add(button_7);
		
		
		balance.setForeground(new Color(224, 255, 255));
		balance.setHorizontalAlignment(SwingConstants.RIGHT);
		balance.setFont(new Font("Arial", Font.PLAIN, 50));
		balance.setBounds(650, 250, 100, 55);
		Balance.add(balance);
		
		
		lblAccount_1.setForeground(Color.BLACK);
		lblAccount_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAccount_1.setFont(new Font("Arial", Font.PLAIN, 50));
		lblAccount_1.setBounds(650, 350, 100, 55);
		Balance.add(lblAccount_1);
		
		
		lblBalance.setForeground(new Color(224, 255, 255));
		lblBalance.setFont(new Font("Arial", Font.PLAIN, 50));
		lblBalance.setBounds(450, 250, 300, 55);
		Balance.add(lblBalance);
		
		
		lblAccount.setForeground(new Color(224, 255, 255));
		lblAccount.setFont(new Font("Arial", Font.PLAIN, 50));
		lblAccount.setBounds(450, 300, 300, 47);
		Balance.add(lblAccount);
		
		JLabel BBG = new JLabel("BBG");
		//BBG.setIcon(new ImageIcon(Test.class.getResource("/img/BlankBG.jpg")));
		BBG.setBounds(0, 0, 1450, 800);
		Balance.add(BBG);
		
		
		
		//Withdrawal
		
		JPanel Withdrawal = new JPanel();
		Windows.add(Withdrawal, "Withdrawal");
		Withdrawal.setLayout(null);
		
		JLabel label_5 = new JLabel("De Bank", SwingConstants.CENTER);
		label_5.setForeground(new Color(100, 149, 237));
		label_5.setFont(new Font("Arial", Font.PLAIN, 99));
		label_5.setBounds(0, 50, 1450, 150);
		Withdrawal.add(label_5);
		
		JLabel label_6 = new JLabel("A", SwingConstants.CENTER);
		label_6.setOpaque(true);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Arial", Font.PLAIN, 40));
		label_6.setBackground(Color.LIGHT_GRAY);
		label_6.setBounds(1300, 400, 75, 75);
		Withdrawal.add(label_6);
		
		JLabel label_7 = new JLabel("B", SwingConstants.CENTER);
		label_7.setOpaque(true);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Arial", Font.PLAIN, 40));
		label_7.setBackground(Color.LIGHT_GRAY);
		label_7.setBounds(1300, 500, 75, 75);
		Withdrawal.add(label_7);
		
		JLabel label_8 = new JLabel("C", SwingConstants.CENTER);
		label_8.setOpaque(true);
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Arial", Font.PLAIN, 40));
		label_8.setBackground(Color.LIGHT_GRAY);
		label_8.setBounds(1300, 600, 75, 75);
		Withdrawal.add(label_8);
		
		JLabel label_9 = new JLabel("D", SwingConstants.CENTER);
		label_9.setOpaque(true);
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Arial", Font.PLAIN, 40));
		label_9.setBackground(Color.LIGHT_GRAY);
		label_9.setBounds(1300, 700, 75, 75);
		Withdrawal.add(label_9);
		
		JLabel label_10 = new JLabel("#", SwingConstants.CENTER);
		label_10.setVerticalAlignment(SwingConstants.BOTTOM);
		label_10.setOpaque(true);
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Arial", Font.PLAIN, 50));
		label_10.setBackground(Color.LIGHT_GRAY);
		label_10.setBounds(30, 500, 75, 75);
		Withdrawal.add(label_10);
		
		JLabel Hash3 = new JLabel("*", SwingConstants.CENTER);
		Hash3.setVerticalAlignment(SwingConstants.BOTTOM);
		Hash3.setOpaque(true);
		Hash3.setForeground(Color.WHITE);
		Hash3.setFont(new Font("Arial", Font.PLAIN, 50));
		Hash3.setBackground(Color.LIGHT_GRAY);
		Hash3.setBounds(30, 600, 75, 75);
		Withdrawal.add(Hash3);
		
		btnHome3.setForeground(Color.BLACK);
		btnHome3.setBackground(Color.BLACK);
		btnHome3.setFont(new Font("Arial", Font.PLAIN, 25));
		btnHome3.setBounds(130, 600, 230, 75);
		Withdrawal.add(btnHome3);
		
		JButton button = new JButton("\u20AC 20");
		
		lblPleaseSelectAn.setForeground(new Color(224, 255, 255));
		lblPleaseSelectAn.setFont(new Font("Arial", Font.PLAIN, 70));
		lblPleaseSelectAn.setBounds(0, 200, 1450, 113);
		Withdrawal.add(lblPleaseSelectAn);
		
		
		lblPressDTo.setForeground(new Color(224, 255, 255));
		lblPressDTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPressDTo.setFont(new Font("Arial", Font.ITALIC, 40));
		lblPressDTo.setBounds(0, 300, 1450, 131);
		Withdrawal.add(lblPressDTo);
		
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Arial", Font.PLAIN, 25));
		button.setFocusPainted(false);
		button.setBackground(new Color(0, 153, 51));
		button.setBounds(1050, 500, 230, 75);
		Withdrawal.add(button);
		
		JButton button_3 = new JButton("\u20AC 50");
		button_3.setForeground(Color.BLACK);
		button_3.setFont(new Font("Arial", Font.PLAIN, 25));
		button_3.setFocusPainted(false);
		button_3.setBackground(new Color(0, 153, 51));
		button_3.setBounds(1050, 600, 230, 75);
		Withdrawal.add(button_3);
		
		btnOther.setForeground(Color.BLACK);
		btnOther.setBackground(Color.BLACK);
		btnOther.setFont(new Font("Arial", Font.PLAIN, 25));
		btnOther.setFocusPainted(false);
		btnOther.setBounds(1050, 700, 230, 75);
		Withdrawal.add(btnOther);
		
		JButton button_4 = new JButton("\u20AC 10");
		button_4.setForeground(Color.BLACK);
		button_4.setFont(new Font("Arial", Font.PLAIN, 25));
		button_4.setFocusPainted(false);
		button_4.setBackground(new Color(0, 153, 51));
		button_4.setBounds(1050, 400, 230, 75);
		Withdrawal.add(button_4);
		
		
		button_5.setForeground(Color.BLACK);
		button_5.setFont(new Font("Arial", Font.PLAIN, 25));
		button_5.setFocusPainted(false);
		button_5.setBackground(Color.BLACK);
		button_5.setBounds(130, 500, 230, 75);
		Withdrawal.add(button_5);
		
		
		JLabel WBG = new JLabel("BBG");
		WBG.setBounds(700,0,1450,800);
		//WBG.setIcon(new ImageIcon(Test.class.getResource("/img/BlankBG.jpg")));
		WBG.setOpaque(true);
		Withdrawal.add(WBG);
		
		
		
		//Input custom amount screen
		
		JPanel CustAmount = new JPanel();
		CustAmount.setLayout(null);
		Windows.add(CustAmount, "CustAmount");
		
		JPanel AmountPanel = new JPanel();
		AmountPanel.setBounds(400, 400, 600, 100);
		AmountPanel.setLayout(null);
		CustAmount.add(AmountPanel);
		
		btnHome4.setForeground(Color.BLACK);
		btnHome4.setBackground(new Color(255, 51, 51));
		btnHome4.setFont(new Font("Arial", Font.PLAIN, 25));
		btnHome4.setBounds(130, 600, 230, 75);
		CustAmount.add(btnHome4);
		
		label_15.setBounds(0, 0, 600, 100);
		AmountPanel.add(label_15);
		label_15.setHorizontalAlignment(SwingConstants.LEADING);
		label_15.setFont(new Font("Arial", Font.PLAIN, 70));
		
		JLabel name4 = new JLabel("De Bank", SwingConstants.CENTER);
		name4.setForeground(new Color(100, 149, 237));
		name4.setFont(new Font("Arial", Font.PLAIN, 99));
		name4.setBounds(0, 50, 1450, 150);
		CustAmount.add(name4);
		
		JLabel OptA = new JLabel("A", SwingConstants.CENTER);
		OptA.setOpaque(true);
		OptA.setForeground(Color.BLACK);
		OptA.setFont(new Font("Arial", Font.PLAIN, 40));
		OptA.setBackground(Color.LIGHT_GRAY);
		OptA.setBounds(1300, 400, 75, 75);
		//CustAmount.add(OptA);
		
		JLabel OptB = new JLabel("B", SwingConstants.CENTER);
		OptB.setOpaque(true);
		OptB.setForeground(Color.BLACK);
		OptB.setFont(new Font("Arial", Font.PLAIN, 40));
		OptB.setBackground(Color.LIGHT_GRAY);
		OptB.setBounds(1300, 500, 75, 75);
		CustAmount.add(OptB);

		JLabel OptC = new JLabel("C", SwingConstants.CENTER);
		OptC.setOpaque(true);
		OptC.setForeground(Color.BLACK);
		OptC.setFont(new Font("Arial", Font.PLAIN, 40));
		OptC.setBackground(Color.LIGHT_GRAY);
		OptC.setBounds(1300, 600, 75, 75);
		CustAmount.add(OptC);
		
		JLabel OptD = new JLabel("D", SwingConstants.CENTER);
		OptD.setOpaque(true);
		OptD.setForeground(Color.BLACK);
		OptD.setFont(new Font("Arial", Font.PLAIN, 40));
		OptD.setBackground(Color.LIGHT_GRAY);
		OptD.setBounds(1300, 700, 75, 75);
		//CustAmount.add(OptD);

		JLabel OptAst = new JLabel("#", SwingConstants.CENTER);
		OptAst.setVerticalAlignment(SwingConstants.BOTTOM);
		OptAst.setOpaque(true);
		OptAst.setForeground(Color.BLACK);
		OptAst.setFont(new Font("Arial", Font.PLAIN, 50));
		OptAst.setBackground(Color.LIGHT_GRAY);
		OptAst.setBounds(30, 500, 75, 75);
		CustAmount.add(OptAst);
		
		JLabel Hash4 = new JLabel("*", SwingConstants.CENTER);
		Hash4.setVerticalAlignment(SwingConstants.BOTTOM);
		Hash4.setOpaque(true);
		Hash4.setForeground(Color.BLACK);
		Hash4.setFont(new Font("Arial", Font.PLAIN, 50));
		Hash4.setBackground(Color.LIGHT_GRAY);
		Hash4.setBounds(30, 600, 75, 75);
		CustAmount.add(Hash4);
		
		PEA.setForeground(new Color(224, 255, 255));
		PEA.setFont(new Font("Arial", Font.PLAIN, 70));
		PEA.setBounds(0, 250, 1450, 113);
		CustAmount.add(PEA);
		
		
		btnContinue.setForeground(Color.BLACK);
		btnContinue.setFont(new Font("Arial", Font.PLAIN, 25));
		btnContinue.setFocusPainted(false);
		btnContinue.setBackground(new Color(0, 153, 51));
		btnContinue.setBounds(1050, 600, 230, 75);
		CustAmount.add(btnContinue);
		
		
		btnClear.setForeground(Color.BLACK);
		btnClear.setFont(new Font("Arial", Font.PLAIN, 25));
		btnClear.setFocusPainted(false);
		btnClear.setBackground(new Color(255, 204, 51));
		btnClear.setBounds(1050, 500, 230, 75);
		CustAmount.add(btnClear);
		
		
		button_12.setForeground(Color.BLACK);
		button_12.setFont(new Font("Arial", Font.PLAIN, 25));
		button_12.setFocusPainted(false);
		button_12.setBackground(new Color(0,0,0));
		button_12.setBounds(130, 500, 230, 75);
		CustAmount.add(button_12);
		
		lblAmount.setForeground(new Color(224, 255, 255));
		lblAmount.setFont(new Font("Arial", Font.PLAIN, 30));
		lblAmount.setBackground(new Color(224, 255, 255));
		lblAmount.setBounds(500, 350, 150, 40);
		CustAmount.add(lblAmount);
	
	
		lblNoteThisAtm.setForeground(new Color(255, 255, 255));
		lblNoteThisAtm.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNoteThisAtm.setBounds(500, 500, 600, 25);
		CustAmount.add(lblNoteThisAtm);
		
		JLabel CBG = new JLabel("BBG");
		//CBG.setIcon(new ImageIcon(Test.class.getResource("/img/BlankBG.jpg")));
		CBG.setOpaque(true);
		CBG.setBounds(700, 0, 1450, 800);
		CustAmount.add(CBG);
		
		
		
		//WaitingScreen
		
		JPanel WaitingScreen = new JPanel();
		WaitingScreen.setLayout(null);
		Windows.add(WaitingScreen, "WaitingScreen");
		
		JLabel name5 = new JLabel("De Bank", SwingConstants.CENTER);
		name5.setForeground(new Color(100, 149, 237));
		name5.setFont(new Font("Arial", Font.PLAIN, 99));
		name5.setBounds(0, 50, 1450, 150);
		WaitingScreen.add(name5);
		
		JLabel Check = new JLabel(" Something went wrong.", SwingConstants.CENTER);
		Check.setForeground(Color.BLACK);
		Check.setFont(new Font("Arial", Font.PLAIN, 60));
		Check.setBounds(0, 300, 1450, 100);
		WaitingScreen.add(Check);
	
	
		error.setForeground(Color.BLACK);
		error.setFont(new Font("Arial", Font.PLAIN, 50));
		error.setBounds(0, 400, 1450, 100);
		WaitingScreen.add(error);
	
	
		lblTransactionComplete.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransactionComplete.setForeground(Color.BLACK);
		lblTransactionComplete.setFont(new Font("Arial", Font.PLAIN, 60));
		lblTransactionComplete.setBounds(0, 300, 1450, 100);
		WaitingScreen.add(lblTransactionComplete);
	
		JLabel WaitBG = new JLabel("BBG");
		//WaitBG.setIcon(new ImageIcon(Test.class.getResource("/img/BlankBG.jpg")));
		WaitBG.setOpaque(true);
		WaitBG.setBounds(700, 0, 1450, 800);
		WaitingScreen.add(WaitBG);
		WaitBG.setOpaque(true);
		
		
		// Receipt screen
		JPanel Receipt = new JPanel();
		Receipt.setLayout(null);
		Windows.add(Receipt, "Receipt");
	
		JLabel name6 = new JLabel("De Bank", SwingConstants.CENTER);
		name6.setForeground(new Color(100, 149, 237));
		name6.setFont(new Font("Arial", Font.PLAIN, 99));
		name6.setBounds(0, 50, 1450, 150);
		Receipt.add(name6);
		
		JLabel label_11 = new JLabel("D", SwingConstants.CENTER);
		label_11.setOpaque(true);
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Arial", Font.PLAIN, 40));
		label_11.setBackground(Color.LIGHT_GRAY);
		label_11.setBounds(1300, 600, 75, 75);
		Receipt.add(label_11);
	
		JLabel label_12 = new JLabel("*", SwingConstants.CENTER);
		label_12.setVerticalAlignment(SwingConstants.BOTTOM);
		label_12.setOpaque(true);
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Arial", Font.PLAIN, 50));
		label_12.setBackground(Color.LIGHT_GRAY);
		label_12.setBounds(30, 600, 75, 75);
		Receipt.add(label_12);
	
	
		JButton btnYes = new JButton("Yes");
		btnYes.setForeground(Color.BLACK);
		btnYes.setFont(new Font("Arial", Font.PLAIN, 25));
		btnYes.setFocusPainted(false);
		btnYes.setBackground(new Color(0, 153, 51));
		btnYes.setBounds(130, 600, 230, 75);
		Receipt.add(btnYes);
	
		JButton btnNo = new JButton("No");
		btnNo.setForeground(Color.BLACK);
		btnNo.setFont(new Font("Arial", Font.PLAIN, 25));
		btnNo.setFocusPainted(false);
		btnNo.setBounds(1050, 600, 230, 75);
		Receipt.add(btnNo);
	
		JLabel Receiptyn = new JLabel("Would you like a receipt?");
		Receiptyn.setForeground(Color.BLACK);
		Receiptyn.setHorizontalAlignment(SwingConstants.CENTER);
		Receiptyn.setFont(new Font("Arial", Font.PLAIN, 70));
		Receiptyn.setBounds(0, 300, 1450, 86);
		Receipt.add(Receiptyn);
	
		JLabel RBackG =  new JLabel();
		//RBackG.setIcon(new ImageIcon(Test.class.getResource("/img/PinCodeBG.jpg")));
		RBackG.setOpaque(true);
		RBackG.setBounds(0, 0, 1450, 1080);
		Receipt.add(RBackG);
	
		//End screen
	
		JPanel Thanks = new JPanel();
		Thanks.setLayout(null);
		Windows.add(Thanks, "Thanks");
	
	
		ThanksFor.setFont(new Font("Arial", Font.PLAIN, 70));
		ThanksFor.setForeground(Color.BLACK);
		ThanksFor.setHorizontalAlignment(SwingConstants.CENTER);
		ThanksFor.setBounds(0, 300, 1450, 111);
		Thanks.add(ThanksFor);
	
	
		lblNiceday.setFont(new Font("Arial", Font.PLAIN, 60));
		lblNiceday.setForeground(Color.BLACK);
		lblNiceday.setHorizontalAlignment(SwingConstants.CENTER);
		lblNiceday.setBounds(0, 450, 1450, 81);
		Thanks.add(lblNiceday);
	
		JLabel ThanksBG = new JLabel("BBG");
		//ThanksBG.setIcon(new ImageIcon(Test.class.getResource("/img/ThanksBG.jpg")));
		ThanksBG.setOpaque(true);
		ThanksBG.setBounds(700, 0, 1450, 800);
		Thanks.add(ThanksBG);	
	
		
	
		setVisible(true);
	}
	
	public void displayPanel(String pnl) {
    	cardLayout.show(Windows , pnl);
        screenPanel.repaint();
    }
    
    public void errorMessage(String message) {
    	error.setText(message);
    }
    
    public void displayPin(int pinLength) {
    	switch (pinLength) {
    	case 1:
    		lblPin1.setVisible(true);

    	break;
    	
    	case 2:
    		lblPin2.setVisible(true);

    		break;
    
    	case 3:
    		lblPin3.setVisible(true);

    	break;
    	
    	case 4:
    
    		lblPin4.setVisible(true);
    	break;
    }
}
    
    public void resetPin() {
    	lblPin1.setVisible(false);
    	lblPin2.setVisible(false);
    	lblPin3.setVisible(false);
    	lblPin4.setVisible(false);
    }
    
    public void setTransactionVis(Boolean f) {
    	lblTransactionComplete.setVisible(f);
    }
    
    public void showBalanceAccount(String clientBalance, String account) {
    	balance.setText("?" + clientBalance);
    	lblAccount_1.setText(account);
    }
    
    public void transactionStatus(Boolean status) {
    	if(status) {
    		lblTransactionComplete.setText("Transaction Complete!");
    	}
    	if(!status) {
    		lblTransactionComplete.setText("Transaction Failed!");
    	}
    }
    
    public void customAmount(String amount) {
    	label_15.setText("? " + amount);
    }
    
    public void loginAttempts(String attemptsLeft) {
    	System.out.println(attemptsLeft);
    	if(Language) {
    		Attempt.setText("Gebruikte pogingen: " + attemptsLeft + "/3");	
    	}
    	else if(!Language) {
    		Attempt.setText("Attempts used: " + attemptsLeft + "/3");
    	}
    }
    
    public void changeLanguage() {

    	if(Language) {
    //Set Dutch
    	btnHome2.setText("Thuis");
    	btnHome3.setText("Thuis");
    	btnHome4.setText("Thuis");
    	//btnVeranderTaal.setIcon(new ImageIcon(Test.class.getResource("/img/UK.jpg")));
    	lblInsertCard.setText("Voer alstublieft uw kaart in");
    	btnContinue_1.setText("Doorgaan");
    	btnClear_1.setText("Wis uit");
    	button_10.setText("Stop");
    	//button_9.setIcon(new ImageIcon(Test.class.getResource("/img/UK.jpg")));
    	lblInsertPin.setText("Voer alstublieft uw pincode in"); 
    	option.setText("Maak een keuze alstublieft"); 
    	btnNewButton.setText("Saldo"); 
    	btnWithdraw.setText("Opname"); 
    	btnFast.setText("Snel \u20AC 70");
    	btnStop.setText("Stop"); 
    	button_1.setText("Opname"); 
    	button_6.setText("Snel \u20AC 70");
    	button_7.setText("Stop"); 
    	lblBalance.setText("Saldo:"); 
    	lblAccount.setText("Rekening:"); 
    	lblPleaseSelectAn.setText("Selecteer een bedrag"); 
    	lblPressDTo.setText("Druk op D om een eigen bedrag in te voeren"); 
    	btnOther.setText("Ander"); 
    	button_5.setText("Stop"); 
    	PEA.setText("Vul alstublieft een bedrag in"); 
    	btnContinue.setText("Doorgaan"); 
    	btnClear.setText("Wis uit"); 
    	button_12.setText("Stop"); 
    	lblAmount.setText("Bedrag:"); 
    	lblNoteThisAtm.setText("Opmerking: Deze pinautomaat geeft alleen 10, 20 en 50 euro biljetten uit"); 
    	ThanksFor.setText("Bedankt dat u De Bank gekozen hebt"); 
    	lblNiceday.setText("Nog een prettige dag toegewenst!");
    	Language = false;
    	}
    		else if(!Language) {
    		//Set English
    		btnHome2.setText("Home");
   			btnHome3.setText("Home");
   			btnHome4.setText("Home");
   			//btnVeranderTaal.setIcon(new ImageIcon(Test.class.getResource("/img/Image 045.jpg")));
   			lblInsertCard.setText("Please Insert Your Card");
   			btnContinue_1.setText("Continue");
   			btnClear_1.setText("Clear");
   			button_10.setText("Abort");
   			//button_9.setIcon(new ImageIcon(Test.class.getResource("/img/Image 045.jpg")));
   			lblInsertPin.setText("Please Insert Your Pin Code"); 
   			option.setText("Please select an option"); 
   			btnNewButton.setText("Balance"); 
   			btnWithdraw.setText("Withdraw"); 
   			btnFast.setText("Fast \u20AC 70"); 
   			btnStop.setText("Abort"); 
   			button_1.setText("Withdraw");  
   			button_6.setText("Fast \u20AC 70"); 
   			button_7.setText("Abort"); 
   			lblBalance.setText("Balance:"); 
   			lblAccount.setText("Account:"); 
   			lblPleaseSelectAn.setText("Please select an amount"); 
   			lblPressDTo.setText("Press D to enter a custom amount"); 
   			btnOther.setText("Other"); 
   			button_5.setText("Abort"); 
   			PEA.setText("Please enter an amount"); 
   			btnContinue.setText("Continue"); 
   			btnClear.setText("Clear"); 
   			button_12.setText("Abort"); 
   			lblAmount.setText("Amount:"); 
   			lblNoteThisAtm.setText("NOTE: This ATM only returns 10, 20 and 50 euro bills."); 
   			ThanksFor.setText("Thank you"); 
   			lblNiceday.setText("Have a nice day!");
   			Language = true;
    		}
    	}
	}