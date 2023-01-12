# Lecture 15

## Collection

> Kotlin 에서는 Collection 이 불변인지 가변인지 설정해야 하는데,
> 이 때 MutableCollection 을 이용하면 가변 Collection 이다.
> 가변 Collection 은 Element 를 추가하거나 삭제하는 등 조작이 가능하지만
> 불변 Collection 은 불가능하다. 하지만 Element 의 Reference Type 의 Property 에 접근하면 값을 변경 할 수 있다.

```kotlin
// 가변 Collection
val mutableList = mutableListOf(1, 2, 3)
val mutableSet = mutableSetOf("고양이", "개")
// 중위 호출 > Pair 클래스를 만들어서 Map 객체를 초기화 할 수 있다.
val mutableMap = mutableMapOf("name" to "심성헌", "age" to "25")
// map.put()
mutableMap["address", "서울시"]
mutableMap["blog"] = "https://dev.osean.me"

// 빈 Collection
val emptyList: List<Int> = emptyList()
val emptySet: Set<String> = emptySet()
val emptyMap: Map<String, Int> = emptyMap()

// 값 가져오기
println(mutableList[0])

// 반복문
for (i in mutableList) {
    println(mutableList[i])
}

for ((idx, value) in mutableList.withIndex()) {
    println("$idx $value")
}
```

### Array

```kotlin
val array = arrayOf(100, 200)

for (i in array.indices) {
    println(array[i])
}

for ((idx, value) in array.withIndex()) {
    println("$idx $value")
}
```

### Collection 의 Null 가능성

> `List<Int?>` -> List 는 Null 일 수 없으나 Element 는 Null 일 수 있다.
> `List<Int>?` -> List 는 Null 일 수 있으나 Element 는 Null 일 수 없다.
> `List<Int?>?` -> List, Element 둘 다 Null 일 수 있다.

### Java 와 함께 Collection 사용하는 경우

> Java 는 가변 / 불변 Collection 을 구분하지 않는다.
> Java 는 null / non-null 을 구분하지 않는다.