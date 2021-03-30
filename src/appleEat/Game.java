/**
 * 
 */
package appleEat;

import java.awt.Color;
import java.awt.FlowLayout;

import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
//import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 * @author USER
 *
 */

public class Game extends JPanel implements KeyListener,ActionListener,Runnable,MouseListener{
	static int sec = 10;
	static int score = 0;
	static JLabel lb1 = new JLabel();
	static JLabel lb2 = new JLabel();
	static JLabel lb3 = new JLabel();
	static JLabel lb4 = new JLabel();
	static JLabel lb5 = new JLabel();
	
	public ImageIcon apple1;
	public ImageIcon apple2;
	public ImageIcon apple3;
	public ImageIcon apple4;
	public ImageIcon apple5;
	ImageIcon play_sign_0 = new ImageIcon("resourse/play_sign_0.png");
	ImageIcon play_sign_1 = new ImageIcon("resourse/play_sign_1.png");
	ImageIcon how_play_sign_0 = new ImageIcon("resourse/how_play_sign_0.png");
	ImageIcon how_play_sign_1 = new ImageIcon("resourse/how_play_sign_1.png");
	
	Object[] AppleArray = {apple1=new ImageIcon("resourse/apple(125x155).png"),apple2=new ImageIcon("resourse/apple(125x155).png"),apple3=new ImageIcon("resourse/apple(125x155).png"),apple4=new ImageIcon("resourse/apple(125x155).png"),apple5=new ImageIcon("resourse/apple(125x155).png")}; 
	/**
	 * 
	 */

	/**
	 * @param args
	 */
	Timer timer = new Timer(1000, this);
	
	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		JFrame frame = new JFrame("Apple Eater");
		//String timeover;
		//JLabel label = new JLabel("time : "+timeover);
		
		
		frame.setBounds(400, 200, 720, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		GamePanel panel = new GamePanel();
		frame.add(panel);
		JLabel label = new JLabel("Time : ");
		label.setFont(new Font("arial",Font.BOLD,30));
	    //panel.add(label);
	    //label.setText(sec);
		//lb1.setBackground(Color.orange);
		//lb1.setVisible(true);
		panel.add(lb1);
		panel.add(lb2);
		panel.add(lb3);
		panel.add(lb4);
		panel.add(lb5);
		
		lb1.setBounds(40, 180, 166, 67);
		//lb1.addMouseListener(MouseEvent e);
	    panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		frame.setVisible(true);
		
		
		
        
	}

	@Override
	public void run() {
		// TODO 自動產生的方法 Stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動產生的方法 Stub
		sec--;
		
	}
    
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO 自動產生的方法 Stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO 自動產生的方法 Stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO 自動產生的方法 Stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自動產生的方法 Stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動產生的方法 Stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動產生的方法 Stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自動產生的方法 Stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動產生的方法 Stub
		
	}

	


}