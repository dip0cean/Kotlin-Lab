# Lecture 16

## 확장 함수

> 확장 함수는 말 그대로 기존 클래스를 확장하는 함수로 클래스 외부에서 정의 할 수 있다.

### 확장 함수 정의

- `클래스명.확장함수명()` 으로 네이밍한다.
- `this` 를 통해 클래스 내부의 함수나 프로퍼티에 접근 가능하다.
- 단, `private`, `protected` 로 정의된 함수나 프로퍼티는 접근 할 수 없다.

```kotlin
fun String.lastChar(): Char = this[this.length - 1]
```

### 멤버 함수와 확장 함수의 우선순위

> 멤버 함수와 확장 함수의 시그니처가 동일한 경우 멤버 함수가 호출된다.
> 만약 확장 함수가 먼저 정의되고 그 후에 멤버 함수가 정의되는 경우 에러를 발생한다.

```kotlin
class Person(
    private val name: String,
    val age: Int
) {
    fun isAdult(): Boolean {
        println("멤버 함수 : ${this.name}")
        return this.age > 19
    }
}

fun Person.isAdult(): boolean {
    println("확장 함수")
    return this.age > 20
}

fun main() {
    val person = Person("심성헌", 19)
    person.isAdult() // 멤버 함수 호출
}
```

### 상속 관계에서 동일한 확장 함수의 우선순위

> 부모 클래스와 자식 클래스 간 동일한 시그니처의 확장 함수가 정의된 경우
> 변수의 정적 타입이 무엇인지에 따라 어떤 클래스의 확장 함수가 호출될지 결정된다.

```kotlin
open class Train(
    val price: Int
)

fun Train.isExpensive(): Boolean {
    println("Train Price : ${this.price}")
    return this.price > 20_000
}

class KTX : Train(30_000)

fun KTX.isExpensive(): Boolean {
    println("KTX Price : ${this.price}")
    return this.price > 20_000
}

fun main() {
    val train1 = Train(10_000)
    train1.isExpensive() // Train
    val train2: Train = KTX()
    train2.isExpensive() // Train
    val train3 = KTX()
    train3.isExpensive() // KTX
}
```

### 확장 프로퍼티

> 확장 함수처럼 확장 프로퍼티도 정의 할 수 있다.
> 기존 프로퍼티를 정의하듯 작성하면 된다.

```kotlin
class Dog(
    val name: String
)

val Dog.age: Int
    get() = 10
```

## infix 함수 (중위 함수)

> 함수를 호출하는 새로운 방식으로 6강에서 배운 `downTo`, `step` 이 중위 함수에 속한다.
> 중위 함수란 `변수.함수명(arg)` 와 같은 표현이 아닌 `변수 함수명 arg` 와 같이 사용한다.

```kotlin
infix fun Int.add(other: Int): Int = this + other

fun main() {
    // add
    val result = 3 add 7
    println(result)

    // downTo
    for (i in 10 downTo 1) {
        println("i : $i")
    }

    // step
    for (i in 1..50 step 5) {
        println("i : $i")
    }
}
```

## inline 함수

> 함수가 호출되는 대신 함수를 호출한 지점에 함수 본문을 그대로 복사하는 경우 사용된다.
> 여러 함수를 중첩해서 호출하는 경우 오버헤드가 발생하게 되는데,
> 이 때 inline 함수를 사용하게 되면 함수를 파라미터로 전달하여 오버헤드를 줄일 수 있다.
> (바이트 코드로 컴파일 시 함수를 호출하는 것이 아닌 함수의 로직이 그대로 작성된다.)
> 하지만 inline 함수는 성능 측정과 함께 신중하게 사용되어야 한다.

```kotlin
inline fun Int.add(other: Int): Int = this + other
```
