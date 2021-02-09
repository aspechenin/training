package com.aspechenin.oop

import com.aspechenin.oop.animals.Animal
import com.aspechenin.oop.animals.Bird
import com.aspechenin.oop.animals.Zoo

fun main() {
	//Программа имитирует жизненный цикл в зоопарке
	//животные каждый день совершают по одному случайному действию
	//при достижении определенного возраста умирают
	//новорожденные животные получают имя родителя

	// :( пока не выходит включить новорожденного в массив зоопарка
    /*
    var bird1 = Bird("Кеша")
    for(i in 1..5) {
        bird1=bird1.makeChild()
        while (!bird1.isTooOld) {
            bird1.liveCicle()
        }
        println("животное с именем ${bird1.name} умирает")
        bird1.makeSound()
    }
    */

    var zoo=Zoo()
    for(i in 1..50) {
        println("\nдень $i-й")
        zoo.randomMake()
        println("состав зоопрака (${zoo.animals.size} животных):")

        if (zoo.animals.size==0)break//если животных не осталось, выход
        zoo.animals.forEach(){//состав зоопрака
            print(it.name+"\t")
        }
        println("\t")
    }



}



