# 『이펙티브 자바 3판』(원서: Effective Java 3rd Edition)
### :santa: effective Java 3판 실습용 저장소

<img src="./img.jpeg">

> ### **2장**
> > #### **아이템2 (Builder)**
> > * **[점층적 생성자 패턴](https://github.com/merry-santa/effective-java-3E/blob/main/src/main/java/chapter2/item2/telescopingconstructor/NutritionFacts.java)** 
> >   * cons
> >     * 매개변수가 많아지면 클라이언트 코드를 작성하거나 읽기 어렵다.
> > * **[자바빈즈 패턴](https://github.com/merry-santa/effective-java-3E/blob/main/src/main/java/chapter2/item2/javabeans/NutritionFacts.java)**
> >   * cons
> >     * 객체하나를 만들기 위해 호출해야할 메서드가 너무 많고, 객체가 완전히 생성되기 전까지 consistency가 무너진 상태에 놓이게 된다.
> > * **[빌더 패턴](https://github.com/merry-santa/effective-java-3E/blob/main/src/main/java/chapter2/item2/builder/NutritionFacts.java)** 
> >   * pros
> >     * 점층적 생성자 패턴의 안전성과 자바빈즈 패턴의 가독성을 겸비함.
> >     * 빌더 패턴은 계층적으로 설계된 클래스와 함께 쓰기에 좋음. ([예제](https://github.com/merry-santa/effective-java-3E/tree/main/src/main/java/chapter2/item2/hierarchicalbuilder))
> >   * cons
> >     * 객체를 만들려면 빌더부터 만들어야한다. 빌더 생성 비용이 크지는 않지만 성능에 민감한 상황에서는 문제가 될 수 있음.
> >     * 점층적 생성자 패턴보다는 코드가 장황해서 매개변수가 4개 이상은 되어야 값어치를 한다.
> > #### **요약**
> > - 생성자나 정적 팩토리가 처리해야 할 매개변수가 많다면 빌더 패턴을 선택하는 게 더 낫다.  
> >   매개변수 중 다수가 필수가 아니거나 같은 타입이면 특히 더그렇다.  
> > - 빌더는 점층적 생성자보다 클라이언트 코드를 읽고 쓰기가 훨씬 간결하고, 자바빈즈보다 훨씬 안전하다.
> > ***
> > #### **아이템3 (Singleton)**
> > * **[필드 방식의 싱글턴](https://github.com/merry-santa/effective-java-3E/blob/main/src/main/java/chapter2/item3/field/Elvis.java)**
> >   * 권한이 있는 클라이언트는 리플렉션 API(아이템 65)인 AccessibleObject.setAccessible을 사용해 private 생성자를 호출할 수 있다.
> >   이러한 공격을 방어하려면 생성자를 수정하여 두번째 객체가 생성되려 할 때 예외를 던지게 하면 된다.
> > * **[정적 팩터리 방식의 싱글턴](https://github.com/merry-santa/effective-java-3E/blob/main/src/main/java/chapter2/item3/staticfactory/Elvis.java)**
> > * **[열거 타입 방식의 싱글턴](https://github.com/merry-santa/effective-java-3E/blob/main/src/main/java/chapter2/item3/enumtype/Elvis.java)**
> >   * public 필드 방식과 비슷하지만, 더 간결하고 추가 노력 없이 직렬화할 수 있고, 복잡한 직렬화 상황이나 리플렉션 공격에서도 제2의 인스턴스가 생기는 일을 완벽히 막아준다.
> > #### **요약**
> > - 대부분 상황에서는 원소가 하나뿐인 열거 타입이 싱글턴을 만드는 가장 좋은 방법이다.
> >   단, 만들려는 싱글턴이 Enum 외의 클래스를 상속해야 한다면 열거 타입 방식의 싱글턴 방법은 사용할 수 없다(열거 타입이 다른 인터페이스를 구현하도록 선언할 수는 있다).
> > ***
> > #### **아이템6**
> > * 박싱된 기본 타입보다는 기본타입을 사용하고, 의도치 않은 오토박싱이 숨어들지 않도록 주의하자!
> > ***
> > #### **아이템8,9**
> > * close 메서드를 호출해 직접 닫아줘야하는 자원들은 상당수가 안전망으로 finalizer를 활용하고 있지만 finalizer는 그리 믿을만하지 못하다.([아이템8](https://github.com/merry-santa/effective-java-3E/tree/main/src/main/java/chapter2/item8))
> > * 그러므로 close 메서드를 호출해 직접 닫아줘야 하는 자원을 사용할 때는 try-with-resources를 사용하자!  
      코드는 더 짧고 분명해지고, 예외 정보도 훨씬 유용하게 사용할 수 있다.
> > ***
> ### **3장**
> > #### **아이템14 (Comparable)**
> > * 순서를 고려해야 하는 값 클래스를 작성한다면 꼭 Comparable 인터페이스를 구현하자.  
      compareTo 메서드에서 필드의 값을 비교할 때 <와> 연산자는 사용하지 말고, 박싱된 기본타입 클래스가 제공하는 정적 compare 메서드나 Comparator 인터페이스가 제공하는 비교자 생성 메서드를 사용하자.
> ### **4장**
> > #### **아이템16 (Comparable)**
> > * public 클래스는 절대 가변필드를 직접 노출해서는 안된다.
> > * 하지만 package-private 클래스나 private 중첩 클래스에서는 종종(불변이든 가변이든) 필드를 노출하는 편이 나을 때도 있다.
> > #### **아이템19**
> > * 상속용 클래스의 생성자는 직접적으로든 간접적으로든 재정의 가능 메서드를 호출해서는 안 된다! 상위 클래스의 생성자가 하위 클래스의 생성자보다 먼저 실행되므로 하위 클래스에서 재정의한 메서드가 하위 클래스의 생성자보다 먼저 호출된다. 이때 그 재정의한 메서드가 하위 클래스의 생성자에서 초기화하는 값에 의존한다면 오동작 할 것이다.([예제](https://github.com/merry-santa/effective-java-3E/tree/main/src/main/java/chapter4/item19))
> > #### **아이템25**
> > * 소스 파일 하나에는 반드시 톱레벨 클래스(혹은 톱레벨 인터페이스)를 하나만 담자.
> ### **5장**
> > #### **아이템31**
> > * 와일드카드 타입을 사용하는 기본원칙 -> PECS(producer-extends, consumer-super)
> > * Comparable과 Comparator는 모두 consumer이다!
> ### **6장**
> > #### **아이템35**
> > * Enum 타입에서 몇 번째 위치인지를 반환하는 oridinal이라는 메서드가 있는데 해당 메서드는 EnumSet과 EnumMap 같이 Enum타입 기반의 범용 자료구조에 쓸 목적으로 설계된 것이므로 이런 용도가 아니라면 oridinal 메서드는 절대 사용하지 말자
> > * Enum 타입 상수에 연결된 값을 사용하고 싶다면 oridinal 메서드로 얻지 말고, 인스턴스 필드에 저장하자. ([e.g](https://github.com/sugil92/effective-java-3E/blob/main/src/main/java/chapter6/item35/Ensemble.java))
  


