package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import stuff.MemoryBot;
import stuff.PictureConnector;
import stuff.Randomizer;

public class GameFrame extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static ArrayList<JButton> buttons = new ArrayList<JButton>();
    public static ArrayList<Integer> integers = new ArrayList<Integer>();
    private int temp, temp2, score1 = 0, score2 = 0;
    public static int counting = 0;
    private boolean player1 = true, player2 = false;
    private JButton reset, menu;
    private JEditorPane playername1, playername2;
    private JLabel playerscore1, playerscore2, names, mark;
    private Timer tw = new Timer();
    private MemoryBot mb;
    private int difficulty = OptionFrame.diff;
    private boolean smart = OptionFrame.smart;

    private Icon iconr, icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8;

    public GameFrame(String title) {

        new PictureConnector();

        iconr = (Icon) new ImageIcon(PictureConnector.getImgURLr());
        icon1 = (Icon) new ImageIcon(PictureConnector.getImgURL1());
        icon2 = (Icon) new ImageIcon(PictureConnector.getImgURL2());
        icon3 = (Icon) new ImageIcon(PictureConnector.getImgURL3());
        icon4 = (Icon) new ImageIcon(PictureConnector.getImgURL4());
        icon5 = (Icon) new ImageIcon(PictureConnector.getImgURL5());
        icon6 = (Icon) new ImageIcon(PictureConnector.getImgURL6());
        icon7 = (Icon) new ImageIcon(PictureConnector.getImgURL7());
        icon8 = (Icon) new ImageIcon(PictureConnector.getImgURL8());

        setTitle(title);
        setSize(1200, 900);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        reset = new JButton("Neues Spiel");
        reset.setBounds(920, 300, 200, 50);
        reset.addActionListener(this);
        add(reset);

        menu = new JButton("Menü");
        menu.setBounds(920, 400, 200, 50);
        menu.addActionListener(this);
        add(menu);

        playername1 = new JEditorPane();
        playername1.setBounds(920, 150, 150, 20);
        if (OptionFrame.bot) {
            if (OptionFrame.player) {
                playername1.setText("Bot");
                playername1.setEditable(false);
            }
        }
        add(playername1);

        playername2 = new JEditorPane();
        playername2.setBounds(920, 190, 150, 20);
        if (OptionFrame.bot) {
            if (!OptionFrame.player) {
                playername2.setText("Bot");
                playername2.setEditable(false);
            }
        }
        add(playername2);

        playerscore1 = new JLabel();
        playerscore1.setBounds(1080, 150, 30, 20);
        playerscore1.setText("" + 0);
        add(playerscore1);

        playerscore2 = new JLabel();
        playerscore2.setBounds(1080, 190, 30, 20);
        playerscore2.setText("" + 0);
        add(playerscore2);

        names = new JLabel("Namen eingeben:");
        names.setBounds(920, 120, 100, 20);
        add(names);

        mark = new JLabel(">");
        mark.setBounds(900, 150, 20, 20);
        add(mark);

        new Randomizer(integers);

        for (int i = 0; i < 16; i++) {

            buttons.add(new JButton(iconr));

            if (i <= 3) {
                buttons.get(i).setBounds(20 + i * 220, 0, 200, 200);
            } else if (i <= 7) {
                buttons.get(i).setBounds(20 + (i - 4) * 220, 220, 200, 200);
            } else if (i <= 11) {
                buttons.get(i).setBounds(20 + (i - 8) * 220, 440, 200, 200);
            } else if (i <= 15) {
                buttons.get(i).setBounds(20 + (i - 12) * 220, 660, 200, 200);
            }

            buttons.get(i).addActionListener(this);

            add(buttons.get(i));
        }

        setVisible(true);

        if (OptionFrame.bot) {
            mb = new MemoryBot(difficulty, buttons, smart);

            if (OptionFrame.player) {
                mb.play();
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reset) {

            if (OptionFrame.bot) {
                mb.delete();
                mb = new MemoryBot(difficulty, buttons, smart);

                if (OptionFrame.player) {
                    mb.play();
                }
            }
            tw.cancel();
            tw = new Timer();
            new Randomizer(integers);
            for (int i = 0; i < integers.size(); i++) {
                buttons.get(i).setIcon(iconr);
                buttons.get(i).setEnabled(true);
            }
            counting = 0;

            player1 = true;
            player2 = false;

            mark.setBounds(900, 150, 20, 20);

            score1 = 0;
            score2 = 0;
            playerscore1.setText("" + score1);
            playerscore2.setText("" + score2);
            setVisible(true);

        } else if (e.getSource() == menu) {
            new StartFrame("Menü");
            if(OptionFrame.bot) {
                mb.delete();
            }
            buttons.clear();
            dispose();

        } else {
            for (int i = 0; i < integers.size(); i++) {
                if (e.getSource() == buttons.get(i)) {

                    if (counting == 0) {

                        counting = 1;
                        temp = integers.get(i);
                        temp2 = i;
                        if (integers.get(i) == 0) {
                            buttons.get(i).setIcon(icon1);
                        } else if (integers.get(i) == 1) {
                            buttons.get(i).setIcon(icon2);
                        } else if (integers.get(i) == 2) {
                            buttons.get(i).setIcon(icon3);
                        } else if (integers.get(i) == 3) {
                            buttons.get(i).setIcon(icon4);
                        } else if (integers.get(i) == 4) {
                            buttons.get(i).setIcon(icon5);
                        } else if (integers.get(i) == 5) {
                            buttons.get(i).setIcon(icon6);
                        } else if (integers.get(i) == 6) {
                            buttons.get(i).setIcon(icon7);
                        } else if (integers.get(i) == 7) {
                            buttons.get(i).setIcon(icon8);
                        } else if (integers.get(i) == 50) {
                            counting = 0;
                        }

                        if(OptionFrame.bot) {
                            if(difficulty == 1) {
                                if(isBot()) {
                                    mb.setNumber(i, integers.get(i));
                                }
                            } else if(difficulty >= 2){
                                mb.setNumber(i, integers.get(i));
                            }
                        }

                    } else if (counting == 1) {

                        counting = 2;

                        if (integers.get(i) == 0) {
                            buttons.get(i).setIcon(icon1);
                        } else if (integers.get(i) == 1) {
                            buttons.get(i).setIcon(icon2);
                        } else if (integers.get(i) == 2) {
                            buttons.get(i).setIcon(icon3);
                        } else if (integers.get(i) == 3) {
                            buttons.get(i).setIcon(icon4);
                        } else if (integers.get(i) == 4) {
                            buttons.get(i).setIcon(icon5);
                        } else if (integers.get(i) == 5) {
                            buttons.get(i).setIcon(icon6);
                        } else if (integers.get(i) == 6) {
                            buttons.get(i).setIcon(icon7);
                        } else if (integers.get(i) == 7) {
                            buttons.get(i).setIcon(icon8);
                        } else if (integers.get(i) == 50) {
                            counting = 1;
                        }

                        if(OptionFrame.bot) {
                            if(difficulty == 1) {
                                if(isBot()) {
                                    mb.setNumber(i, integers.get(i));
                                }
                            } else if(difficulty >= 2){
                                mb.setNumber(i, integers.get(i));
                            }
                        }

                        if (temp == integers.get(i)) {
                            if (!(temp2 == i)) {
                                if (!(integers.get(i) == 50)) {
                                    integers.set(i, 50);
                                    integers.set(temp2, 50);
                                    if (player1) {
                                        counting = 0;
                                        score1++;
                                        playerscore1.setText("" + score1);
                                        setVisible(true);

                                        if (OptionFrame.bot) {
                                            mb.revealCard(buttons.get(i));
                                            mb.revealCard(buttons.get(temp2));

                                            if (isBot()) {
                                                if (score1 + score2 != 8) {
                                                    if(MemoryBot.justwon) {
                                                        MemoryBot.justwon2 = true;
                                                    }
                                                    MemoryBot.justwon = true;
                                                    mb.play();
                                                }
                                            }
                                        }
                                    }
                                    if (player2) {
                                        counting = 0;
                                        score2++;
                                        playerscore2.setText("" + score2);
                                        setVisible(true);

                                        if (OptionFrame.bot) {
                                            mb.revealCard(buttons.get(i));
                                            mb.revealCard(buttons.get(temp2));

                                            mb.setNumber(i, 50);
                                            mb.setNumber(temp2, 50);

                                            if (isBot()) {
                                                if (score1 + score2 != 8) {
                                                    if(MemoryBot.justwon) {
                                                        MemoryBot.justwon2 = true;
                                                    }
                                                    MemoryBot.justwon = true;
                                                    mb.play();
                                                }
                                            }
                                        }
                                    }
                                    if (score1 + score2 == 8) {
                                        for (JButton jButton : buttons) {
                                            jButton.setEnabled(true);
                                        }

                                        if (score1 < score2) {
                                            JOptionPane.showMessageDialog(null,
                                                    playername2.getText() + " hat gewonnen!");
                                        } else if (score2 < score1) {
                                            JOptionPane.showMessageDialog(null,
                                                    playername1.getText() + " hat gewonnen!");
                                        } else if (score1 == score2) {
                                            JOptionPane.showMessageDialog(null, "Unentschieden!");
                                        }
                                    }
                                }
                            } else
                                counting = 1;
                        } else {

                            TimerTask tt = new TimerTask() {

                                @Override
                                public void run() {
                                    for (JButton b : buttons) {
                                        b.setEnabled(true);
                                    }
                                    counting = 0;
                                    for (int i = 0; i < integers.size(); i++) {
                                        if (!(integers.get(i) == 50)) {
                                            buttons.get(i).setIcon(iconr);
                                        }
                                    }
                                    if (player1) {
                                        player1 = false;
                                        player2 = true;

                                        mark.setBounds(900, 190, 20, 20);
                                        setVisible(true);

                                        if (OptionFrame.bot) {
                                            if (!OptionFrame.player) {
                                                mb.play();
                                            }
                                        }

                                    } else if (player2) {
                                        player1 = true;
                                        player2 = false;

                                        mark.setBounds(900, 150, 20, 20);
                                        setVisible(true);

                                        if (OptionFrame.bot) {
                                            if (OptionFrame.player) {
                                                mb.play();
                                            }
                                        }

                                    }

                                }
                            };
                            if (integers.get(i) == 50) {
                                counting = 1;
                            } else {
                                tw.schedule(tt, 1500);
                            }
                        }

                    }

                }

            }
        }

    }

    public boolean isBot() {
        if (player1 && OptionFrame.player) {
            return true;
        } else if (player2 && !OptionFrame.player) {
            return true;
        } else
            return false;

    }


}
