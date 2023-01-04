# Lecture 08

## Function

### Basic Function

> Java 와 동일하게 여러 접근 제어자를 추가 할 수 있지만
> `public` 접근 제어자는 생략 가능하다.
> 또한 Return 을 해야 하면서 그 코드가 한 문장으로 축약 가능한 경우
> { } 블록을 생략하고 대신 = 를 붙여 사용할 수 있다.
> 그리고 { } 을 사용할 때 Return 이 존재하는 경우 Unit 을 제외한 나머지 타입은 함수에 명시해줘야 한다.

```kotlin
// { } 미사용, = 사용
// Return 결과에 따라 타입 추론이 가능하기 때문에 타입 생략
fun max(a: Int, b: Int) = if (a > b) a else b

// { } 블록을 사용할 때 Return 이 존재한다면 Unit 은 생략 가능하다.
fun sum(a: Int, b: Int) {
    return { a, b -> a + b }
}
```

### Default Argument

> Kotlin 에서는 Java 와 달리 인자의 기본값을 설정 할 수 있다.

```kotlin
// range 와 isNewLine 의 기본값 설정
fun repeat(message: String, range: Int = 10, isNewLine: Boolean = true) {
    for (i in 1..range) if (isNewLine) println(message) else print(message)
}

fun main() {
    repeat("Hello")
    repeat("World", 100)
}
```

### Named Argument

> Kotlin 에서는 함수의 특정 인자에만 값을 할당 할 수 있으며,
> Builder 의 특징을 가지기 때문에 유연하게 코드를 작성 할 수 있다.
> 이 때 주의해야 할 점은 Java 의 메소드를 사용할 때 Named Argument 사용이 불가능하다.

```kotlin
fun repeat(message: String, range: Int = 10, isNewLine: Boolean = true) {
    for (i in 1..range) if (isNewLine) println(message) else print(message)
}

fun main() {
    repeat("Hello", range = 100)
    repeat("World", isNewLine = false)
}
```

### 가변인자

> Java 의 가변인자를 Kotlin 에서도 사용 할 수 있지만 표현 방식이 다르다.
> `vararg` 라는 키워드를 인자 앞에 명시해줘야 하며, 인자로 Array 를 전달할 경우
> `*` 키워드를 붙여줘야 한다.

```kotlin
fun printAll(vararg messages: String) {
    for (message in messages) println(message)
}

fun main() {
    // 쉼표로 구분지어 인자를 전달
    printAll("A", "B", "C")

    // 배열을 인자로 전달
    val arr = arrayOf("A", "B", "C")
    printAll(*arr)
}
```