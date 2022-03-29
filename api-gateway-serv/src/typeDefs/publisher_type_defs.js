const { gql } = require('apollo-server');

const publisherTypeDefs = gql `
    type Publisher{
        id: String!
        publisherName: String!
        foundationYear:  Int!
    }

    input PublisherInput{
        publisherName: String!
        foundationYear:  Int!
    }

    extend type Mutation {
        createPublisher(publisher: PublisherInput!): Publisher
        updatePublisher(id: String!, publisherName: String!, foundationYear:  Int!): Publisher
    }

    extend type Query {
        publisherByPublisherName(publisherName: String!): [Publisher]
        publisherById(id: String!): Publisher
        allPublishers: [Publisher]
    }
`;

module.exports = publisherTypeDefs;