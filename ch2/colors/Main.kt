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

fun main() {
    println(getMnemonic(Color.BLUE))
    // Battle

    println(getWarmthFromSensor())
    //　warm (red = 255)
}