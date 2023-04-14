package fr.jeu.pattern

import fr.jeu.pattern.actionJoueur.comportement.combat
import fr.jeu.pattern.actionJoueur.magasin
import fr.jeu.pattern.decorator.ennemyDecorator
import fr.jeu.pattern.entity.Ennemy
import fr.jeu.pattern.entity.Joueur
import fr.jeu.pattern.utility.clearCmd
import java.util.*

private var p : Joueur = Joueur()
private var ennemy : Ennemy = Ennemy()
val scanner = Scanner(System.`in`)

fun main(args: Array<String>) {
    clearCmd()
    do {
        println("\n1 - Combattre")
        println("2 - Voir ses stats")
        println("3 - Acheter compétences (points dispo: "+ p.getLvl()+")")
        println("4 - Acheter compétences à effets (points dispo: "+ p.getLvl()+")")

        when (scanner.nextLine()) {
            "1" -> {
                p.setPv(combat.startCombat(p, ennemy))
                if(p.getPv() > 0){
                    println("\n--------------------------------------------------")
                    System.out.println("Vous avez gagné")
                    println("--------------------------------------------------\n")
                    var pointGagner = ennemy.getLvl() * (1+ ennemy.getLvl() / 10)
                    if (ennemy.getBoolBoss()){
                      pointGagner *= 2
                    }
                    p.addLvl(pointGagner)
                    ennemy = ennemyDecorator(ennemy)
                } else {
                    println("\n--------------------------------------------------")
                    System.out.println("Vous avez perdu")
                    println("--------------------------------------------------\n")
                    ennemy = Ennemy()
                    p.setPv(p.getPvMax().toDouble())
                }
            }
            "2" -> {
                clearCmd()
                ennemy.getStats()
                p.getStats()
            }
            "3" -> {
                p.setLvl(magasin.startMagasin(p))
            }
            "4" -> {
                p.setLvl(magasin.startMagasinEffets(p))
            }
        }
    } while (true)
}

