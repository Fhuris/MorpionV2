package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import jeu.Clic;
import listener.HumanListener;
import listener.IaListener;

@SuppressWarnings("serial")
public class Grille extends JFrame {
	
	private int[] b={0,0,0,0,0,0,0,0,0};
	private int compt=0;
	private Clic clic=new Clic();
	private ArrayList<JButton> gril;
	private boolean tour=true;
		
	public Grille(int ia){
		setSize(405,428);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Morpion");
		setResizable(false);
		setLocationRelativeTo(null);
		

		setLayout(new GridLayout(3,3));
		
		Font f=new Font("DejaVu Sans",Font.PLAIN,80);
		this.gril=new ArrayList<JButton>();
		for(int i=0;i<9;i++){
			gril.add(new JButton(""));
			gril.get(i).setFont(f);
			gril.get(i).setBackground(Color.white);
			add(gril.get(i));
		}
		
		if(ia==0){
			for(int i=0;i<9;i++){
				gril.get(i).addActionListener(new HumanListener(i, gril, this));
			}
		}else{
			for(int i=0;i<9;i++){
				gril.get(i).addActionListener(new IaListener(i, gril, this, ia));
			}
		}
	}
	
	public void setGril(ArrayList<JButton> gril) {
			this.gril = gril;
	}
	
	public void setTour(boolean tour){
		this.tour=tour;
	}
	
	public void setB(int i,int a) {
		this.b[i] = a;
	}

	public void setCompt(int compt) {
		this.compt = compt;
	}

	public void setClic(Clic clic) {
		this.clic = clic;
	}

	public int[] getB() {
		return b;
	}

	public int getCompt() {
		return compt;
	}

	public Clic getClic() {
		return clic;
	}

	public boolean getTour() {
		return tour;
	}
}

	
	
