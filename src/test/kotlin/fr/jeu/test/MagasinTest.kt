package fr.jeu.test

import org.junit.jupiter.api.Test
import fr.jeu.pattern.actionJoueur.magasin
import org.junit.jupiter.api.Assertions

class MagasinTest {
    @Test
    fun competenceListNotEmpty(){
        magasin.initComp()
        Assertions.assertFalse(magasin.Companion.getLesComp()::isEmpty, "La liste de compétence ne devrait pas être vide")
    }
}