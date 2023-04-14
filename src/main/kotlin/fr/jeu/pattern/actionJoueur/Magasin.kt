package fr.jeu.pattern.actionJoueur

import fr.jeu.pattern.utility.clearCmd
import fr.jeu.pattern.entity.Joueur
import fr.jeu.pattern.scanner

class magasin(var p : Joueur) {
    /**
     * Permet au joueur d'acheter
     */
    init {
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
    }
    /**
     * Return le joueur au main
     */
    fun getJoueur() : Joueur{
        return p
    }
}