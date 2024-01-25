package controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 어노테이션 발동시점 -> 실행시 발동
@Target(ElementType.METHOD) // 어노테이션 위치붙이는 곳

public @interface RequestMapping {
    String uri();
}
