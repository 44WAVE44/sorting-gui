package sorting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class sorting {
	
	public static void main(String[]args) throws Exception {
		
		Sframe frm = new Sframe();
		frm.Sortframe();
		
	}

}

class Sframe extends JFrame implements ActionListener {
	
	JButton btn,btn1,btn2,btn3;
	JTextField txf;
	JTextArea txa,txa1,txa2;
	
	public void Sortframe () throws Exception {
		
		this.setTitle("SortingAlgorithm's");
		this.setLayout(null);
		this.setSize(500,500);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txa = new JTextArea("Input number's");
		txa.setBounds(201,10,83,18);
		txa.setEditable(false);
		txa.setBackground(getForeground());
		txa.setFocusable(false);
		this.getContentPane().add(txa);
		
		txf = new JTextField();
		txf.setBounds(49,30,385,50);
		JScrollPane scpf = new JScrollPane(txf);
		scpf.setBounds(49,30,385,50);
		scpf.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scpf.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(scpf);
		
		btn = new JButton("Add");
		btn.setBounds(211,95,60,40);
		btn.addActionListener(this);
		this.add(btn);
		
		txa1 = new JTextArea();
		txa1.setFocusable(false);
		JScrollPane scp = new JScrollPane(txa1);
		scp.setBounds(49,150,385,50);
		scp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(scp);
		
		btn1 = new JButton("QuickSort");
		btn1.setBounds(284,215,150,40);
		btn1.addActionListener(this);
		this.add(btn1);
		
		txa2 = new JTextArea();
		txa2.setFocusable(false);
		JScrollPane scp1 = new JScrollPane(txa2);
		scp1.setBounds(49,270,385,50);
		scp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(scp1);
		
		btn2 = new JButton("Clear");
		btn2.setBounds(209,335,64,40);
		btn2.addActionListener(this);
		this.add(btn2);
		
		btn3 = new JButton("InsertionSort");
		btn3.setBounds(49,215,150,40);
		btn3.addActionListener(this);
		this.add(btn3);
		
		this.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			
			if (e.getSource() == btn) {
				
				String input = txf.getText();
				int input_int = Integer.parseInt(input);
				txf.setText(null);
				txa1.append(input_int+",");
		
				
			}
			else if (e.getSource() == btn1) {
				
				//****QUICKSORT****//
				
				txa2.setText(null);
				
				SortingAlgorithmOne qck = new SortingAlgorithmOne();
				
				String[] txa1Values = txa1.getText().split(",");
				int[] sorting = new int[txa1Values.length];
				
				for(int i=0;i<sorting.length;i++) {
					sorting[i] = Integer.parseInt(txa1Values[i]);
				}

					for(int l=0;l<sorting.length;l++) {System.out.print(sorting[l]);}
					
					qck.quickSort(sorting, 0, sorting.length-1);
					
					for(int k=0;k<=sorting.length;k++) {
						txa2.append(sorting[k]+",");
					}
					
			}	
			else if (e.getSource() == btn2) {
				txa1.setText(null);
				txa2.setText(null);
			}
			
			else if (e.getSource() == btn3) {
				
				//****INSERTIONSORT****//
				
				txa2.setText(null);
				
				SortingAlgorithmTwo ins = new SortingAlgorithmTwo();
				
				String[] txa1Values = txa1.getText().split(",");
				int[] sorting = new int[txa1Values.length];
				
				for(int i=0;i<sorting.length;i++) {
					sorting[i] = Integer.parseInt(txa1Values[i]);
				}
				
				ins.InsertionSort(sorting);
				
				for(int k=0;k<=sorting.length;k++) {
					txa2.append(sorting[k]+",");
				}
				
			}
			
			
		} catch (Exception e2) {}
		
	}
	
	
}

		//********************SORTING ALGORITHMS********************//

	class SortingAlgorithmOne {
	
	public static void quickSort(int[] array,int start,int end) {
		
		
		if(end<=start) return;
		
		int pivot = partition(array, start, end);
		
		quickSort(array, start, pivot-1);
		quickSort(array, pivot+1, end);
		
	}
	
	public static int partition(int[] array,int start,int end) {
		
		int pivot = array[end];
		int i= start-1;
		
		for(int j= start;j<= end-1;j++) {
			if(array[j]<pivot) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;

			}
		}
		i++;
		int temp = array[i];
		array[i] = array[end];
		array[end] = temp;
		
		return i;
		
	}
	
}

	class SortingAlgorithmTwo {
		
		public static void InsertionSort(int[]array) {
			
			for(int i = 1; i< array.length;i++) {
				int temp = array[i];
				int j = i-1;
				
				while(j>=0 && array[j] > temp) {
					array[j+1] = array[j];
					j--;
				}
				array[j+1] = temp;
			}
			
		}
		
	}













