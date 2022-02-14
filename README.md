# 『이펙티브 자바 3판』(원서: Effective Java 3rd Edition)
### effective Java 3판 실습용 저장소  

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
> > 생성자나 정적 팩토리가 처리해야 할 매개변수가 많다면 빌더 패턴을 선택하는 게 더 낫다.  
> > 매개변수 중 다수가 필수가 아니거나 같은 타입이면 특히 더그렇다.  
> > 빌더는 점층적 생성자보다 클라이언트 코드를 읽고 쓰기가 훨씬 간결하고, 자바빈즈보다 훨씬 안전하다.


     
  


