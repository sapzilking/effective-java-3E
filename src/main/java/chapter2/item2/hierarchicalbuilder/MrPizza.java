package chapter2.item2.hierarchicalbuilder;

import java.util.Objects;

// 코드 2-5 뉴욕 피자(이름을 미스터피자로 바꿈) - 계층적 빌더를 활용한 하위 클래스 (20쪽)
// 크기(size) 매개변수를 필수로 받는다.
public class MrPizza extends Pizza {

    public enum Size {SMALL, MEDIUM, LARGE}

    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public MrPizza build() {
            return new MrPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private MrPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    @Override
    public String toString() {
        return toppings + "로 토핑한 미스터피자";
    }
}