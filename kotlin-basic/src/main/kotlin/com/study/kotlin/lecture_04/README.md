# Lecture 04

## Kotlin 의 연산자

### 비교 연산자

> Kotlin 에서는 `<`, `>`, `>=`, `<=` 와 같은 비교 연산자 호출 시
> 자동으로 `compareTo()` 메소드를 호출한다.
> 때문에 Comparable 인터페이스를 구현한다면 더 유연하고 가독성 높은 코드를 작성 할 수 있다.

```kotlin
val money1 = Money(1_000)
val money2 = Money(2_000)
println(money1 < money2)

class Money : Comparable<Money> {
    override fun compareTo(other: Money): Int = amount.compareTo(other.amount)
}
```

### 동등 비교 연산자

- 동등성?
    - 두 객체의 값이 같은가?
    - `===`, `!==`
- 동일성?
    - 두 객체가 동일한가? (참조하는 주소가 같은가?)
    - `==`, `!=`

```kotlin
// 동등성 > 두 객체의 값이 같은가?
if (money1 !== money2) println("money1 과 money2 는 서로 다른 값이다.")
if (money2 === money3) println("money2 와 money3 는 동일한 값이다.")
// 동일성 > 완전히 동일한 객체인가? 주소가 같은가?
if (money1 != money2) println("money1 과 money2 는 서로 다른 객체이다.") // equals()
if (money2 == money2) println("money2 와 money3 는 동일한 객체이다.") // equals()
```

### in / !in

> Collection 의 범위 내 포함 여부를 체크한다.

```kotlin
val list: List<Int> = listOf(1, 2, 3, 4, 5)
if (1 in list) println("list 에는 1 이 포함되어 있다.")
if (1_000 !in list) println("list 에는 1,000 이 포함되어 있지 않다.")
```

### a..b

> a 부터 b 까지의 범위 객체를 생성한다.

```kotlin
val intRange: IntRange = 1..10
val longRange: LongRange = 1_000_000_000L..9_999_999_999L
```

### Operator Override

> Kotlin 에서는 `operator` 라는 키워드를 함수 앞에 붙이고 연산 함수를 구현하면
> `+`, `-`, `*`, `/`, `%` 등과 같은 키워드 사용 시 자동으로 구현된 함수를 호출한다.

```kotlin
class Money(private val amount: Int) {
    operator fun plus(other: Money): Money = Money(this.amount + other.amount)
}

val money1 = Money(1_000)
val money2 = Money(2_000)
println(money1 + money2)
```