# Lecture 06

## Kotlin 의 For 문

### For 문

> Java 와 동일하게 `for (..) {..}` 로 작성하지만
> `in` 을 조건 스코프에 사용하도록 한다.

```kotlin
val numbers = listOf(1..100)

// 기본적인 For 문
for (number in numbers) println(number)

// 1 씩 커지는 등차수열 For 문
for (number in 1..100) println(number)

// 1 씩 작아지는 등차수열 For 문
for (number in 100 downTo 1) println(number)

// 2 씩 커지는 등차수열 For 문
for (number in 1..100 step 2) println(number)
```

### While / Do ~ While 문

> While / Do ~ While 문 작성도 Java 와 동일하다.

```kotlin
var i = 0

while (i < 10) {
    println(i)
    i++
}

do {
    println(i)
    i++
} while (i < 20)
```