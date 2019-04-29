import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TestMoney {
    /*
    아래 개념이 모두 동작하게 코드를 작성해주세요.
    5dallar = 5000krw
    5dallar + 5 dallar = 10dallar
    5000krw + 5000krw = 10000krw
    5000krw + 5dallar = 10dallar
    10dallar = 10000krw
    평소에 tdd를 하셧으면 tdd로 짜셔도 되고,
    unit test를 짜면서 만드셨으면 unit test 가 있어도 되고,
    test가 없어도 좋습니다
*/
/*
    아래 인터페이스는 완전한 인터페이스가 아닙니다.
    상황에 따라 interface가 바뀔 수 있어요.(어쩌면 interface가 필요하지 않을지도)
*/
    @Test
    fun `5dallar = 5000krw`() {
        assertTrue(Dallor(5f).equals(Krw(5000f)))
    }

    @Test
    fun `5dallar + 5 dallar = 10dallar`() {
        assertEquals(Dallor(5f) + Dallor(5f), Dallor(10f))
    }

    @Test
    fun `5000krw + 5000krw = 10000krw`() {
        assertEquals(Krw(5000f) + Krw(5000f), Krw(10000f))
    }

    @Test
    fun `5000krw + 5dallar = 10dallar`() {
        assertTrue((Krw(5000f).plus(Dallor(5f))).equals(Dallor(10f)))
    }

    @Test
    fun `10dallar = 10000krw`() {
        assertTrue(Dallor(10f).equals(Krw(10000f)))
    }
}