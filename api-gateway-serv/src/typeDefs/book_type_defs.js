const { gql } = require('apollo-server');

const bookTypeDefs = gql `
    type Book{
        id: String!
        title: String!
        isbn: String!
        synopsis: String!
        genre: String!
        publicationYear: Int!
        author: String!
        publisher: String!
    }

    input BookInput{
        title: String!
        isbn: String!
        synopsis: String!
        genre: String!
        publicationYear: Int!
        author: String!
        publisher: String!
    }

    extend type Mutation {
        createBook(book: BookInput!): Book
        updateBook(id: String!,
                   title: String,
                   isbn: String,
                   synopsis: String,
                   genre: String,
                   publicationYear: Int,
                   author: String,
                   publisher: String): Book
    }

    extend type Query {
        bookById(id: String!): Book
        booksByTitle(title: String!): [Book]
        booksByAuthor(author: String!): [Book]
        booksByPublisher(publisher: String!): [Book]
        booksByPublicationYear(publicationYear: Int!): [Book]
        allBooks: [Book]
    }
`;

module.exports = bookTypeDefs;