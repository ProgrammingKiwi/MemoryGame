package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class StartFrame extends JFrame implements ActionListener{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JButton start,
            info,
            options,
            end;

    public StartFrame(String title) {

        setTitle(title);
        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        start = new JButton("Start");
        start.setBounds(100, 20, 200, 50);
        start.addActionListener(this);

        info = new JButton("Info");
        info.setBounds(100, 90, 200, 50);
        info.addActionListener(this);

        options = new JButton("Optionen");
        options.setBounds(100, 160, 200, 50);
        options.addActionListener(this);

        end = new JButton("Beenden");
        end.setBounds(100, 230, 200, 50);
        end.addActionListener(this);

        add(start);
        add(info);
        add(options);
        add(end);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == start) {
            new GameFrame("Game");
            dispose();
        } else if(e.getSource() == info) {
            JOptionPane.showMessageDialog(null, "Version 2.0, mehrere Motive, Punktezähler, Gewinnansage, Reset, Menü enthalten.");
        } else if(e.getSource() == options) {
            new OptionFrame("Options");
        } else if(e.getSource() == end) {
            dispose();
        }

    }

}
