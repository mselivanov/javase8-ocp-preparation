// Functional interfaces
// Built-in functional interfaces
import java.util.function.*;
Supplier<StringBuilder> s1 = StringBuilder::new;
StringBuilder sb1 = s1.get().append("Hello").append(", world!");
Consumer<String> c1 = System.out::println;
Consumer<String> c2 = System.out::print;
c1.accept(sb1.toString());

BiConsumer<String, Integer> bi1 = (s, i) -> System.out.println(String.format(s, i));
Function<String, Integer> toLen = s -> s.length();
toLen.apply(sb1.toString());

BiFunction<String, Integer, String> bf1 = (s, i) -> String.format(s, i);
c1.accept(bf1.apply("Magic number: %d", 42));

Predicate<String> p1 = s->s.startsWith("g");
BiPredicate<String, String> p2 = (s1, s2) -> s1.length() > s2.length();
c1.accept(String.format("google starts with g: %b", p1.test("google")));
c1.accept(String.format("Hello length is greater than world length: %b", p2.test("Hello", "world")));

UnaryOperator<Integer> upSquare = i -> i*i;
c1.accept(String.format("UnaryOperator applied to 10: %d", upSquare.apply(10)));

BinaryOperator<Integer> binOp = (i1, i2) -> i1 + i2;
c1.accept(String.format("BinaryOperato applied to 10 and 12: %d", binOp.apply(10, 12)));

// Working with Optional
import java.util.Optional;
Optional<String> emptyString = Optional.empty();
c1.accept(String.format("Optional.empty() = " + emptyString));

c1.accept(String.format("emptyString.orElseGet(()->\"Stub\") = %s", emptyString.orElseGet(()->"Stub")));
Optional<Integer> optionalTen = Optional.of(10);
c2.accept("optionalTen.ifPresent(System.out::println) = ");
optionalTen.ifPresent(System.out::println);
emptyString.orElseThrow(()-> new IllegalArgumentException("Optional is empty!"));
Optional<Integer> oon = Optional.ofNullable(null);
c1.accept(String.format("Optional.ofNullable(null).isPresent() = %b", oon.isPresent()));
c1.accept(String.format("Optional.<String>ofNullable(null).orElse(\"Empty optional!\") = %s", Optional.<String>ofNullable(null).orElse("Empty optional!")));

