# Lecture 12

## 중첩 클래스의 종류

### Java 에서는?

- `static` 을 사용하는 중첩 클래스
    - 클래스 외부에서 직접 참조가 불가능하다.
- `static` 을 사용하지 않는 중첩 클래스
    - Inner Class
        - 클래스 외부에서 직접 참조가 가능하다.
    - Local Class
        - 메소드 내부에 정의한 클래스이다.
    - Anonymous Class
        - 일회성으로 사용하는 클래스이다.

> Effective Java - Item 24
> 내부 클래스는 숨겨진 외부 클래스 정보를 가지고 있어, 참조를 해지하지 못하는 경우
> 메모리 누수가 생길 수 있고, 이를 디버깅하기 어렵다.

> Effective Java - Item 86
> 내부 클래스의 직렬화 형태가 명확하게 정의되지 않아 직렬화에 있어 제한이 있다.

#### 위와 같은 이유로 `static` 를 사용하는 것을 권장한다.

## 코틀린의 중첩 클래스와 내부 클래스

### 중첩 클래스

> 클래스 내부에 클래스를 정의를 하면 된다.
> 기본적으로 Kotlin 에서는 외부 클래스에 대한 연결이 필요 없는 중첩 클래스가 만들어진다.
> (Java 에서 `static` 을 사용하는 중첩 클래스와 같다.)

```kotlin
class House(
    val address: String,
    val livingRoom: LivingRoom
) {
    // Java 에서의 static 중첩 클래스
    class LivingRoom(
        private val area: Double
    )
}
```

### 내부 클래스

> 내부 클래스는 권장하지 않지만, `inner` 키워드를 사용하면 Java 의 내부 클래스와 같이
> 외부에서 직접 참조가 가능한 형태로 클래스를 정의 할 수 있다.
> 그리고 내부 클래스의 경우 바깥 클래스를 참조하기 위해서는 `this.@{바깥 클래스명}` 을 사용해야 한다.

```kotlin
class House(
    val address: String,
    val bathRoom: BathRoom
) {
    inner class BathRoom(
        private val area: Double
    ) {
        val address: String
            get() = this@House.address
    }
}
```