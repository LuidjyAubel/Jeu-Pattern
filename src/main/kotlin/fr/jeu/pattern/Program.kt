package fr.jeu.pattern

import java.util.*
import kotlin.collections.ArrayList

private val p : Joueur = Joueur()
private val pointComp = 0
private var ennemy : Ennemy = Ennemy()
val scanner = Scanner(System.`in`)

fun main(args: Array<String>) {
    do {
        println("Jeu avec les design pattern !")
        println("1 - Combattre")
        println("2 - Voir ses stats")
        println("3 - Acheter compétences")
        when (scanner.nextLine()) {
            "1" -> {
                combat()
                if(p.getPv() > 0){
                    println("\n--------------------------------------------------")
                    System.out.println("Vous avez gagné")
                    println("--------------------------------------------------\n")
                } else {
                    println("\n--------------------------------------------------")
                    System.out.println("Vous avez perdu")
                    println("--------------------------------------------------\n")
                }
            }
            "2" -> {
                //TODO
                /**
                 * Afficher toutes ses stats
                 */
            }
            "3" -> {
                //TODO
                /**
                 * Utiliser pointComp pour ajouté des stats ex +dePv,atq,def
                 * Et après mettre en place des effets de compétences
                 */
            }
        }
    } while (true)
}

fun combat(){
    ennemy = Ennemy()
    while (ennemy.getPv() > 0 && p.getPv() > 0 ){
        var error = false
        do {
            println(ennemy.getStatsCombat())
            println("--------------------------------------------------")
            println(p.getStatsCombat())
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
            val rep = scanner.nextLine()
            clear()
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
        } while (error)
    }
}

fun clear() {
    println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
}

fun atqJoueur(): Boolean {
    var error = false
    if(p.getNbBalle() < 1){
        error = true
    } else {
        p.setNbTourDef(0)
        p.setNbBalle(p.getNbBalle()-1)
        val action = getActionEnnemy()
        when (action) {
            1 -> {
                atqEnnemy(false)
            }
            2 -> {
                rechEnnemy()
            }
            3 -> {
                defEnnemy()
            }
        }
        if (action != 3){
            var degat : Double = p.getDegatMin()+(0..p.getDegatMax()).random().toDouble()
            if((p.getCrittique()*100) >= (0..100).random()){
                println("\nCoup crittique !!!\n")
                degat = (degat * p.getDegatCrittique())
                degat = degat - ennemy.getDef()
            }
            if(degat > 0){
                ennemy.setPv(ennemy.getPv() - degat)
            }
            println("\nDégats infligé : "+degat+" !!!\n")
        }
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
        when (getActionEnnemy()) {
            1 -> {
                atqEnnemy(false)
            }
            2 -> {
                rechEnnemy()
            }
            3 -> {
                defEnnemy()
            }
        }
    }
    return error
}

fun defJoueur(): Boolean {
    var error = false
    if (p.getLimiteTourDef() == p.getNbTourDef()){
        error = true
    } else {
        p.setNbTourDef(p.getNbTourDef()+1)
        when (getActionEnnemy()) {
            1 -> {
                atqEnnemy(true)
            }
            2 -> {
                rechEnnemy()
            }
            3 -> {
                defEnnemy()
            }
        }
    }
    return error
}

fun getActionEnnemy(): Int {
    val actions = ArrayList<Int>()
    if (ennemy.getNbBalle() > 0) {
        actions.add(1)
    }
    if (ennemy.getNbBalle() < ennemy.getNbBalleMax()){
        actions.add(2)
    }
    if (ennemy.getNbTourDef() < ennemy.getLimiteTourDef()){
        actions.add(3)
    }
    var index = (0..(actions.size-1)).random()
    return actions.get(index)
}

fun atqEnnemy(boolDefJoueur:Boolean): Boolean {
    println("--------------------------------------------------")
    println("L'ennemi à attaqué !")
    println("--------------------------------------------------")
    var error = false
    if(ennemy.getNbBalle() < 1){
        error = true
    } else {
        ennemy.setNbTourDef(0)
        ennemy.setNbBalle(ennemy.getNbBalle()-1)
        if (!boolDefJoueur) {
            var degat : Double = ennemy.getDegatMin()+(0..ennemy.getDegatMax()).random().toDouble()
            if((ennemy.getCrittique()*100) >= (0..100).random()){
                println("\nCoup crittique !!!\n")
                degat = (degat * ennemy.getDegatCrittique())
                degat = degat - p.getDef()
            }
            if(degat > 0){
                p.setPv(p.getPv() - degat)
            }
            println("\nDégats infligé : "+degat+" !!!\n")
        }
    }
    return error
}

fun rechEnnemy(): Boolean {
    println("--------------------------------------------------")
    println("L'ennemi à rechargé !")
    println("--------------------------------------------------")
    var error = false
    if (ennemy.getNbBalle() == ennemy.getNbBalleMax()){
        error = true
    } else {
        ennemy.setNbTourDef(0)
        var nbBalle = ennemy.getNbBalle()+ennemy.getNbBalleRecharge()
        if (ennemy.getNbBalleMax()<nbBalle){
            ennemy.setNbBalle(ennemy.getNbBalleMax())
        } else {
            ennemy.setNbBalle(nbBalle)
        }
    }
    return error
}

fun defEnnemy(): Boolean {
    println("--------------------------------------------------")
    println("L'ennemi se defend !")
    println("--------------------------------------------------")
    var error = false
    if (ennemy.getLimiteTourDef() == ennemy.getNbTourDef()){
        error = true
    }
    ennemy.setNbTourDef(ennemy.getNbTourDef()+1)
    return error
}

