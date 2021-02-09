package com.aspechenin.oop.animals

class Fish(name: String) :
    Animal(name,  maxAge=2),Soundable {

    override fun move() {
        super.move()
        println("$name плывет")
    }


    override fun makeChild(): Fish {
        return Fish(name)
    }

    override fun makeSound() {
        println("$name - молчит")
    }


}