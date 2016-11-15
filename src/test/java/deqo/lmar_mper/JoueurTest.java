package deqo.lmar_mper;

import junit.framework.TestCase;
import org.junit.*;

public class JoueurTest extends TestCase {

    @Test
    public void testSequenceValide() throws Exception {

        /* "5/ X X 46 2/ 3/ X __ 9_ 5/X" */
        Joueur marty = new Joueur("5/XX452/3/X__9_5/X");

        assertTrue("La séquence est valide", marty.sequenceValide());
    }

    @Test
    public void testSequenceNonValideSpares() throws Exception {

        /* "5/ X X 46 2/ 3/ X __ 9_ 5/X" */
        Joueur marty = new Joueur("5/XX462/3/X__9_5/X3/3/2/3/1/4/5/6/9/");

        assertFalse("La séquence est pas valide", marty.sequenceValide());
    }


    @Test
    public void testSequenceNonValideStrikes() throws Exception {

        /* "5/ X X 46 2/ 3/ X __ 9_ 5/X" */
        Joueur marty = new Joueur("5/XX462/3/X__9_5/XXXXXXXXXXX");

        assertFalse("La séquence est pas valide", marty.sequenceValide());
    }


    @Test
    public void testSequenceNonValideJeux() throws Exception {

        /* "5/ X X 46 2/ 3/ X __ 9_ 5/X" */
        Joueur marty = new Joueur("5/XX462/3/X__9_5/XX");

        assertFalse("La séquence est pas valide", marty.sequenceValide());
    }

    @Test
    public void testSequenceNonValideLancers() throws Exception {

        /* "5/ X X 46 2/ 3/ X __ 9_ 5/X" */
        Joueur marty = new Joueur("5/XX462/3/X__9_5/XX5555555");

        assertFalse("La séquence est pas valide", marty.sequenceValide());
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


    @Test
    public void testNbJeuxValideStrikes() throws Exception {

        Joueur marty = new Joueur("XXXXXXXXXXXX");

        assertTrue("Nombre de jeux valide", marty.nbJeuxValide());
    }

    @Test
    public void testNbJeuxValideSpares() throws Exception {

        Joueur marty = new Joueur("5/5/5/5/5/5/5/5/5/5/5");

        assertTrue("Nombre de jeux valide", marty.nbJeuxValide());
    }

    @Test
    public void testNbJeuxValideNombres() throws Exception {

        Joueur marty = new Joueur("52545351525152535452");

        assertTrue("Nombre de jeux valide", marty.nbJeuxValide());
    }


    @Test
    public void testNbJeuxNonValideStrikes() throws Exception {

        Joueur marty = new Joueur("XXXXXXXXXXXXXXXXXXX");

        assertFalse("Nombre de jeux pas valide", marty.nbJeuxValide());
    }


    @Test
    public void testNbJeuxNonValideSpares() throws Exception {

        Joueur marty = new Joueur("5/5/5/5/5/5/5/5/5/5/5/5/5/5/5/5/5");

        assertFalse("Nombre de jeux pas valide", marty.nbJeuxValide());
    }

    @Test
    public void testNbJeuxNonValideNombres() throws Exception {

        Joueur marty = new Joueur("5254535152515253545251525354");

        assertFalse("Nombre de jeux pas valide", marty.nbJeuxValide());
    }

    @Test
    public void testLancersValide() throws Exception {

        Joueur marty = new Joueur("5254535152515253545/2");

        assertTrue("Nombre de lancers valide", marty.nbLancersValide());
    }

    @Test
    public void testLancersNonValide() throws Exception {

        Joueur marty = new Joueur("5254535152515253545/24");

        assertFalse("Nombre de lancers pas valide", marty.nbLancersValide());
    }

    @Test
    public void testPasCoherent1() throws Exception {

        Joueur marty = new Joueur("//XX452/3/X__9_5/X");

        assertFalse("Pas coherent : spare à la premiere position", marty.sequenceCoherente());
    }

    @Test
    public void testPasCoherent2() throws Exception {

        Joueur marty = new Joueur("5/XX462/3/X__9_5/X");

        assertFalse("Pas coherent : 4 + 6 > 9", marty.sequenceCoherente());
    }


    @Test
    public void testPasCoherent3() throws Exception {

        Joueur marty = new Joueur("5/XX/2/3/X__9_5/X");

        assertFalse("Pas coherent", marty.sequenceCoherente());
    }

    @Test
    public void testPasCoherent4() throws Exception {

        Joueur marty = new Joueur("5/XX//2/3/X__9_5/X");

        assertFalse("Pas coherent", marty.sequenceCoherente());
    }

    @Test
    public void testScoreStrikes() throws Exception {
        Joueur marty = new Joueur("XXXXXXXXXXXX");

        assertEquals(300, marty.calculerScore());
    }

    @Test
    public void testScoreSansBonus() throws Exception {
        Joueur marty = new Joueur("9_9_9_9_9_9_9_9_9_9_");

        assertEquals(90, marty.calculerScore());
    }

    @Test
    public void testScoreSpares() throws Exception {
        Joueur marty = new Joueur("5/5/5/5/5/5/5/5/5/5/5");

        assertEquals(150, marty.calculerScore());
    }

    @Test
    public void testScoreStrikesSpares1() throws Exception {
        Joueur marty = new Joueur("5/XX5/5/1_1_2_3_4_");

        assertEquals(102, marty.calculerScore());
    }

    @Test
    public void testScoreStrikesSpares2() throws Exception {
        Joueur marty = new Joueur("5/XX1_5/1_1_2_3_4_");

        assertEquals(80, marty.calculerScore());
    }

    @Test
    public void testScoreStrikesSpares3() throws Exception {
        Joueur marty = new Joueur("5/X1_1_5/1_1_2_3_4_");

        assertEquals(56, marty.calculerScore());
    }

    @Test
    public void testScoreStrikesSpares4() throws Exception {
        Joueur marty = new Joueur("5/X5/1_1_1_1_2_3_4_");

        assertEquals(60, marty.calculerScore());
    }
}