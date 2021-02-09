package com.aspechenin.basicsyntax

fun main(){
    var firstName="Алексей"
    var lastName="Печенин"
    var height=186
    var weight=82.5
    var isChild = (height<150)||(weight<40)
    var info = ("$lastName $firstName рост - $height cм, вес - $weight кг - ${if(isChild)"ребенок" else "взрослый"}")
    println(info)
    height=138
    isChild = (height<150)||(weight<40)
    info = ("$lastName $firstName рост - $height cм, вес - $weight кг - ${if(isChild)"ребенок" else "взрослый"}")
    println(info)





}
