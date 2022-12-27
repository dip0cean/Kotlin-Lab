# Lecture 01
## Kotlin 에서 변수를 다루는 방법
### Java 의 변수 선언

``` java
long number1 = 10L;
final long number2 = 10L;
Long number3 = 1_000L;
Person person = new Person("심성헌");
```

### Kotlin 의 변수 선언
```kotlin
var number1 = 10L // long number1 = 10L;
val number2 = 10L // final long number2 = 10L
```

### 타입 추론 / Boxing / UnBoxing
> Effective Java 에서는 Primitive Type 의 Wrapper Class 를 사용할 경우 불필요한 자원을 사용하기 때문에 이를 지양하라고 말한다. 
> 반면 Kotlin 에서는 개발자가 Boxing / UnBoxing 에 대해 고민하지 않아도 되게끔 알아서 타입을 추론하고 변형한다. 
```kotlin
var number1 = 10L // long number1 = 10L;
val number3 = 10L // Long number3 = 10L
```

### 객체의 인스턴스화
> Kotlin 에서는 Java 와 달리 new 생성자 키워드를 사용하지 않는다.
```kotlin
val user = User("id", "password")
```