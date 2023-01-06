package ludo.main;

import java.awt.*;

public class Pawn {
    int x,y;
    int current;
    int height,width;
    public Pawn(int h,int w){
        current=-1;
        x=-1;
        y=-1;
        height=h;
        width=w;
    }

    public void draw(Graphics2D g, int i, int j,int play) {

        Color red = new Color(213,76,86);
        Color green = new Color(25,180,131);
        Color yellow = new Color(210,213,105);
        Color blue = new Color(71,124,213);

        if(current==-1) {
            int temp1=80+(height/2),temp2=50+(width/2);
            x=i;
            y=j;
            if(play==0) {
                g.setColor(red);
            }
            else if(play==1) {
                g.setColor(green);
            }
            else if(play==2) {
                g.setColor(yellow);
            }
            else if(play==3) {
                g.setColor(blue);
            }
            g.fillOval(temp1+5+(i*width),temp2+5+(j*height),width-10,height-10);
            g.setStroke(new BasicStroke(2));
            g.setColor(Color.BLACK);
            g.drawOval(temp1+5+(i*width),temp2+5+(j*height),width-10,height-10);
        }
        else
        {
            int temp1=80,temp2=50;
            x= Path.ax[play][current];
            y= Path.ay[play][current];
            if(play==0) {
                g.setColor(red);
            }
            else if(play==1) {
                g.setColor(green);
            }
            else if(play==2) {
                g.setColor(yellow);
            }
            else if(play==3) {
                g.setColor(blue);
            }
            g.fillOval(temp1+5+(x*width),temp2+5+(y*height),width-10,height-10);
            g.setStroke(new BasicStroke(2));
            g.setColor(Color.BLACK);
            g.drawOval(temp1+5+(x*width),temp2+5+(y*height),width-10,height-10);
        }
    }
}
