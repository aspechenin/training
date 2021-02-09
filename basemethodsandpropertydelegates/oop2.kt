package com.aspechenin.basemethodsandpropertydelegates

import android.os.Parcel
import android.os.Parcelable
import com.aspechenin.basemethodsandpropertydelegates.oop2.Person
import com.aspechenin.basemethodsandpropertydelegates.oop2.Animal
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun main(){

//реализуется сравнение объектов по ссылке и по значению
//в дополнению к персоне создается массив из его домашних животных
//домашнее животное добавляется со случайным именем

//:( не разобрался, как реализовать класс-делегат для вывода имени и питомцев персоны
	

    var person1 = Person(170,70,"Павел")
    var person2 = Person(170,70,"Павел")
    var personSet = hashSetOf(person1,person2)
    var person3 = Person(150,80,"Дима")
    personSet.add(person3)

    println("количество элементов - ${personSet.size}")

    personSet.forEach(){
        println(it)
        it.buyPet()
    }
    person2 = Person(170,70,"Павел")
    person2.buyPet()
    personSet.add(person2)

    personSet.forEach(){
        println(it)
    }
    //person1.pets.add(dog)

}

class PrintNameAndPetsDelegate<T>: ReadOnlyProperty<Person,T> {
    override fun getValue(thisRef: Person, property: KProperty<*>): T {
        TODO("Not yet implemented")
    }
}