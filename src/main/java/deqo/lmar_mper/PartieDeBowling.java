package deqo.lmar_mper;

/**
 * Created by 21204603 on 09/11/2016.
 */
public class PartieDeBowling {

    /**
     * Une partie de Bowling est composée de plusieurs joueurs.
     */
    private Joueur[] partie;


    /**
     * Constructeur de la classe PartieDeBowling.
     *
     * @param nbJoueurs : nombre de joueurs pour la partie de bowling.
     */
    public PartieDeBowling(final int nbJoueurs) {
        partie = new Joueur[nbJoueurs];
    }
}