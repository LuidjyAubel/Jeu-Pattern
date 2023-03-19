package fr.jeu.pattern

class Competence(unID : String, unNom : String, uneDesc : String, unCout : Double) {
    private var id : String = unID
    private var nom :String = unNom // Nom de la compétence
    private var desc : String = uneDesc // Description de la compétence
    private var cout : Double = unCout // cout en XP pour obtenir la compétence
    private var acheter : Boolean = false // Si la compétence est acheté ou pas (defaut = false)
    fun getId() : String{
        return id
    }
    fun getNom(): String{
        return  nom
    }
    fun getDesc() : String{
        return desc
    }
    fun getCout() : Double{
        return cout
    }
    fun getAcheter() : Boolean{
        return acheter
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
    fun setCout(x :Double){
        cout = x
    }
    fun setAcheter(){
        acheter = !acheter
    }
}