abstract class Money: Calc {
    abstract val value: Float
    abstract val rate: Float
    val exchange: Float
        get() = value * rate
    override fun equals(other: Money): Boolean{
        return exchange == other.exchange
    }
}

interface Calc {
    operator fun plus(other: Money): Money
    fun equals(other: Money): Boolean
}

data class Krw(override val value: Float) : Money() {
    override val rate = 1f
    override fun plus(other: Money): Money {
        return Krw((exchange + other.exchange) / rate)
    }
}

data class Dallor(override val value: Float) : Money() {
    override val rate = 1000f
    override fun plus(other: Money): Money {
        return Dallor((exchange + other.exchange) / rate)
    }
}