/* eslint-disable class-methods-use-this */

import 'reflect-metadata';

import { inject, singleton } from 'tsyringe';

import GreetingService from '../services/GreetingService.ts';

@singleton()
export default class HomeController {
  private greetingService: GreetingService;

  constructor(
    @inject(GreetingService) greetingService: GreetingService,
  ) {
    this.greetingService = greetingService;
  }

  public async home() {
    const data = await this.greetingService.greet();
    return data;
  }
}
