package com.aspechenin.collections
fun main() {

    //вводим количество номеров
    var phoneBookSize:Int=0
    while (phoneBookSize<=0) {
        print("введите количество номеров: ")
        readLine()?.toIntOrNull()
            ?.let {
                phoneBookSize= it
            }
            ?:continue
    }

    println("количество номеров - $phoneBookSize")
    //счетчик цикла
    var count=0

    //enterPhoneNumber(phoneBookSize!!.toInt()).forEach { println(it) }

/*
    //создаем пустой массив номеров
    var myPhoneNumbers= Array<String?>(phoneBookSize!!.toInt()){index->null}
    //заполняем массив телефонных номеров
    while(count<phoneBookSize!!.toInt()){
        println("введите ${count+1}-й номер телефона")
        myPhoneNumbers[count]= readLine()
        count++
    }
    myPhoneNumbers.forEach { println(it)}
 */
    //заполняем массив номеров
    var phoneBookNumbers=enterPhoneNumber(phoneBookSize)

    //номера, начинающиеся с +7
    printIdentityNumbers(phoneBookNumbers,"+7")

    //только неповторяющиеся номера, печать множества
    println("только неповторяющиеся номера:")
    phoneBookNumbers.toSet().forEach {println(it)}
    print("количество неповторяющихся номеров:")
    println(phoneBookNumbers.toSet().size)

    //суммируем длину всех номеров без sumBy, т.к. синтаксис непонятен

    var sumNumbers=0
    phoneBookNumbers.forEach {sumNumbers+=it!!.toString().length }
    println("общая длина = ${sumNumbers}")

    //заполняем массив контактов
    var phoneBookContacts= enterPhoneContakt(phoneBookNumbers)

    //формируем телефонную книгу в виде отображения
    var phoneBook= formingPhoneBook(phoneBookNumbers,phoneBookContacts)

    //печатаем телефонную книгу
    for(man in phoneBook){
        println("Человек: ${man.value}. Номер телефона: ${man.key} ")
    }



}


//функция заполнения массива номеров
fun enterPhoneNumber(Size:Int):List<String?>{
    //создаем пустой массив номеров
    var myPhoneNumbers= mutableListOf<String?>()
    while (myPhoneNumbers.lastIndex<Size-1) {
        println("Введите ${myPhoneNumbers.lastIndex+2}-й номер телефона")
                myPhoneNumbers.add(readLine())
    }
    return myPhoneNumbers
}

//функция заполнения массива имен контактов
fun enterPhoneContakt(Numbers:List<String?>):List<String?>{
    //создаем пустой массив имен
    var myPhoneContacts= mutableListOf<String?>()
    //заполняем массив имен контактов
    Numbers.forEach{
        print("введите имя человека с номером телефона: $it - ")
        myPhoneContacts.add(readLine())
    }
    return myPhoneContacts
}

//формирование телефонной книги в виде отображения
//на входе массивы номеров и имен
fun formingPhoneBook(phoneNumbers:List<String?>,phoneContacts:List<String?>):Map<String?,String?>{
    var phoneBook= mutableMapOf<String?,String?>()
    var count=0
    phoneNumbers.forEach {
        phoneBook.put(it,phoneContacts[phoneNumbers.indexOf(it)])
    }
    return phoneBook

}

//функция отфильтровывания номеров, начинающихся одинаково
fun printIdentityNumbers(Numbers: List<String?>,begin:String){
        println("номера, начинающиеся с $begin :")
    Numbers.forEach {
        var count = 0
        var str=it!!.toString()
        //сначала предполагаем, что начало совпадает
        var isContain=true
        //номер короче критерия
        if (str.length>=begin.length) {
            //посимвольное сравнение от начала слова
            begin.forEach {
                if (str[count] != it) isContain = false
                count++
            }
            //если начало совпадает то печать
            if (isContain == true) println(it)
        }
    }
}
