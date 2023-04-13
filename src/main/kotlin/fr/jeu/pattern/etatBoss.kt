package fr.jeu.pattern

class etatDeBoss(ennemy: Ennemy) : etatEnnemy{
    private  var en : Ennemy = ennemy;
    override fun Normal(){
        en.setDegatMin(1)
        en.setDegatMax(0)
        en.setDegatCrittique(0.01)
        en.setPv(3.00)
        en.changeEtatNormal()
    }
    override fun Boss(){
        println("Je suis déjà un boss")
    }
}