package Calculator;

import javax.swing.*;
import java.awt.event.*;

public class Calculator extends JFrame{
	JTextField io;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bdiv,bmul,bmin,bpls,beql,bc,bpoint,bback;
	double pre,res;
	String op = null;
	String prepoint = null;
	String lastvalue = null;
	
	public void setComponents()
	{
		io = new JTextField(null);
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		b0 = new JButton("0");
		bdiv = new JButton("/");
		bmin = new JButton("-");
		bmul = new JButton("*");
		bpls = new JButton("+");
		beql = new JButton("=");
		bc = new JButton("C");
		bpoint = new JButton(".");
		bback = new JButton("<");

		// event handlig
		b1.addActionListener(new NumberHandler("1")); 
		b2.addActionListener(new NumberHandler("2"));
		b3.addActionListener(new NumberHandler("3"));
		b4.addActionListener(new NumberHandler("4"));
		b5.addActionListener(new NumberHandler("5"));
		b6.addActionListener(new NumberHandler("6"));
		b7.addActionListener(new NumberHandler("7"));
		b8.addActionListener(new NumberHandler("8"));
		b9.addActionListener(new NumberHandler("1"));
		b0.addActionListener(new NumberHandler("0"));
		
		bc.addActionListener(new CHandler());
		
		bdiv.addActionListener(new OpHandler("/"));
		bmul.addActionListener(new OpHandler("*"));
		bmin.addActionListener(new OpHandler("-"));
		bpls.addActionListener(new OpHandler("+"));
		
		beql.addActionListener(new EqlHandler());
		bpoint.addActionListener(new PointHandler());
		bback.addActionListener(new BackSpaceHandler());
		
		setLayout(null);
		
		add(io);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
		add(b9);
		add(b0);
		add(bdiv);
		add(bmul);
		add(bmin);
		add(bpls);
		add(beql);
		add(bc);
		add(bpoint);
		add(bback);
		
		io.setBounds(5,5,235,40);

		bback.setBounds(5,50,55,30);
		//b8.setBounds(65,50,55,30);
		//b9.setBounds(125,50,55,30);
		bc.setBounds(185,50,55,30);
		
		b7.setBounds(5,85,55,30);
		b8.setBounds(65,85,55,30);
		b9.setBounds(125,85,55,30);
		bdiv.setBounds(185,85,55,30);
		
		b4.setBounds(5,120,55,30);
		b5.setBounds(65,120,55,30);
		b6.setBounds(125,120,55,30);
		bmul.setBounds(185,120,55,30);
		
		b1.setBounds(5,155,55,30);
		b2.setBounds(65,155,55,30);
		b3.setBounds(125,155,55,30);
		bmin.setBounds(185,155,55,30);
		
		bpoint.setBounds(5,190,55,30);
		b0.setBounds(65,190,55,30);
		beql.setBounds(125,190,55,30);
		bpls.setBounds(185,190,55,30);
		
	}
	class NumberHandler implements ActionListener
	{
		String k;
		public NumberHandler(String s)
		{
			k = s;
		}
		public void actionPerformed(ActionEvent e)
		{
			if(io.getText() == null)
				io.setText(k);
			else {
				String i = io.getText();
				io.setText(i+k);
			}
			lastvalue = k;
		}
	}
	class CHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			io.setText(null);
			op = null;
			lastvalue = null;
			prepoint = null;
		}
	}
	
	class OpHandler implements ActionListener
	{
		String k;
		public OpHandler(String s)
		{
			k = s;
		}
		public void actionPerformed(ActionEvent e)
		{
			if(io.getText() != null)
			{
				pre = Double.parseDouble(io.getText());
				op = k;
				io.setText(null);
				lastvalue = null;
				prepoint = null;
			}	
		}
	}
	
	class EqlHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(op != null)
			{
				String n = io.getText();
				if(lastvalue == "." && prepoint != null)
					n = n + "0";
				Double now = Double.parseDouble(n);
				if(op == "+")
				{
					res = now + pre;
					io.setText(""+res);
					op = null;
				}
				else if(op == "-")
				{
					res = pre - now;
					io.setText(""+res);
					op = null;
				}
				else if(op == "*")
				{
					res = pre*now;
					io.setText(""+res);
					op = null;
				}
				else if(op == "/")
				{
					res = pre/now;
					io.setText(""+res);
					op = null;
				}
				else{
					io.setText("Invalid operation");
				}
				prepoint = null;
				lastvalue = null;
			}
		}
	}
	class PointHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(prepoint == null)
			{
				if(io.getText() == null)
				{
					io.setText("0.");
				}
				else{
					String s = io.getText();
					io.setText(s+".");
				}
				prepoint = "true";
			}
		}
	}
	class BackSpaceHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(io.getText() != null)
			{
				String s = io.getText();
				if(prepoint == null)
					s = s.substring(0,s.length()-1);
				else {
					s = s.substring(0,s.length()-1);
					lastvalue = null;
					prepoint = null;
				}
				io.setText(s);
			}
		}
	}
	public Calculator(String name)
	{
		super(name);
	}
	public static void main(String[] args)
	{
		Calculator jf = new Calculator("Calculator");
		jf.setComponents();
		jf.setSize(260,265);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}