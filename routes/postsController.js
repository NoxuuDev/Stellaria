const express = require('express');
const router = express.Router();

const { PostsModel } = require('../models/postsModel');

router.get('/', (req, res)=> {
    PostsModel.find((err, docs)=> {
        if (!err) res.send(docs);
        else console.log("Error to getting data : " + err);
    })
});

router.post('https://localhost:5500/posts', (req, res) =>{
    const newRecord = new PostsModel({
        author: req.body.author,
        message: req.body.message
    });
    newRecord.save((err, docs) =>{
        if (!err) res.send(docs);
        else console.log('Error creating a new data : '+ err);
    });
})

module.exports = router;