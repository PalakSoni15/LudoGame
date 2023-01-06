package ludo.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameMoves extends JPanel implements KeyListener, ActionListener, MouseListener{

    private static final long serialVersionUID = 1L;
    Layout la;
    Build_Player p;
    Timer time;
    int delay=10;
    int current_player,dice;
    int flag=0,roll,kill=0;
    public GameMoves() {
        setFocusTraversalKeysEnabled(false);
        requestFocus();
        current_player=0;
        la = new Layout(80,50);
        p=new Build_Player(la.height,la.width);
        dice=0;
        flag=0;
        roll=0;
        kill=0;
    }

    @Override
    public void paint(Graphics g) {
        Color red = new Color(213,76,86);
        Color green = new Color(25,180,131);
        Color yellow = new Color(210,213,105);
        Color blue = new Color(71,124,213);
        la.draw((Graphics2D)g);
        p.draw((Graphics2D)g);
        if(p.pl[current_player].coin==4) {
            g.setColor(Color.WHITE);
            g.fillRect(125, 567, 350,35);
            if(current_player==0) {
                g.setColor(red);
            }
            else if(current_player==1) {
                g.setColor(green);
            }
            else if(current_player==2) {
                g.setColor(yellow);
            }
            else if(current_player==3) {
                g.setColor(blue);
            }
            g.setFont(new Font("tahoma", Font.BOLD, 20));
            //g.drawString("Player "+(current_player+1)+" wins.", 55, 580);
            //g.drawString("Congratulations.", 55, 600);
            g.drawString("Player "+(current_player+1)+" wins! Congratulations!", 144, 590);
            current_player=0;
            la = new Layout(80,50);
            p=new Build_Player(la.height,la.width);
            dice=0;
            flag=0;
            roll=0;
            kill=0;
        }
        else if(dice!=0) {
            g.setColor(Color.WHITE);
            g.fillRect(125, 567, 350,35);
            if(current_player==0) {
                g.setColor(red);
            }
            else if(current_player==1) {
                g.setColor(green);
            }
            else if(current_player==2) {
                g.setColor(yellow);
            }
            else if(current_player==3) {
                g.setColor(blue);
            }
            g.setFont(new Font("tahoma", Font.BOLD, 20));
            //g.drawString("Player "+(current_player+1), 55, 580);
            //g.drawString("Number on dice is "+dice, 55, 600);
            g.drawString("Player "+(current_player+1)+"    Number on dice is "+dice, 145, 590);

        }
        if(flag==0&&dice!=0&&dice!=6&&kill==0) {
            current_player=(current_player+1)%4;
        }
        kill=0;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        if (e.getKeyCode() == KeyEvent.VK_SPACE&&flag==0) {
            roll=0;
            dice=1 + (int)(Math.random() * 6);
            repaint();
            for(int i=0;i<4;i++) {
                if(p.pl[current_player].pa[i].current!=-1&&p.pl[current_player].pa[i].current!=56&&(p.pl[current_player].pa[i].current+dice)<=56) {
                    flag=1;
                    break;
                }
            }
            if(flag==0&&dice==6) {
                for(int i=0;i<4;i++) {
                    if(p.pl[current_player].pa[i].current==-1) {
                        flag=1;
                        break;
                    }
                }
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
        if(flag==1) {
            int x=e.getX();
            int y=e.getY();
            x=x-80;
            y=y-50;
            x=x/30;
            y=y/30;
            int value=-1;
            //System.out.println(x+" "+y);
            if(dice==6) {
                for(int i=0;i<4;i++) {
                    if(p.pl[current_player].pa[i].x==x&&p.pl[current_player].pa[i].y==y&&(p.pl[current_player].pa[i].current+dice)<=56) {
                        value=i;
                        flag=0;
                        break;
                    }
                }
                if(value!=-1) {
                    p.pl[current_player].pa[value].current+=dice;
                    if(p.pl[current_player].pa[value].current==56) {
                        p.pl[current_player].coin++;
                    }
                    int k=0;
                    int hou=p.pl[current_player].pa[value].current;
                    if((hou%13)!=0&&(hou%13)!=8&&hou<51)
                    {
                        for(int i=0;i<4;i++) {
                            if(i!=current_player) {
                                for(int j=0;j<4;j++) {
                                    int tem1= Path.ax[current_player][p.pl[current_player].pa[value].current],tem2= Path.ay[current_player][p.pl[current_player].pa[value].current];
                                    if(p.pl[i].pa[j].x==tem1&&p.pl[i].pa[j].y==tem2) {
                                        p.pl[i].pa[j].current=-1;
                                        kill=1;
                                        k=1;
                                        break;
                                    }
                                }
                            }
                            if(k==1)
                                break;
                        }
                    }
                }
                else {
                    for(int i=0;i<4;i++) {
                        if(p.pl[current_player].pa[i].current==-1) {
                            p.pl[current_player].pa[i].current=0;
                            flag=0;
                            break;
                        }
                    }
                }
            }
            else {
                for(int i=0;i<4;i++) {
                    if(p.pl[current_player].pa[i].x==x&&p.pl[current_player].pa[i].y==y&&(p.pl[current_player].pa[i].current+dice)<=56) {
                        value=i;
                        flag=0;
                        break;
                    }
                }
                if(value!=-1) {
                    p.pl[current_player].pa[value].current+=dice;
                    if(p.pl[current_player].pa[value].current==56) {
                        p.pl[current_player].coin++;
                    }
                    int k=0;
                    int hou=p.pl[current_player].pa[value].current;
                    if((hou%13)!=0&&(hou%13)!=8&&hou<51)
                    {
                        for(int i=0;i<4;i++) {
                            if(i!=current_player) {
                                for(int j=0;j<4;j++) {
                                    int tem1= Path.ax[current_player][p.pl[current_player].pa[value].current],tem2= Path.ay[current_player][p.pl[current_player].pa[value].current];
                                    if(p.pl[i].pa[j].x==tem1&&p.pl[i].pa[j].y==tem2) {
                                        p.pl[i].pa[j].current=-1;
                                        kill=1;
                                        k=1;
                                        break;
                                    }
                                }
                            }
                            if(k==1)
                                break;
                        }
                    }
                }
            }
            repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }


}