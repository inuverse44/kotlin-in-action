package colors
import colors.Color.* // 明示的に色の名前をimportする

fun getMnemonic(color: Color) = // when expressionを直接返す
    when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }

fun measureColor() = Color.ORANGE
// as a stand-in for more complex measurement logic
// より複雑な測定ロジックの代替として

fun getWarmthFromSensor(): String {
    return when(val color = measureColor()) { // color変数のスコープはwhenの中だけになる。周りにコードの変数と競合しないようにスコープは小さくとる。
        RED, ORANGE, YELLOW -> "warm (red = ${color.r})" // whenにcaptureされたcolorが使える
        GREEN -> "neutral (green = ${color.g})"
        BLUE, INDIGO, VIOLET -> "cold (blue = ${color.b})"
    }
}

// listing 2.15 いくらか非効率的
// これはsetインスタンスを何回も作成する。大量に呼ぶのであれば、
// 短命オブジェクトをたくさん生成するのは避けるべきである。
// この短命オブジェクトはGCによってクリーンアップされる必要のあるものである。
fun mix(c1: Color, c2: Color) =
    when(setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("Dirty color")
    }

// 可読性は落ちるものの、mix()よりも性能は向上している
fun mixOptimized(c1: Color, c2: Color) =
    when {
        (c1 == RED && c2 == YELLOW) ||
        (c1 == YELLOW && c2 == RED) ->
            ORANGE

        (c1 == YELLOW && c2 == BLUE) ||
        (c1 == BLUE && c2 == YELLOW) ->
            GREEN

        (c1 == BLUE && c2 == VIOLET) ||
        (c1 == VIOLET && c2 == BLUE) ->
            INDIGO

        else -> throw Exception("Dirty color")
    }

fun main() {
    println(getMnemonic(Color.BLUE))
    // Battle

    println(getWarmthFromSensor())
    //　warm (red = 255)

    println(mix(BLUE, YELLOW))
    // GLEEN

    println(mixOptimized(BLUE, YELLOW))
    // GLEEN
}