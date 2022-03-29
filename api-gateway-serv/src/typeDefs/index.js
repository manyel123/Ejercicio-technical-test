const authTypeDefs      = require('./auth_type_defs');
const authorTyprDefs    = require('./author_type_defs');
const bookTypeDefs      = require('./book_type_defs');
const publisherTypeDefs = require('./publisher_type_defs');

const schemasArrays = [authTypeDefs, authorTyprDefs, bookTypeDefs, publisherTypeDefs];

module.exports = schemasArrays;