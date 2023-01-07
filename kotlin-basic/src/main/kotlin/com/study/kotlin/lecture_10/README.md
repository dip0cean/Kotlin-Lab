# Lecture 10

## Inheritance

> Kotlin 에서도 Java 와 동일하게 Interface 혹은 Abstract Class 를 상속 받아 하위 클래스로 구현 할 수 있다.
> 다만 그 표현 방식이 상이한데 해당 부분에 대해 살펴보자.

```kotlin
abstract class Animal(
    protected val name: String,
    protected var legs: Int
) {
    abstract fun move()
}

interface Flyable {
    fun flying()
}

class Penguin(
    name: String
) : Flyable,
    // 추상 클래스를 상속 받을 때 생성자의 인자가 필요하다면 상속 받는 곳에서 주입해줘야 한다.
    Animal(name, 2) {

    override fun move() {
        println("펭귄은 ${super.legs} 개의 다리로 걷는다.")
    }

    override fun flying() {
        throw IllegalStateException("펭귄은 날 수 없다.")
    }
}
```