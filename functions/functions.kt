package com.aspechenin.functions
import kotlin.math.sqrt
fun main(){
    //уравнение a*x^2+b*x+c=0
    val a=1
    val b=6
    val c=3
    //println("корни уравнения ${if((a!=1)&&(a!=-1))a.toString()+"*x^2" else if(a==-1) "-x^2" else "x^2"}+$b*x+$c=0")
    println("корни уравнения $a*x^2+$b*x+$c=0")
    println("и их сумма: ${solveEquation(a,b,c)}")

}

fun solveEquation(a:Int,b:Int,c:Int):Float{
    //расчитываем дискриминант
    val Discriminant = (b*b-4*a*c).toFloat()
    if(Discriminant<0)
        println("нет корней")
    else{
        //вычисляем и выводим корни уравнения
        println("x1 = ${(-b+sqrt(Discriminant))/(2*a)} x2= ${(-b-sqrt(Discriminant))/(2*a)}")
        return -b.toFloat()/(2*a)
    }
    return 0.toFloat()

}