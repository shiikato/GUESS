package com.company.gui;

import com.company.Main;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    //credit to Guru99

    public String question;

    //region fonts
    public Font font = new Font("Montserrat", Font.PLAIN, 16);
    public Font headerFont = new Font("Montserrat", Font.PLAIN, 20);
    //endregion
    //region window-specs
    private Color bg = new Color(255, 235, 255);
    private Border border = new EmptyBorder(0,0,0,0);
    private int sizeX = 400;
    private int sizeY = 600;
    //endregion
    //region gui-elements
    private JFrame frame;
    private JTextField tf;

    //region JButtons
        private JButton noBtn;
        private JButton yesBtn;
        //endregion

    //endregion

    public void initializeGUI()
    {
        //region frame
        frame = new JFrame("GUESS ME");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(sizeX, sizeY);
        //endregion

        //region user-in
        //creating user-input buttons
        JPanel userInPanel = new JPanel();
        userInPanel.setBorder(border); //remove border from panel

        yesBtn = new JButton("Yes");
        yesBtn.setFont(font); //set font to Montserrat-plan-16
        userInPanel.add(yesBtn); //ad btn to panel

        noBtn = new JButton("No");
        noBtn.setFont(font); //set font to Montserrat-plan-16
        userInPanel.add(noBtn); //add btn to panel

        setBtnActions();
        //endregion

        //region text field
        tf = new JTextField(Main.tree.pointer.prompt);
        tf.setFont(headerFont); //set font to Montserrat-plain-24
        tf.setBorder(border); //remove the border
        tf.setHorizontalAlignment(0); //center the text field
        tf.setEditable(false); //text is not editable
        //endregion

        //region adding to frame
        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, userInPanel); //add user input panel to bottom of win
        frame.getContentPane().add(BorderLayout.CENTER, tf); //add text field to center of win
        frame.setVisible(true); //enable frame
        //endregion
    }

    public void setQuestion(String _text)
    {
        question = _text;
        tf.setText(_text);
        if(_text.length() > 50)
        {
            changeFontSize(14, tf.getFont());
            return;
        }
        if(_text.length() > 40)
        {
            changeFontSize(16, tf.getFont());
            return;
        }
        if(_text.length() < 40)
        {
            changeFontSize(18, tf.getFont());
            return;
        }

    }

    public void setYesBtn(String _text)
    {
        yesBtn.setText(_text);
    }

    public void setNoBtn(String _text)
    {
        noBtn.setText(_text);
    }

    private void setBtnActions()
    {
        yesBtn.addActionListener(yesAction);
        noBtn.addActionListener(noAction);
    }

    //region btnActionListeners
    private ActionListener yesAction = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            Main.tree.onTrue();
        }
    };

    private ActionListener noAction = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            Main.tree.onFalse();
        }
    };
    //endregion

    public void restartGui()
    {
        setYesBtn("Yes");
        setNoBtn("No");
    }

    public void changeFontSize(int _size, Font _font)
    {
        Font font = new Font(_font.getName(), _font.getStyle(), _size);
        tf.setFont(font);
    }

    public void exit()
    {
        System.exit(0);
    }

}