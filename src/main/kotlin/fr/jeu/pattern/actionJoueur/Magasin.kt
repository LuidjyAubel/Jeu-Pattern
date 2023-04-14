package fr.jeu.pattern.actionJoueur

import fr.jeu.pattern.actionJoueur.comportement.combat
import fr.jeu.pattern.utility.clearCmd
import fr.jeu.pattern.entity.Joueur
import fr.jeu.pattern.scanner
import fr.jeu.pattern.utility.Competence

open class magasin() {
    companion object {
        private var nbAchatsEffect = 1
        private var effectBuy = ArrayList<Int>()
        private var lesComp = ArrayList<Competence>()

        /**
         * Initialise le magasin effets
         */
        fun initComp(){
            lesComp.add(Competence(1,"Récupérer 10% de pv/combat",))
            lesComp.add(Competence(2,"Commencer avec 25% du chargeur",))
            lesComp.add(Competence(3,"Permet de fusionner les balles pour multiplier les dégats",))
            lesComp.add(Competence(4,"50% des dégats infligé ignore l'armure ennemi",))
            lesComp.add(Competence(5,"Bloqué restore 10% des dégats que l'ennemi aurait du vous infliger",))
        }

        /**
         * Permet au joueur d'acheter
         * @Return les points restants
         */
        fun startMagasin(p: Joueur): Int {
            clearCmd()
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
                        if ((q * cout) > p.getLvl()) {
                            println("Pas assez de points disponible")
                        } else if (p.getCrittique() + 0.005 * q > 1.0) {
                            println("La limite à été atteinte, achat annulé !")
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
                        if ((q * cout) > p.getLvl()) {
                            println("Pas assez de points disponible")
                        } else if (p.getDodge() + 0.005 * q > 0.9) {
                            println("La limite à été atteinte, achat annulé !")
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
                        if ((q * cout) > p.getLvl()) {
                            println("Pas assez de points disponible")
                        } else if (p.getNbBalleMax() + q > 20) {
                            println("La limite à été atteinte, achat annulé !")
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
                        if ((q * cout) > p.getLvl()) {
                            println("Pas assez de points disponible")
                        } else if (p.getLimiteTourDef() + q > 5) {
                            println("La limite à été atteinte, achat annulé !")
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
                            var regen = 25 * q
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
            return p.getLvl()
        }

        /**
         * Permet au joueur d'acheter
         * @Return les points restants
         */
        fun startMagasinEffets(p: Joueur): Int {
            clearCmd()
            var cout = nbAchatsEffect * 25
            println("Entrez le numéro de la compétence à acheter : ")
            lesComp.forEach {
                if (!it.getAcheter())
                    println("${it.getId()}--> ${it.getDesc()} "+ cout +" points")
            }
            when (scanner.nextLine()) {
                "1" -> {
                    if(lesComp.get(0).getAcheter()){
                        println("La compétence à effets à déjà été acheté!")
                    } else if (cout > p.getLvl()) {
                        println("Pas assez de points disponible")
                    } else {
                        p.delLvl(cout)
                        combat.comportementFinCombat = {
                            combat.comportementFinCombat()
                            var regen = (p.getPvMax().toDouble() / 10)
                            if (regen + p.getPv() > p.getPvMax()) {
                                p.setPv(p.getPvMax().toDouble())
                            } else {
                                p.setPv(p.getPv() + regen)
                            }
                        }
                        println("Achat validé")
                        nbAchatsEffect++
                        lesComp.get(0).setAcheter()
                    }
                }

                "2" -> {
                    if(lesComp.get(1).getAcheter()){
                        println("La compétence à effets à déjà été acheté!")
                    } else if (cout > p.getLvl()) {
                        println("Pas assez de points disponible")
                    } else {
                        p.delLvl(cout)
                        combat.comportementDebutCombat = {
                            combat.comportementDebutCombat()
                            var newMax: Double = (p.getNbBalleMax().toDouble() / 4)
                            if (newMax < 1) {
                                newMax = 1.0
                            }
                            p.setNbBalle(newMax.toInt())
                        }
                        println("Achat validé")
                        nbAchatsEffect++
                        lesComp.get(1).setAcheter()
                    }
                }

                "3" -> {
                    if(lesComp.get(2).getAcheter()){
                        println("La compétence à effets à déjà été acheté!")
                    } else if (cout > p.getLvl()) {
                        println("Pas assez de points disponible")
                    } else {
                        p.delLvl(cout)
                        combat.comportementAtqSpeJoueur = {
                            if(p.getNbBalle()>1) {
                                println("Combiens de balles voulez vous tirer? (balles dispo : ${p.getNbBalle()}")
                                try {
                                    var q = scanner.nextLine().toInt()
                                    if (q <= p.getNbBalle()){
                                        combat.degatJ *= q
                                        println("$q balle ont été tiré")
                                    } else {
                                        println("1 balle à été tiré")
                                    }
                                } catch (e: Exception) {
                                    println("1 balle à été tiré")
                                }
                            }
                            combat.comportementAtqSpeJoueur()
                        }
                        println("Achat validé")
                        nbAchatsEffect++
                        lesComp.get(2).setAcheter()
                    }
                }

                "4" -> {
                    if(lesComp.get(3).getAcheter()){
                        println("La compétence à effets à déjà été acheté!")
                    } else if (cout > p.getLvl()) {
                        println("Pas assez de points disponible")
                    } else {
                        p.delLvl(cout)
                        combat.comportementAtqSpeJoueur = {
                            combat.comportementAtqSpeJoueur()
                            combat.degatJ += (combat.ennemy.getDef().toDouble()/2)
                        }
                        println("Achat validé")
                        nbAchatsEffect++
                        lesComp.get(3).setAcheter()
                    }
                }

                "5" -> {
                    if(lesComp.get(4).getAcheter()){
                        println("La compétence à effets à déjà été acheté!")
                    } else if (cout > p.getLvl()) {
                        println("Pas assez de points disponible")
                    } else {
                        p.delLvl(cout)
                        combat.comportementDefense = {
                            var degat : Double = combat.ennemy.getDegatMin()+(0..combat.ennemy.getDegatMax()).random().toDouble()
                            var crittique = combat.ennemy.getCrittique()
                            var pCrittique = ((0..100).random().toDouble())/100
                            if(crittique >= pCrittique){
                                degat = (degat * combat.ennemy.getDegatCrittique())
                            }
                            if(degat > 0){
                                var regen = degat / 10
                                if (regen + p.getPv() > p.getPvMax()) {
                                    p.setPv(p.getPvMax().toDouble())
                                } else {
                                    p.setPv(p.getPv() + regen)
                                    println("Vous avez récupéré $regen pv")
                                }
                                p.getPv()
                            } else {
                                degat = 0.0
                            }
                        }
                        println("Achat validé")
                        nbAchatsEffect++
                        lesComp.get(4).setAcheter()
                    }
                }
            }
            return p.getLvl()
        }
    }
}