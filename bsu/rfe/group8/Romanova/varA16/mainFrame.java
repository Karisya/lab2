package bsu.rfe.group8.Romanova.varA16;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class mainFrame extends JFrame{

private static final int WIDTH = 600; private static final int HEIGHT = 520;

private JTextField textFieldY; 
private JTextField textFieldX;  
private JTextField textFieldZ; 
private JTextField textFieldResult;
private ButtonGroup radioButtons = new ButtonGroup(); 
private Box hboxFormulaType = Box.createHorizontalBox(); 
private int formulaId = 1;  
private double newValue = 0; 

public double calculate1(double x, double y, double z)
{return Math.sin(Math.sin(y)+Math.pow(Math.E, Math.cos(y))+z*z)*Math.pow(Math.sin(Math.PI*y*y)+Math.log(x*x), 1/4);}

public double calculate2(double x, double y, double z)
{return Math.pow(x,x)/(Math.sqrt(Math.pow(y, 3)+1) + Math.log(z));}

private void addRadioButton(String buttonName, final int formulaId) { 
 JRadioButton button = new JRadioButton(buttonName);
 button.addActionListener(new ActionListener() { 
 public void actionPerformed(ActionEvent ev) {
  mainFrame.this.formulaId = formulaId; 
  } 
 });

 radioButtons.add(button);
hboxFormulaType.add(button);
}

public mainFrame() {

   super("Вычисление формулы");
setSize(WIDTH, HEIGHT);
Toolkit kit = Toolkit.getDefaultToolkit(); //получение ряда характеристик
setLocation((kit.getScreenSize().height - HEIGHT)/2, (kit.getScreenSize().height - HEIGHT)/2);
hboxFormulaType.add(Box.createHorizontalGlue()); 
addRadioButton("Формула 1", 1);
addRadioButton("Формула 2", 2);
radioButtons.setSelected(((AbstractButton) radioButtons.getElements().nextElement()).getModel(), true);
//radioButtons.setSelected(radioButtons.getElements().nextElement().getModel(), true);
hboxFormulaType.add(Box.createHorizontalGlue()); 
hboxFormulaType.setBorder(BorderFactory.createLineBorder(Color.YELLOW));

JLabel labelForX = new JLabel("X:"); 
textFieldX = new JTextField("0", 10);
textFieldX.setMaximumSize(textFieldX.getPreferredSize());

JLabel labelForY = new JLabel("Y:"); 
textFieldY = new JTextField("0", 10);
textFieldY.setMaximumSize(textFieldY.getPreferredSize());

JLabel labelForZ = new JLabel("Z:");
textFieldZ = new JTextField("0", 10);
textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());
Box hboxVariables = Box.createHorizontalBox();


hboxVariables.setBorder(BorderFactory.createLineBorder(Color.RED)); 
//hboxVariables.add(Box.createHorizontalGlue()); 
hboxVariables.add(Box.createHorizontalStrut(10)); 
hboxVariables.add(labelForX,BorderLayout.WEST);
hboxVariables.add(textFieldX, BorderLayout.WEST);
hboxVariables.add(Box.createHorizontalGlue());
hboxVariables.add(labelForY,BorderLayout.CENTER); 
hboxVariables.add(textFieldY, BorderLayout.CENTER);
hboxVariables.add(Box.createHorizontalGlue());
hboxVariables.add(labelForZ, BorderLayout.EAST); 
hboxVariables.add(textFieldZ,BorderLayout.EAST);
//hboxVariables.add(Box.createHorizontalGlue());


JLabel labelForResult = new JLabel("Результат:");
textFieldResult = new JTextField("0", 20); 
textFieldResult.setMaximumSize(textFieldResult.getPreferredSize());
Box hboxResult = Box.createHorizontalBox();
hboxResult.add(Box.createHorizontalGlue()); 
hboxResult.add(labelForResult); 
hboxResult.add(Box.createHorizontalStrut(10));
hboxResult.add(textFieldResult);
hboxResult.add(Box.createHorizontalGlue());
hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE));
JButton buttonCalc = new JButton("Вычислить");
buttonCalc.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ev) { try {
 
double x = Double.parseDouble(textFieldX.getText());
double y = Double.parseDouble(textFieldY.getText()); 
double z = Double.parseDouble(textFieldZ.getText()); 
double result;
if (formulaId == 1)
result = calculate1(x, y, z);
else
result = calculate2(x, y, z); 
textFieldResult.setText(Double.toString(result));
} catch (NumberFormatException ex) 
  { JOptionPane.showMessageDialog(mainFrame.this,"Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа", JOptionPane.WARNING_MESSAGE);
}
}
});


JButton buttonReset = new JButton("MC"); 
buttonReset.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ev) { 
 newValue = 0;
}
} );

JButton buttonMemoryPlus = new JButton("M+");
buttonMemoryPlus.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
      newValue += Double.parseDouble(textFieldResult.getText());
  }
});

JButton buttonMemoryRead = new JButton("MR");
buttonMemoryRead.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
      textFieldResult.setText(Double.toString(newValue));
  }
});

JButton buttonCleanEntry = new JButton("CE");
buttonCleanEntry.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    textFieldY.setText("0");
    textFieldX.setText("0");
    textFieldZ.setText("0");
    textFieldResult.setText("0");
   }
 });

Box hboxButtons = Box.createHorizontalBox();

hboxButtons.add(buttonCalc, BorderLayout.WEST);
hboxButtons.add(buttonCleanEntry, BorderLayout.WEST);
hboxButtons.add(Box.createHorizontalGlue()); 
hboxButtons.add(Box.createHorizontalStrut(30)); 
hboxButtons.add(buttonReset, BorderLayout.EAST);
//hboxButtons.add(Box.createHorizontalStrut(30)); 
hboxButtons.add(buttonMemoryPlus, BorderLayout.EAST);
//hboxButtons.add(Box.createHorizontalStrut(30)); 
hboxButtons.add(buttonMemoryRead, BorderLayout.EAST);
//hboxButtons.add(Box.createHorizontalGlue()); 
//hboxButtons.add(Box.createHorizontalStrut(30)); 
//hboxButtons.add(Box.createHorizontalGlue()); 


hboxButtons.setBorder(
BorderFactory.createLineBorder(Color.GREEN));

Box contentBox = Box.createVerticalBox();
contentBox.add(Box.createVerticalGlue());
contentBox.add(hboxFormulaType);
contentBox.add(hboxVariables); 
contentBox.add(hboxButtons);
contentBox.add(hboxResult); 
contentBox.add(Box.createVerticalGlue()); 
getContentPane().add(contentBox, BorderLayout.CENTER);

}

public static void main(String[] args) {
mainFrame frame = new mainFrame(); 
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frame.setVisible(true);
} }