package graphics;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import trafficlight.Iterate;


public class Graphics {
    
int summ, firstInt, secondInt;//числа из ген алгоритма  
int y=10;
Timer timer;

JLabel label1;

JLabel label2;
JLabel label3;
JPanel panel = new JPanel();
JTextField filePath = new JTextField();

public Graphics(int summ, int firstInt, int secondInt) {
    this.summ = summ;
    this.firstInt = firstInt;
    this.secondInt = secondInt;
    label1 = new JLabel(String.valueOf(summ));
    label2 = new JLabel(String.valueOf(firstInt));
    label3 = new JLabel(String.valueOf(secondInt));
    start();
}


public void start(){
    System.err.println(label1.getText());
    this.timer = new Timer(1,timerListener);
    JFrame frame = new JFrame();
   
    JButton button = new JButton("next");
    JTextField text = new JTextField();
    
    frame.setContentPane(panel);
    frame.setLayout(null);
    
    panel.add(button);
    panel.add(text);
    panel.add(label1);
    panel.add(label2);
    panel.add(label3);
    panel.add(filePath);
    
    label1.setFont(new Font("Serif", Font.PLAIN, 36));
    label2.setFont(new Font("Serif",Font.PLAIN,36));
    label3.setFont(new Font("Serif",Font.PLAIN,36));
    
    label1.setBounds(280, 10, 20, 30);
    label2.setBounds(210, 70, 20, 30);
    label3.setBounds(350,70,20,30);
    button.setBounds(500, 300, 80, 20);
    button.addActionListener(buttonListener);
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 400);
    frame.setVisible(true);
    
    label2.setVisible(false);
    label3.setVisible(false);
}//добавление всякой всячины на фрейм

public void createL(){
    JLabel label = new JLabel(String.valueOf(firstInt));
    JLabel labelv= new JLabel(String.valueOf(secondInt));
    panel.add(label);
    panel.add(labelv); 
    label.setBounds(500,y,20,30);
    labelv.setBounds(530, y, 20, 30); 
    y=y+20;
}

ActionListener buttonListener = new ActionListener(){
   
    @Override
    public void actionPerformed(ActionEvent e) {//для кнопки
     createL();
     label2.setVisible(true);
     label3.setVisible(true);
     String fileName = filePath.getText();
        try {
            Iterate start = new Iterate(0, fileName);
        } catch (FileNotFoundException ex) {
           System.err.println("error");
        }
     timer.start();
    }
    
};

ActionListener timerListener = new ActionListener(){//для таймера
   int x1=210,y1=70,x2=350,y2=70;//координаты лейблов
    @Override
    public void actionPerformed(ActionEvent e){
        label2.setLocation(x1, y1);
        label3.setLocation(x2, y2);
        x1--; y1++;
        x2++;y2++;
        if(y1 == 150) {
            timer.stop();
            x1 = 210;
            y1 = 70;
            x2 = 350;
            y2 = 70;
        }
    }
};
}
