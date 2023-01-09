# Lecture 11

## 접근 제어자

| Keyword     | Explain                                                                  |
|-------------|--------------------------------------------------------------------------|
| `public`    | 모든 곳에서 접근 가능하며 기본적으로 생략되어 있다.                                            |
| `protected` | 선언된 클래스 또는 하위 클래스에서만 접근 가능하며, Class 에만 사용한 접근 제어자이기 때문에 파일에서는 사용 할 수 없다. |
| `internal`  | 같은 모듈에서만 접근 가능하며, 바이트 코드로 컴파일하면 `public` 으로 설정된다.                        |
| `private`   | 선언된 클래스 내에서만 접근 가능하다.                                                    |

### 피일의 접근 제어

> Kotlin 은 `.kt` 파일에 변수, 함수, 클래스 여러 개를 바로 만들 수 있다.

```kotlin
// 한 파일 내에 정의된 클래스
open class Product(
    protected val name: String,
    protected val price: String,
    protected val quantity: Int
)

// 한 파일 내에 정의된 함수
fun sum(a: Int, b: Int) = a + b

// 한 파일 내에 정의된 변수
val product = Product("MackBook Pro", 1_000_000, 1)
```

### 유틸성 Kotlin 파일

> 유틸성 파일을 Decompile 해보면 `파일명Kt` 라는 클래스가 생성되고 정의한 함수가 클래스 내부에 추가된다.

### Property 접근 제어

> Property 도 다른 영역과 동일하게 접근 제어자를 사용 할 수 있지만,
> 사용자가 원하는 방식으로 Getter 와 Setter 의 가시성을 설정 할 수 있다.

```kotlin
class Car(
    internal val name: String,
    var owner: String,
    _price: Int
) {
    val price = _price
        private get
}
``` 