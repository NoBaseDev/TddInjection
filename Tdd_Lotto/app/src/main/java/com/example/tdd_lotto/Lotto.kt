package com.example.tdd_lotto

import kotlin.random.Random

class Lotto {

    fun getNumber(): Int = Random.nextInt(1, 46)

    fun getAllNumber(): MutableList<Int> {
        var numbers = mutableListOf<Int>()
        while(numbers.size < 6) {
            numbers.add(getNumber())
        }
        return numbers
    }

    fun getUniqueAllNumber(): MutableList<Int> {
        var numbers = mutableListOf<Int>()
        while(numbers.size < 6) {
            val number = getNumber()
            if(!numbers.contains(number)) {
                numbers.add(number)
            }
        }
        return numbers

    }

}
