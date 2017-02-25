package listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;

import interfaces.Final;
import interfaces.Grille;
import jeu.Conditions;

public class IaListener implements ActionListener {
		
		private int k;
		private int j;
		ArrayList<JButton> gril=new ArrayList<JButton>();
		Grille frame;
		Random r=new Random();
		private boolean v=false;
		private int ia;
		
		public IaListener(int k, ArrayList<JButton> gril, Grille frame, int ia){
			this.k=k;
			this.gril=gril;
			this.frame=frame;
			this.ia=ia;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (frame.getB()[k]==0){
				frame.getClic().setI(k);
				frame.getB()[k]=1;
				gril.get(k).setText("O");
				frame.getClic().clicked(1);
				frame.setGril(gril);				
				frame.setCompt(frame.getCompt()+1);
				if(frame.getCompt()==9 && Conditions.testV(frame.getClic().getCases())[3]==-1){
					Final fin=new Final(0,true,frame);
					for(int i=0;i<9;i++)
						frame.getB()[i]=1;
					fin.setVisible(true);
					v=true;
				}
				if(Conditions.testV(frame.getClic().getCases())[3]==0){
					Final fin=new Final(1,true,frame);
					for(int i=0;i<3;i++)
						gril.get(Conditions.testV(frame.getClic().getCases())[i]).setBackground(Color.green);
					frame.setGril(gril);
					for(int i=0;i<9;i++)
						frame.getB()[i]=1;
					fin.setVisible(true);
					v=true;
				}
		
				if(v!=true){
					if(ia==3 && Conditions.testW(frame.getClic().getCases())!=-1){
						j=Conditions.testW(frame.getClic().getCases());
					}else if(ia!=1 && Conditions.testE(frame.getClic().getCases())!=-1){
						j=Conditions.testE(frame.getClic().getCases());
					}else{
						do{
							j=r.nextInt(8);
						}while(frame.getB()[j]==1);	
					}
					frame.getClic().setI(j);
					frame.getB()[j]=1;
					gril.get(j).setText("X");
					frame.getClic().clicked(10);
					frame.setGril(gril);				
					frame.setCompt(frame.getCompt()+1);
					if(frame.getCompt()==9 && Conditions.testV(frame.getClic().getCases())[3]==-1){
						Final fin=new Final(0,true,frame);
						for(int i=0;i<9;i++)
							frame.setB(i,1);
						fin.setVisible(true);
					}
					if(Conditions.testV(frame.getClic().getCases())[3]==1){
						Final fin=new Final(2,true,frame);
						for(int i=0;i<3;i++)
							gril.get(Conditions.testV(frame.getClic().getCases())[i]).setBackground(Color.red);
						frame.setGril(gril);
						for(int i=0;i<9;i++)
							frame.setB(i,1);
						fin.setVisible(true);
					}
				}
			}
		}
}

