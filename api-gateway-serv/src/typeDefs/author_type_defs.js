const { gql } = require('apollo-server');

const authorTypeDefs = gql `
    type Author{
        id: String!
        authorName: String!
        country:  String!
    }

    input AuthorInput{
        authorName: String!
        country:  String!
    }

    extend type Mutation {
        createAuthor(author: AuthorInput!): Author
        updateAuthor(id: String!, authorName: String!, country: String!): Author
    }

    extend type Query {
        authorsByAuthorName(authorName: String!): [Author]
        authorsById(id: String!): Author
        allAuthors: [Author]
    }
`;

module.exports = authorTypeDefs;