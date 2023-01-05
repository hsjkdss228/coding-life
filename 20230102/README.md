# 프리온보딩 백엔드 챌린지 1월: 함수형 프로그래밍, 실무에서 사용할 수 있나요? (feat. TypeScript, Nest.js)

## 사전 과제

> 사전과제는 해당 레포지토리 **Issues** 탭에 미리 올려 둔 template 을 복사해서 새로운 이슈로 사전과제 풀이를 올려주세요. (Pull Request X)

### 1. 본인이 작성했던 코드 중 공유하고 싶은 코드를 이유와 함께 마크다운 code block 을 사용해 올려주세요

- 언어 상관없음
- 어떤 로직이든 상관없음
- 단, 길이가 길지 않은 함수 단위가 좋습니다.

```Java
해당 code block 에 올려주세요
```

### 2. Layered Architecture(계층 아키텍처)에 대해서 설명해 주세요

### 3. Dependency Injection(의존성 주입)의 개념과 함께, 왜 필요한지 작성해 주세요

### 4. 본인이 사용하는 언어의 Functional Programming(함수형 프로그래밍) 스펙을 예제와 함께 소개해 주세요

### 5. (코드 작성) 다음 스펙을 만족하는 delay 함수를 작성해 주세요 (hint: Promise 사용)

```JavaScript
type SomeFunctionReturnString = () => string

function delay(f: SomeFunctionReturnString, seconds: number): Promise<string> {
    // 해당 함수 내부를 구현해 주세요
};

const success = () => {
  return "successfully done";
};

const fail = () => {
  throw new Error("failed");
};

delay(success, 2)
  .then((res) => console.log(res))
  .catch((e) => console.log(e));

delay(fail, 2)
  .then((res) => console.log(res))
  .catch((e) => console.log(e));
```

결과값

```Shell
  $ ts-node delay.ts
  successfully done
  Error: failed
```

### 6. 강의를 통해서 기대하는 바, 또는 얻고 싶은 팁을 적어주세요
