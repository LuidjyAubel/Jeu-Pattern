package fr.jeu.pattern
 class ennemyDecorator(val ennemy : Ennemy) : Ennemy() {
     init {
         addLvl(ennemy.getLvl())
         setDegatMin(ennemy.getDegatMin())
         setDegatMax(ennemy.getDegatMax())
         setCrittique(ennemy.getCrittique())
         setDegatCrittique(ennemy.getDegatCrittique())
         setDodge(ennemy.getDodge())
         setDef(ennemy.getDef())
         setPvMax(ennemy.getPvMax())
         setPv(ennemy.getPvMax().toDouble())
         setNbTourDef(0)
         setNbBalle(0)
         setLimiteTourDef(ennemy.getLimiteTourDef())
         setNbBalleMax(ennemy.getNbBalleMax())
         setNbBalleRecharge(ennemy.getNbBalleRecharge())
         lvlUp()
     }
     fun lvlUp(){
         addLvl(1)
         if (getLvl() % 5 == 0){
             setPvMax(getPvMax()*2)
             setDef(getDef()*2)
             setDegatMin(getDegatMin()*2)
             changeEtatBoss()
             when ((0..2).random()) {
                 0 ->{
                     setLimiteTourDef(getLimiteTourDef()+1)
                     System.out.println("L'ennemi à plus de tours de défense")
                 }
                 1 ->{
                     setNbBalleMax(getNbBalleMax()+1)
                     System.out.println("L'ennemi à un plus grand chargeur")
                 }
                 2 ->{
                     setNbBalleRecharge(getNbBalleRecharge()+1)
                     System.out.println("L'ennemi recharge plus de balle par tour")
                 }
             }
             setNbBalle(getNbBalleMax())
         } else {
             changeEtatNormal()
             when ((0..2).random()) {
                 0 -> {
                     setDegatMin(getDegatMin()+1)
                     setDegatMax(getDegatMax()+3)
                     System.out.println("L'ennemi inflige plus de dégats")
                 }

                 1 -> {
                     setPvMax(getPvMax()+3)
                     setDef(getDef())
                     System.out.println("L'ennemi à plus de vie et de défense")
                 }

                 2 -> {
                     setCrittique(getCrittique()+0.01)
                     setDodge(getDodge()+0.01)
                     System.out.println("L'ennemi à plus de chance d'esquive et de chance de crittique")
                 }
             }
         }
         setDegatCrittique(getDegatCrittique()+0.01)
         setPv(getPvMax().toDouble())
     }
 }