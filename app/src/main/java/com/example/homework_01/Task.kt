package com.example.homework_01

/*Task 1*/

fun main() {
    val numbers = (0..99).toList()
    val sum = numbers.filter { it % 2 == 0 }
        .slice(10..20)
        .map { it +1 }
        .sum()
    println(sum)
    println(foo())
    println(time())
}

/*Task 2*/

data class Person (val name: String, val surname: String, val age: Int)

fun List<Person>.sortByDescending(): List<Person> = this.sortedByDescending { it.age }
fun List<Person>.sortByName(): List<Person> = this.sortedWith(compareBy({it.name},{it.surname}))

fun foo(){
    val people = listOf(
        Person("Alice", "Smith", 25),
        Person("Bob", "Johnson", 30),
        Person("Charlie", "Williams", 20),
        Person("Jonny", "Walker", 41),
        Person("Alice", "Jones", 35),
        Person("Bob", "Smith", 40)
    )
    val peopleSortedByDescending = people.sortByDescending()

    val peopleSortedByName = people.sortByName()
    println(peopleSortedByDescending)
    println(peopleSortedByName)
}

/*Task 3*/

fun <T> timeMillis(calculate: () -> T):Long{
    val startTime = System.currentTimeMillis()
    calculate()
    val endTime = System.currentTimeMillis()
    return endTime - startTime
}

fun time() {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25)
    val duration = timeMillis {
        list.filter { it % 2 == 0 }
            .map { it * it * it * it * it}
            .forEach { println(it) }

    }
    println("Execution time: ${duration}ms")
}