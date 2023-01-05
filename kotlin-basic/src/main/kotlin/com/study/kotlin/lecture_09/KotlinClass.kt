package com.study.kotlin.lecture_09

// constructor 키워드는 생략이 가능하다.
private class Person(
    // Kotlin 에서는 생성자에 Property 를 정의 할 수 있다.
    name: String,
    region: String,
    var age: Int
) {

    // Custom Getter / Setter
    // 실제 메모리에 존재하는 것과 무관하게 Custom Getter / Setter 를 생성 할 수 있다.
    // Getter / Setter 를 Property 로 정의 할 수 있다.
    val name: String = name
        get() = field.uppercase()

    // Kotlin 에서는 Setter 를 지양하기 때문에 Backing Field 를 사용할 일이 자주 발생하지는 않는다.
    var region = region
        set(value) {
            field = value.uppercase()
        }

    val isAdult: Boolean
        get() = this.age >= 20

    // Kotlin 에서 init 블록은 클래스가 생성되는 시점에 검증 로직을 추가할 수 있다.
    init {
        if (this.age < 0) {
            throw IllegalArgumentException("나이는 $age 일 수 없습니다.")
        }
        println("init()")
    }

    // 추가적인 생성자는 최종적으로 다른 생성자를 호출하도록 해야 한다.
    // Kotlin 에서는 constructor 정의 보다는 Property 의 default 값을 할당하는 것을 권장한다.
    // 만약 부생성자를 꼭 써야하는 경우, 정적 팩토리 메소드를 사용하는 것이 권장한다.
    constructor(person: Person) : this(person.name, person.region, person.age + 1) {
        println("First Sub Constructor")
    }

    // 부생성자는 Body 스코프를 가질 수 있다.
    constructor() : this("", "unknown", 0) {
        println("Second Sub Constructor")
    }
}

fun main() {
    val person = Person(name = "simseongheon", region = "korea", age = 28)
    println("이름 : ${person.name}, 나이 : ${person.age}, 성인? ${person.isAdult}")

    val secondPerson = Person(person)
    println("이름 : ${secondPerson.name}, 나이 : ${secondPerson.age}, 성인? ${secondPerson.isAdult}")

    val emptyPerson = Person()
    println("이름 : ${emptyPerson.name}, 나이 : ${emptyPerson.age}, 성인? ${emptyPerson.isAdult}")

    val errorPerson = Person(age = -1, name = "ddoick", region = "korea")
    println("이름 : ${errorPerson.name}, 나이 : ${errorPerson.age}, 성인? ${errorPerson.isAdult}")
}
