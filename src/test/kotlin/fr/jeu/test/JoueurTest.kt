package fr.jeu.test

import org.junit.jupiter.api.Test
import fr.jeu.pattern.entity.Joueur
import org.junit.jupiter.api.Assertions

class JoueurTest {
    var j1 : Joueur = Joueur()
    @Test
    fun createJoueur(){
        Assertions.assertNotSame(j1, Joueur(), "Ces le même objet")
    }
    @Test
    fun setlevelJoueur(){
        j1.setLvl(3)
        Assertions.assertEquals(3, j1.getLvl(), "Le Joueur n'as pas pu prendre les niveaux")
    }
    @Test
    fun setPvMaxJoueur(){
        j1.setPvMax(20)
        Assertions.assertEquals(20, j1.getPvMax(), "Les Pv Max du joueur n'ont pas changé")
    }
    @Test
    fun setNbBallJoueur(){
        j1.setNbBalle(2)
        Assertions.assertEquals(2, j1.getNbBalle(), "Le nombre de balle du joueur n'ont pas changé")
    }
    @Test
    fun setBallSupJoueur(){
        j1.setNbBalle(3)
        Assertions.assertTrue(j1.getNbBalle()>j1.getNbBalleMax(), "Le nombre de balle n'est pas supérieurs au nombre maximun")
    }
}