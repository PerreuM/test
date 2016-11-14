package deqo.lmar_mper;

import junit.framework.TestCase;
import org.junit.*;

public class JoueurTest extends TestCase {

    @Test
    public void testSequenceValide() throws Exception {

        /* "5/ X X 46 2/ 3/ X __ 9_ 5/X" */
        Joueur marty = new Joueur("5/XX462/3/X__9_5/X");

        assertTrue("La séquence est valide", marty.sequenceValide());
    }

    @Test
    public void testSequenceNonValideSpares() throws Exception {

        /* "5/ X X 46 2/ 3/ X __ 9_ 5/X" */
        Joueur marty = new Joueur("5/XX462/3/X__9_5/X3/3/2/3/1/4/5/6/9/");

        assertFalse("La séquence est valide", marty.sequenceValide());
    }


    @Test
    public void testSequenceNonValideStrikes() throws Exception {

        /* "5/ X X 46 2/ 3/ X __ 9_ 5/X" */
        Joueur marty = new Joueur("5/XX462/3/X__9_5/XXXXXXXXXXX");

        assertFalse("La séquence est valide", marty.sequenceValide());
    }

    @Test
    public void testNbStrikesValide() throws Exception {

        Joueur marty = new Joueur("XXXXXXXXXXXX");

        assertTrue("Nombre de strikes valide", marty.nbStrikesValide());
    }


    @Test
    public void testNbStrikesValideAvecAutresCaracteres() throws Exception {

        Joueur marty = new Joueur("2X5X3XX4XXX8XXXXX");

        assertTrue("Nombre de strikes valide", marty.nbStrikesValide());
    }

    @Test
    public void testNbStrikesNonValide() throws Exception {

        Joueur marty = new Joueur("XXXXXXXXXXXXXXXXXX");

        assertFalse("Nombre de strikes pas valide", marty.nbStrikesValide());
    }

    @Test
    public void testNbStrikesNonValideAvecAutresCaracteres() throws Exception {

        Joueur marty = new Joueur("XXX4XXXXX2X5XXXX3XXXX9X");

        assertFalse("Nombre de strikes pas valide", marty.nbStrikesValide());
    }

    @Test
    public void testNbSparesValide() throws Exception {

        Joueur marty = new Joueur("5/5/5/5/5/5/5/5/5/5/");

        assertTrue("Nombre de spares valide", marty.nbSparesValide());
    }


    @Test
    public void testNbSparesNonValide() throws Exception {

        Joueur marty = new Joueur("5/5/5/5/5/5/5/5/5/5/5/5/5/");

        assertFalse("Nombre de spares pas valide", marty.nbSparesValide());
    }

}