package com.example.tdd_lotto

import kotlin.random.Random

class Lotto {

    companion object {
        val minNum = 1
        val maxNum = 45
        val numCnt = 6
    }

    fun getNumber(): Int = Random.nextInt(minNum, maxNum + 1)

    fun getAllNumber(): MutableList<Int> {
        var numbers = mutableListOf<Int>()
        while(numbers.size < numCnt) {
            numbers.add(getNumber())
        }
        return numbers
    }

    fun getUniqueAllNumber(): MutableList<Int> {
        var numbers = mutableListOf<Int>()
        while(numbers.size < numCnt) {
            val number = getNumber()
            if(!numbers.contains(number)) {
                numbers.add(number)
            }
        }
        return numbers
    }

    fun isRange(number: Int): Boolean {
        if(number in minNum..maxNum) {
            return true
        }
        return false
    }

    fun isUnique(numbers: MutableList<Int>): Boolean {
        for (i in numbers) {
            if(numbers.count { it == i } != 1) {
                return false
            }
        }
        return true
    }

}
