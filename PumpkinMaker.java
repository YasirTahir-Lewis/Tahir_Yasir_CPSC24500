import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// This program is to create a Pumpkin with your own choice of size and type
// You can select where you wanna make a pumpkin on the window
// Also what size it should be and type of nose, eye, and mouth
class PumpkinPanel extends JPanel {
	
	private int pumpkinLeft;
	private int pumpkinTop;
	private int pumpkinWidth;
	private int pumpkinHeight;
	private String pumpkinEye;
	private String pumpkinNose;
	private String pumpkinMouth;
	
	public int getPumpkinLeft() {
		return pumpkinLeft;
	}
	
	public void setPumpkinLeft(int l) {
		if (l < 0) {
			pumpkinLeft = 50;
		} else {
			pumpkinLeft = l;
		}
	}
	
	public int getPumpkinTop() {
		return pumpkinTop;
	}
	
	public void setPumpkinTop(int t) {
		if (t < 0) {
			pumpkinTop = 50;
		} else {
			pumpkinTop = t;
		}
	}
	
	public int getPumpkinWidth() {
		return pumpkinWidth;
	}
	
	public void setPumpkinWidth(int w) {
		if (w < 0) {
			pumpkinWidth = 50;
		} else {
			pumpkinWidth = w;
		}
	}
	
	public int getPumpkinHeight() {
		return pumpkinHeight;
	}
	
	public void setPumpkinHeight(int h) {
		if (h < 0) {
			pumpkinHeight = 50;
		} else {
			pumpkinHeight = h;
		}
	}
	
	public String getPumpkinEye() {
		return pumpkinEye;
	}
	
	public void setPumpkinEye(String e) {
		if (e.equalsIgnoreCase("c")) {
			pumpkinEye = "Circle";
		} else if (e.equalsIgnoreCase("s")){
			pumpkinEye = "Square";
		} else if (e.equalsIgnoreCase("t")) {
			pumpkinEye = "Triangle";
		} else {
			pumpkinEye = "Circle";
		}
	}
	
	public String getPumpkinNose() {
		return pumpkinNose;
	}
	
	public void setPumpkinNose(String n) {
		if (n.equalsIgnoreCase("c")) {
			pumpkinNose = "Circle";
		} else if (n.equalsIgnoreCase("s")){
			pumpkinNose = "Square";
		} else if (n.equalsIgnoreCase("t")) {
			pumpkinNose = "Triangle";
		} else {
			pumpkinNose = "Square";
		}
	}
	
	public String getPumpkinMouth() {
		return pumpkinMouth;
	}
	
	public void setPumpkinMouth(String m) {
		if (m.equalsIgnoreCase("o")) {
			pumpkinMouth = "Oval";
		} else if (m.equalsIgnoreCase("r")) {
			pumpkinMouth = "Rectangle";
		} else {
			pumpkinMouth = "Oval";
		}
	}
	public PumpkinPanel() {
		pumpkinLeft = 200;
		pumpkinTop = 100;
		pumpkinWidth = 100;
		pumpkinHeight = 100;
		pumpkinEye = "Circle";
		pumpkinNose = "Square";
		pumpkinMouth = "Oval";
		
	}
	public PumpkinPanel(int l, int t, int w, int h, String n, String e, String m) {
		setPumpkinLeft(l);
		setPumpkinTop(t);
		setPumpkinWidth(w);
		setPumpkinHeight(h);
		setPumpkinEye(e);
		setPumpkinNose(n);
		setPumpkinMouth(m);
		
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.ORANGE);
		g.fillOval(pumpkinLeft,pumpkinTop,pumpkinWidth,pumpkinHeight);
		if (pumpkinEye.equalsIgnoreCase("Circle")) {
			g.setColor(Color.WHITE);
			g.fillOval(pumpkinLeft + (pumpkinWidth/4),pumpkinTop + (pumpkinHeight/4),pumpkinWidth/8, pumpkinHeight/8);
			g.fillOval(pumpkinLeft + (pumpkinWidth/2),pumpkinTop + (pumpkinHeight/4),pumpkinWidth/8, pumpkinHeight/8);
		} else if (pumpkinEye.equalsIgnoreCase("Square")) {
			g.setColor(Color.WHITE);
			g.fillRect(pumpkinLeft + (pumpkinWidth/5),pumpkinTop + (pumpkinHeight/4),pumpkinWidth/8, pumpkinHeight/8);
			g.fillRect(pumpkinLeft + (pumpkinWidth/2),pumpkinTop + (pumpkinHeight/4),pumpkinWidth/8, pumpkinHeight/8);
		}
		if (pumpkinNose.equalsIgnoreCase("Square")) {
			g.setColor(Color.WHITE);
			g.fillRect(pumpkinLeft + (pumpkinWidth/3),pumpkinTop + (pumpkinHeight/2),pumpkinWidth/8, pumpkinHeight/8);
		} else if (pumpkinNose.equalsIgnoreCase("Circle")) {
			g.setColor(Color.WHITE);
			g.fillOval(pumpkinLeft + (pumpkinWidth/3),pumpkinTop + (pumpkinHeight/2),pumpkinWidth/8, pumpkinHeight/8);
		}
		if (pumpkinMouth.equalsIgnoreCase("Oval")) {
			g.setColor(Color.WHITE);
			g.fillOval(pumpkinLeft + (pumpkinWidth/4),pumpkinTop + (pumpkinHeight/2),pumpkinWidth/2, pumpkinHeight/8);
		} else if (pumpkinNose.equalsIgnoreCase("Rectangle")) {
			g.setColor(Color.WHITE);
			g.fillRect(pumpkinLeft + (pumpkinWidth/4),pumpkinTop + (pumpkinHeight/2),pumpkinWidth/2, pumpkinHeight/8); 
		}
	}
}
class FancyCustomFrame extends JFrame {
	
	public PumpkinPanel panCenter;
	public void setLook(String title, int left, int top, int width, int height) {
		
		setTitle(title);
		setBounds(left,top,width,height);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		PumpkinPanel panCenter = new PumpkinPanel();
		c.add(panCenter,BorderLayout.CENTER);
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		JLabel lbl1 = new JLabel("Left: ");
		panSouth.add(lbl1);
		JTextField txt1 = new JTextField(3);
		panSouth.add(txt1);
		JLabel lbl2 = new JLabel("Top: ");
		panSouth.add(lbl2);
		JTextField txt2 = new JTextField(3);
		panSouth.add(txt2);
		JLabel lbl3 = new JLabel("Width: ");
		panSouth.add(lbl3);
		JTextField txt3 = new JTextField(3);
		panSouth.add(txt3);
		JLabel lbl4 = new JLabel("Height: ");
		panSouth.add(lbl4);
		JTextField txt4 = new JTextField(3);
		panSouth.add(txt4);
		JLabel lbl5 = new JLabel("Eye (CST): ");
		panSouth.add(lbl5);
		JTextField txt5 = new JTextField(2);
		panSouth.add(txt5);
		JLabel lbl6 = new JLabel("Nose (CST): ");
		panSouth.add(lbl6);
		JTextField txt6 = new JTextField(2);
		panSouth.add(txt6);
		JLabel lbl7 = new JLabel("Mouth (OR): ");
		panSouth.add(lbl7);
		JTextField txt7 = new JTextField(2);
		panSouth.add(txt7);
//		DrawingPanel panCenter1 = new DrawingPanel();
		JButton btnClick = new JButton("Draw");
		btnClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					int pLeft = Integer.parseInt(txt1.getText());
					int pTop = Integer.parseInt(txt2.getText());
					int pWidth = Integer.parseInt(txt3.getText());
					int pHeight = Integer.parseInt(txt4.getText());
					String pEye = txt5.getText();
					String pNose = txt6.getText();
					String pMouth = txt7.getText();
					panCenter.setPumpkinLeft(pLeft);
					panCenter.setPumpkinTop(pTop);
					panCenter.setPumpkinWidth(pWidth);
					panCenter.setPumpkinHeight(pHeight);
					panCenter.setPumpkinEye(pEye);
					panCenter.setPumpkinNose(pNose);
					panCenter.setPumpkinMouth(pMouth);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"All the values must be an int.");
				}
					
					repaint();
					
					
			}
});
		panSouth.add(btnClick);
		c.add(panSouth,BorderLayout.SOUTH);
		c.add(panCenter,BorderLayout.CENTER);
	}
	// default constructor
	public FancyCustomFrame() {
		setLook("Pumkin Maker",300,200,800,480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	
}
public class pumpkinMaker {
	public static void main(String[] args) {
		FancyCustomFrame frm1 = new FancyCustomFrame();
		frm1.setVisible(true);
		
		
	}
}
