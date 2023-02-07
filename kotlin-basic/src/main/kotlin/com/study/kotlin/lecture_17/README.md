# Lecture 17

## Functional Programming

> 함수는 Java 에서 2급 시민이지만, Kotlin 에서는 1급 시민이다.
> 때문에 함수 자체를 변수에 넣을 수 있고, 파라미터로 전달 할 수 있다.
> Kotlin 에서는 `Closure` 를 사용하여 `non-final` 변수도 람다에서 사용할 수 있다.

### 변수에 함수 할당

```kotlin
// 변수에 함수를 할당하는 방법
val isApple = fun(fruit: Fruit): Boolean = fruit.name == "사과"
val isBanana = { fruit: Fruit -> fruit.name == "바나나" }
```

### 파라미터에 함수 할당

```kotlin
fun filterFruit(fruits: List<Fruit>, filter: (Fruit) -> Boolean) = fruits.filter(filter)

// 파라미터에 함수를 할당하는 방법 1
filterFruit(listOf(), isApple)
// 파라미터에 함수를 할당하는 방법 2
filterFruit(listOf()) { isBanana(it) }
```
