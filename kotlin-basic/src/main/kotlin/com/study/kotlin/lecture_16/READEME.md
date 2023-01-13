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

## infix 함수

## inline 함수