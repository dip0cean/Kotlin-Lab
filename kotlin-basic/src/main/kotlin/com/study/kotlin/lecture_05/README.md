# Lecture 05

## Kotlin 의 If 문

### If 문

> Java 와 동일하게 `if (..) {..}` 로 작성한다.
> 추가적으로 Kotlin 에서는 Java 와 달리 If 문은 `Expression` 이기 때문에 If 문 자체를 Return 할 수 있다.
> 이러한 이유로 Java 에서 존재하는 삼항 연산자는 Kotlin 에서 존재하지 않는다.

```kotlin
// 기본적인 If 문
fun validScoreIsNotNegative(score: Int) {
    if (score < 0) {
        throw IllegalArgumentException("score 는 0 보다 작을 수 없습니다.")
    }
}

// If 문을 그대로 Return
fun passOrFail(score: Int): String {
    return if (score >= 50) "p" else "f"
}

// If ~ Else If 문도 동일하게 Return 가능하다.
fun getGrade(score: Int): String {
    return if (score >= 90) "A" else if (score >= 80) "B" else if (score >= 70) "C" else "D"
}
```

### 비교 연산을 통한 If 문

> Java 에서는 특정 값이 범위 내에 속하는 코드를 다음과 같이 작성했다.
> `if (0 >= score && score <= 100)`
> 하지만 Kotlin 에서는 in 과 .. 연산자를 사용해 더욱 더 간결하게 작성 할 수 있다.

```kotlin
fun validateScore(score: Int) {
    if (score !in 0..100) throw IllegalArgumentException("유효하지 않은 점수 입니다.")
}
```

### When 문

> Java 의 Switch 문이 Kotlin 에서는 When 문으로 대체 되었다.
> 기준 인자에 대한 여러 케이스를 작성하거나 연산문을 케이스에 작성할 수 있는 등
> 다양한 방법으로 사용 가능하며, 이를 통해 비약적으로 코드의 양을 줄일 수 있다.
> 또한, When 문도 Expression 이기 때문에 그대로 Return 가능하다.

```kotlin
// 기본적인 When 문
val score = 95
val grade = when (score) {
    in 90..100 -> "A"
    in 80..89 -> "B"
    in 70..79 -> "C"
    else -> "D"
}

// is 문을 이용해 클래스를 확인
fun startsWithA(message: Any): Boolean {
    return when (message) {
        is String -> message.startsWith("A")
        else -> false
    }
}

// 여러 조건이 동일한 값을 반환해야 하는 경우
fun judgeNumber(number: Int) {
    when (number) {
        1, 0, -1 -> println("Comparable 가능한 숫자입니다.")
        else -> println("정렬이 불가능 합니다.")
    }
}

fun judgeNumber2(number: Int) {
    when {
        number == 0 -> println("값이 0 입니다.")
        number % 2 == 0 -> println("짝수 입니다.")
        else -> println("홀수 입니다.")
    }
}
```