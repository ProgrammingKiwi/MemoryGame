package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class OptionFrame extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JLabel botLabel, botplaylabel, botdifficultyLabel;
    private String[] Stringlist = { "Fruits", "Animals", "Colors"};
    private String[] DifficultyList = { "Easy", "Medium", "Hard", "Very hard", "Impossible"};
    private JComboBox<String> list, list2;
    private JButton best;
    public static String chosen = "Fruits";
    public static int diff = 0;
    public static boolean smart = false;
    public static boolean bot = false, player = false;
    private JRadioButton check1, check2, check3, check4, check5, check6;

    public OptionFrame(String title) {

        setTitle(title);
        setSize(500, 700);
        setLayout(null);
        setResizable(false);

        best = new JButton("Bestätigen");
        best.setBounds(150, 600, 200, 30);
        best.addActionListener(this);
        add(best);

        list = new JComboBox<String>(Stringlist);
        list.setBounds(150, 50, 200, 30);
        list.addActionListener(this);
        switch (chosen) {
            case "Fruits":
                list.setSelectedIndex(0);
                break;
            case "Animals":
                list.setSelectedIndex(1);
                break;
            case "Colors":
                list.setSelectedIndex(2);
                break;
            case "Conrad":
                list.setSelectedIndex(3);
                break;
            default:
                list.setSelectedIndex(0);
        }
        add(list);

        list2 = new JComboBox<String>(DifficultyList);
        list2.setBounds(150, 250, 200, 30);
        list2.addActionListener(this);
        /*switch (diff) {
            case 0:
                list2.setSelectedIndex(0);
                break;
            case 1:
                list2.setSelectedIndex(1);
                break;
            case 2:
                list2.setSelectedIndex(2);
                break;
            case 3:
                list2.setSelectedIndex(3);
                break;
            default:
                list2.setSelectedIndex(0);
        } */
        list2.setSelectedIndex(diff);
        add(list2);

        botLabel = new JLabel("Bot");
        botLabel.setBounds(150, 100, 100, 20);
        add(botLabel);

        botdifficultyLabel = new JLabel("Difficulty");
        botdifficultyLabel.setBounds(150, 220, 100, 20);
        add(botdifficultyLabel);

        check1 = new JRadioButton("Yes");
        check1.setBounds(150, 130, 50, 20);
        check1.addActionListener(this);
        if (bot) {
            check1.setSelected(true);
        }
        add(check1);

        check2 = new JRadioButton("No");
        check2.setBounds(200, 130, 60, 20);
        if (!bot) {
            check2.setSelected(true);
        }
        check2.addActionListener(this);
        add(check2);

        botplaylabel = new JLabel("Bot as player");
        botplaylabel.setBounds(150, 160, 100, 20);
        add(botplaylabel);

        check3 = new JRadioButton("1");
        check3.setBounds(150, 190, 40, 20);
        check3.addActionListener(this);
        if (player) {
            check3.setSelected(true);
        }
        add(check3);

        check4 = new JRadioButton("2");
        check4.setBounds(200, 190, 60, 20);
        if (!player) {
            check4.setSelected(true);
        }
        check4.addActionListener(this);
        add(check4);

        check5 = new JRadioButton("Smart");
        check5.setBounds(150, 290, 70, 20);
        if (smart) {
            check5.setSelected(true);
        }
        add(check5);

        check6 = new JRadioButton("Stupid");
        check6.setBounds(220, 290, 70, 20);
        if(!smart) {
            check6.setSelected(true);
        }
        add(check6);

        if(diff != 0) {
            check5.setEnabled(true);
            check6.setEnabled(true);
        } else {
            check5.setEnabled(false);
            check6.setEnabled(false);
        }

        ButtonGroup group = new ButtonGroup();
        ButtonGroup group2 = new ButtonGroup();
        ButtonGroup group3 = new ButtonGroup();

        group.add(check1);
        group.add(check2);

        group2.add(check3);
        group2.add(check4);

        group3.add(check5);
        group3.add(check6);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == best) {
            dispose();
            chosen = (String) list.getSelectedItem();
            diff = list2.getSelectedIndex();
            if (check1.isSelected()) {
                bot = true;
            } else {
                bot = false;
            }
            if (check3.isSelected()) {
                player = true;
            } else {
                player = false;
            }
            if (check5.isSelected()) {
                smart = true;
            } else {
                smart = false;
            }
        } else if(e.getSource() == list2) {
            if(list2 != null) {
                if(check5 != null && check6 != null) {
                    if(list2.getSelectedIndex() != 0) {
                        check5.setEnabled(true);
                        check6.setEnabled(true);
                    } else {
                        check5.setEnabled(false);
                        check6.setEnabled(false);
                    }
                }else System.out.println("Halt die Fresse Conrad!");
            }
        }
    }

}
