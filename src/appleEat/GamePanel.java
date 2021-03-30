/**
 * 
 */

package appleEat;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.util.TimerTask;
/**
 * 
 * @author USER
 *
 */
public class GamePanel extends Game implements MouseListener{

	    
		ImageIcon player = new ImageIcon("resourse/concentric(247x247).png");
		ImageIcon apple = new ImageIcon("resourse/apple(125x155).png");
		ImageIcon apple_finish = new ImageIcon("resourse/apple_finish.png");
		ImageIcon newton_0 = new ImageIcon("resourse/newton_0.png");
		ImageIcon newton_1 = new ImageIcon("resourse/newton_1.png");
		ImageIcon start_bg = new ImageIcon("resourse/start_bg.png");
		ImageIcon sign = new ImageIcon("resourse/sign.png");
		ImageIcon choice = new ImageIcon("resourse/choice.png");
		Image imageCursor = Toolkit.getDefaultToolkit().getImage("resourse/concentric_f.png"); 
		ImageIcon sure = new ImageIcon("resourse/sure.png");
		ImageIcon full = new ImageIcon("resourse/full.png");
		ImageIcon select = new ImageIcon("resourse/select.png");
		ImageIcon nul = new ImageIcon("resourse/null.png");
		
		Random ran = new Random();
		int appleLocationY;
		int appleLocationY1;
		int appleLocationY2;
		int appleLocationY3;
		int appleLocationY4;
		int appleLocationY5;
		int appleLocationX = ran.nextInt(650);
		int appleNum = ran.nextInt(5);
		boolean isStarted = false;
		boolean yes =false;
		boolean no =false;
		int wait=0;
		int book_Y = 576;
		
		boolean GameOver = false;
		boolean toStart = false;
		boolean GameOver_onClick = false;
		int sup ;
		int a=0;
		
		public static int timeout=60;
		public GamePanel(){
			this.addKeyListener(this);
			this.setFocusable(true);
		    this.addMouseListener(this);
	        
		    
		    
		}
		
		
		int[] LocationArray = {ran.nextInt(150)+ran.nextInt(appleLocationX),ran.nextInt(300)+ran.nextInt(appleLocationX),ran.nextInt(650)+ran.nextInt(appleLocationX),ran.nextInt(400)+ran.nextInt(appleLocationX),ran.nextInt(550)+ran.nextInt(appleLocationX)};
		int[] SpeedArray = {};
		
       
		//繪畫物件在畫布上
        
		public void paint(Graphics g) {
			super.paint(g);
			
			//遊戲選單畫面
			if(toStart==false) {
				//this.setBackground(new Color(187,255,255));
				start_bg.paintIcon(this, g, 0, 0);
				newton_1.paintIcon(this, g, 420, 300);
				sign.paintIcon(this, g, 80, 150);
				play_sign_0.paintIcon(this, g, 40, 180);
				how_play_sign_0.paintIcon(this, g, 40, 290);
			}
			
			//遊戲中畫面
			//設定背景顏色
			if(toStart==true) {
			   this.setBackground(new Color(187,255,255));
			}
			//自訂鼠標圖案
			if(a==0) {
			   Image imageCursor = Toolkit.getDefaultToolkit().getImage("resourse/concentric_f.png"); 
			   setCursor(Toolkit.getDefaultToolkit().createCustomCursor( imageCursor, new Point(0, 0), "cursor"));
			}
			//繪製開始字樣
			if(isStarted==false&&GameOver==false&&toStart==true) {
				g.setColor(Color.BLACK);
				g.setFont(new Font("arial",Font.BOLD,30));
				g.drawString("Press Space to start / pause game", 120, 188);
			}
			//啟動計時器
			if(toStart==true) {
				//isStarted=true;
				timer.start();
				
			}
			
			//當遊戲暫停，停止計時器
			if(isStarted==false) {
				timer.stop();
			}
			//時間結束，停止計時器，並顯示Game Over字樣
			if(sec<=0) {
				timer.stop();
				isStarted=false;
				GameOver=true;
				//g.clipRect(0, 0, 720, 576);
				//g.setClip(0, 0, 720, 576);
				g.setColor(Color.BLACK);
				g.setFont(new Font("arial",Font.BOLD,60));
				g.drawString("Time  Up!", 220, 150);
				g.setFont(new Font("arial",Font.BOLD,40));
				g.drawString("Your  Score : "+score, 210, 250);
				g.setFont(new Font("arial",Font.BOLD,20));
				g.drawString("Please chick the Mouse to do next", 190, 400);
			}
			//設定GameOver書往上動畫
			if((GameOver_onClick==true)&&(book_Y>=41)) {
				book_Y-=1.5;
				repaint();
			}
			if((sup>0)) {
				
				
				choice.paintIcon(this, g, 10, book_Y);
				
				repaint();
			}
			
			//設定當點選Sure!會跑出勾勾圖案並重新遊戲
			if(yes==true&&GameOver==true) {
				
				select.paintIcon(this, g, 370, 200);
				
				//timer.start();
				//timer.addActionListener(new subpanel());
				if(wait<1) {
			    
			    
				isStarted=true;
				
				
				/*try {
					Thread.sleep(1500); //1000 毫秒，也就是1秒.
				} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
				
				}*/
				
				sup=0;
				sec=10;
				score=0;
				yes=false;
				GameOver=false;
				book_Y=576;
				GameOver_onClick=false;
				apple1.setImage(apple.getImage());
				apple2.setImage(apple.getImage());
				apple3.setImage(apple.getImage());
				apple4.setImage(apple.getImage());
				apple5.setImage(apple.getImage());
				appleLocationY1=0;
				appleLocationY2=0;
				appleLocationY3=0;
				appleLocationY4=0;
				appleLocationY5=0;
				LocationArray[0]=ran.nextInt(150)+ran.nextInt(appleLocationX);
				LocationArray[1]=ran.nextInt(150)+ran.nextInt(appleLocationX);
				LocationArray[2]=ran.nextInt(150)+ran.nextInt(appleLocationX);
				LocationArray[3]=ran.nextInt(150)+ran.nextInt(appleLocationX);
				LocationArray[4]=ran.nextInt(150)+ran.nextInt(appleLocationX);
				repaint();
				}
			}
			if(no==true&&GameOver==true) {
				//select.paintIcon(this, g, 370, 200);
				sup=0;
				sec=30;
				score=0;
				toStart=false;
				no=false;
				GameOver=false;
				book_Y=576;
				GameOver_onClick=false;
				apple1.setImage(apple.getImage());
				apple2.setImage(apple.getImage());
				apple3.setImage(apple.getImage());
				apple4.setImage(apple.getImage());
				apple5.setImage(apple.getImage());
				appleLocationY1=0;
				appleLocationY2=0;
				appleLocationY3=0;
				appleLocationY4=0;
				appleLocationY5=0;
				LocationArray[0]=ran.nextInt(150)+ran.nextInt(appleLocationX);
				LocationArray[1]=ran.nextInt(150)+ran.nextInt(appleLocationX);
				LocationArray[2]=ran.nextInt(150)+ran.nextInt(appleLocationX);
				LocationArray[3]=ran.nextInt(150)+ran.nextInt(appleLocationX);
				LocationArray[4]=ran.nextInt(150)+ran.nextInt(appleLocationX);
				repaint();
			}
			
        	//設定蘋果隨機掉落
        	if(isStarted==true&&toStart==true) {
        		Timer timer = new Timer(1000, this);
        		
        		
        		
        	    //設定計分以及計時器UI
        		g.setColor(Color.BLACK);
				g.setFont(new Font("arial",Font.BOLD,30));
				g.drawString("Time : "+ sec, 20, 40);
				g.drawString("Score : "+ score, 20, 70);
				
				
				
		
				
				   
					

	
        	
        		//apple.paintIcon(this, g, appleLocationX, appleLocationY);
        		//設定掉落的隨機速度
        		//appleLocationY=appleLocationY+ran.nextInt(2)+1;	
        		appleLocationY1 = appleLocationY1+ran.nextInt(2)+ran.nextInt(3);
        		appleLocationY2 = appleLocationY2+ran.nextInt(2)+ran.nextInt(3);
        		appleLocationY3 = appleLocationY3+ran.nextInt(2)+ran.nextInt(3);
        		appleLocationY4 = appleLocationY4+ran.nextInt(2)+ran.nextInt(3);
        		appleLocationY5 = appleLocationY5+ran.nextInt(2)+ran.nextInt(3);
        		
        		((ImageIcon) AppleArray[0]).paintIcon(this,g,LocationArray[0],appleLocationY1);
        		((ImageIcon) AppleArray[1]).paintIcon(this,g,LocationArray[1],appleLocationY2);
        		((ImageIcon) AppleArray[2]).paintIcon(this,g,LocationArray[2],appleLocationY3);
        		((ImageIcon) AppleArray[3]).paintIcon(this,g,LocationArray[3],appleLocationY4);
        		((ImageIcon) AppleArray[4]).paintIcon(this,g,LocationArray[4],appleLocationY5);
        		
        		
        		
				//((ImageIcon) AppleArray[0]).paintIcon(this,g,100,200);
        		if(appleLocationY1>576) {
        			apple1.setImage(apple.getImage());
        			appleLocationY1=0;
        			LocationArray[0]=ran.nextInt(250)+ran.nextInt(appleLocationX);
        			((ImageIcon) AppleArray[0]).paintIcon(this,g,LocationArray[0],appleLocationY1);
        		}
        		if(appleLocationY2>576) {
        			apple2.setImage(apple.getImage());
        			appleLocationY2=0;
        			LocationArray[1]=ran.nextInt(340)+ran.nextInt(appleLocationX);
        			((ImageIcon) AppleArray[1]).paintIcon(this,g,LocationArray[1],appleLocationY2);
        		}
        		if(appleLocationY3>576) {
        			apple3.setImage(apple.getImage());
        			appleLocationY3=0;
        			LocationArray[2]=ran.nextInt(180)+ran.nextInt(appleLocationX);
        			((ImageIcon) AppleArray[2]).paintIcon(this,g,LocationArray[2],appleLocationY3);
        		}
        		if(appleLocationY4>576) {
        			apple4.setImage(apple.getImage());
        			appleLocationY4=0;
        			LocationArray[3]=ran.nextInt(570)+ran.nextInt(appleLocationX);
        			((ImageIcon) AppleArray[3]).paintIcon(this,g,LocationArray[3],appleLocationY4);
        		}
        		if(appleLocationY5>576) {
        			apple5.setImage(apple.getImage());
        			appleLocationY5=0;
        			LocationArray[4]=ran.nextInt(650)+ran.nextInt(appleLocationX);
        			((ImageIcon) AppleArray[4]).paintIcon(this,g,LocationArray[4],appleLocationY5);
        		}
        		repaint();
        		
        		
        		/*if(GameOver==false) {
        			//String result = drop[ran.nextInt(2)];
            		//if(result=="true") {
        			    
            			player.paintIcon(this, g, appleLocationX, appleLocationY);
                		appleLocationY=appleLocationY+ran.nextInt(2)+1;
                		//repaint();
            		//}
        		}*/

        	    		
        	}
		
		      
		}

        
		
		@Override
		public void keyPressed(KeyEvent args2) {
			// TODO 自動產生的方法 Stub
        	
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO 自動產生的方法 Stub
			int keycode = e.getKeyCode();
        	if((keycode==KeyEvent.VK_SPACE)/*&&(toStart==true)*/) {
        		isStarted = !isStarted;
        		
        	}
        	repaint();
		}
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO 自動產生的方法 Stub
			
		}

		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自動產生的方法 Stub
			sec--;
			wait--;
			
		}
		public void actionPerformed1(ActionEvent e) {
			// TODO 自動產生的方法 Stub
			
			wait--;
			
		}

		public void mouseClicked(MouseEvent m) {
			// TODO 自動產生的方法 Stub
			
		}



		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO 自動產生的方法 Stub
			/*play_sign_0.setImage(play_sign_1.getImage());
			repaint();*/
			/*if(toStart==false) {
				if(((40<=e.getX())&&(e.getX()<=206))&&((180<=e.getY())&&(e.getY()<=247))) {
					play_sign_0.setImage(play_sign_1.getImage());
					
					
					
				}
				repaint();
			}*/
			/*if(((40<=e.getX())&&(e.getX()<=206))&&((180<=e.getY())&&(e.getY()<=247))) {
				play_sign_0.setImage(play_sign_1.getImage());
			}
			repaint();*/
			
			Image imageCursor = Toolkit.getDefaultToolkit().getImage("resourse/concentric(247x247).png"); 
			setCursor(Toolkit.getDefaultToolkit().createCustomCursor( imageCursor, new Point(0, 0), "cursor"));
			repaint();
		}



		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 自動產生的方法 Stub
			/*play_sign_0.setImage(play_sign_0.getImage());
			repaint();*/
			/*if(toStart==false) {
				if((40<=e.getX()&&e.getX()<=206)&&((180<=e.getY())&&(e.getY()<=247))) {
					play_sign_0.setImage(play_sign_1.getImage());
				}
			}*/
		}



		@Override
		//設定滑鼠點擊蘋果能加分並且蘋果會更改圖示
		public void mousePressed(MouseEvent m) {
			// TODO 自動產生的方法 Stub
			if(isStarted==true) {
				
				if(m.getButton()==MouseEvent.BUTTON1) {
				if((LocationArray[0]<=m.getX())&&((m.getX()<=LocationArray[0]+62))&&((appleLocationY1<=m.getY())&&(m.getY()<=appleLocationY1+72))&&apple1.getImage()==apple.getImage()) {
					
					score++;
					apple1.setImage(apple_finish.getImage());
				}
				
				else if((LocationArray[1]<=m.getX())&&((m.getX()<=LocationArray[1]+62))&&((appleLocationY2<=m.getY())&&(m.getY()<=appleLocationY2+72))&&apple2.getImage()==apple.getImage()) {
					
					score++;
					apple2.setImage(apple_finish.getImage());
				}
				else if((LocationArray[2]<=m.getX())&&((m.getX()<=LocationArray[2]+62))&&((appleLocationY3<=m.getY())&&(m.getY()<=appleLocationY3+72))&&apple3.getImage()==apple.getImage()) {
					
					score++;
					apple3.setImage(apple_finish.getImage());
				}
				else if((LocationArray[3]<=m.getX())&&((m.getX()<=LocationArray[3]+62))&&((appleLocationY4<=m.getY())&&(m.getY()<=appleLocationY4+72))&&apple4.getImage()==apple.getImage()) {
					
					score++;
					apple4.setImage(apple_finish.getImage());
				}
				else if((LocationArray[4]<=m.getX())&&((m.getX()<=LocationArray[4]+62))&&((appleLocationY5<=m.getY())&&(m.getY()<=appleLocationY5+72))&&apple5.getImage()==apple.getImage()) {
					
					score++;
					apple5.setImage(apple_finish.getImage());
				}
				}
				}
			if(toStart==false) {
				if(m.getButton()==MouseEvent.BUTTON1) {
				  if(((40<=m.getX())&&(m.getX()<=206))&&((180<=m.getY())&&(m.getY()<=247))) {
					//play_sign_0.setImage(play_sign_1.getImage());
					
					toStart=true;
					isStarted=true;
					
				  }
				  repaint();
				}
				
			}
			if(GameOver==true) {
				if(m.getButton()==MouseEvent.BUTTON1) {
					sup=1;
					GameOver_onClick=true;
				}
			}
			repaint();
			/*Image imgCursor = Toolkit.getDefaultToolkit().getImage("resourse/concentric_f.png"); 
			setCursor(Toolkit.getDefaultToolkit().createCustomCursor( imgCursor, new Point(0, 0), "cursor"));
			repaint();*/
			if(book_Y==40) {
				if(m.getButton()==MouseEvent.BUTTON1) {
					if((((400<=m.getX())&&(m.getX()<=500))&&((180<=m.getY())&&(m.getY()<=240)))&&no==false) {
						//wait=1;
						yes=true;
						/*try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO 自動產生的 catch 區塊
							e.printStackTrace();
						}*/
						
					}
					
				}
			}
			if(book_Y==40) {
				if(m.getButton()==MouseEvent.BUTTON1) {
					if((((400<=m.getX())&&(m.getX()<=650))&&((245<=m.getY())&&(m.getY()<=310)))&&yes==false) {
						no=true;
					}
				}
			}
		}



		@Override
		public void mouseReleased(MouseEvent m) {
			// TODO 自動產生的方法 Stub
			/*Image imgCursor = Toolkit.getDefaultToolkit().getImage("resourse/concentric(247x247).png"); 
			setCursor(Toolkit.getDefaultToolkit().createCustomCursor( imgCursor, new Point(0, 0), "cursor"));
			repaint();*/
		}
		
	    

        public void timewait() {
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自動產生的 catch 區塊
				e.printStackTrace();
			}
        }
        
        
	




		
		
	}


class subpanel extends GamePanel implements ActionListener{
	 public void actionPerformed(ActionEvent e){
		 wait--;
	 }
}



