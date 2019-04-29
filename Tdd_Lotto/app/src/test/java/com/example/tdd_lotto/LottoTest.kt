package com.example.tdd_lotto

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * 로또 번호 만들기
 * 1~45 번호 중에서 랜덤하게 6개 중복없이 출력
 * - 1~45 번호 랜덤하게 생성하기
 * - 1~45 번호 랜덤하게 6개 생성하기
 * - 1~45 번호 랜덤하게 6개 생성한 것에 중복 결과가 없어야 함.
 *
 *
 */
class LottoTest {
    @Test
    fun `1~45 번호 랜덤하게 생성하기`() {
        val lotto = Lotto()
        testRepeat(100) {
            val number = lotto.getNumber()
            println(number)
            assertTrue(number > 0)
            assertTrue(number < 46)
        }
    }

    @Test
    fun `1~45 번호 랜덤하게 6개 생성하기`() {
        val lotto = Lotto()
        testRepeat(100) {
            val numbers = lotto.getAllNumber()
            println("numbers : $numbers, count : ${numbers.size}")
            assertEquals(6, numbers.size)
        }
    }

    @Test
    fun `1~45 번호 랜덤하게 6개 생성한 것에 중복 결과가 없어야 함`() {
        val lotto = Lotto()
        testRepeat(100) {
            val numbers = lotto.getUniqueAllNumber()
            println("numbers : $numbers, count : ${numbers.size}")
            for (i in numbers) {
                assertEquals(1, numbers.count { it == i })
            }
        }
    }

    fun testRepeat(count: Int, check: ()->Unit) {
        println("\n===================  " + Thread.currentThread().stackTrace[2].methodName + "  ==")
        var i = 0
        while(i < count) {
            check()
            i++
        }
        println("==  " + Thread.currentThread().stackTrace[2].methodName + "  ===================")
    }
}
