package deqo.lmar_mper;

/**
 * Created by 21204603 on 09/11/2016.
 */
public class Joueur {

    /**
     * Constante de nombre de jeux maximum pour un joueur.
     */
    private static final int NB_JEUX = 10;

    /**
     * Le nombre de strikes maximum dans une partie est de 12.
     */
    private static final int NB_MAX_STRIKES = 12;

    /**
     * Le nombre de spare maximum dans une partie est de 10.
     */
    private static final int NB_MAX_SPARES = 10;

    /**
     * Représente la séquence de lancer de l'utilisateur.
     */
    private String sequenceLancers;

    /**
     * Nombre de jeux effectués.
     */
    private int jeux = 0;

    /**
     * Score du joueur.
     */
    private int score = 0;


    /**
     * Constructeur de la classe Joueur.
     *
     * @param sequence : représente la séquence de lancer de l'utilisateur.
     */
    public Joueur(final String sequence) {
        sequenceLancers = sequence;
    }

    /**
     * Fonction qui retourne true si la séquence de lancers est valide,
     * false sinon.
     *
     * @return boolean
     */
    public final boolean sequenceValide() {

        boolean resultat = true;

        /* On vérifie d'abord que le nombre de strikes et de spares
        soit correct */
        resultat = nbStrikesValide() && nbSparesValide();

        /* On s'occupe ensuite de la cohérence de la séquence */

        return (resultat);
    }


    /**
     * Fonction qui retourne true si le nombre de strikes
     * de la séquence de lancers est correct, false sinon.
     *
     * @return boolean
     */
    public final boolean nbStrikesValide() {

        int nbStrikes = 0;

        for (int i = 0; i < sequenceLancers.length(); i++) {

            char c = sequenceLancers.charAt(i);

            if (c == 'X') {

                nbStrikes++;
            }
        }

        return (nbStrikes <= NB_MAX_STRIKES);
    }

    /**
     * Fonction qui retourne true si le nombre de spare
     * de la séquence de lancers est correct, false sinon.
     *
     * @return boolean
     */
    public final boolean nbSparesValide() {

        int nbSpares = 0;

        for (int i = 0; i < sequenceLancers.length(); i++) {

            char c = sequenceLancers.charAt(i);

            if (c == '/') {

                nbSpares++;
            }
        }

        return (nbSpares <= NB_MAX_SPARES);
    }
}
