import java.awt.*;
import javax.swing.*;
import java.util.*;

public class ZegarWatek{
    public static void main(String[] args){

        JFrame okno=new JFrame("Zegar");
        okno.setSize(400,200);
        Panel panel=new Panel();
        okno.getContentPane().add(panel);
        okno.setDefaultCloseOperation(3);
        okno.setVisible(true);

    }
}

class Panel extends JPanel implements Runnable{

    int rok,mc,dzien,godz,min,sek;
    String smc,sdzien,sgodz,smin,ssek;
    Thread watek=null;


    public Panel(){
        watek=new Thread(this);
        watek.start();
    }
    public void paintComponent(Graphics g){

        g.clearRect(0,0,400,150);
        Font czcionka=new Font("Monospaced",Font.BOLD,30);
        g.setFont(czcionka);
        if(mc<9){ smc="0";} else smc="";
        if(dzien<10){ sdzien="0"; } else sdzien="";
        g.drawString(rok+"."+smc+(mc+1)+"."+sdzien+dzien,70,40);
        if(godz<10){ sgodz="0";} else sgodz="";
        if(min<10){ smin="0";} else smin="";
        if(sek<10){ ssek="0";} else ssek="";
        g.drawString(sgodz+godz+":"+smin+min+":"+ssek+sek,70,80);
    }


    public void run(){
        while(true){
            GregorianCalendar czas=new GregorianCalendar();
            rok=czas.get(Calendar.YEAR);
            mc=czas.get(Calendar.MONTH);
            dzien=czas.get(Calendar.DAY_OF_MONTH);
            godz=czas.get(Calendar.HOUR_OF_DAY);
            min=czas.get(Calendar.MINUTE);
            sek=czas.get(Calendar.SECOND);

            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){
                System.out.println("wystapil blad");}
            repaint();
        }
    }
}
