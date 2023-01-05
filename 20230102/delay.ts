type SomeFunctionReturnString = () => string

function delay(f: SomeFunctionReturnString, seconds: number): Promise<string> {
  // 해당 함수 내부를 구현해 주세요
  let message: string;

  const checkError = () => {
    try {
      message = f();
    } catch (error) {
      if (error instanceof Error) {
        const errorMessage = error.message
        setTimeout(() => console.log(`Error: ${errorMessage}`), seconds * 1000);
      }
    }
  }

  checkError();

  return new Promise<string>((resolve) => {
    if (message) {
      setTimeout(() => resolve(message), seconds * 1000);
    }
  });
};

const success = () => {
  return 'successfully done';
};

const fail = () => {
  throw new Error('failed');
};

delay(success, 2)
  .then((res) => console.log(res))
  .catch((e) => console.log(e));

delay(fail, 2)
  .then((res) => console.log(res))
  .catch((e) => console.log(e));
