# tsyringe 동작 테스트

## 의존성 설치

```bash
npm i
```

## 실행

```bash
npm start
```

## 요청 및 응답

```text
메서드 및 경로: GET /
응답: 'Hello, world!'
```

## 콘솔 출력

- 메서드 호출 시 homeRoutes에서 반환되는 homeController 인스턴스들의 동일성을 검증

```text
Server is running on port ${port}.

true
true
true
```
