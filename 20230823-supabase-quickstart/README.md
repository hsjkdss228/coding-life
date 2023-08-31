# Supabase Edge Function Quick Start

## Edge Function이란?

- <https://supabase.com/docs/guides/functions>
- 전 세계의 Edge 네트워크에 분산되어 배포되는 서버사이드 함수
- JavaScript, TypeScript, WebAssembly 런타임 deno를 기반으로 함.

## How it works

### Prerequisite

- 생성되어 있는 특정 Supabase 프로젝트

### Deno 설치

```bash
brew install deno
```

### Supabase CLI 설치

```bash
brew install supabase/tap/supabase
```

### Supabase Edge Function과 Supabase 프로젝트 연결

```bash
supabase functions deploy {function_name} --project-ref {reference} --no-verify-jwt
```

- function_name: functions 하위 디렉토리 내 배포할 함수의 `index.ts`가 위치한 디렉토리명 (예시에서는 home)
- reference: Supabase 프로젝트 host 내 고유 식별자 (`{reference}.supabase.io`에서 reference에 해당되는 문자열)

### 생성된 API 경로에 요청 송신

![edge_function_requeset_example](https://github.com/hsjkdss228/coding-life/assets/50052512/ca15f800-7f21-44d5-8756-739380765d20)
