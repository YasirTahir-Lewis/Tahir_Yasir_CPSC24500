import javax.swing.JFrame;
import java.awt.Container;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.Color;
import org.math.plot.Plot2DPanel;
import org.math.plot.plotObjects.BaseLabel;
	
	// This programs is to give us the comparison of deaths due to COVID-19 between two or more countries.
	// It has show the graph of daily deaths as well as cumulative deaths.
	// It can also be used to show the number of deaths per day or total in a specific country 
	public class Covid_Plotter {
		
		// This function gives us the header 
		public static void printHeader() {
			System.out.println("*************************************************************************************************");
			System.out.println("*  	                     INTERNATIONAL COVID-19 MORTALITY RATES                             *");
			System.out.println("*************************************************************************************************");
		}
		
		// This function gives us the Cumulative data from the file so we can graph it on plot
		public static LinkedHashMap<String,double[]> readDataCumulative(Scanner fsc) {
			
			LinkedHashMap<String, double[]> result = new LinkedHashMap<String,double[]>();
	        fsc.nextLine();  // gets rid of the first line
	        String name; // country name
	        String line; // line that we read
	        String[] parts;
	        double[] values;  // the number of deaths
	        while (fsc.hasNextLine()) {
	            line = fsc.nextLine();
	            parts = line.split("\t");
	            name = parts[0];
	            values = new double[parts.length-1];
	            
	            // fill the values with the death totals
	            for (int i = 1; i < parts.length; i++) {
	            	values[i-1] = Double.parseDouble(parts[i]);
	            }
	           
	            // now I have the country and the death totals
	            // put them in the result map
	            result.put(name,values);
	            
	      // all the accounts info will now be returned 
		} return result;
		}
		
		// This function is to create daily data for deaths so we can graph it on plot
		public static LinkedHashMap<String,double[]> readDataDaily(Scanner fsc) {
			
			LinkedHashMap<String, double[]> result = new LinkedHashMap<String,double[]>();
	        fsc.nextLine();  // gets rid of the first line
	        String name; // country name
	        String line; // line that we read
	        String[] parts;
	        double[] values;  // the number of deaths
	        while (fsc.hasNextLine()) {
	            line = fsc.nextLine();
	            parts = line.split("\t");
	            name = parts[0];
	            values = new double[parts.length-1];
	            
	            // fill the values with the death daily
	            for (int i = 1; i < parts.length; i++) {
	        
	            	if (i == 1) {	
	            		values[i-1] = Double.parseDouble(parts[i]);
	            	} else {
	            		values[i-1] = Double.parseDouble(parts[i]) - Double.parseDouble(parts[i-1]);
	            	}
	            }
	            
	            
	            // now I have the country and daily deaths
	            // put them in the result map
	            result.put(name,values);
	            
	      // all the accounts info will now be returned.  
		} return result;
		}
			
			// This programs gives us the number of days of x-axis according to how much data we have
	        public static double[] getDays(int howMany) {
	        	
	            double[] result = new double[howMany];
	            for (int i = 0; i < howMany; i++) {
	                result[i] = i;
	                
	            }
	            return result;
	        }
	    
	        // This function graph the Cumulative plot and show it on the screen
	        public static void setUpAndShowPlotCumulative(Plot2DPanel plot) {
	            JFrame frm = new JFrame();
	            frm.setBounds(100,100,500,500);
	            frm.setTitle("Death Curves");
	            frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // get rid from memory
	            Container c = frm.getContentPane();
	            c.setLayout(new BorderLayout());
	            plot.addLegend("SOUTH");
	            plot.setAxisLabels("Day","Value");
	            BaseLabel title = new BaseLabel("Cumulative Deaths",Color.RED,0.5,1.1);
	            plot.addPlotable(title);
	            c.add(plot,BorderLayout.CENTER);
	            frm.setVisible(true);
	        }
	        
	        // This function graph the daily plot and show it on the screen
	        public static void setUpAndShowPlotDaily(Plot2DPanel plot) {
	            JFrame frm = new JFrame();
	            frm.setBounds(100,100,500,500);
	            frm.setTitle("Death Curves");
	            frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // get rid from memory
	            Container c = frm.getContentPane();
	            c.setLayout(new BorderLayout());
	            plot.addLegend("SOUTH");
	            plot.setAxisLabels("Day","Value");
	            BaseLabel title = new BaseLabel("Daily Deaths",Color.RED,0.5,1.1);
	            plot.addPlotable(title);
	            c.add(plot,BorderLayout.CENTER);
	            frm.setVisible(true);
	        }
	        
	    // This is the main function where we ask the user for file and plot the data using user's input and our functions
		public static void main(String[] args) {
			String inputtedNames, answer;
			String[] names;
			double[] deathNumbers;
			LinkedHashMap<String,double[]> accounts1 = null;
			LinkedHashMap<String,double[]> accounts2 = null;
			
			printHeader();
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the name of data file: ");
			
			try {
	
				String fname = sc.nextLine();
				Scanner fsc1 = new Scanner(new File(fname));
				Scanner fsc2 = new Scanner(new File(fname));
				accounts1 = readDataCumulative(fsc1);
				accounts2 = readDataDaily(fsc2);
				
			} catch (Exception ex) {

				System.out.println("Couldn't read the file.");
			}
			
			// This will ask the user again again if they want to compare more countries unless they type quit
			do {
					System.out.println("Enter countries to plot, seperated by commas (or quit to end): ");
					inputtedNames = sc.nextLine();
					
					if (!inputtedNames.equalsIgnoreCase("quit")) {
						
						System.out.println("[D]aily or [C]umulative? ");
						answer = sc.nextLine();
							
						if (answer.equalsIgnoreCase("D")) {
							
							// Plot the data
							Plot2DPanel plot = new Plot2DPanel();
							
							names = inputtedNames.split(",");
					
							for (String name : names) {
								name = name.trim();
								
								if (!accounts2.containsKey(name)) {
									System.out.printf("%s is not in the data.\n", name);
									
								} else { 
									deathNumbers = accounts2.get(name);
									plot.addLinePlot(name, getDays(deathNumbers.length),deathNumbers);
								}
							}
							// Shows the data on the plot
							setUpAndShowPlotDaily(plot);
							
						} else if (answer.equalsIgnoreCase("C")) {
							
							// Plot the data
							Plot2DPanel plot = new Plot2DPanel();
							
							names = inputtedNames.split(",");
					
							for (String name : names) {
								name = name.trim();
								
								if (!accounts1.containsKey(name)) {
									System.out.printf("%s is not in the data.\n", name);
									
								} else { 
									deathNumbers = accounts1.get(name);
									plot.addLinePlot(name, getDays(deathNumbers.length),deathNumbers);
								}
							}
							// shows the data on the plot
							setUpAndShowPlotCumulative(plot);
						
						} else {
							System.out.println("That was not a valid option!");
						}
						}
					
						} while (!inputtedNames.equalsIgnoreCase("quit"));
						System.out.println("Your only task ...");
						System.out.println("\t       ... is to wear a mask");
						}
			
}
	
						 
							


