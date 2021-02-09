package com.aspechenin.oop.animals

import kotlin.random.Random

class Zoo (

){
    var animals= mutableListOf(
        Bird("Гоша"),
        Bird("Кеша"),
        Bird("Каркуша"),
        Bird("Дональд"),
        Bird("Маргоша"),
        Fish("Немо"),
        Fish("Дори"),
        Fish("Флаундер"),
        Animal("Лев",5),
        Animal("Белка",5),
        Dog("Шарик"),
        Dog("Барбос")
    )


    open fun randomMake(){
        var animalsTemp=animals
        for(animal in animals) {
            if(animal.isTooOld){
                println("${animal.name} умер(ла)")
                animalsTemp.remove(animal)
                break//пока выход из цикла, иначе - ошибка
            }else {
                when (Random.nextInt(5) + 1) {
                    //1 -> animals.add(animal.makeChild())
                    1 -> animal.makeChild()
                        //animalsTemp.plusAssign(animal.makeChild())//ошибка, не добавляется в массив
                        //animalsTemp.add(animal.makeChild())//ошибка, не добавляется в массив

                    2 -> animal.move()
                    3 -> animal.sleep()
                    4 -> animal.eat()
                    5 -> animal.makeSound()
                }
            }
        }
        animals=animalsTemp

    }

}