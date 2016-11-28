import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Sekigae extends JFrame implements ActionListener{
	JButton sfl_btn, clr_btn;
	int numbers[] = new int[42];
	JLabel label[] = new JLabel[42];
	public static void main(String[] args) {
		Sekigae sg = new Sekigae();
		sg.setVisible(true);
	}
	private static int rand(int min, int max) {
		double a = min + Math.floor(Math.random() * (max - min + 1));
		return (int)a;
	}
	private static void shuffle(int number[]) {
		for (int i = 0; i < 42; i++) {
			int index_num1 = rand(0,41);
			int index_num2 = rand(0,41);
			int temp = number[index_num1];
			number[index_num1] = number[index_num2];
			number[index_num2] = temp;
		}
	}
	private static void clear(int number[]) {
		for (int i = 1; i <= 42; i++) {
			number[i-1] = i;
		}
	}
	Sekigae() {
		setTitle("席替え");
		JLabel top_table = new JLabel("教卓");
		JLabel msg = new JLabel("「シャッフル!」をクリックして席替え");
		JPanel panel[] = new JPanel[10];
		/*出席番号*/
		for (int i = 1; i <= 42; i++) {
			numbers[i-1] = i;
		}
		/*境界線*/
		LineBorder border = new LineBorder(Color.BLACK, 1, true);
		/*42個のラベル*/
		for (int i = 0; i < 42; i++) {
			label[i] = new JLabel();
			label[i].setText(Integer.toString(numbers[i]));
			label[i].setBorder(border);
			label[i].setPreferredSize(new Dimension(50,40));
			label[i].setHorizontalAlignment(JLabel.CENTER);
			label[i].setVerticalAlignment(JLabel.CENTER);
		}
		/*10個のパネル*/
		for (int i = 0; i < 10; i++) {
			panel[i] = new JPanel();
		}
		/*ボタンの設定*/
		sfl_btn = new JButton("シャッフル!");
		sfl_btn.addActionListener(this);
		clr_btn = new JButton("クリア");
		clr_btn.addActionListener(this);
		/*パネルへの各部品の追加*/
		panel[0].add(msg);
		panel[1].add(top_table);
		int counter = 0;
		for (int i = 2; i <= 8; i++) {
			for (int j = counter; j < 42; j+=7) {
				panel[i].add(label[j]);
			}
			counter++;
		}
		panel[9].add(sfl_btn);
		panel[9].add(clr_btn);
		
		JPanel p = new JPanel();
		GridLayout layout = new GridLayout(10,1);
		p.setLayout(layout);
		for (int i = 0; i < 10; i++) {
		    p.add(panel[i]);
		}
		/*
		p.add(panel[0]);
		p.add(panel[1]);
		p.add(panel[2]);
		p.add(panel[3]);
		p.add(panel[4]);
		p.add(panel[5]);
		p.add(panel[6]);
		p.add(panel[7]);
		p.add(panel[8]);
		p.add(panel[9]);
		*/
		getContentPane().add(p, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,400,550);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sfl_btn) {
			shuffle(numbers);
			for (int i = 0; i < 42; i++) {
				label[i].setText(Integer.toString(numbers[i]));
			}
		} else if (e.getSource() == clr_btn) {
			clear(numbers);
			for (int i = 0; i < 42; i++) {
				label[i].setText(Integer.toString(numbers[i]));
			}
		}
	}
}
