package listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import interfaces.Final;
import interfaces.Grille;
import jeu.Conditions;

public class HumanListener implements ActionListener {
		
		private int k;
		ArrayList<JButton> gril=new ArrayList<JButton>();
		Grille frame;
		
		public HumanListener(int k, ArrayList<JButton> gril, Grille frame){
			this.k=k;
			this.gril=gril;
			this.frame=frame;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (frame.getB()[k]==0){
				frame.getClic().setI(k);
				frame.getB()[k]=1;
				if(frame.getTour()==true){
					gril.get(k).setText("O");
					frame.setTour(false);
					frame.getClic().clicked(1);
				}else{
					gril.get(k).setText("X");
					frame.setTour(true);
					frame.getClic().clicked(10);
				}
				frame.setGril(gril);
				
				frame.setCompt(frame.getCompt()+1);
				if(frame.getCompt()==9 && Conditions.testV(frame.getClic().getCases())[3]==-1){
					Final fin=new Final(0,false,frame);
					fin.setVisible(true);
				}
				if(Conditions.testV(frame.getClic().getCases())[3]==0){
					Final fin=new Final(1,false,frame);
					for(int i=0;i<3;i++)
						gril.get(Conditions.testV(frame.getClic().getCases())[i]).setBackground(Color.green);
					frame.setGril(gril);
					fin.setVisible(true);
					for(int i=0;i<9;i++)
						frame.getB()[i]=1;
				}
				if(Conditions.testV(frame.getClic().getCases())[3]==1){
					Final fin=new Final(2,false,frame);
					for(int i=0;i<3;i++)
						gril.get(Conditions.testV(frame.getClic().getCases())[i]).setBackground(Color.green);
					frame.setGril(gril);
					fin.setVisible(true);
					for(int i=0;i<9;i++)
						frame.getB()[i]=1;
				}
			}
		}
	}

