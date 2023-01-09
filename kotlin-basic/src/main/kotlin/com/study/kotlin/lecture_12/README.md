# Lecture 12

## `object` Keyword

### Companion Object

> Java 에서는 `static` 키워드를 통해 정적 변수를 정의 했으나, Kotlin 에서는 `static` 키워드가 사라졌다.
> (Java 의 `static` 키워드는 인스턴스 생성 시, 새로운 값이 복제되는 것이 아닌 인스턴스 간 값을 공유한다.)
> 대신 Kotlin 에서는 `companion object` 라는 키워드가 등장 했는데, 해당 키워드는
> Java 의 `static` 과 비슷하게 동작하는데, 이는 클래스와 동행하는 유일한 오브젝트라는 의미이다.

```kotlin
class Person private constructor(
    var name: String,
    var age: Int
) {
    companion object {
        private const val MIN_AGE = 1
        fun newBaby(name: String) = Person(name, MIN_AGE)
    }
}
```

> 또한 `companion object` 는 하나의 객체이기 때문에
> 별도의 이름을 지정해줄 수 있다.
> Java 에서도 사용하는 방법을 알아보자.

```kotlin
class Car private constructor(
    var name: String,
    val isFourWheels: Boolean
) {
    companion object Factory {
        private const val DEFAULT_NAME = "Sonata"
        private const val DEFAULT_IS_FOUR_WHEELS = false

        fun newCar() = Car(DEFAULT_NAME, DEFAULT_IS_FOUR_WHEELS)
    }
}
```

```java
import com.study.kotlin.lecture_12.Person;

public class Application {
    public static void main(String[] args) {
        // companion object 의 이름이 정의되어 있지 않은 경우
        // Person.Companion.newBaby("심똑오망");

        // companion object 의 이름이 정의되어 있는 경우
        // Person.Factory.newBaby("심똑오망");

        // Java 의 static field 와 같이 사용하려는 경우
        // 해당하는 Kotlin 파일에 속한 함수에 @JvmStatic 애노테이션을 붙인다.
        Person.newBaby("심똑오망");
    }
}
```

### `const`

> 변수를 선언할 때 `val` 혹은 `var` 키워드만 붙이면 런타임 시 메모리에 할당 되지만,
> `const` 키워드와 함께 사용하면 컴파일 시 메모리에 할당된다.
> 때문에 상수를 정의하기 위해서 사용된다.

## `object`

> Java 에서 Singleton 객체를 만들기 위해서는 private 한 인스턴스를 필드로 정의하고,
> Factory Method 를 통해 인스턴스를 리턴하는 형식으로 구현 할 수 있었지만,
> Kotlin 에서는 `object` 키워드만 붙여주면 된다.
> 또한, 해당 키워드는 익명 클래스를 구현 할 때도 사용 할 수 있다.

### Singleton

```kotlin
object ProductService(
    private val repository: ProductRepository
) {
    fun addProduct(product: Product) {
        repository.save(product)
    }
}
```

### 익명 클래스

```kotlin
fun main() {
    actionMovable(object : Movable {
        override fun move() {
            println("움직이다.")
        }
    })
}

fun actionMovable(movable: Movable) {
    movable.move()
}
```