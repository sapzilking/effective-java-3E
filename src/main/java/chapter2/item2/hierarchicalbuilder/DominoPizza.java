package chapter2.item2.hierarchicalbuilder;

// 코드 2-6 칼초네 피자(이름을 도미노피자로 바꿈) - 계층적 빌더를 활용한 하위 클래스 (20~21쪽)
// 소스를 안에 넣을지 선택(sauceInside)하는 매개변수를 필수로 받는다.
public class DominoPizza extends Pizza {

    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false; // 기본값

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override
        public DominoPizza build() {
            return new DominoPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private DominoPizza(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }

    @Override
    public String toString() {
        return String.format("%s로 토핑한 도미노피자 (소스는 %s에)",
          toppings, sauceInside ? "안" : "바깥");
    }
}
