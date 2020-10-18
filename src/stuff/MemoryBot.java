package stuff;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;

import frames.GameFrame;

public class MemoryBot {

    private int difficulty;
    private ArrayList<Integer> numbers = new ArrayList<Integer>();
    private ArrayList<JButton> buttons;
    public static ArrayList<JButton> revealed = new ArrayList<JButton>(), stillfree = new ArrayList<JButton>();
    private static JButton clickedrn = null;
    private static int temporary = -1;
    public static boolean justwon = false;
    public static boolean justwon2 = false;

    public MemoryBot(int difficulty, ArrayList<JButton> buttons) {
        this.difficulty = difficulty;
        this.buttons = buttons;
        for (JButton jButton : buttons) {
            stillfree.add(jButton);
        }

        for (int i = 0; i < 16; i++) {
            numbers.add(-1);
        }
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void play() {

        if (difficulty == 0) {
            if (GameFrame.counting == 0) {
                for (JButton b : buttons) {
                    b.setEnabled(false);
                }
                FirstGuessEasy();
            } else if (GameFrame.counting == 1) {
                secondGuessEasy();
            }
        } else if (difficulty == 1) {
            if (GameFrame.counting == 0) {
                for (JButton b : buttons) {
                    b.setEnabled(false);
                }
                FirstGuessMedium();
            } else if (GameFrame.counting == 1) {
                SecondGuessMedium();
            }
        } else if (difficulty == 2) {
            if (GameFrame.counting == 0) {
                for (JButton b : buttons) {
                    b.setEnabled(false);
                }
                FirstGuessDifficult();
            } else if (GameFrame.counting == 1) {
                SecondGuessDifficult();
            }
        } else if (difficulty == 3) {
            if (GameFrame.counting == 0) {
                for (JButton b : buttons) {
                    b.setEnabled(false);
                }
                FirstGuessVeryDifficult();
            } else if (GameFrame.counting == 1) {
                SecondGuessVeryDifficult();
            }
        } else if(difficulty == 4) {
            if (GameFrame.counting == 0) {
                for (JButton b : buttons) {
                    b.setEnabled(false);
                }
                FirstGuessImpossible();
            } else if (GameFrame.counting == 1) {
                SecondGuessImpossible();
            }
        }

    }

    public void setNumber(int position, int number) {
        numbers.set(position, number);
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public int getNumber(int position) {
        return numbers.get(position);
    }

    public void FirstGuessEasy() {
        int rnd = (int) (Math.random() * stillfree.size());

        JButton b = stillfree.get(rnd);

        if (!revealed.contains(b)) {
            b.setEnabled(true);
            b.doClick();
            clickedrn = b;
        }
        Timer t = new Timer();
        TimerTask tt = new TimerTask() {

            @Override
            public void run() {
                play();
            }
        };
        t.schedule(tt, 1500);

    }

    public void FirstGuessMedium() {

        boolean b = false;
        int number = -1;
        temporary = -1;

        for (int i : numbers) {
            if (i != -1 && i != 50) {
                if (numbers.indexOf(i) != numbers.lastIndexOf(i)) {
                    b = true;
                    number = i;
                }
            }
        }
        if (b) {
            b = false;

            JButton bt = buttons.get(numbers.indexOf(number));
            // numbers.set(numbers.indexOf(number), -1);
            temporary = number;
            number = -1;
            bt.setEnabled(true);
            bt.doClick();

            clickedrn = bt;

            b = false;
            Timer t = new Timer();
            TimerTask tt = new TimerTask() {

                @Override
                public void run() {
                    play();
                }
            };
            t.schedule(tt, 1500);

        } else {
            FirstGuessEasy();
        }

    }

    public void FirstGuessDifficult() {
        FirstGuessMedium();
    }

    public void FirstGuessVeryDifficult() {
        if(!justwon) {
            FirstGuessEasy();
        } else {
            FirstGuessDifficult();
        }
    }

    public void FirstGuessImpossible() {
        if(!justwon || !justwon2) {
            FirstGuessEasy();
        } else {
            FirstGuessDifficult();
        }
    }

    public void secondGuessEasy() {
        int rnd = (int) (Math.random() * stillfree.size());

        JButton b = stillfree.get(rnd);

        if (stillfree.size() == 1) {
            stillfree.get(1).setEnabled(true);
            stillfree.get(1).doClick();
        }

        if (!revealed.contains(b)) {
            if (b != clickedrn) {
                b.setEnabled(true);
                b.doClick();
            } else
                secondGuessEasy();
        } else
            secondGuessEasy();
    }

    public void SecondGuessMedium() {

        if (temporary != -1) {
            if (numbers.lastIndexOf(temporary) != -1 && !revealed.contains(buttons.get(numbers.lastIndexOf(temporary)))
                    && numbers.indexOf(temporary) != numbers.lastIndexOf(temporary)) {
                JButton b = buttons.get(numbers.lastIndexOf(temporary));
                if (b != clickedrn) {
                    b.setEnabled(true);
                    b.doClick();

                    if (numbers.contains(temporary)) {
                        numbers.set(numbers.indexOf(temporary), -1);
                        if (numbers.contains(temporary)) {
                            numbers.set(numbers.lastIndexOf(temporary), -1);
                        }
                    }

                    temporary = -1;
                    clickedrn = null;
                    b = null;
                }
            } else {
                secondGuessEasy();
            }

        } else {
            secondGuessEasy();
        }

    }

    public void SecondGuessDifficult() {
        SecondGuessMedium();
    }

    public void SecondGuessVeryDifficult() {

        if(!justwon) {
            int index = GameFrame.integers.indexOf(GameFrame.integers.get(buttons.indexOf(clickedrn)));
            int lastindex = GameFrame.integers.lastIndexOf(GameFrame.integers.get(index));

            JButton jb1 = buttons.get(index);
            JButton jb2 = buttons.get(lastindex);

            if (clickedrn == jb1) {
                jb2.setEnabled(true);
                jb2.doClick();
            } else if(clickedrn == jb2) {
                jb1.setEnabled(true);
                jb1.doClick();
            }
        } else {
            justwon = false;
            SecondGuessDifficult();
        }
    }

    public void SecondGuessImpossible() {
        if(!justwon || !justwon2) {
            int index = GameFrame.integers.indexOf(GameFrame.integers.get(buttons.indexOf(clickedrn)));
            int lastindex = GameFrame.integers.lastIndexOf(GameFrame.integers.get(index));

            JButton jb1 = buttons.get(index);
            JButton jb2 = buttons.get(lastindex);

            if (clickedrn == jb1) {
                jb2.setEnabled(true);
                jb2.doClick();
            } else if(clickedrn == jb2) {
                jb1.setEnabled(true);
                jb1.doClick();
            }
        } else {
            justwon = false;
            justwon2 = false;
            SecondGuessDifficult();
        }
    }

    public void revealCard(JButton jb) {
        stillfree.remove(jb);
        revealed.add(jb);
    }

    public void delete() {
        numbers.clear();
        difficulty = 0;
        revealed.clear();
        stillfree.clear();
        clickedrn = null;
        buttons = null;
    }

    public int getAmountofNumberinNumber(ArrayList<Integer> al, int si) {

        int i = 0;

        for (Integer integer : al) {
            if (integer == si) {
                i++;
            }
        }

        return i;
    }

}
