package com.aspechenin.oop.animals

class Bird(name: String) :
    Animal(name,  maxAge=3),Soundable {

    override fun move() {
            super.move()
            println("$name летит")
    }

    //жизненный цикл
    override fun liveCicle() {
        super.liveCicle()
        move()
    }

    override fun makeChild(): Bird {
        return Bird(name)
    }

    override fun makeSound() {
        println("$name - Кря-кря!!!")
    }

}