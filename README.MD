# spring core security Sample Application

## Describe

인프런의 [코어 스프링 시큐리티](https://www.inflearn.com/course/%EC%BD%94%EC%96%B4-%EC%8A%A4%ED%94%84%EB%A7%81-%EC%8B%9C%ED%81%90%EB%A6%AC%ED%8B%B0) 강의를 학습하면서 만든 애플리케이션 

## 사용 기술

* spring boot 2.5.5
* spring security
* thymeleaf
* H2 In Memory DB
* Spring Data JPA
* JDK 11
* Maven

## IntelliJ에서 구동 방법

### Prerequisites
* Java 11 or newer
* git
* IntelliJ or other IDE

### Steps:

1) On the command line
    ```
    git clone https://github.com/willdonejw/core-security.git`
    ```
   
2) open IntelliJ
    ```
    File - open - core-security - pox.xml
    ```
   
3) 구동 

    core-security 애플리케이션의 main class를 실행: `Run CoreSecurityApplication`


## 실행 정보

### 접속 주소
* 사용자화면: http://localhost:8080
* 관리자화면: http://localhost:8080/admin
* h2 콘솔: http://localhost:8080/h2-console

### 테스트 계정(id / pw)
* 사용자: user / 123
* 관리자: admin / 123
* 매니저: manager / 123
