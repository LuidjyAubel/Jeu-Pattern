package fr.jeu.pattern

import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

private val p : Joueur = Joueur()
private var ennemy : Ennemy = Ennemy()
val scanner = Scanner(System.`in`)

fun main(args: Array<String>) {
    clear()
    do {
        println("\n1 - Combattre")
        println("2 - Voir ses stats")
        println("3 - Acheter compétences (points dispo: "+ p.getLvl()+")")
        when (scanner.nextLine()) {
            "1" -> {
                combat()
                if(p.getPv() > 0){
                    println("\n--------------------------------------------------")
                    System.out.println("Vous avez gagné")
                    println("--------------------------------------------------\n")
                    ennemy = ennemyDecorator(ennemy)
                    p.addLvl(ennemy.getLvl() * (1+ ennemy.getLvl()/10))
                } else {
                    println("\n--------------------------------------------------")
                    System.out.println("Vous avez perdu")
                    println("--------------------------------------------------\n")
                    ennemy = Ennemy()
                    p.setPv(p.getPvMax().toDouble())
                }
            }
            "2" -> {
                clear()
                ennemy.getStats()
                p.getStats()
            }
            "3" -> {
                magasin()
            }
        }
    } while (true)
}

fun combat(){
    clear()
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
    p.setNbBalle(0)
    p.setNbTourDef(0)
}

fun clear() {
    println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
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
            }
            degat = degat - ennemy.getDef()
            if(degat > 0){
                ennemy.setPv(ennemy.getPv() - degat)
            } else {
                degat = 0.0
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
            }
            degat = degat - p.getDef()
            if(degat > 0){
                p.setPv(p.getPv() - degat)
            } else {
                degat = 0.0
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

fun magasin() {
    println("Entrez le numéro de la compétence à acheter : ")
    println("1--> 1 PV 1 point")
    println("2--> 1 DEF 3 point")
    println("3--> 1 ATQ min 3 point")
    println("4--> ATQ max 1 point")
    println("5--> +0.5 Chance critique 5 point (limite 100%)")
    println("6--> +0.01 Multiplicateur critique 2 point ")
    println("7--> +0.5% Chance d'esquive 10 point (limite 90%)")
    println("8--> Nombre de balle 25 point (limite 20)")
    println("9--> Plus de balle rechargé par tour 15 point")
    println("10--> Limite tour de def 25 point (limite 5)")
    println("11--> Se soigner de 25% de sa vie max 5 points")
    println("12--> Se soigner de 25 pv 1 points")
    when (scanner.nextLine()) {
        "1" -> {
            println("Quantité ?")
            try {
                var cout = 1
                var q = scanner.nextLine().toInt()
                if ((q * cout) > p.getLvl()) {
                    println("Pas assez de points disponible")
                } else {
                    p.delLvl(q * cout)
                    p.setPvMax(p.getPvMax() + q)
                    println("Achat validé")
                }
            } catch (e: Exception) {
                println("Achat annulé")
            }
        }

        "2" -> {
            println("Quantité ?")
            try {
                var cout = 3
                var q = scanner.nextLine().toInt()
                if ((q * cout) > p.getLvl()) {
                    println("Pas assez de points disponible")
                } else {
                    p.delLvl(q * cout)
                    p.setDef(p.getDef() + q)
                    println("Achat validé")
                }
            } catch (e: Exception) {
                println("Achat annulé")
            }
        }

        "3" -> {
            println("Quantité ?")
            try {
                var cout = 3
                var q = scanner.nextLine().toInt()
                if ((q * cout) > p.getLvl()) {
                    println("Pas assez de points disponible")
                } else {
                    p.delLvl(q * cout)
                    p.setDegatMin(p.getDegatMin() + q)
                    println("Achat validé")
                }
            } catch (e: Exception) {
                println("Achat annulé")
            }
        }

        "4" -> {
            println("Quantité ?")
            try {
                var cout = 1
                var q = scanner.nextLine().toInt()
                if ((q * cout) > p.getLvl()) {
                    println("Pas assez de points disponible")
                } else {
                    p.delLvl(q * cout)
                    p.setDegatMax(p.getDegatMax() + q)
                    println("Achat validé")
                }
            } catch (e: Exception) {
                println("Achat annulé")
            }
        }

        "5" -> {
            println("Quantité ?")
            try {
                var cout = 5
                var q = scanner.nextLine().toInt()
                if ((q * cout) > p.getLvl() || p.getCrittique() + 0.005 * q > 1.0) {
                    println("Pas assez de points disponible")
                } else {
                    p.delLvl(q * cout)
                    p.setCrittique(p.getCrittique() + q * 0.005)
                    println("Achat validé")
                }
            } catch (e: Exception) {
                println("Achat annulé")
            }
        }

        "6" -> {
            println("Quantité ?")
            try {
                var cout = 2
                var q = scanner.nextLine().toInt()
                if ((q * cout) > p.getLvl()) {
                    println("Pas assez de points disponible")
                } else {
                    p.delLvl(q * cout)
                    p.setDegatCrittique(p.getDegatCrittique() + q * 0.01)
                    println("Achat validé")
                }
            } catch (e: Exception) {
                println("Achat annulé")
            }
        }

        "7" -> {
            println("Quantité ?")
            try {
                var cout = 10
                var q = scanner.nextLine().toInt()
                if ((q * cout) > p.getLvl() || p.getCrittique() + 0.005 * q > 0.9) {
                    println("Pas assez de points disponible")
                } else {
                    p.delLvl(q * cout)
                    p.setDodge(p.getDodge() + q * 0.005)
                    println("Achat validé")
                }
            } catch (e: Exception) {
                println("Achat annulé")
            }
        }

        "8" -> {
            println("Quantité ?")
            try {
                var cout = 25
                var q = scanner.nextLine().toInt()
                if ((q * cout) > p.getLvl() || p.getNbBalleMax() + q > 20) {
                    println("Pas assez de points disponible")
                } else {
                    p.delLvl(q * cout)
                    p.setNbBalleMax(p.getNbBalleMax() + q)
                    println("Achat validé")
                }
            } catch (e: Exception) {
                println("Achat annulé")
            }
        }

        "9" -> {
            println("Quantité ?")
            try {
                var cout = 15
                var q = scanner.nextLine().toInt()
                if ((q * cout) > p.getLvl()) {
                    println("Pas assez de points disponible")
                } else {
                    p.delLvl(q * cout)
                    p.setNbBalleRecharge(p.getNbBalleRecharge() + q)
                    println("Achat validé")
                }
            } catch (e: Exception) {
                println("Achat annulé")
            }
        }

        "10" -> {
            println("Quantité ?")
            try {
                var cout = 25
                var q = scanner.nextLine().toInt()
                if ((q * cout) > p.getLvl() || p.getLimiteTourDef() + q > 5) {
                    println("Pas assez de points disponible")
                } else {
                    p.delLvl(q * cout)
                    p.setLimiteTourDef(p.getLimiteTourDef() + q)
                    println("Achat validé")
                }
            } catch (e: Exception) {
                println("Achat annulé")
            }
        }

        "11" -> {
            println("Quantité ?")
            try {
                var cout = 5
                var q = scanner.nextLine().toInt()
                if ((q * cout) > p.getLvl()) {
                    println("Pas assez de points disponible")
                } else {
                    p.delLvl(q * cout)
                    var regen = (p.getPvMax().toDouble() / 4) * q
                    if (regen + p.getPv() > p.getPvMax()) {
                        p.setPv(p.getPvMax().toDouble())
                    } else {
                        p.setPv(p.getPv() + regen)
                    }
                    println("Achat validé")
                }
            } catch (e: Exception) {
                println("Achat annulé")
            }
        }

        "12" -> {
            println("Quantité ?")
            try {
                var cout = 1
                var q = scanner.nextLine().toInt()
                if ((q * cout) > p.getLvl()) {
                    println("Pas assez de points disponible")
                } else {
                    p.delLvl(q * cout)
                    var regen = 5 * q
                    if (regen + p.getPv() > p.getPvMax()) {
                        p.setPv(p.getPvMax().toDouble())
                    } else {
                        p.setPv(p.getPv() + regen)
                    }
                    println("Achat validé")
                }
            } catch (e: Exception) {
                println("Achat annulé")
            }
        }
    }

}

