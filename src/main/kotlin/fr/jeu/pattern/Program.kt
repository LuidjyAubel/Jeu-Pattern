package fr.jeu.pattern

import java.util.*

private var Comps : MutableList<Competence> = mutableListOf<Competence>()
private val p : Joueur = Joueur()
private var ennemy : Ennemy = Ennemy()
private val console = Scanner(System.`in`)
fun main(args: Array<String>) {
    println("Jeu avec les design pattern !")
    println("1 - Combattre")
    println("2 - Voir ses stats")
    println("3 - Acheter compétences")
    combat()
}
fun combat(){
    ennemy = Ennemy()
    while (ennemy.getPv() < 0 || p.getPv() < 0 ){
        var error = false
        while (error) {
            println(ennemy.toString())
            println("--------------------------------------------------")
            println(p.toString())
            if (p.getNbBalle() > 0) {
                println("1 - Tirer sur l'ennemi")
            } else {
                println("1 - Vous n'avez pas de munition")
            }
            if (p.getNbBalle() < p.getNbBalleMax()){
                println("2 - Recharger")
            } else {
                println("1 - Vous ne pouvez plus recharger")
            }

            if (p.getNbTourDef() < p.getLimiteTourDef()){
                println("3 - Bloquer")
            } else {
                println("1 - Vous ne pouvez plus bloquer")
            }
            val rep = console.nextLine()
            when (rep) {
                "1" -> {
                    error = atqJoueur()
                }
                "2" -> {
                    error = rechJoueur()
                }
                "3" -> {
                    error = defJoueur()
                }
                else -> {
                    error = true
                }
            }
        }
    }
}
fun atqJoueur(): Boolean {
    var error = false
    if(p.getNbBalle() < 0){
        error = true
    }
    p.setNbTourDef(0)
    var degat = p.getDegatMin()+(0..p.getDegatMax()).random()
    if((p.getCrittique()*100) >= (0..100).random()){
        println("Coup crittique !!!")
        degat = (degat * p.getDegatCrittique()).toInt()
    }
    if(degat > ennemy.getDef()){
        ennemy.setPv(ennemy.getPv() - degat + ennemy.getDef())
    }
    return error
}

fun rechJoueur(): Boolean {
    var error = false
    if (p.getNbBalle() == p.getNbBalleMax()){
        error = true
    } else {
        p.setNbTourDef(0)
        var nbBalle = p.getNbBalle()+p.getNbBalleRecharge()
        if (p.getNbBalleMax()<nbBalle){
            p.setNbBalle(p.getNbBalleMax())
        } else {
            p.setNbBalle(nbBalle)
        }
    }
    return error
}

fun defJoueur(): Boolean {
    var error = false
    if (p.getLimiteTourDef() == p.getNbTourDef()){
        error = true
    }
    p.setNbTourDef(p.getNbTourDef()+1)
    return error
}
