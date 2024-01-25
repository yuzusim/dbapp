package com.matacoding.myhttp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Getter -> @ 주석 같은것
// JVM이 무시하지 않는 JVM이 보는 주석
// JVM이 보고 실행시에 힌트를 가져가서 실행시에 @Getter 를 만들어 버리는 것
// 컴파일하는 .class 파일에 게터를 띄워서 실행
// 컴파일 시점에 툴이 이해를 못함 실행시 생김
// 플러그인 설치 하지 않으면 못쓴다.(라이브러리만 사용해서는 못씀)
// 내가 쓰기 편하게 어노테이션으로 정리

@NoArgsConstructor
@AllArgsConstructor // 모든 인수를 다 받는 생성자
@Data
//@Setter
//@Getter
public class Posts {
    private int userId;
    private int id;
    private String title;
    private String body;

}

