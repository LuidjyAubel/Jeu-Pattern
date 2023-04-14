package fr.jeu.pattern.actionJoueur.comportement

import fr.jeu.pattern.utility.clearCmd
import fr.jeu.pattern.entity.Ennemy
import fr.jeu.pattern.entity.Joueur
import fr.jeu.pattern.scanner

class combat {

    companion object {

        lateinit var p : Joueur
        lateinit var ennemy : Ennemy
        var degatJ = 0.0
        var comportementFinCombat: () -> Unit = {
            p.setNbBalle(0)
            p.setNbTourDef(0)
        }
        var comportementDebutCombat: () -> Unit = {
        }
        var comportementAtqSpeJoueur: () -> Unit = {
            degatJ = degatJ - ennemy.getDef()
        }
        var comportementDefense : () -> Unit = {
        }

        /**
         * Effectue le combat
         * @return les pv restants
         */
        fun startCombat(leP:Joueur, Lennemy: Ennemy): Double {
            comportementDebutCombat()
            p = leP
            ennemy = Lennemy
            clearCmd()
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
                    clearCmd()
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
            comportementFinCombat()
            return p.getPv()
        }

        /**
         * Effectue l'action atq du joueur
         */
        fun atqJoueur(): Boolean {
            var error = false
            if(p.getNbBalle() < 1){
                error = true
            } else {
                p.setNbTourDef(0)
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
                    degatJ = p.getDegatMin()+(0..p.getDegatMax()).random().toDouble()
                    var crittique = p.getCrittique()
                    var pCrittique = ((0..100).random().toDouble())/100
                    if(crittique >= pCrittique){
                        println("\nCoup crittique !!!")
                        degatJ = (degatJ * p.getDegatCrittique())
                    }
                    var dodge = ennemy.getDodge()
                    var pDodge = ((0..100).random().toDouble())/100
                    if(dodge >= pDodge){
                        println("\nEsquive !!!")
                        degatJ = 0.0
                    } else {
                        comportementAtqSpeJoueur()
                    }
                    if(degatJ > 0){
                        ennemy.setPv(ennemy.getPv() - degatJ)
                    } else {
                        degatJ = 0.0
                    }
                    println("\nDégats infligé : "+degatJ+" !!!\n")
                }
                if (p.getNbBalle()!=0)p.setNbBalle(p.getNbBalle()-1)
            }
            return error
        }

        /**
         * Effectue l'action rech du joueur
         */
        fun rechJoueur(): Boolean {
            var error = false
            if (p.getNbBalle() == p.getNbBalleMax()){
                error = true
            } else {
                p.setNbTourDef(0)
                var nbBalle = p.getNbBalle()+ p.getNbBalleRecharge()
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

        /**
         * Effectue l'action def du joueur
         */
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

        /**
         * Sélectionne l'action de l'ennemi
         */
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

        /**
         * Effectue l'action atq de l'ennemi
         */
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
                    var crittique = ennemy.getCrittique()
                    var pCrittique = ((0..100).random().toDouble())/100
                    if(crittique >= pCrittique){
                        println("\nCoup crittique !!!")
                        degat = (degat * ennemy.getDegatCrittique())
                    }
                    degat = degat - p.getDef()
                    var dodge = p.getDodge()
                    var pDodge = ((0..100).random().toDouble())/100
                    if(dodge >= pDodge){
                        println("\nEsquive !!!")
                        degat = 0.0
                    }
                    if(degat > 0){
                        p.setPv(p.getPv() - degat)
                    } else {
                        degat = 0.0
                    }
                    println("\nDégats subis : "+degat+" !!!\n")
                } else {
                    comportementDefense()
                }
            }
            return error
        }

        /**
         * Effectue l'action rech de l'ennemi
         */
        fun rechEnnemy(): Boolean {
            println("--------------------------------------------------")
            println("L'ennemi à rechargé !")
            println("--------------------------------------------------")
            var error = false
            if (ennemy.getNbBalle() == ennemy.getNbBalleMax()){
                error = true
            } else {
                ennemy.setNbTourDef(0)
                var nbBalle = ennemy.getNbBalle()+ ennemy.getNbBalleRecharge()
                if (ennemy.getNbBalleMax()<nbBalle){
                    ennemy.setNbBalle(ennemy.getNbBalleMax())
                } else {
                    ennemy.setNbBalle(nbBalle)
                }
            }
            return error
        }

        /**
         * Effectue l'action def de l'ennemi
         */
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
    }
}