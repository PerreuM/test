package deqo.lmar_mper;

import java.util.ArrayList;

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
     * Constante de bonus.
     */
    private static final int BONUS = 10;

    /**
     * Constante quand lancer précédent nul.
     */
    private static final int PREV_NULL = 3;

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
     * Tableau d'enregistrement des points.
     */
    private ArrayList<Points> tabRes = new ArrayList();

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

    /**
     * Fonction qui calcule le score.
     * d'une séquence donnée.
     * @return void
     */
    public final int calculerScore() {
        int dernier = 0;
        int taille = sequenceLancers.length();
        int ind = 0;
        //indique si on a fait un spare au jeu d'avant
        boolean spare = false;
        boolean strikeIt1 = false;
        boolean strikeIt2 = false;
        boolean precedentVide = false;
        for (int i = 0; i < taille; i++) {
            char c = sequenceLancers.charAt(i);
            int valeur = Character.getNumericValue(c);
            if (c == '/') {
                if (i == taille - 2) {
                    //lancer à ne pas compter à la fin
                    //car un lancer complémentaire
                    dernier = 1;
                }
                //si on vient de faire un spare il faut ajouter
                //10  points en tant que points courants
                //et lors du prochain lancers mémoriser les points
                tabRes.get(ind - 1).setPtsCourants(BONUS);
                //met à 1 pour mise à jour au prochain lancer
                tabRes.get(ind - 1).setPtsProchainLancer1(1);
                spare = true;

            } else if (c == 'X') {
                tabRes.add(new Points(0, 0, 0));
                if (i == taille - 2) {
                    //lancer à ne pas compter à la fin
                    // car deux lancers complémentaires
                    dernier = 2;
                }
                //si on vient de faire un strike il faut ajouter
                // 10 points en tant que points courants
                //et lors des 2 prochains lancers  mémoriser les points
                tabRes.get(ind).setPtsCourants(BONUS);
                //met à 1 pour mise à jour aux prochains lancers
                tabRes.get(ind).setPtsProchainLancer1(1);
                tabRes.get(ind).setPtsProchainLancer2(1);
                if (spare) {
                    tabRes.get(ind - 1).setPtsProchainLancer1(BONUS);
                }
                spare = false;
                if (strikeIt1 && strikeIt2) {
                    tabRes.get(ind - 1).setPtsProchainLancer1(BONUS);
                    tabRes.get(ind - 2).setPtsProchainLancer2(BONUS);
                    strikeIt1 = false;
                } else if (strikeIt1) {
                    strikeIt2 = true;
                    strikeIt1 = false;
                    tabRes.get(ind - 1).setPtsProchainLancer1(BONUS);
                }
                ind++;
                strikeIt1 = true;
            } else {
                tabRes.add(new Points(0, 0, 0));
                //sinon ajouter le nombre de quilles qui sont tombées
                if (c != '_') {
                    tabRes.get(ind).setPtsCourants(valeur);

                    if (spare) {
                        tabRes.get(ind - 1).setPtsProchainLancer1(valeur);
                    }
                    spare = false;
                    if (strikeIt1 && strikeIt2) {
                        tabRes.get(ind - 1).setPtsProchainLancer1(valeur);
                        tabRes.get(ind - 2).setPtsProchainLancer2(valeur);
                        strikeIt1 = false;
                    } else if (strikeIt1) {
                        strikeIt1 = false;
                        strikeIt2 = true;
                        tabRes.get(ind - 1).setPtsProchainLancer1(valeur);
                    } else if (strikeIt2) {
                        strikeIt2 = false;
                        if (precedentVide) {
                            tabRes.get(ind - PREV_NULL)
                                    .setPtsProchainLancer2(valeur);
                        } else {
                            tabRes.get(ind - 2).setPtsProchainLancer2(valeur);
                        }
                        precedentVide = false;
                    }
                } else {
                    precedentVide = true;
                }
                ind++;
            }
        }
        //somme de tous les points de chaque lancer
        // enregistrés dans tabRes = SCORE FINAL
        for (int i = 0; i < tabRes.size() - dernier; i++) {
            score += tabRes.get(i).sommeDesPointsJeu();
        }
        return score;
    }
}