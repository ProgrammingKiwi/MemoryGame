package stuff;

import java.net.URL;

import frames.OptionFrame;

public class PictureConnector {

    public static URL imgURLr,
            imgURL1,
            imgURL2,
            imgURL3,
            imgURL4,
            imgURL5,
            imgURL6,
            imgURL7,
            imgURL8;
    private String selector;

    public PictureConnector() {

        selector = OptionFrame.chosen;

        if(selector.equalsIgnoreCase("Fruits")) {

            imgURLr = getClass().getResource("/picturesF/MemorieKorb.jpg");
            imgURL1 = getClass().getResource("/picturesF/MemorieWeintrauben.jpg");
            imgURL2 = getClass().getResource("/picturesF/MemorieApfel.jpg");
            imgURL3 = getClass().getResource("/picturesF/MemorieBirne.jpg");
            imgURL4 = getClass().getResource("/picturesF/MemorieAnanas.jpg");
            imgURL5 = getClass().getResource("/picturesF/MemorieBlaubeere.jpg");
            imgURL6 = getClass().getResource("/picturesF/MemorieKirsche.jpg");
            imgURL7 = getClass().getResource("/picturesF/MemorieKiwi.jpg");
            imgURL8 = getClass().getResource("/picturesF/MemorieHimbeere.jpg");

        } else if(selector.equalsIgnoreCase("Animals")) {

            imgURLr = getClass().getResource("/picturesA/MemorieTiere.jpg");
            imgURL1 = getClass().getResource("/picturesA/MemorieTiger.jpg");
            imgURL2 = getClass().getResource("/picturesA/MemoriePapagei.jpg");
            imgURL3 = getClass().getResource("/picturesA/MemoriePinguin.jpg");
            imgURL4 = getClass().getResource("/picturesA/MemorieStrauss.jpg");
            imgURL5 = getClass().getResource("/picturesA/MemorieTotenkopfaffe.jpg");
            imgURL6 = getClass().getResource("/picturesA/MemorieWaschbaer.jpg");
            imgURL7 = getClass().getResource("/picturesA/MemorieZebra.jpg");
            imgURL8 = getClass().getResource("/picturesA/MemorieKatze.jpg");

        } else if(selector.equalsIgnoreCase("Colors")) {

            imgURLr = getClass().getResource("/picturesC/MemorieBunt.jpg");
            imgURL1 = getClass().getResource("/picturesC/MemorieBlau.jpg");
            imgURL2 = getClass().getResource("/picturesC/MemorieGelb.jpg");
            imgURL3 = getClass().getResource("/picturesC/MemorieGruen.jpg");
            imgURL4 = getClass().getResource("/picturesC/MemorieLila.jpg");
            imgURL5 = getClass().getResource("/picturesC/MemorieOrange.jpg");
            imgURL6 = getClass().getResource("/picturesC/MemorieRot.jpg");
            imgURL7 = getClass().getResource("/picturesC/MemorieSchwarz.jpg");
            imgURL8 = getClass().getResource("/picturesC/MemorieWeiss.jpg");

        }

    }
    public static URL getImgURLr() {
        return imgURLr;
    }
    public static URL getImgURL1() {
        return imgURL1;
    }
    public static URL getImgURL2() {
        return imgURL2;
    }
    public static URL getImgURL3() {
        return imgURL3;
    }
    public static URL getImgURL4() {
        return imgURL4;
    }
    public static URL getImgURL5() {
        return imgURL5;
    }
    public static URL getImgURL6() {
        return imgURL6;
    }
    public static URL getImgURL7() {
        return imgURL7;
    }
    public static URL getImgURL8() {
        return imgURL8;
    }

}
