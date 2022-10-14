const bodyParser = require('body-parser');
const express = require('express');
const app = express();
require('./models/dbConfig');
const postsRoutes = require('./routes/postsController');

app.use(bodyParser.json());
app.use('/posts', postsRoutes);

app.listen(5500, () => console.log('sv open : 5500'));
