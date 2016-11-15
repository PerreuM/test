package deqo.lmar_mper;

/**
 * Created by MarieP on 14/11/2016.
 */
public class Points {

    /**
     * points courants.
     */
    private int pointsCourants;

    /**
     * points prochain lancer numéro 1.
     */
    private int pointsProchainLancer1;

    /**
     * points prochain lancer numéro 2.
     */
    private int pointsProchainLancer2;

    /**
     * Constructeur de la classe Points.
     *
     * @param c : points courant
     * @param p1 : points prochain lancer 1
     * @param p2 : points prochain lancer 2
     */
    public Points(final int c, final int p1, final int p2) {
        setPtsCourants(c);
        setPtsProchainLancer1(p1);
        setPtsProchainLancer2(p2);
    }

    /**
     * Fonction qui renvoie l'attribut pointsCourants.
     * @return int
     */
    public final int getPointsCourants() {
        return pointsCourants;
    }

    /**
     * Fonction qui renvoie l'attribut pointsProchainLancer1.
     * @return int
     */
    public final int getPointsProchainLancer1() {
        return pointsProchainLancer1;
    }

    /**
     * Fonction qui renvoie l'attribut pointsProchainLancer2.
     * @return int
     */
    public final int getPointsProchainLancer2() {
        return pointsProchainLancer2;
    }

    /**
     * Fonction qui modifie l'attribut pointsCourants.
     * @param c : points courants
     */
    public final void setPtsCourants(final int c) {
        pointsCourants = c;
    }

    /**
     * Fonction qui modifie l'attribut pointsProchainLancer1.
     * @param p1 : points prochain lancer 1
     */
    public final void setPtsProchainLancer1(final int p1) {
        pointsProchainLancer1 = p1;
    }

    /**
     * Fonction qui modifie l'attribut pointsProchainLancer2.
     * @param p2 : points prochain lancer 2
     */
    public final void setPtsProchainLancer2(final int p2) {
        pointsProchainLancer2 = p2;
    }

    /**
     * Fonction qui renvoie la somme des attributs.
     * @return int
     */
    public final int sommeDesPointsJeu() {
        return getPointsCourants()
                + getPointsProchainLancer1()
                + getPointsProchainLancer2();
    }
}
