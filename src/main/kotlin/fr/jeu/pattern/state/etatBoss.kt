package fr.jeu.pattern

import fr.jeu.pattern.entity.Ennemy
import fr.jeu.pattern.state.etatEnnemy

class etatDeBoss(ennemy: Ennemy) : etatEnnemy {
    private var en : Ennemy = ennemy
    override fun getStatsCombat() {
        System.out.println("\n<-----Boss----->")
        System.out.println("PV : "+en.getPv()+" / "+en.getPvMax())
        System.out.println("Balle "+en.getNbBalle()+" / "+en.getNbBalleMax())
        System.out.println("Limite tour de def "+en.getNbTourDef()+" / "+en.getLimiteTourDef()+"\n")
    }

    override fun getBoolBoss(): Boolean {
        return true
    }
}