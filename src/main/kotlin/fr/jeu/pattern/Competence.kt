package fr.jeu.pattern

class Competence(unID : String, unNom : String, uneDesc : String) {
    private var id : String = unID
    private var nom :String = unNom // Nom de la compétence
    private var desc : String = uneDesc // Description de la compétence

    fun getId() : String{
        return id
    }
    fun getNom(): String{
        return  nom
    }
    fun getDesc() : String{
        return desc
    }
    fun setId(x : String){
        id = x
    }
    fun setNom(x : String){
        nom = x
    }
    fun setDesc(x : String){
        desc = x
    }
}