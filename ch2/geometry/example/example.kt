package geometry.example

import geometry.shapes.Rectangle // Rectangleクラスをimportしている
import geometry.shapes.createUnitSquare // メソッド名でimportしている

fun main() {
    println(Rectangle(3, 4).isSquare)
    // false
    println(createUnitSquare().isSquare)
    // true
}