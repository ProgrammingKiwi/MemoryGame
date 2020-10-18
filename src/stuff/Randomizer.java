package stuff;

import java.util.ArrayList;

public class Randomizer {

    int counter;

    public Randomizer(ArrayList<Integer> al) {

        al.clear();

        for(al.size(); al.size() < 16;) {
            int r = (int) (Math.random() * 8);
            for(int i3 = 0; i3 < al.size(); i3++) {

                if(al.size() != 0) {
                    if(al.get(i3) != null) {
                        if(al.get(i3) == r) {
                            counter++;
                        }
                    }
                }
            }
            if(counter <= 1) {
                al.add(r);
                counter = 0;
            } else counter = 0;

        }

    }

}
