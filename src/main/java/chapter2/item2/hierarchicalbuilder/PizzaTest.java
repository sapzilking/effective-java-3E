package chapter2.item2.hierarchicalbuilder;

import static chapter2.item2.hierarchicalbuilder.MrPizza.Size.*;
import static chapter2.item2.hierarchicalbuilder.Pizza.Topping.*;

// 계층적 빌더 사용 (21쪽)
public class PizzaTest {

    public static void main(String[] args) {
        MrPizza mrPizza = new MrPizza.Builder(SMALL)
          .addTopping(SAUSAGE).addTopping(ONION).build();
        DominoPizza dominoPizza = new DominoPizza.Builder()
          .addTopping(HAM).sauceInside().build();

        System.out.println("mrPizza = " + mrPizza);
        System.out.println("dominoPizza = " + dominoPizza);
    }
}
