import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class is view class it displays output to the screen
 * It has three main functions which are setupMenu (It creates a main menu on the top of screen to access multiple things you wanna do)
 * It has setupLook function that creates the overall look of the window and displays all the tiles and the buttons
 * It also has cashBalance update function which updates the cash balance every time we press the buttons or restart the game
 */
public class SlotMachineFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private TilePanel tpan;
	private JTextField txtBalance;
	private JButton btnMax, btnMid, btnMin;
	private float cashBalance=5;
	
/**
 * 	It creates a main menu on the top of screen to access multiple things
 * 	Under file you can click on load to load the arrangement of tiles from the file in the local drive
 * 	You can click Save to save the file with the current arrangement of tiles in to the local drive
 * 	You can click print to print the current arrangement of tiles to the console
 * 	You can click restart to restart the game and the cash balance will update and buttons will be enabled
 * 	You can click exit to exit the game
 * 	Under Help you can click about to see author's name and location of program online 
 */
	public void setupMenu() {
		JMenuBar mbar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		JMenuItem miLoad = new JMenuItem("Load");
		JMenuItem miSave = new JMenuItem("Save");
		JMenuItem miPrint = new JMenuItem("Print");
		miPrint.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("\nThis is the current arrangement of the tiles.");
				for (int i=0; i<4; i++) {
					System.out.println(tpan.getTiles().get(i).toStringFancy());
				}
				
			}
			
		});
		JMenuItem miRestart = new JMenuItem("Restart");
		miRestart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cashBalance=5;
				TileRandomizer tr = new TileRandomizer();
				tpan.setTiles(tr.randomizedTiles());
				btnMax.setEnabled(true);
				btnMid.setEnabled(true);
				btnMin.setEnabled(true);
				updateCashBalance();
				tpan.repaint();
				
			}
			
		});
		JMenuItem miExit = new JMenuItem("Exit");
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		miLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileReader tr = new TileReader();
				ArrayList<Tile> tiles;
				if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					tiles = tr.read(jfc.getSelectedFile());
					if (tiles != null) {
						tpan.setTiles(tiles);
						repaint();
					} else {
						JOptionPane.showMessageDialog(null,"Tiles could not be read.");
					}
				}
			}
		});
		miSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileWriter tw = new TileWriter();
				if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					if (tw.write(jfc.getSelectedFile(),tpan.getTiles())) {
						JOptionPane.showMessageDialog(null,"Wrote tiles successfully.");
					} else {
						JOptionPane.showMessageDialog(null,"Could not write tiles.");
					}
				}
			}
		});
		mnuFile.add(miLoad);
		mnuFile.add(miSave);
		mnuFile.add(miPrint);
		mnuFile.add(miRestart);
		mnuFile.add(miExit);
		mbar.add(mnuFile);
		JMenu mnuHelp = new JMenu("Help");
		JMenuItem miAbout = new JMenuItem("About");
		miAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Vegas Baby Vegas by Yasir Tahir.\nCode at <https://github.com/YasirTahir-Lewis/Tahir_Yasir_CPSC24500.git>");
			}
		});
		mnuHelp.add(miAbout);
		mbar.add(mnuHelp);
		setJMenuBar(mbar);
	}
	
/**
 * 	This function handles everything shown on the window and creates the window
 * 	Add the tiles into it
 * 	Add all the buttons
 *	And uses setupMenu function to show up that on the window
 */
	public void setupLook() {
		setBounds(100,100,750,300);
		setTitle("Vegas Baby Vegas Slot Machine");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		btnMax = new JButton("Max");
		btnMax.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				float bet = cashBalance;
				
				cashBalance = 0;
				TileRandomizer tr = new TileRandomizer();
				tpan.setTiles(tr.randomizedTiles());
				tpan.repaint();
				TileChecker tc = new TileChecker();
				if (tc.matchChecker(tpan.getTiles())) {
					cashBalance += 100*bet;
				} else if (tc.colorChecker(tpan.getTiles())) {
					cashBalance += 25*bet;
				} 
				updateCashBalance();
			}
			
		});
		btnMid = new JButton("Mid");
		btnMid.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				float bet = cashBalance/2;
				
				cashBalance -= bet;
				TileRandomizer tr = new TileRandomizer();
				tpan.setTiles(tr.randomizedTiles());
				tpan.repaint();
				TileChecker tc = new TileChecker();
				if (tc.matchChecker(tpan.getTiles())) {
					cashBalance += 50*bet;
				} else if (tc.colorChecker(tpan.getTiles())) {
					cashBalance += 10*bet;
				} 
				updateCashBalance();
			}
			
		});

		btnMin = new JButton("Min");
		btnMin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				float bet = cashBalance/10;
				
				cashBalance -= bet;
				TileRandomizer tr = new TileRandomizer();
				tpan.setTiles(tr.randomizedTiles());
				tpan.repaint();
				TileChecker tc = new TileChecker();
				if (tc.matchChecker(tpan.getTiles())) {
					cashBalance += 10*bet;
				} else if (tc.colorChecker(tpan.getTiles())) {
					cashBalance += 5*bet;
				} 
				updateCashBalance();
			}
			
		});
		panSouth.add(btnMax);
		panSouth.add(btnMid);
		panSouth.add(btnMin);
		c.add(panSouth,BorderLayout.SOUTH);
		tpan = new TilePanel();
		c.add(tpan,BorderLayout.CENTER);
		JLabel lblBalance = new JLabel("$");
		panSouth.add(lblBalance);
		txtBalance = new JTextField(6);
		txtBalance.setEditable(false);
		txtBalance.setText(String.format("%.2f",5.00));
		panSouth.add(txtBalance);
		setupMenu();
	}
	
/**
 *  This functions updates the cash balance
 *  Every time we click on the Max, Mid, and Min buttons
 *  And also when we restart the game from the main menu
 */
	public void updateCashBalance() {
		txtBalance.setText(String.format("%.2f",cashBalance));
		if (cashBalance<=0.01) {
			btnMax.setEnabled(false);
			btnMid.setEnabled(false);
			btnMin.setEnabled(false);
		}

	}
	
/**
 * 	This function uses setupLook function to show everything
 */
	public SlotMachineFrame() {
		setupLook();
	}
}
