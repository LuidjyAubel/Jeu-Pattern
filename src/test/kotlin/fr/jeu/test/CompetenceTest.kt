package fr.jeu.test

import fr.jeu.pattern.utility.Competence
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CompetenceTest {
    var c1 : Competence = Competence(1, "Competence de test")
    @Test
    fun createCompetence(){
        Assertions.assertNotSame(c1, Competence(1, "Competence de test"), "Le 2 compétence sont les même")
    }
    @Test
    fun getId(){
        Assertions.assertEquals(1, c1.getId(), "L'identifiant de la compétence ne correspond pas")
    }
    @Test
    fun setId(){
        c1.setId(2)
        Assertions.assertEquals(2, c1.getId(), "le changement d'Id n'as pas étais pris en compte")
    }
    @Test
    fun getDescription(){
        Assertions.assertEquals("Competence de test", c1.getDesc(), "La description ne correspond pas")
    }
    @Test
    fun setDescription(){
        c1.setDesc("Test set Description")
        Assertions.assertEquals("Test set Description",c1.getDesc(), "Le changement de description n'as pas étais pris en compte")
    }
    @Test
    fun estPasAcheter(){
        Assertions.assertFalse(c1.getAcheter(), "La valeur de acheter devrait être à false par défaut")
    }
    @Test
    fun estAcheter(){
        c1.setAcheter()
        Assertions.assertTrue(c1.getAcheter(), "Le changement de l'état de l'achat d'une compétence ne fonctionnne pas")
    }
}