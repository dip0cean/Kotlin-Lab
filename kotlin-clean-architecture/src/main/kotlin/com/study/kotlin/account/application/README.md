## Application Package

> application 패키지는 Domain 모델을 둘러싼 `Service Layer` 이다.
> `SendMoneyService` 는 **인커밍 포트 인터페이스**인 `SendMoneyUseCase` 를 구현하고,
> **아웃고잉 포트 인터페이스**이면서 **영속성 어댑터**에 의해 구현된 `LoadAccountPort`, `UpdateAccountStatePort` 를 사용한다.
> 
> Service 클래스의 경우 바깥에서 UseCase 로 호출되기 때문에 Service 클래스가 직접적으로
> 호출될 일이 없기에 private 으로 설정하는 것이 좋다. 그 이유는 우발적인 의존성을 제거할 수 있기 때문이다.