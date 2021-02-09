package com.aspechenin.oop.animals

import androidx.core.content.contentValuesOf
import kotlin.random.Random

open class Animal(//сразу задаются
    val name:String,//имя
    maxAge:Int//максимальный возраст
):AgedAnimal(maxAge),Soundable
{
    //вес
    var weight = Random.nextInt(5)+1
        private set(value){
            field=value
            print(" вес = $value")
        }

    //энергия
    var energy = Random.nextInt(10)+1
        private set(value){
            field=value
            println(" энергия = $value")
        }

    //возраст
    var age: Int=0
        get(){
            return field
        }
        private set(new_age){
            print("возраст = $new_age из $maxAge")
            field=new_age
        }

    init {
        print("рождается ")
        this.animal_info()
    }

    //проверка возраста
    var isTooOld = false
        get() {
            return this.maxAge<=age
        }

    //поспать
    fun sleep(){
        if(!isTooOld){
            println("$name спит")
            age++
            print(" вес = $weight")
            energy+=5
        }else println("$name не может спать")
    }

    //информация
    fun animal_info(){
        println("животное с именем $name (возраст: $age из $maxAge, вес: $weight, энeргия: $energy)")
    }

    //поесть
    fun eat(){
        if(!isTooOld){
            println("$name ест")
            incrementAgeSometimes()
            weight++
            energy+=3
        }else println("$name не может есть")

    }

    //пробежаться
    open fun move(){
        if((!isTooOld)&&(energy>=5)&&(weight>0)) {
            println("$name двигается")
            incrementAgeSometimes()
            weight--
            energy -= 5
        }else println("$name не может двигаться")

    }

    private fun incrementAgeSometimes(){
        if(Random.nextBoolean())age++
        else print("возраст = $age из $maxAge")
    }

    //рождение нового персонажа
    open fun makeChild(): Animal{
        return Animal(name+"I", maxAge)
    }

    //жизненный цикл
    open fun liveCicle(){
        eat()
        sleep()
    }

    override fun makeSound() {

        println("$name издает звук")

    }

}