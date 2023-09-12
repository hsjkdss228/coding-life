import express from 'express';

import homeRoutes from './src/routes/homeRoutes.ts';

import config from './config.ts';

const app = express();

app.use(homeRoutes);

const { port } = config;

app.listen(port, () => {
  console.log(`Server is running on port ${port}.`);
});
