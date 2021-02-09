package com.aspechenin.oop.animals

class Dog(name: String) :
    Animal(name,  maxAge=5),Soundable {

    override fun move() {
        super.move()
        println("$name бежит")
    }


    override fun makeChild(): Dog {
        return Dog(name)
    }

    override fun makeSound() {
        println("$name - Гав-гав!!!")
    }


}