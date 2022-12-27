# Lecture 01

## Kotlin 에서 Null 다루는 방법

### Java Null 예외 처리

> Java 에서는 파라미터 인자에 대해 Null 체크를 수행하지 않기 때문에
> 별도의 if 문을 통해 Null 체크를 해줘야 한다. 그렇지 않다면 NPE 발생률이 높아진다.

### Kotlin Null Check

```kotlin
fun startsWithA1(str: String?): Boolean = str?.startsWith("A") ?: throw IllegalArgumentException("null 은 허용하지 않습니다.")

fun startsWithA2(str: String?): Boolean = str?.startsWith("A") ?: false

fun startsWithA3(str: String?): Boolean? = str?.startsWith("A")

fun startsWithA4(str: String?): Boolean = str!!.startsWith("A")
```

### Safe Call

> Kotlin 은 언어 자체적으로 Null 을 허용하지 않는다.
> 하지만 Safe Call(?.) 를 사용한다면 Null 인 경우 컴파일 에러를 발생하지 않고 Null 을 리턴한다.

```kotlin
val message: String? = null
println("message.length() is ${message?.length}") // null 반환
```

### Elvis Operator

> ?: 연산자를 사용하면 연산값이 Null 인 경우 지정한 대체값으로 리턴하도록 한다.

```kotlin
val message: String? = null
val isNotBlank: Boolean = (message?.length > 0) ?: false
```

### Null 이 들어올 수 없는 경우

> !! 연산자를 사용할 경우 인자가 Null 이 아닌 경우라는 의미를 가지지만
> 만에 하나 Null 이라면 NPE 를 발생한다.

```kotlin
fun isNotBlank(str: String?): Boolean = str!!.length()
```