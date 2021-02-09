package com.aspechenin.loops_recursion_nullabletypes

fun main() {

    //вводим размер массива
    var dimMassive:Int=0
    while(dimMassive<=0) {
        print("введите размер массива: ")
        readLine()?.toIntOrNull()
            ?.let{
                dimMassive=it
            }

        if (dimMassive<=0) println("неверное значение")
    }

    //создаем список
    val myArray= mutableListOf<Int>()

    //var myCount:Int=0

    //вводим вместо индекса числа
    while (myArray.lastIndex<dimMassive-1) {
        println("Введите ${myArray.lastIndex+2}-е число")
        readLine()?.toIntOrNull()
            ?.let {
                myArray.add(it)
             //   myCount++
            }
            ?:continue
    }

    //считаем и выводим количество положительных и сумму элементов
    //var summa=0

    var positiveCount:Int=0
    myArray.forEach {
        //summa+=it
        if (it>0)positiveCount++
    }

    println("Кол-во положительных = $positiveCount")
    println("Сумма всех чисел = ${myArray.sum()}")

    //вычисление НОД

    //    findNOD(18,24, 1,1)

    println("введите число для вычисления НОД с суммой чисел в массиве")

    val numberNOD:Int= readLine()!!.toInt()

//    findNOD(summa,numberNOD, 1,1)

    println("наибольший общий делитель = ${findNOD(myArray.sum(),numberNOD, 1,1)}")


}
/*
fun findNOD(a:Int,b:Int,n:Int,NOD:Int){
    //функция вычисления НОД

    //а,b - рассматриваемые числа, n - текущее подбираемое число, NOD-текущее произведение найденных общих делителей

    if(n>=a || n>=b) println("наибольший общий делитель = $NOD")
    else if(a%n==0 && b%n==0 ) findNOD(a/n,b/n,n+1,NOD*n)
    else findNOD(a,b,n+1,NOD)

}
*/

tailrec fun findNOD(a:Int,b:Int,n:Int,NOD:Int):Int {
    //функция вычисления НОД
    //а,b - рассматриваемые числа, n - текущее подбираемое число, NOD-текущее произведение найденных общих делителей

    if (n <= a || n <= b){
        if (a % n == 0 && b % n == 0) return findNOD(a / n, b / n, n + 1, NOD * n)
        else return findNOD(a, b, n + 1, NOD)}
    else return NOD
}
