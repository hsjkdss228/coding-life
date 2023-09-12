/* eslint-disable class-methods-use-this */

import 'reflect-metadata';

import { singleton } from 'tsyringe';

@singleton()
export default class GreetingService {
  public async greet() {
    return 'Hello, world!';
  }
}
