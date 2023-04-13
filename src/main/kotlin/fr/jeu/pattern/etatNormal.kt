package fr.jeu.pattern

class etatNormal(ennemy: Ennemy) : etatEnnemy{
    private var en : Ennemy = ennemy
    override fun getStatsCombat() {
        System.out.println("\nEnnemy lvl: "+en.getLvl())
        System.out.println("PV : "+en.getPv()+" / "+en.getPvMax())
        System.out.println("Balle "+en.getNbBalle()+" / "+en.getNbBalleMax())
        System.out.println("Limite tour de def "+en.getNbTourDef()+" / "+en.getLimiteTourDef()+"\n")
    }

    override fun getBoolBoss(): Boolean {
        return false
    }

}