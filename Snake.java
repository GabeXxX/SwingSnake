import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

class Home extends JFrame
	{
		public Home()
		{
			this.setBounds(1440/4, 900/4, 1440/2, 900/2);
			this.setTitle("Snake");
			this.setResizable(false);
			this.setUndecorated(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(new BorderLayout());
			this.getContentPane().add(new Start(this), BorderLayout.CENTER);
			this.getContentPane().add(new Exit(), BorderLayout.SOUTH);
			this.setVisible(true);
			
		}
		
	}
class Start extends JPanel
{
	private Font f = new Font("Calibri", Font.PLAIN, 60);
	private Home c;
	
	public Start(Home home)
	{
		
		this.c= home;   //NECESSARRIO PER FARE CHIUDERE IL JFRAME QUANDO CLICCANDO START SI APRIR� UN NUOVO JFRAME
		
		this.setLayout(new BorderLayout());


		JButton inizio = new JButton("Start");
		inizio.setBackground(Color.GREEN);
		inizio.setFont(f);
		inizio.addMouseListener(new MouseListener()
			{

				@Override
				public void mouseClicked(MouseEvent e)
					{
						// TODO Auto-generated method stub
						
					}

				@Override
				public void mouseEntered(MouseEvent e)
					{
						// TODO Auto-generated method stub
						if(e.getComponent().equals(inizio))
							{									
								inizio.setBackground(Color.WHITE);
															
							}
						
						
					}

				@Override
				public void mouseExited(MouseEvent e)
					{
						// TODO Auto-generated method stub
						inizio.setBackground(Color.GREEN);
						
						
					}

				@Override
				public void mousePressed(MouseEvent e)
					{
						// TODO Auto-generated method stub
						
						
					}

				@Override
				public void mouseReleased(MouseEvent e)
					{
						// TODO Auto-generated method stub
						
						
					}
				
			});
		
		inizio.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
					{
						// TODO Auto-generated method stub
					
						Game g = new Game();
						c.dispose();
						
																
					}
				
			});
		
		add(inizio);
		
	}
}

class Exit extends JPanel
{
	private Font f = new Font("Calibri", Font.PLAIN, 60);
	
	public Exit()
	{
		JButton esci = new JButton("Esci");
		esci.setPreferredSize(new Dimension(this.getMaximumSize().width, 100));
		esci.setBackground(Color.RED);
		esci.setFont(f);		
		esci.addMouseListener(new MouseListener()
				{

					@Override
					public void mouseClicked(MouseEvent e)
						{
							// TODO Auto-generated method stub
							
						}

					@Override
					public void mouseEntered(MouseEvent e)
						{
							// TODO Auto-generated method stub
							if(e.getComponent().equals(esci))
								{									
									esci.setBackground(Color.WHITE);
									
								}
							
							
						}

					@Override
					public void mouseExited(MouseEvent e)
						{
							// TODO Auto-generated method stub
							esci.setBackground(Color.red);
							
							
						}

					@Override
					public void mousePressed(MouseEvent e)
						{
							// TODO Auto-generated method stub
							
							
						}

					@Override
					public void mouseReleased(MouseEvent e)
						{
							// TODO Auto-generated method stub
							
							
						}
					
				});
		
		esci.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e)
						{
							// TODO Auto-generated method stub
							System.exit(0);
							
						}
					
				});
		
		add(esci);
		
	}
}

class Game extends JFrame
{
	public Game()
	{
		this.setBounds(1440/4, 900/4, 1440/2, 900/2);
		this.setTitle("Snake");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		add(new GamePanel(), BorderLayout.CENTER);
		add(new Score(), BorderLayout.NORTH);
		this.setVisible(true);
	}
}


class GamePanel extends JPanel
{
	private static int x = 80;
	private static int y = 20;
	private int x1[] = new int[1000];
	private int y1[] = new int[1000];
	public static int length = 6;
	private Rectangle h[];
	private boolean up = false;
	private boolean down = false;
	private boolean right = true;
	private boolean left = false;
	private Random r = new Random();
	private int a = r.nextInt(1440/4);
	private int b = r.nextInt(900/4);
	private Rectangle q = new Rectangle(a,b, 20, 20);
	static private Timer t;
	private static boolean GameOver = false;
	private static boolean pause = false;
	
	public static Timer getT()
		{
				return t;
		}

	public static void setT(Timer t)
		{
				GamePanel.t = t;
		}

	public static boolean isPause()
		{
				return pause;
		}

	public static void setPause(boolean pause)
		{
				GamePanel.pause = pause;
		}	
	
	public boolean isGameOver()
		{
				return GameOver;
		}

	public static void setGameOver(boolean gameOver)
		{
				GameOver = gameOver;
		}
	public static int getx()
	{
		return x;
	}
	public static void setx(int t)
	{
		x = t;
	}
	public static int gety()
		{
			return y;
		}
		public static void sety(int t)
		{
			y = t;
		}

	public GamePanel()
	{
		
		this.setFocusable(true);
		this.setBackground(Color.WHITE);
		
		this.addKeyListener(new KeyListener()
				{

					@Override
					public void keyPressed(KeyEvent e)
						{
							// TODO Auto-generated method stubsyso
							System.out.println(e.getKeyCode());
							if(e.getKeyCode()==38 && down==false)
								{
									up = true;
									down = false;
									right = false;
									left = false;
								}
							if(e.getKeyCode()==40 && up==false)
								{
									down = true;
									up = false;
									right = false;
									left = false;
								}
							if(e.getKeyCode()==39 && left==false)
								{
									down = false;
									up = false;
									right = true;
									left = false;
								}
							if(e.getKeyCode()==37 && right==false)
								{
									down = false;
									up = false;
									right = false;
									left = true;
								}
							if(e.getKeyCode()==27)
								{
									DialogPauseFrame g = new DialogPauseFrame();
									pause = true;
								}
							
							
							
						}

					@Override
					public void keyReleased(KeyEvent e)
						{
							// TODO Auto-generated method stub
							
						}

					@Override
					public void keyTyped(KeyEvent e)
						{
							// TODO Auto-generated method stub
							
						}
					
				});
	}

	public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			

			
			class Move implements ActionListener
			{
										
				@Override
				public void actionPerformed(ActionEvent e)
					{
						// TODO Auto-generated method stub
						

						for(int i=length; i>0; i--)
							{
								x1[i]= x1[i-1];
								y1[i]= y1[i-1];
								
							}	
						if(up==true)
							{		
								
								y-=20;
								
								
							}
						if(down==true)
							{
								
								y+=20;
								
							}
						if(right==true)
							{
								
								x+=20;
								
								
							}
						if(left==true)
							{
								
							     x-=20;
							}
						
						if(h[0].intersects(q))
							{
								a = r.nextInt(1440/4);
								b = r.nextInt(900/4);
								length++;
								q = new Rectangle(a,b, 20, 20);
								Toolkit.getDefaultToolkit().beep();
								
							}
						 for(int z1=1; z1<length-1; z1++)
								{
									if(h[0].intersects(h[z1]))
										{
											
                                            setGameOver(true);
                                            x = 80;
                                            y = 20;
                                            GameOverFrame h = new GameOverFrame();
                                                                                     
										}
								}
						 if(h[0].getLocation().getX() <= 0 ) x=1439;
						 if(h[0].getLocation().getY() <= 0 ) y=899;
						 if(h[0].getLocation().getX() >= 1440 ) x=1;
						 if(h[0].getLocation().getY() >= 900) y=1;

						 repaint();
										
					}
		
				
			}
			
			 
			 setT(new Timer((int) (84/(length*0.1)),new Move())); 
			 getT().setRepeats(false);
			 if(isGameOver() == false)
				 {
					 if(!isPause()) getT().start();
					 if(isPause()) getT().stop();
				 }
			 if(isGameOver()) getT().stop();
			 
			 
			 Graphics2D g2= (Graphics2D)g;		
			 h = new Rectangle[1000];  
			 x1[0]=x;
			 y1[0]=y;
			 h[0] = new Rectangle(x1[0], y1[0], 20, 20);	//disegna testa serpente		 
			 g2.fill(h[0]);
			 for(int i = 1; i<length; i++)  //disegna primi rettangoli serpente
				 {
					 h[i] = new Rectangle(x1[i], y1[i], 20, 20);
					 g2.fill(h[i]);
				 } 
			 
			 g2.fill(q); //disegna mela
			 
			 
			  

		}
	
}
class Score extends JPanel
{
	private Timer o;
	private int score = 0;
	private String z = "Your score is "+ (score+"  ");
	private Font f = new Font("Calibri", Font.PLAIN, 30);		
	private JLabel l = new JLabel(z);		
	
	
	public Score()
	{
		setLayout(new BorderLayout());
		l.setFont(f);
		add(l, BorderLayout.EAST);
						
		o = new Timer(130, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e)
				{
					// TODO Auto-generated method stub
										
					score = GamePanel.length-6;
					z = "Your score is "+ (score)+ "  ";
					l.setText(z);
					repaint();					
				}
									
		});
		o.start();
		
		
		JButton pause = new JButton("Pause");
		pause.setFocusable(false);
		pause.setFont(f);
		pause.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e)
				{
					// TODO Auto-generated method stub
					GamePanel.setPause(true);
					DialogPauseFrame k = new DialogPauseFrame();
										
				}
			
			
		});
		
		add(pause, BorderLayout.WEST);
		
		 		   
	}
}

class DialogPauseFrame extends JFrame
{
	public DialogPauseFrame()
	{
		this.setFocusable(true);
		this.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e)
				{
					// TODO Auto-generated method stub
					if(e.getKeyCode()==27)
						{
							
							GamePanel.setPause(false);
							GamePanel.getT().start();
							dispose();
						}
					
				}

			@Override
			public void keyReleased(KeyEvent e)
				{
					// TODO Auto-generated method stub
					
				}

			@Override
			public void keyTyped(KeyEvent e)
				{
					// TODO Auto-generated method stub
					
				}
			
		});
		this.getContentPane().setBackground(Color.GRAY);
		
		BorderLayout i = new BorderLayout();
		this.setLayout(new BorderLayout( ));
		this.setBounds(1440/4, 900/4, 1440/2, 900/2);
		this.setTitle("Snake");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setUndecorated(true);
		Font f = new Font("Calibri", Font.PLAIN, 30);
		JLabel v = new JLabel("Pause");
		v.setHorizontalAlignment(JLabel.CENTER);
		v.setFont(f);
		JButton continu = new JButton("Continue");
		continu.setFont(f);
		continu.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e)
						{
							// TODO Auto-generated method stub
							GamePanel.setPause(false);
							GamePanel.getT().start();
							dispose();
														
						}
					
				});
		JButton exit = new JButton("Exit");
		exit.setFont(f);
		exit.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e)
						{
							// TODO Auto-generated method stub
							System.exit(0);				
						}
					
				});
		
		JButton restart = new JButton("Restart");
		restart.setFont(f);
		restart.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e)
						{
							// TODO Auto-generated method stub
							GamePanel.length= 6;
							GamePanel.setx(80);
							GamePanel.sety(20);
							GamePanel.setPause(false);
							GamePanel.getT().restart();
							dispose();
														
						}
					
				});
		
		add(restart, BorderLayout.EAST);
		add(exit, BorderLayout.NORTH);
		add(continu, BorderLayout.SOUTH);		
		add(v, BorderLayout.CENTER);
		this.setVisible(true);
	}
}

class GameOverFrame extends JFrame
{
	private static String Score = "";
	
	public static String getScore()
		{
				return Score;
		}

	public static void setScore(String score)
		{
				Score = score;
		}

	public GameOverFrame()
	{
		this.getContentPane().setBackground(Color.GRAY);
		
		BorderLayout i = new BorderLayout();
		this.setLayout(new BorderLayout( ));
		this.setBounds(1440/3, 900/3, 1440/4, 900/4);
		this.setTitle("Snake");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setUndecorated(true);
		Font f = new Font("Calibri", Font.PLAIN, 30);
		
		try
			{
				Record t = new Record();
			}
		catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		JLabel v = new JLabel(getScore());
		v.setHorizontalAlignment(JLabel.CENTER);
		v.setFont(f);
		//JLabel w = new JLabel("Your Score is " + (GamePanel.length-6));
		//w.setHorizontalAlignment(JLabel.CENTER);
		//w.setFont(f);
		JButton restart = new JButton("Restart");
		restart.setFont(f);
		restart.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e)
						{
							// TODO Auto-generated method stub
							GamePanel.length= 6;
							GamePanel.setGameOver(false);
							GamePanel.getT().restart();
							dispose();
														
						}
					
				});
		
		JButton exit = new JButton("Exit");
		exit.setFont(f);
		exit.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e)
						{
							// TODO Auto-generated method stub
							System.exit(0);				
						}
					
				});
		
		
		add(exit, BorderLayout.NORTH);
		add(restart, BorderLayout.SOUTH);
		//add(w, BorderLayout.CENTER);
		add(v, BorderLayout.CENTER);
		this.setVisible(true);
	}
}

class Record
{
	public Record() throws IOException
	{
		File record = new File("Record.txt");
		record.createNewFile();
		
		
						
		
		
		FileInputStream f1 = new FileInputStream(record);
		InputStreamReader g1 = new InputStreamReader(f1);
		BufferedReader o1 = new BufferedReader(g1);
		
		if(record.length()== 0 || Integer.parseInt(o1.readLine())<GamePanel.length-6 )
			{
				record.delete();
				record.createNewFile();
				
				FileOutputStream f = new FileOutputStream(record);
				OutputStreamWriter g = new OutputStreamWriter(f);
				PrintWriter o = new PrintWriter(g);
				o.println(GamePanel.length-6);
				o.close();
				GameOverFrame.setScore("<html><p align=center>Game Over</p><p align=center> NEW RECORD !!! Your Score is " + (GamePanel.length-6)+"</p></html>");
				
			}
		else
			{
				GameOverFrame.setScore("<html><p align=center>Game Over</p><p align=center> Your Score is " + (GamePanel.length-6)+"</p></html>");
			}
		
		
		o1.close();
		System.out.println("prova");
		
		
		
	}
}

public class Snake
	{

		public static void main(String[] args)
			{
				// TODO Auto-generated method stub
				Home home = new Home();
			}

	}
