package com.aspechenin.basemethodsandpropertydelegates.oop2

import java.util.*
import kotlin.random.Random

class Person(
    var height:Int,
    var weight:Int,
    val name:String
) {
    var pets=HashSet<Animal>()

	//переопределение функции сравнения для объектов по значению
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        if (height != other.height) return false
        if (weight != other.weight) return false
        if (name != other.name) return false
        if (pets != other.pets) return false

        return true
    }

	//переопределение функции сравнения для объектов по ссылке
    override fun hashCode(): Int {
        var result = height
        result = 31 * result + weight
        result = 31 * result + name.hashCode()
        result = 31 * result + pets.hashCode()
        return result
    }

    override fun toString(): String {
        return "Персона $name ростом $height см и весом $weight кг (дом.Животные$pets)"
    }

	//приобретение случайного животного
    fun buyPet(){
        pets.add(Animal(Random.nextInt(10)+1,Random.nextInt(5)+1,randomName()))
    }


    private val petNames= setOf("Жужа","Боба","Гога","Пуджик","Лариска","собачка","кошечка")

	//выбор случайного имени из массива имен
    private fun randomName():String{
        return petNames.elementAt(Random.nextInt(petNames.size))
    }


}