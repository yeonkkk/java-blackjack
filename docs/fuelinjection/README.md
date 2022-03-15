# README

# 기능 목록

- [X]  여행할 목적지의 이동 거리를 입력받는다.

```
목적지까지 이동할 거리를 입력해주세요.
120
```

- [X]  입력받은 이동 거리를 검증한다.
    - [X]  [예외] 입력값이 공백이거나 빈 값이 들어올 때
    - [X]  [예외] 입력값이 정수가 아닐 때
    - [X]  [예외] 입력값이 0 이하 일 때
- [X]  차량별로 주입해야 할 연료량를 구한다.
- [X]  구한 연료량으로 보고서를 만든다.
- [X]  만들어진 보고서를 출력한다.

```
"Sonata : 12리터"
"Avante : 8리터"
"K5 : 9리터"
```

<br>

##### 예외 처리
- 예외가 발생하지 않을 때까지 재입력 받는다.

# 도메인 구조

### InputView

- 여행할 목적지의 이동 거리를 입력받는다.

### Distance

- 이동 거리를 검증한다.

### Car

- 주입해야 할 연료량를 구한다.

### Cars

- 각 Car에게 주입해야 할 연료량을 요청한다.

### RentCompany

- 차량별로 주입해야 할 연료량을 Cars에게 요청한다.
- 연료량 보고서를 만든다.

### ResultView

- 만들어진 보고서를 출력한다.