import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Created by arodriguez on 4/3/2015.
 */
public class CreateUI extends JFrame{
    JPanel jPanel = new JPanel(new BorderLayout());
    HashMap<String, StoryStep> map;


    public CreateUI(HashMap<String, StoryStep> story) {
        map = story;
        initUI();
    }

    public final void initUI() {

        StoryStep step = map.get("Start Again");


        addImagePanel(step.getImage());

        addOptionPanel(step.getStoryOptions());

        addDescPanel(step.getDescription());

        setContentPane(jPanel);
        setSize(1000, 600);
        setTitle("BorderLayout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void addDescPanel(String desc) {
        JTextArea area = new JTextArea();
        area.setColumns(10);
        area.setWrapStyleWord(true);
        area.setLineWrap(true);
        area.setText(desc);
        area.setEditable(false);
        jPanel.add(area, BorderLayout.CENTER);
    }

    //img panel
    public void addImagePanel(String file) {

        JPanel imagePanel = new JPanel();

        System.out.println("letters");

        System.out.println(file);
        if(file != null){
            ImageIcon select = new ImageIcon("src/Resources/Images/" + file);

            JButton selectb = new JButton(select);
            selectb.setBorder(new EmptyBorder(3, 0, 3, 0));


            imagePanel.add(selectb);

            jPanel.add(imagePanel, BorderLayout.EAST);
        }
    }

    public void addOptionPanel(List<String> options) {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.setBorder(new EmptyBorder(new Insets(40, 60, 40, 60)));
        panel.setBackground(new Color(0, 0, 0));

        for(final String option : options){
            JButton optionButton = new JButton(option);
            optionButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {

                    newStep(map.get(option));

                }

            });

            panel.add(optionButton);
            panel.add(Box.createRigidArea(new Dimension(0, 5)));

        }
//        pack();

        jPanel.add(panel, BorderLayout.SOUTH);

    }

    public void newStep(StoryStep step) {
        jPanel.removeAll();
        jPanel.repaint();
        jPanel.revalidate();

        addDescPanel(step.getDescription());
        addImagePanel(step.getImage());
        addOptionPanel(step.getStoryOptions());
        repaint();
        revalidate();
    }

}
