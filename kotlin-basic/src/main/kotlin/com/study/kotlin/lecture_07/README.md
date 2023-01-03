# Lecture 07

## Kotlin 의 try catch

### try catch

> Java 와 동일하게 try catch 구문을 작성하면 된다.
> 하지만 Kotlin 에서는 try catch 구문도 하나의 Expression 으로 보기 때문에
> 해당 구문 내에서 Return 을 수행하는 경우 If 문과 동일하게 try catch 구문 자체를 Return 할 수 있다.

```kotlin
fun parseIntOrNull(str: Strin): Int? {
    return try {
        str.toInt()
    } catch (e: NumberFormatException) {
        null
    }
}
```

### try catch resources

> Kotlin 에서는 Java 의 try catch resources 구문 대신
> Inline 함수인 `use` 를 사용한다. 해당 내용에 대해서는 추후 자세히 기술하고,
> 사용법에 대해서만 간단히 익혀보자.

```kotlin

import java.io.BufferedReader
import java.io.FileReader

fun readFile(path: String) {
    BufferedReader(FileReader(path)).use { reader ->
        println(reader.readLine())
    }
}
```