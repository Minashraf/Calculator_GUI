package eg.edu.alexu.csd.oop.calculator.cs67;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalInterface {

    private JPanel Frame;
    private JButton nextButton;
    private JButton previousButton;
    private JButton loadButton;
    private JButton MultiplicationButton;
    private JButton a0Button;
    private JButton currentButton;
    private JButton saveButton;
    private JButton divisionButton;
    private JButton EqualButton;
    private JButton AdditionButton;
    private JButton SubstractionButton;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton a5Button;
    private JButton a4Button;
    private JButton a6Button;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton DecimalButton;
    private JButton backspaceButton;
    private JButton clearButton;
    private JLabel Display;
    private JLabel Result;

    private Calculator calcul=new CalculatorImplementation();
    public GraphicalInterface() {

        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display.setText(Display.getText()+'0');
            }
        });
        DecimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display.setText(Display.getText()+'.');
            }
        });
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display.setText(Display.getText()+'1');
            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display.setText(Display.getText()+'2');
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display.setText(Display.getText()+'3');
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display.setText(Display.getText()+'4');
            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display.setText(Display.getText()+'5');
            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display.setText(Display.getText()+'6');
            }
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display.setText(Display.getText()+'7');
            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display.setText(Display.getText()+'8');
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display.setText(Display.getText()+'9');
            }
        });
        AdditionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display.setText(Display.getText()+'+');
            }
        });
        SubstractionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display.setText(Display.getText()+'-');
            }
        });
        MultiplicationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display.setText(Display.getText()+'*');
            }
        });
        divisionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display.setText(Display.getText()+'/');
            }
        });
        EqualButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    calcul.input(Display.getText());
                } catch (Exception E)
                {
                    JOptionPane.showMessageDialog(Frame,
                            "Make sure you entered a valid input!",
                            "Syntax error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    Result.setText(calcul.getResult());
                } catch (Exception E)
                {
                    JOptionPane.showMessageDialog(Frame,
                            "Make sure you entered a valid mathematical equation!",
                            "Math error",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcul.save();
                JOptionPane.showMessageDialog(Frame,
                        "Saved successfully!");
            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    calcul.load();
                }catch (Exception E)
                {
                    JOptionPane.showMessageDialog(Frame,
                            "No previously saved files!",
                            "Load error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(Frame,
                        "Loaded successfully!");
                Display.setText(calcul.current());
            }
        });
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prev=calcul.prev();
                if(prev!=null)
                {
                    Display.setText(prev);
                    Result.setText(calcul.getResult());
                }

                else
                    JOptionPane.showMessageDialog(Frame,
                            "No previously saved operations!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String next=calcul.next();
                if(next!=null)
                {
                    Display.setText(next);
                    Result.setText(calcul.getResult() );
                }
                else
                    JOptionPane.showMessageDialog(Frame,
                            "You reached the last operation!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);

            }
        });
        currentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String current=calcul.current();
                if(current!=null)
                    Display.setText(current);
                else
                    JOptionPane.showMessageDialog(Frame,
                            "No current operation found!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
            }
        });

        backspaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Display.getText().length()!=0)
                    Display.setText(Display.getText().substring(0,Display.getText().length()-1));
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display.setText("");
                //Result.setText("");
            }
        });
    }
    public static void main(String[] args) {
        GraphicalInterface gui = new GraphicalInterface();
        JFrame jf=new JFrame();
        gui.Frame.setBorder(new EmptyBorder(10, 10, 10, 10));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(500, 500);
        jf.getContentPane().add(gui.Frame);
        jf.setLocation(500,50);
        jf.setVisible(true);
    }
}
