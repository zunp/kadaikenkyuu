import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Calc extends JFrame implements ActionListener{
	JButton btn[] = new JButton[16];
	JPanel panel[] = new JPanel[5];
	JLabel label_1 = new JLabel("0");
	String formula = "";
	String marks[] = new String[100];
	double result = 0;
	int formula_c = 0;
	double numbers[] = new double[100];
	public static void main(String[] args) {
		Calc cc = new Calc();
		cc.setVisible(true);
	}
	Calc() {
		setTitle("簡易電卓");
		LineBorder border = new LineBorder(Color.BLACK, 1, true);
		label_1.setPreferredSize(new Dimension(300, 80));
		label_1.setBorder(border);
		label_1.setForeground(Color.gray);
		label_1.setFont(new Font("Arial", Font.PLAIN, 16));
		label_1.setHorizontalAlignment(JLabel.RIGHT);
		for (int i = 0; i < 5; i++) {
			panel[i] = new JPanel();
		}
		for (int i = 0; i < 16; i++) {
			btn[i] = new JButton();
			btn[i].addActionListener(this);
			btn[i].setPreferredSize(new Dimension(70, 70));
		}
		marks[0] = "+";
		btn[0].setText("7");
		btn[1].setText("8");
		btn[2].setText("9");
		btn[3].setText("-");
		btn[4].setText("4");
		btn[5].setText("5");
		btn[6].setText("6");
		btn[7].setText("+");
		btn[8].setText("1");
		btn[9].setText("2");
		btn[10].setText("3");
		btn[11].setText("c");
		btn[12].setText("0");
		btn[13].setText("00");
		btn[14].setText(".");
		btn[15].setText("=");
		
		panel[0].add(label_1);
		int count = 0;
		for (int i = 1; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				panel[i].add(btn[count]);
				count++;
			}
		}
		
		JPanel p = new JPanel();
		GridLayout layout = new GridLayout(5,1);
		p.setLayout(layout);
		p.add(panel[0]);
		p.add(panel[1]);
		p.add(panel[2]);
		p.add(panel[3]);
		p.add(panel[4]);
		
		getContentPane().add(p, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(10,10,350,470);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn[0]) {
			formula += "7";
		} else if (e.getSource() == btn[1]) {
			formula += "8";
		} else if (e.getSource() == btn[2]) {
			formula += "9";
		} else if (e.getSource() == btn[3]) {
			numbers[formula_c] = Double.parseDouble(formula);
			formula_c++;
			marks[formula_c] = "-";
			formula += "-";
		} else if (e.getSource() == btn[4]) {
			formula += "4";
		} else if (e.getSource() == btn[5]) {
			formula += "5";
		} else if (e.getSource() == btn[6]) {
			formula += "6";
		} else if (e.getSource() == btn[7]) {
			numbers[formula_c] = Double.parseDouble(formula);
			formula_c++;
			marks[formula_c] = "+";
			formula += "+";
		} else if (e.getSource() == btn[8]) {
			formula += "1";
		} else if (e.getSource() == btn[9]) {
			formula += "2";
		} else if (e.getSource() == btn[10]) {
			formula += "3";
		} else if (e.getSource() == btn[11]) {
			double numbers[] = new double[100];
			formula_c = 0;
			formula = "0";
		} else if (e.getSource() == btn[12]) {
			formula += "0";
		} else if (e.getSource() == btn[13]) {
			formula += "00";
		} else if (e.getSource() == btn[14]) {
			formula += ".";
		} else if (e.getSource() == btn[15]) {
			System.out.println();
			for (int i = 0; i < numbers.length; i++) {
				switch (marks[i]) {
					case "+":
						result += numbers[i];
						break;
					case "-":
						result -= numbers[i];
						break;
				}
			}
			formula = Double.toString(result);
		}
		label_1.setText(formula);
	}
}