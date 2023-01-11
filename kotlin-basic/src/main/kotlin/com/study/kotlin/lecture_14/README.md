# Lecture 14

## Data Class

> `data` 키워드를 붙이면 `equals()`, `toString()`, `hashCode()` 함수를 자동으로 만들어준다.
> 또한, named argument 를 활용하면 Builder Pattern 으로도 사용 가능해 유연하게 개발 할 수 있다.
> JDK 16 부터 등장한 Java 의 Record 클래스와 Kotlin 의 data class 가 유사하다.

```kotlin
data class Dog(
    val name: String,
    val age: Int
)

fun main() {
    // named argument 활용한 Builder
    val dog1 = Dog(name = "심또익", age = 9)
    val dog2 = Dog("심또익", 9)

    println("dog 1 과 2 는 같은 객체인가? ${dog1 == dog2}")
    println(dog1)
}
```

## Enum Class

> Enum Class 는 인터페이스만 구현 할 수 있으며, 클래스는 상속 받을 수 없다.
> 또한, 각 코드는 Singleton 으로 메모리 상에 하나만 존재한다.
> (Effective Java - EnumSet / EnumMap 을 사용해야 하는 이유)

```kotlin
enum class Country(
    private val code: String
) {
    KOREA("ko"),
    US("us"),
    JAPAN("jp");

    companion object {
        fun handleCountry(country: Country): String = when (country) {
            KOREA -> "대한민국입니다."
            US -> "미국입니다."
            JAPAN -> "일본입니다."
        }
    }
}
```

## Sealed Class

> Sealed Class 는 컴파일 타임 때 하위 클래스의 타입을 모두 기억한다.
> 즉, 런타임 때 클래스 타입이 추가 될 수 없다.
> 때문에 Sealed Class 는 추상화가 필요한 Entity 혹은 DTO 에서 활용 할 수 있다.