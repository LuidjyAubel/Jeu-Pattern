package fr.jeu.pattern

class etatNormal(ennemy: Ennemy) : etatEnnemy{
    private  var en : Ennemy = ennemy;
    override fun Normal(){
        println("Je suis déjà un ennemi normal")
    }
    override fun Boss(){
        en.setDegatMin(2)
        en.setDegatMax(1)
        en.setDegatCrittique(0.03)
        en.setPv(5.00)
        en.changeEtatBoss();
    }
}