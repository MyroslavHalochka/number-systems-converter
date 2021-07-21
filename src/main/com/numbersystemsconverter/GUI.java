package main.com.numbersystemsconverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.com.numbersystemsconverter.Controller.*;

public class GUI extends JFrame {

    private final JLabel label = new JLabel("Введите значение:");
    private final JLabel resultLabel = new JLabel("");
    private final JTextField textFieldInput = new JTextField("", 8);
    private final JTextField textFieldOutput = new JTextField("", 8);
    private final JButton button = new JButton("Перевести");
//    private Icon icon = UIManager.getIcon("OptionPane.informationIcon");

    public GUI () {

        super("Конвертер систем исчисления");
        this.setBounds(100, 100, 250, 100); //размеры окна
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //снятие процесса после нажатия крестика
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));
        container.add(label);
        container.add(textFieldInput);
        container.add(button);
        container.add(textFieldOutput);
//        container.add(resultLabel);

        button.addActionListener(new ButtonEventListener ());

    }

    class ButtonEventListener implements ActionListener {

        public void actionPerformed (ActionEvent e) {

            String message = decimalToHexadecimal(Integer.parseInt(textFieldInput.getText())); //ввод числа for int input
            
//            int message = binaryToDecimal(String.valueOf(Integer.parseInt(textFieldInput.getText()))); for String input

//            resultLabel.setText(message);

            textFieldOutput.setText(message);
//            textFieldOutput.setText(String.valueOf(message));

            JOptionPane.showMessageDialog(null, resultLabel, "Результат", JOptionPane.INFORMATION_MESSAGE); //Вывод текста в новом окне

        }

    }

}
