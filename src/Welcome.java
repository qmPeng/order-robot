import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Welcome extends JFrame {

	private JPanel contentPane;
	static ArrayList<String> word = new ArrayList<String>();
	static int random = 0;
	Timer timer = new Timer();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
				try {
					Welcomeword();
					Welcome frame = new Welcome();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			
	}

	/**
	 * Create the frame.
	 */
	public Welcome() {
		Usertime();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		random = (int)(Math.random()*4);
		JButton btnNewButton = new JButton(word.get(random));
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 34));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timer.cancel();
				RobotGUI robotgui = new RobotGUI();
				dispose();
				
			}
		});
		btnNewButton.setBounds(0, 0, 615, 304);
		contentPane.add(btnNewButton);
	}
	/**
	 * read welcome word
	 */
	public static void Welcomeword(){
		
		try{
		File welcome = new File("../File/welcome.txt");
		FileReader rew = new FileReader(welcome);
		BufferedReader brew = new BufferedReader(rew);
		
		String line = null;
		while((line = brew.readLine())!=null){
			word.add(line);
		}
		}catch(Exception ex){
		    ex.printStackTrace();	
		}
	}
	
	/**
	 * timer
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
			sleep.add(panel);
			
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
