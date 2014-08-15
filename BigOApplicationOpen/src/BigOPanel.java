import java.awt.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.*;
import java.io.*;


public class BigOPanel extends JPanel {
	
	private FileHandler filer= new FileHandler();
	
	private JTextField userinput;
	private JTextField randomlistlength;
	private JTextField randomlistbound;
	private JButton exportmanually;
	private JButton exportrandomly;
	
	private JCheckBox selection;
	private JCheckBox insertion;
	private JCheckBox bubble;
	private JCheckBox javasort;
	
	private JButton sort;
	private JLabel currentfile;
	private JButton openfile;
	
	private JFileChooser jfca;
	private FileNameExtensionFilter filter;

	
	
	private int[] list;
	

	
	
	public BigOPanel(){
		
		//setPreferredSize(new Dimension(500,500));
		
		
		JPanel export= new JPanel();
		export.setLayout(new BoxLayout(export, BoxLayout.PAGE_AXIS));
		
		
		
		userinput= new JTextField("Enter your list manually here", 10);
		
		
		randomlistlength= new JTextField("Enter the list length you want.",10);
		randomlistbound= new JTextField("Enter the bound of random numbers you want.", 10);
		exportmanually= new JButton("Export Manually");
		exportrandomly= new JButton("Export a Random Integer List");
		
		exportrandomly.addActionListener(new PanelListener(0));
		exportmanually.addActionListener(new PanelListener(1));
		
		export.add(userinput);
		export.add(exportmanually);
		export.add(randomlistlength);
		export.add(randomlistbound);
		export.add(exportrandomly);
		
		JPanel checks= new JPanel();
		checks.setLayout(new FlowLayout(3));
		
		selection=new JCheckBox("Selection Sort");
		insertion= new JCheckBox("Insertion Sort");
		bubble= new JCheckBox("Bubble Sort");
		javasort= new JCheckBox("Java Sort");
		
		checks.add(selection);
		checks.add(insertion);
		checks.add(bubble);
		checks.add(javasort);
		
		JPanel left= new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.PAGE_AXIS));
		
		left.add(export);
		left.add(checks);
		
		add(left);
		
		JPanel right= new JPanel();
		right.setLayout(new BoxLayout(right, BoxLayout.PAGE_AXIS));
		
		sort= new JButton("Sort");
		sort.addActionListener(new PanelListener(2));
		
		currentfile=new JLabel("No file currently chosen.");
		openfile= new JButton("Open a List");
		openfile.addActionListener(new PanelListener(3));
		
		jfca= new JFileChooser();
		filter = new FileNameExtensionFilter("TXT files","txt");
		jfca.setFileFilter(filter);
		
		
		
		
		right.add(sort);
		right.add(currentfile);
		right.add(openfile);
		
		add(right);
		
		
		
		
		
	}
	
	
	
	public static void main(String[] args){
		
		JFrame jp= new JFrame();
		jp.add(new BigOPanel());
		jp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp.pack();
		jp.setVisible(true);
		
	}

	private class PanelListener implements ActionListener{

		
		private int job;
		
		/*
		 * job numbers:
		 * 0- Write and export a randomly made list
		 * 1- Write and export a manually made list
		 */
		
		public PanelListener(int x){
			job=x;
		}
		
		public void actionPerformed(ActionEvent e) {
			
			if (job==0){
				
				try{
				//	System.out.println(Integer.parseInt(randomlistlength.toString()));
				filer.writeRandomList(Integer.parseInt(randomlistlength.getText()), Integer.parseInt(randomlistbound.getText()));
				JOptionPane.showMessageDialog(null, "Random List Exported to file \"randomexportedlist.txt\" ");
				}
				
				catch(Exception x){
				
				JOptionPane.showMessageDialog(null,
						    "You did not enter valid input for the Random List Exporter",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
					
				}
				

			}
			
			if (job==1){
				
				try{
				//	System.out.println(Integer.parseInt(randomlistlength.toString()));
				filer.writeManualList(userinput.getText());
				JOptionPane.showMessageDialog(null, "Manual List Exported to file \"manualexportedlist.txt\" ");
				}
				
				catch(Exception x){
				
				JOptionPane.showMessageDialog(null,
						    "You did not enter valid input for the Manual List Exporter",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
					
				}
				

			}
			
			if (job==2){
				
				try{
				FileHandler.writeList(Sorts.insertionSort(list));
				
				FileHandler.BigOInfoclear();
				if (selection.isSelected()==true){
					BigOInfo.selectionSortInfo(list);
				}
				if (insertion.isSelected()==true){
					BigOInfo.insertionSortInfo(list);
				}
				if (bubble.isSelected()==true){
					BigOInfo.bubbleSortInfo(list);
				}
				if (javasort.isSelected()==true){
					BigOInfo.javaSortInfo(list);
				}
				
				JOptionPane.showMessageDialog(null, "List sorted to \"sortedlist.txt\". Information on Logistics can be found at \"bigolist.txt\". ");
			
				}
				catch(Exception x){
					JOptionPane.showMessageDialog(null,
						    "You have not selected a list to sort!",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
				}
				

			}
			
			if (job==3){
				
			    int returnVal = jfca.showOpenDialog(null);
			    File f;
			    
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       //System.out.println("You chose to open this file: " +
			         //   jfca.getSelectedFile().getName());
			       
			       f= jfca.getSelectedFile();
			       try{
			       list=FileHandler.interpretFile(f);
			       }
			       catch(Exception x){
			    	   JOptionPane.showMessageDialog(null,
							    "Error Occured in Interpreting List",
							    "Warning",
							    JOptionPane.WARNING_MESSAGE);
			       }
			       
			       JOptionPane.showMessageDialog(null, "List successfully imported! ");
			       currentfile.setText(jfca.getSelectedFile().getName());
			       
			    }
				
			    
			    
				
				
				
			}
			
			
		}
			
	}
	
	
	
	
	
}
