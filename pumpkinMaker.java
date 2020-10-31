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

class PumpkinPanel extends JPanel {
	
	private int left;
	private int top;
	private int width;
	private int height;
	private String eye;
	private String nose;
	private String mouth;
	
	public int getleft() {
		return left;
	}
	
	public void setleft(int l) {
		if (l < 0) {
			left = 50;
		} else {
			left = l;
		}
	}
	
	public int gettop() {
		return top;
	}
	
	public void settop(int t) {
		if (t < 0) {
			top = 50;
		} else {
			top = t;
		}
	}
	
	public int getwidth() {
		return width;
	}
	
	public void setwidth(int w) {
		if (w < 0) {
			width = 50;
		} else {
			width = w;
		}
	}
	
	public int getheight() {
		return height;
	}
	
	public void setheight(int h) {
		if (h < 0) {
			height = 50;
		} else {
			height = h;
		}
	}
	
	public String geteye() {
		return eye;
	}
	
	public void seteye(String e) {
		if (e.equalsIgnoreCase("c")) {
			eye = "Circle";
		} else if (e.equalsIgnoreCase("s")){
			eye = "Square";
		} else if (e.equalsIgnoreCase("t")) {
			eye = "Triangle";
		} else {
			eye = "Circle";
		}
	}
	
	public String getnose() {
		return nose;
	}
	
	public void setnose(String n) {
		if (n.equalsIgnoreCase("c")) {
			nose = "Circle";
		} else if (n.equalsIgnoreCase("s")){
			nose = "Square";
		} else if (n.equalsIgnoreCase("t")) {
			nose = "Triangle";
		} else {
			nose = "Square";
		}
	}
	
	public String getmouth() {
		return mouth;
	}
	
	public void setmouth(String m) {
		if (m.equalsIgnoreCase("o")) {
			mouth = "Oval";
		} else if (m.equalsIgnoreCase("r")) {
			mouth = "Rectangle";
		} else {
			mouth = "Oval";
		}
	}
	public PumpkinPanel() {
		left = 200;
		top = 100;
		width = 100;
		height = 100;
		eye = "Circle";
		nose = "Square";
		mouth = "Oval";
		
	}
	public PumpkinPanel(int l, int t, int w, int h, String n, String e, String m) {
		setleft(l);
		settop(t);
		setwidth(w);
		setheight(h);
		seteye(e);
		setnose(n);
		setmouth(m);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.ORANGE);
		g.fillOval(left,top,width,height);
		
	}
}

class FancyCustomFrame extends JFrame {
	
	private void PumpkinPanel(int left, int top, int width, int height, String eye, String nose, String mouth){}
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
			
					int left = Integer.parseInt(txt1.getText());
					int top = Integer.parseInt(txt2.getText());
					int width = Integer.parseInt(txt3.getText());
					int height = Integer.parseInt(txt4.getText());
					String eye = txt5.getText();
					String nose = txt6.getText();
					String mouth = txt7.getText();
					PumpkinPanel(left,top,width,height,eye,nose,mouth);
					repaint();
			}
});
		panSouth.add(btnClick);
		c.add(panSouth,BorderLayout.SOUTH);
		c.add(panCenter,BorderLayout.CENTER);
	}
	// default constructor
	public FancyCustomFrame() {
		setLook("Pumkin Maker",300,200,800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	
}
public class pumpkinMaker {
	public static void main(String[] args) {
		FancyCustomFrame frm1 = new FancyCustomFrame();
		frm1.setVisible(true);
		
		
	}
}
