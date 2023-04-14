package fr.jeu.test

import fr.jeu.pattern.entity.Ennemy
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class EnnemyTest {
    var e1 : Ennemy = Ennemy()
    @Test
    fun createEnnemy(){
        Assertions.assertNotSame(e1,Ennemy(), "les deux ennemi sont les même")
    }
    @Test
    fun setlevelEnnemy(){
        e1.setLvl(3)
        Assertions.assertEquals(3, e1.getLvl(), "L'ajout de niveau pour l'ennemi n'as pas étais pris en compte")
    }
    @Test
    fun setPvMaxEnnemy(){
        e1.setPvMax(20)
        Assertions.assertEquals(20, e1.getPvMax(), "L'ajout de PV pour l'ennemi n'as pas étais pris en compte")
    }
    @Test
    fun setNbBallEnnemy(){
        e1.setNbBalle(2)
        Assertions.assertEquals(2, e1.getNbBalle(), "L'ajout de balle pour l'ennemi n'as pas étais pris en compte")
    }
    @Test
    fun setBallSupEnnemy(){
        e1.setNbBalle(3)
        Assertions.assertTrue(e1.getNbBalle()>e1.getNbBalleMax(), "Le nombre de balle de l'ennemi n'est pas supérieur au nombre maximum")
    }
    @Test
    fun EnnemyBoss(){
        e1.changeEtatBoss()
        Assertions.assertTrue(e1.getBoolBoss(),  "Le changement de type d'ennemi n'as pas pris en compte")
    }
    @Test
    fun EnnemyNormal(){
        e1.changeEtatNormal()
        Assertions.assertFalse(e1.getBoolBoss(), "Le changement de type d'ennemi n'as pas étais pris en compte")
    }
}