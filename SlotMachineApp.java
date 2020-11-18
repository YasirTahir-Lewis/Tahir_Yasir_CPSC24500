import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Tile {
	private String shape;
	private String color;
	
	public String getShape() {
		return shape;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setShape(String s) {
		
	}
	
	public void setColor(String c) {
		
	}
	
	public Tile() {
		
	}
	
	public Tile(String shape, String color) {
		
	}
	
	public void setRandomly() {
			
	}
	public String toString() {
		return String.format("%d %d", shape, color);
	}
}

class TilePanel extends JPanel implements MouseListener {
	private String mouseStatus;
	private int x, y;
	
	public TilePanel() {
		mouseStatus = "Welcome!";
		addMouseListener(this);
		
	}
	
	public String getMouseStatus() {
		return mouseStatus;
	}
	
	public void setMouseStatus(String ms) {
		mouseStatus = ms;
	}
	
	public void mouseEntered(MouseEvent e) {
		mouseStatus = "Entered the window.";
		repaint();
	}
	
	public void mouseExited(MouseEvent e) {}
	
	public void mousePressed(MouseEvent e) {}
	
	public void mouseReleased(MouseEvent e) {}
	
	public void mouseClicked(MouseEvent e) {
		mouseStatus = String.format("Mouse Clicked at (%d, %d)", e.getX(), e.getY());
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(mouseStatus, 20, 20);
		g.setColor(Color.YELLOW);
		g.fillOval(50,100,150,150);
		g.setColor(Color.BLUE);
		g.fillRect(210,100,150,150);
		g.setColor(Color.GREEN);
		g.fillRect(370,100,150,150);
		g.setColor(Color.RED);
		g.fillRect(530,100,150,150);
	}
}
	
class TileWriter {
	
}
class TileReader {
	
}


class SlotMachineFrame extends JFrame {
		
		public void setLook(String title, int left, int top, int width, int height) {
			setTitle(title);
			setBounds(left,top,width,height);
			Container c = getContentPane();
			c.setLayout(new BorderLayout());
			TilePanel panCenter = new TilePanel();
			c.add(panCenter,BorderLayout.CENTER);
			JPanel panSouth = new JPanel();
			panSouth.setLayout(new FlowLayout());
			JButton btn1 = new JButton("Max");
			JButton btn2 = new JButton("Mid");
			JButton btn3 = new JButton("Min");
			JLabel lbl1 = new JLabel("$");
			JTextField txt1 = new JTextField("$5.00");
			panSouth.add(btn1);
			panSouth.add(btn2);
			panSouth.add(btn3);
			panSouth.add(lbl1);
			panSouth.add(txt1);
			c.add(panSouth,BorderLayout.SOUTH);
			c.add(panCenter,BorderLayout.CENTER);
	}
		public void setupMenu() {
			
			JMenuBar mbar = new JMenuBar();
			JMenu mnuFile = new JMenu("File");
			JMenuItem miSave = new JMenuItem("Save");
			miSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}	
				});
	/*				JFileChooser jfc = new JFileChooser();
					DotWriter dw;
					if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
						dw = new DotWriter();
						if (dw.write(jfc.getSelectedFile(),pan.getDots())) {
							JOptionPane.showMessageDialog(null,"Dots were written.");
						} else {
							JOptionPane.showMessageDialog(null,"Dots could not be written.");
						}
					}
				}
	}*/
			mnuFile.add(miSave);
			JMenuItem miLoad = new JMenuItem("Load");
			miLoad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
				});
	/*				JFileChooser jfc = new JFileChooser();
					DotReader dr;
					ArrayList<Dot> dotsRead;
					if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
						dr = new DotReader();
						dotsRead = dr.read(jfc.getSelectedFile());
						if (dotsRead == null) {
							JOptionPane.showMessageDialog(null,"Could not read.");
						} else {
							pan.setDots(dotsRead);
							repaint();
						}
					}
				}
	*/		
			mnuFile.add(miLoad);
			JMenuItem miRestart = new JMenuItem("Restart");
			miRestart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
				});
	/*				pan.setMouseStatus("");
					pan.clearDots();
					repaint();
				}
	*/		
			JMenuItem miExit = new JMenuItem("Exit");
			miExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			mnuFile.add(miRestart);
			mnuFile.add(miExit);
			mbar.add(mnuFile);
			JMenu mnuHelp = new JMenu("Help");
			JMenuItem miAbout = new JMenuItem("About");
			miAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Application created by Yasir!");
				}
			});
			mnuHelp.add(miAbout);
			mbar.add(mnuHelp);
			setJMenuBar(mbar);
	}
		
		public SlotMachineFrame() {
			setupMenu();
			setLook("Vegas Baby Vegas",300,200,800,480);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		}
}

public class SlotMachineApp3 {

	public static void main(String[] args) {
	SlotMachineFrame frm1 = new SlotMachineFrame();
	frm1.setVisible(true);
	}

}
