import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.LineBorder;



import java.awt.Color;

public class RobotGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField1;
	private double sum = 0;
    Timer timer;
	/**
	 * Create the frame.
	 */
	public RobotGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 408);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setForeground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelup = new JPanel();
		panelup.setBackground(new Color(30, 144, 255));
		panelup.setForeground(new Color(30, 144, 255));
		contentPane.add(panelup, BorderLayout.NORTH);
		//panelup.setLayout(null);
		JLabel lblNewLabel = new JLabel("Please select an option:");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		panelup.add(lblNewLabel);
		
		JPanel panelbot = new JPanel();
		panelbot.setBackground(new Color(30, 144, 255));
		panelbot.setForeground(new Color(30, 144, 255));
		contentPane.add(panelbot, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_1 = new JLabel("Option selected:");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panelbot.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		panelbot.add(textField);
		textField.setColumns(10);
		timer = new Timer();
		timer.schedule(new InactiveTimer(), 30000);
		JButton btnNewButton = new JButton("confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timer.cancel();
				Usertime();
			try{
				
				int i =Integer.parseInt(textField.getText());
				RobotInterface ri = new RobotInterface(i);
				ri.load();
				if(i>0 && i<=5){
				JFrame order = new JFrame();
				order.setBounds(100, 100, 769, 408);
				order.setVisible(true);
				JPanel contentPane1 = new JPanel();
				contentPane1 = new JPanel();
				contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
				contentPane1.setLayout(new BorderLayout(0, 0));
				contentPane1.setVisible(true);
				contentPane1.setBackground(new Color(30, 144, 255));
				order.getContentPane().add(contentPane1);
				
				JPanel opanelup = new JPanel();
				contentPane1.add(opanelup, BorderLayout.NORTH);
				opanelup.setBackground(new Color(30, 144, 255));
				JLabel lb = new JLabel("Please select a dish to order:");
				lb.setFont(new Font("Calibri", Font.BOLD, 30));
				opanelup.add(lb);
				
				JPanel opanelbot = new JPanel();
				opanelbot.setBackground(new Color(30, 144, 255));
				contentPane1.add(opanelbot, BorderLayout.SOUTH);
				JLabel lb_1 = new JLabel("Option selected:");
				lb_1.setHorizontalAlignment(SwingConstants.RIGHT);
				opanelbot.add(lb_1);
				textField1 = new JTextField();
				textField1.setHorizontalAlignment(SwingConstants.LEFT);
				opanelbot.add(textField1);
				textField1.setColumns(10);
				JButton btn = new JButton("confirm order");
				btn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						timer.cancel();
						Usertime();
						try{
					    
						int o = Integer.parseInt(textField1.getText());
						switch(o){
						case 1:
							ri.dishlist.get(0).getPrice();
							int s1 = ri.dishlist.get(0).getSurpuls();
							if(s1>=1){
							ri.save(s1-1,0);
							}else{
							ri.save(0,0);	
							}
							if(ri.dishlist.get(0).getSurpuls()==0){
								lb.setText("The choice is not available. Please select again:");
								
							}else{
								int n = JOptionPane.showConfirmDialog(null, "Do you confirm?", "Tips",JOptionPane.YES_NO_OPTION);
								timer.cancel();
								Usertime();
								if(n==0){
								  JOptionPane.showMessageDialog(null,"Order success");
								  timer.cancel();
								  Usertime();
								  sum = sum + ri.dishlist.get(0).getPrice();
								  int i = (int)(Math.random()*3);
								  JFrame joke = new JFrame();
								  joke.setVisible(true);
								  joke.setBounds(100, 100, 633, 351);
								  JPanel jo = new JPanel();
								  jo.setLayout(new BorderLayout(0, 0));
								  joke.getContentPane().add(jo);
								  JTextArea jt = new JTextArea();
								  jt.setBounds(100, 100, 500, 100);
								  jt.setLineWrap(true);
								  jt.setEditable(false);
								  ri.loadjoke();
								  jt.setText(ri.jokelist.get(i));
								  jt.setFont(new Font("Calibri", Font.BOLD, 15));
								  jo.add(jt,BorderLayout.CENTER);
								  JButton bt = new JButton("back");
								  bt.addActionListener(new ActionListener(){
									    
									@Override
									public void actionPerformed(ActionEvent arg0) {
										timer.cancel();
										Usertime();
										joke.dispose();
										
									}
									  
								  });
								  jo.add(bt,BorderLayout.SOUTH);
								}else{
								JOptionPane.showMessageDialog(null,"Canel the order success");
								timer.cancel();
								Usertime();
								ri.save(s1, 0);
								}
							}
							break;
						case 2:
							ri.dishlist.get(1).getPrice();
							int s2 = ri.dishlist.get(1).getSurpuls();
							if(s2>=1){
							ri.save(s2-1,1);
							}else{
							ri.save(0,1);	
							}
							if(ri.dishlist.get(1).getSurpuls()==0){
								lb.setText("The choice is not available. Please select again:");
							}else{
								int n = JOptionPane.showConfirmDialog(null, "Do you confirm?", "Tips",JOptionPane.YES_NO_OPTION);
								timer.cancel();
								Usertime();
								if(n==0){
								  JOptionPane.showMessageDialog(null,"Order success");
								  timer.cancel();
								  Usertime();
								  sum = sum + ri.dishlist.get(1).getPrice();
								  int i = (int)(Math.random()*3);
								  JFrame joke = new JFrame();
								  joke.setVisible(true);
								  joke.setBounds(100, 100, 633, 351);
								  JPanel jo = new JPanel();
								  jo.setLayout(new BorderLayout(0, 0));
								  joke.getContentPane().add(jo);
								  JTextArea jt = new JTextArea();
								  jt.setBounds(100, 100, 500, 100);
								  jt.setLineWrap(true);
								  jt.setEditable(false);
								  ri.loadjoke();
								  jt.setText(ri.jokelist.get(i));
								  jt.setFont(new Font("Calibri", Font.BOLD, 15));
								  jo.add(jt,BorderLayout.CENTER);
								  JButton bt = new JButton("back");
								  bt.addActionListener(new ActionListener(){

									@Override
									public void actionPerformed(ActionEvent arg0) {
										timer.cancel();
										Usertime();
										joke.dispose();
										
									}
									  
								  });
								  jo.add(bt,BorderLayout.SOUTH);
								}else{
								  JOptionPane.showMessageDialog(null,"Canel the order success");
								   timer.cancel();
								   Usertime();
								   ri.save(s2, 0);
								}
							}
							break;
						case 3:
							ri.dishlist.get(2).getPrice();
							int s3 = ri.dishlist.get(2).getSurpuls();
							if(s3>=1){
							ri.save(s3-1,2);
							}else{
							ri.save(0,2);	
							}
							if(ri.dishlist.get(2).getSurpuls()==0){
								lb.setText("The choice is not available. Please select again:");
							}else{
								int n = JOptionPane.showConfirmDialog(null, "Do you confirm?", "Tips",JOptionPane.YES_NO_OPTION);
								timer.cancel();
								Usertime();
								if(n==0){
								  JOptionPane.showMessageDialog(null,"Order success");
								  timer.cancel();
									Usertime();
								  sum = sum + ri.dishlist.get(2).getPrice();
								  int i = (int)(Math.random()*3);
								  JFrame joke = new JFrame();
								  joke.setVisible(true);
								  joke.setBounds(100, 100, 633, 351);
								  JPanel jo = new JPanel();
								  jo.setLayout(new BorderLayout(0, 0));
								  joke.getContentPane().add(jo);
								  JTextArea jt = new JTextArea();
								  jt.setBounds(100, 100, 500, 100);
								  jt.setLineWrap(true);
								  jt.setEditable(true);
								  ri.loadjoke();
								  System.out.println(ri.jokelist);
								  jt.setText(ri.jokelist.get(i));
								  jt.setFont(new Font("Calibri", Font.BOLD, 15));
								  jo.add(jt,BorderLayout.CENTER);
								  JButton bt = new JButton("back");
								  bt.addActionListener(new ActionListener(){

									@Override
									public void actionPerformed(ActionEvent arg0) {
										timer.cancel();
										Usertime();
										joke.dispose();
										
									}
									  
								  });
								  jo.add(bt,BorderLayout.SOUTH);
								}else{
								  JOptionPane.showMessageDialog(null,"Canel the order success");
								  timer.cancel();
								  Usertime();
								  ri.save(s3, 0);
								}
							}
							break;
						case 4:
							ri.dishlist.get(3).getPrice();
							int s4 = ri.dishlist.get(3).getSurpuls();
							if(s4>=1){
							ri.save(s4-1,3);
							}else{
							ri.save(0,3);	
							}
							if(ri.dishlist.get(3).getSurpuls()==0){
								lb.setText("The choice is not available. Please select again:");
							}else{
								int n = JOptionPane.showConfirmDialog(null, "Do you confirm?", "Tips",JOptionPane.YES_NO_OPTION);
								timer.cancel();
								Usertime();
								if(n==0){
								  JOptionPane.showMessageDialog(null,"Order success");
								  timer.cancel();
									Usertime();
								  sum = sum + ri.dishlist.get(3).getPrice();
								  int i = (int)(Math.random()*3);
								  JFrame joke = new JFrame();
								  joke.setVisible(true);
								  joke.setBounds(100, 100, 633, 351);
								  JPanel jo = new JPanel();
								  jo.setLayout(new BorderLayout(0, 0));
								  joke.getContentPane().add(jo);
								  JTextArea jt = new JTextArea();
								  jt.setBounds(100, 100, 500, 100);
								  jt.setLineWrap(true);
								  jt.setEditable(true);
								  ri.loadjoke();
								  jt.setText(ri.jokelist.get(i));
								  jt.setFont(new Font("Calibri", Font.BOLD, 15));
								  jo.add(jt,BorderLayout.CENTER);
								  JButton bt = new JButton("back");
								  bt.addActionListener(new ActionListener(){

									@Override
									public void actionPerformed(ActionEvent arg0) {
										timer.cancel();
										Usertime();
										joke.dispose();
										
									}
									  
								  });
								  jo.add(bt,BorderLayout.SOUTH);
								}else{
								JOptionPane.showMessageDialog(null,"Canel the order success");
								timer.cancel();
								Usertime();
									ri.save(s4, 0);
								}
							}
							break;
						case 5:
							ri.dishlist.get(4).getPrice();
							int s5 = ri.dishlist.get(4).getSurpuls();
							if(s5>=1){
							ri.save(s5-1,4);
							}else{
							ri.save(0,4);	
							}
							if(ri.dishlist.get(4).getSurpuls()==0){
								lb.setText("The choice is not available. Please select again:");
							}else{
								int n = JOptionPane.showConfirmDialog(null, "Do you confirm?", "Tips",JOptionPane.YES_NO_OPTION);
								timer.cancel();
								Usertime();
								if(n==0){
								  JOptionPane.showMessageDialog(null,"Order success");
								  timer.cancel();
									Usertime();
								  sum = sum + ri.dishlist.get(4).getPrice();
								  int i = (int)(Math.random()*3);
								  JFrame joke = new JFrame();
								  joke.setVisible(true);
								  joke.setBounds(100, 100, 633, 351);
								  JPanel jo = new JPanel();
								  jo.setLayout(new BorderLayout(0, 0));
								  joke.getContentPane().add(jo);
								  JTextArea jt = new JTextArea();
								  jt.setBounds(100, 100, 500, 100);
								  jt.setLineWrap(true);
								  jt.setEditable(false);
								  ri.loadjoke();
								  jt.setText(ri.jokelist.get(i));
								  jt.setFont(new Font("Calibri", Font.BOLD, 15));
								  jo.add(jt,BorderLayout.CENTER);
								  JButton bt = new JButton("back");
								  bt.addActionListener(new ActionListener(){

									@Override
									public void actionPerformed(ActionEvent arg0) {
										timer.cancel();
										Usertime();
										joke.dispose();
										
									}
									  
								  });
								  jo.add(bt,BorderLayout.SOUTH);
								}else{
								JOptionPane.showMessageDialog(null,"Canel the order success");
								timer.cancel();
								Usertime();
									ri.save(s5, 0);
								}
							}
							break;
						case 6:
							ri.dishlist.get(5).getPrice();
							int s6 = ri.dishlist.get(5).getSurpuls();
							if(s6>=1){
							ri.save(s6-1,5);
							}else{
							ri.save(0,5);	
							}
							if(ri.dishlist.get(5).getSurpuls()==0){
								lb.setText("The choice is not available. Please select again:");
							}else{
								int n = JOptionPane.showConfirmDialog(null, "Do you confirm?", "Tips",JOptionPane.YES_NO_OPTION);
								timer.cancel();
								Usertime();
								if(n==0){
								  JOptionPane.showMessageDialog(null,"Order success");
								  timer.cancel();
									Usertime();
								  sum = sum + ri.dishlist.get(5).getPrice();
								  int i = (int)(Math.random()*3);
								  JFrame joke = new JFrame();
								  joke.setVisible(true);
								  joke.setBounds(100, 100, 633, 351);
								  JPanel jo = new JPanel();
								  jo.setLayout(new BorderLayout(0, 0));
								  joke.getContentPane().add(jo);
								  JTextArea jt = new JTextArea();
								  jt.setBounds(100, 100, 500, 100);
								  jt.setLineWrap(true);
								  jt.setEditable(true);
								  ri.loadjoke();
								  jt.setText(ri.jokelist.get(i));
								  jt.setFont(new Font("Calibri", Font.BOLD, 15));
								  jo.add(jt,BorderLayout.CENTER);
								  JButton bt = new JButton("back");
								  //bt.setHorizontalAlignment(SwingConstants.BOTTOM);
								  bt.addActionListener(new ActionListener(){
                                    
									@Override
									public void actionPerformed(ActionEvent arg0) {
										timer.cancel();
										Usertime();
										joke.dispose();
										
									}
									  
								  });
								  jo.add(bt,BorderLayout.SOUTH);
								}else{
								JOptionPane.showMessageDialog(null,"Canel the order success");
								timer.cancel();
								Usertime();
									ri.save(s6, 0);
								}
							}
							break;
						}
						}catch(Exception ex){
							JOptionPane.showMessageDialog(null,"Order failed");
							ex.printStackTrace();
						}
					}
					});
				btn.setHorizontalAlignment(SwingConstants.LEFT);
				opanelbot.add(btn);
				
				JButton btn1 = new JButton("return to main menu");
				btn1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						timer.cancel();
						order.dispose();
					}
					});
				btn1.setHorizontalAlignment(SwingConstants.LEFT);
				opanelbot.add(btn1);
				
				JPanel opanelcen = new JPanel();
				opanelcen.setBackground(new Color(30, 144, 255));
				contentPane1.add(opanelcen, BorderLayout.CENTER);
				GridLayout gl1 = new GridLayout(2,3);
				gl1.setHgap(5);
				gl1.setVgap(5);
				opanelcen.setLayout(gl1);
				
				
				JPanel panel_fish1 = new JPanel();
				panel_fish1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panel_fish1.setBackground(new Color(72, 209, 204));
				opanelcen.add(panel_fish1);
				panel_fish1.setLayout(null);
				
				JLabel lb_2 = new JLabel("1");
				lb_2.setFont(new Font("Calibri", Font.BOLD, 30));
				lb_2.setHorizontalAlignment(SwingConstants.CENTER);
				lb_2.setBounds(87, 30, 72, 34);
				panel_fish1.add(lb_2);
				
				JLabel lb_3 = new JLabel(ri.dishlist.get(0).getDname());
				lb_3.setHorizontalAlignment(SwingConstants.CENTER);
				lb_3.setBounds(70, 71, 120, 18);
				panel_fish1.add(lb_3);
				
				JPanel panel_meat1 = new JPanel();
				panel_meat1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panel_meat1.setBackground(new Color(255, 165, 0));
				opanelcen.add(panel_meat1);
				panel_meat1.setLayout(null);
				
				JLabel lblNewLabel_12 = new JLabel(Integer.toString(ri.dishlist.get(0).getPrice())+" "+"yuan");
				lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_12.setBounds(87, 100, 72, 18);
				panel_fish1.add(lblNewLabel_12);
				
				JLabel lb_4 = new JLabel("2");
				lb_4.setFont(new Font("Calibri", Font.BOLD, 30));
				lb_4.setHorizontalAlignment(SwingConstants.CENTER);
				lb_4.setBounds(88, 33, 72, 27);
				panel_meat1.add(lb_4);
				
				JLabel lb_5 = new JLabel(ri.dishlist.get(1).getDname());
				lb_5.setHorizontalAlignment(SwingConstants.CENTER);
				lb_5.setBounds(60, 71, 140, 18);
				panel_meat1.add(lb_5);
				
				JLabel lblNewLabel_13 = new JLabel(Integer.toString(ri.dishlist.get(1).getPrice())+" "+"yuan");
				lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_13.setBounds(87, 102, 72, 18);
				panel_meat1.add(lblNewLabel_13);
				
				JPanel panel_rice1 = new JPanel();
				panel_rice1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panel_rice1.setBackground(new Color(0, 255, 255));
				opanelcen.add(panel_rice1);
				panel_rice1.setLayout(null);
				
				JLabel lb_6 = new JLabel("3");
				lb_6.setHorizontalAlignment(SwingConstants.CENTER);
				lb_6.setFont(new Font("Calibri", Font.BOLD, 30));
				lb_6.setBounds(88, 26, 72, 37);
				panel_rice1.add(lb_6);
				
				JLabel lb_7 = new JLabel(ri.dishlist.get(2).getDname());
				lb_7.setHorizontalAlignment(SwingConstants.CENTER);
				lb_7.setBounds(60, 71, 140, 18);
				panel_rice1.add(lb_7);
				
				JLabel lblNewLabel_14 = new JLabel(Integer.toString(ri.dishlist.get(2).getPrice())+" "+"yuan");
				lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_14.setBounds(87, 102, 72, 18);
				panel_rice1.add(lblNewLabel_14);
				
				JPanel panel_noddle1 = new JPanel();
				panel_noddle1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panel_noddle1.setBackground(new Color(255, 250, 205));
				opanelcen.add(panel_noddle1);
				panel_noddle1.setLayout(null);
				
				JLabel lb_8 = new JLabel("4");
				lb_8.setHorizontalAlignment(SwingConstants.CENTER);
				lb_8.setFont(new Font("Calibri", Font.BOLD, 30));
				lb_8.setBounds(84, 26, 72, 37);
				panel_noddle1.add(lb_8);
				
				JLabel lb_9 = new JLabel(ri.dishlist.get(3).getDname());
				lb_9.setHorizontalAlignment(SwingConstants.CENTER);
				lb_9.setBounds(50, 71, 140, 18);
				panel_noddle1.add(lb_9);
				
				JLabel lblNewLabel_15 = new JLabel(Integer.toString(ri.dishlist.get(3).getPrice())+" "+"yuan");
				lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_15.setBounds(87, 102, 72, 18);
				panel_noddle1.add(lblNewLabel_15);
				
				JPanel panel_drink1 = new JPanel();
				panel_drink1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panel_drink1.setBackground(new Color(255, 0, 255));
				opanelcen.add(panel_drink1);
				panel_drink1.setLayout(null);
				
				JLabel lb_10 = new JLabel("5");
				lb_10.setFont(new Font("Calibri", Font.BOLD, 30));
				lb_10.setHorizontalAlignment(SwingConstants.CENTER);
				lb_10.setBounds(87, 30, 72, 29);
				panel_drink1.add(lb_10);
				
				JLabel lb_11 = new JLabel(ri.dishlist.get(4).getDname());
				lb_11.setHorizontalAlignment(SwingConstants.CENTER);
				lb_11.setBounds(55, 71, 140, 18);
				panel_drink1.add(lb_11);
				
				JLabel lblNewLabel_16 = new JLabel(Integer.toString(ri.dishlist.get(4).getPrice())+" "+"yuan");
				lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_16.setBounds(87, 102, 72, 18);
				panel_drink1.add(lblNewLabel_16);
				
				JPanel pan_5 = new JPanel();
				pan_5.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				pan_5.setBackground(new Color(127, 255, 0));
				opanelcen.add(pan_5);
				pan_5.setLayout(null);
				
				JLabel lb_12 = new JLabel("6");
				lb_12.setFont(new Font("Calibri", Font.BOLD, 30));
				lb_12.setHorizontalAlignment(SwingConstants.CENTER);
				lb_12.setBounds(87, 30, 72, 29);
				pan_5.add(lb_12);
				
				JLabel lb_13 = new JLabel(ri.dishlist.get(5).getDname());
				lb_13.setHorizontalAlignment(SwingConstants.CENTER);
				lb_13.setBounds(55, 71, 140, 18);
				pan_5.add(lb_13);
				
				JLabel lblNewLabel_17 = new JLabel(Integer.toString(ri.dishlist.get(5).getPrice())+" "+"yuan");
				lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_17.setBounds(87, 102, 72, 18);
				pan_5.add(lblNewLabel_17);

				
			   }else{
				   JOptionPane.showMessageDialog(null,"Option error. Please option again.");
			   }
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null,"Option error. Please option again.");
			}	
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		panelbot.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("pay");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timer.cancel();
				dispose();
				JFrame pay = new JFrame("Payment");
				pay.setBounds(100, 100, 769, 408);
				pay.setVisible(true);
				JPanel jp = new JPanel();
				jp.setLayout(null);
				pay.getContentPane().add(jp);
				JLabel pl = new JLabel();
				pl.setText(Double.toString(sum)+" "+"yuan");
				pl.setFont(new Font("Calibri", Font.BOLD, 34));
				pl.setBounds(340, 100, 404, 33);
				jp.add(pl);
				JButton leave = new JButton("leave restaurant");
				leave.setBounds(320, 250, 113, 27);
				leave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//System.exit(0);
						  RobotInterface r = new RobotInterface();
						  int i = (int)(Math.random()*3);
						  JFrame farewell = new JFrame();
						  farewell.setVisible(true);
						  farewell.setBounds(100, 100, 769, 408);
						  JPanel jo1 = new JPanel();
						  jo1.setLayout(null);
						  farewell.getContentPane().add(jo1);
						  JLabel jt1 = new JLabel();
						  jt1.setBounds(200, 100, 404, 33);
						  //jt1.setLineWrap(true);
						  //jt1.setEditable(false);
						  jt1.setHorizontalAlignment(SwingConstants.CENTER);
						  r.loadfarewell();
						  jt1.setText(r.farelist.get(i));
						  jt1.setFont(new Font("Calibri", Font.BOLD, 30));
						  jo1.add(jt1,BorderLayout.CENTER);
						  JButton bt1 = new JButton("leave restaurant");
						  bt1.setBounds(320, 250, 113, 27);
						  bt1.addActionListener(new ActionListener(){
                           
							@Override
							public void actionPerformed(ActionEvent arg0) {
								timer.cancel();
								Usertime();
								System.exit(0);
								
							}
							  
						  });
						  jo1.add(bt1);
					}
					});
				jp.add(leave);
			}
		});
		panelbot.add(btnNewButton_1);
		
		JPanel panelcen = new JPanel();
		panelcen.setBackground(new Color(30, 144, 255));
		contentPane.add(panelcen, BorderLayout.CENTER);
		GridLayout gl = new GridLayout(2,3);
		gl.setHgap(5);
		gl.setVgap(5);
		panelcen.setLayout(gl);
		
		
		JPanel panel_fish = new JPanel();
		panel_fish.setBackground(new Color(72, 209, 204));
		panel_fish.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelcen.add(panel_fish);
		panel_fish.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("1");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(87, 30, 72, 34);
		panel_fish.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("fish");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(87, 71, 72, 18);
		panel_fish.add(lblNewLabel_3);
		
		
		JPanel panel_meat = new JPanel();
		panel_meat.setBackground(new Color(255, 165, 0));
		panel_meat.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelcen.add(panel_meat);
		panel_meat.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("2");
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(88, 33, 72, 27);
		panel_meat.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("meat");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(88, 73, 72, 18);
		panel_meat.add(lblNewLabel_5);
		
		JPanel panel_rice = new JPanel();
		panel_rice.setBackground(new Color(0, 255, 255));
		panel_rice.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelcen.add(panel_rice);
		panel_rice.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("3");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNewLabel_6.setBounds(88, 26, 72, 37);
		panel_rice.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("rice");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(88, 76, 72, 18);
		panel_rice.add(lblNewLabel_7);
		
		JPanel panel_noddle = new JPanel();
		panel_noddle.setBackground(new Color(255, 250, 205));
		panel_noddle.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelcen.add(panel_noddle);
		panel_noddle.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("4");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNewLabel_8.setBounds(84, 26, 72, 37);
		panel_noddle.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("noddle");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(84, 76, 72, 18);
		panel_noddle.add(lblNewLabel_9);
		
		JPanel panel_drink = new JPanel();
		panel_drink.setBackground(new Color(255, 0, 255));
		panel_drink.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelcen.add(panel_drink);
		panel_drink.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("5");
		lblNewLabel_10.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(87, 30, 72, 29);
		panel_drink.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("drink");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(87, 79, 72, 18);
		panel_drink.add(lblNewLabel_11);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(127, 255, 0));
		panelcen.add(panel_5);
		panel_5.setLayout(null);
	}
	
	/**
	 * Timer  
	 */
	
	public void Usertime(){
		timer=new Timer();
		timer.schedule(new InactiveTimer(), 30000);
	}
	
	/**
	 * 
	 * Inner class extends the TimerTask
	 *
	 */
	public class InactiveTimer extends TimerTask{

		@Override
		public void run() {
		    
			JFrame sleep = new JFrame();
			sleep.setVisible(true);
			sleep.setBounds(100, 100, 769, 408);
			JPanel panel = new JPanel();
			panel.setLayout(null);
			
			JLabel jb = new JLabel("Waiting for your order:");
			jb.setFont(new Font("Calibri", Font.BOLD, 34));
			jb.setBounds(230, 100, 404, 33);
			panel.add(jb);
			sleep.getContentPane().add(panel);
			
			JButton wake = new JButton("wake");
			wake.setBounds(320, 250, 113, 27);
			wake.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					 timer.cancel();
					 Usertime();
					 sleep.dispose();
				}
				
			});
			panel.add(wake);
		}	
	}

}
