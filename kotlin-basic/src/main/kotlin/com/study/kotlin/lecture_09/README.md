# Lecture 09

## Class

### Constructor

> Kotlin 에서는 Java 와 달리 Property 가 Final 이기 때문에 Default 값을 지정해줘야 한다.
> 때문에 Kotlin 에서는 생성자에 Property 를 정의할 수 있고, 인자로 받아서 Class 내부에 값을 할당해줄 수도 있다.
> Primary Constructor 는 클래스 명 옆에 `constructor()` 라는 키워드를 통해 받을 인자를 작성 할 수 있는데,
> 이 때 `constructor` 키워드는 생략 가능하다.

#### Primary Constructor

```kotlin
// constructor 키워드를 생략한 Primary Constructor
class Animal(
    val name: String,
    var age: Int
)
```

#### Second Constructor

```kotlin
// 생성자에서 인자만 받고 Body 블럭 내부에서 Property 를 정의하고 초기화 할 수 있다.
class Dog(
    name: String,
    age: Int
) {
    val name = name
    var age = age

    // 부생성자는 Primary Constructor 외의 방식으로 
    // 인스턴스를 생성해야 할 때 정의하지만, 부생성자 정의는 지양하며 대신에 Property 의 Default 값을 정해 놓는 것을 권장한다.
    // 부생성자의 경우 최종적으로 Class 의 다른 생성자를 호출하도록 작성해야 한다.
    constructor(animal: Animal) : this(animal.name, animal.age)
}
```

#### init Block

```kotlin
class Person(
    val name: String,
    var age: Int
) {
    init {
        if (this.age < 0) {
            throw IllegalArgumentException("나이는 0세 이상이어야 합니다.")
        }
    }
}
```

### Backing Field

> Kotlin 에서는 기본적으로 Property 를 직접 접근 할 수 있다.
> 다만, private 접근 제어자를 붙이는 경우 별도의 Getter 를 정의해줘야 한다.
> 이러한 Custom Getter / Setter 는 자기 자신을 호출하는데
> 이 때, `field` 라는 예약어를 사용하지 않고 자신 Property 명을 호출한다면 무한 루프에 빠지게 된다.
> 여기서 `field` 가 Backing Field 를 의미한다.
> 또한, Custom Getter / Setter 는 메모리에 존재하는 것과 별개로 생성 가능하다.

```kotlin
class Product(
    name: String,
    var price: Int,
    var quantity: Int
) {
    var name = name
        // Backing Field 를 이용해 Custom Getter 정의
        get() = field.uppercase()
        // Backing Field 를 이용해 Custom Setter 정의
        set(value) {
            field = value.lowercase()
        }
}

fun main() {
    val product = Product("", 0, 0)
    product.name
}
```