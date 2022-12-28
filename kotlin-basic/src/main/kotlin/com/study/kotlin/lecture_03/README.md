# Lecture 03

## Kotlin 의 명시적 Type 변환

### Primitive Type

> Java 에서는 임묵적으토 타입을 자동으로 변환 했지만,
> Kotlin 에서는 필수적으로 타입을 명시 해줘야 한다.
> Primitive Type 의 경우, L(Long) / f(Float) 키워드를 초기화 값 뒤에 붙이면
> Long 혹은 Float 으로 간주하여 해당 타입으로 변수를 초기화한다.

```kotlin
val number1 = 10 // Int
val number2 = 10L // Long
val number3 = 0.0 // Double
val number4 = 0.0f // Float
// Long 타입 변수를 Int 타입 변수로 초기화 하기 위해서는 toType() 함수를 이용하도록 한다.
val number5: Long = number1.toLong()
```

### Reference Type

#### is / !is

> Java 에서는 파라미터의 타입이 상위 클래스인 경우, 특정 클래스가 맞는지 확인하기 위해서
> `instanceof` 라는 키워드를 통해 확인 했으나
> Kotlin 에서는 `is` 혹은 `!is` 키워드를 이용해 Reference Type 을 비교한다.

```kotlin
val person = Person("심성헌")
val dog = Dog("또익")

println("person is Dog ? ${person is Dog}") // true
println("dog is not Person ? ${dog !is Person}") // true
```

#### as / as?

> Java 에서는 `(Object)` 와 같이 초기화 하고자 하는 값 앞에 어떤 클래스로 Casting 할지
> 명시해줘야 했으나 Kotlin 에서는 `as` 혹은 `as?` 키워드를 통해 Reference Type 을 변환 할 수 있다.
> 하지만 타입 변환 전의 코드를 확인해 타입이 적절한 경우 해당 키워드는 생략이 가능하다.

```kotlin
// as
fun printAgeIfPerson(obj: Any) {
    if (obj is Person) {
        val person = obj as Person
        println(person.age)
        // 생략하는 경우
        // println(obj.age) // if 문에서 obj 가 Person 타입인 것을 암묵적으로 확인
    }
}

// as?
fun printAgeIfPersonOrNull(obj: Any?) {
    val person: Person = obj as? Person
    println(person.age) // obj 가 null 인 경우 age 호출 시 null 이 반환된다.
}
```

#### Any

> Java 의 Object 와 동일한 역할을 가진다.
> Typescript 의 Any 와 비슷한 성질이며, Primitive Type 을 포함한 모든 클래스의 최상위 클래스이다.
> Any 클래스 또한 null 을 표현하기 위해서는 Any? 를 이용하며,
> `equals()`, `toString()`, `hashCode()` 함수가 존재한다.

### Unit

> Java 의 Void 클래스와 동일한 역할을 한다.
> 하지만 Kotlin 에서는 함수형 프로그래밍에 의해 단하나의 인스턴스를 가진다.

```kotlin
fun getUnit(): Unit {} // return 타입은 생략 가능
// Unit 도 다른 클래스와 마찬가지로 하나의 인스턴스가 된다.
println("is Unit ? ${getUnit() is Unit}") // true
```

### Nothing

> 함수의 끝이 정해지지 않거나 무조건 예외가 발생하는 경우를 표현하기 위한 타입이다.

```kotlin
fun getNothing(): Nothing {
    throw NullPointerException()
}
```