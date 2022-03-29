const authResolver      = require('./auth_resolver');
const authorResolver    = require('./author_resolver');
const bookResolver      = require('./book_resolver');
const publisherResolver = require('./publisher_resolver');

const loadsh            = require('loadsh');

const resolvers         = loadsh.merge(authResolver, authorResolver, bookResolver, publisherResolver);

module.exports = resolvers;
