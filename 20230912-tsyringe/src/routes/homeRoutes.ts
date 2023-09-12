import express from 'express';

import 'reflect-metadata';

import { container } from 'tsyringe';

import HomeController from '../controllers/HomeController.ts';

const router = express.Router();

const homeController1 = container.resolve(HomeController);
const homeController2 = container.resolve(HomeController);
const homeController3 = container.resolve(HomeController);

router.get('/', async (_, response) => {
  console.log(homeController1 === homeController2);
  console.log(homeController2 === homeController3);
  console.log(homeController3 === homeController1);

  const data = await homeController1.home();

  response.type('text/plain')
    .send(data);
});

export default router;
