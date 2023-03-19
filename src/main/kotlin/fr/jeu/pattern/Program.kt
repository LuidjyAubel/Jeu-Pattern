package fr.jeu.pattern
fun main(args: Array<String>) {
    println("Jeu avec les design pattern !")
    var Comps : MutableList<Competence> = mutableListOf<Competence>()
    var Frapper : Competence = Competence("1", "Frapper", "Permet à l'entité de frapper", 10.00)
    var Personnage : Joueur = Joueur("1","Angel",10.0, 10.0, 1000.0, 90.0,0.0,Comps)
    Personnage.setUneCompetence(Frapper)
    println(Personnage.toString())
}