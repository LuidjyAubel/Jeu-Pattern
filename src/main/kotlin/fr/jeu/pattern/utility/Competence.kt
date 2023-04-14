package fr.jeu.pattern.utility

class Competence(unID : Int, uneDesc : String) {
    private var id : Int = unID
    private var desc : String = uneDesc // Description de la compétence
    private var acheter : Boolean = false // Si la compétence est acheté ou pas (defaut = false)
    fun getId() : Int{
        return id
    }
    fun getDesc() : String{
        return desc
    }
    fun getAcheter() : Boolean{
        return acheter
    }
    fun setId(x : Int){
        id = x
    }
    fun setDesc(x : String){
        desc = x
    }
    fun setAcheter(){
        acheter = true
    }
}