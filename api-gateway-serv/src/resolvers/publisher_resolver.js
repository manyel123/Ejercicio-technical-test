const publisherResolver = {
    Query: {
        publisherById: async(_, {id}, { dataSources }) => {
            return dataSources.backendAPI.publisherById(id)
        },
        publisherByPublisherName: async(_, {publisherName}, { dataSources }) => {
            return dataSources.backendAPI.publisherByPublisherName(publisherName)
        },
        allPublishers: async(_, {}, { dataSources }) => {
            return dataSources.backendAPI.allPublishers()
        }
    },
    Mutation: {
        createPublisher: async(_, {publisher}, { dataSources, userIdToken }) => {
            usernameToken =  (await dataSources.authAPI.getUser(userIdToken)).username
            if (usernameToken !== undefined)
                return dataSources.backendAPI.createPublisher(publisher)
            else
                return null
        },
        updatePublisher: async(_, {id, publisherName, foundationYear}, { dataSources, userIdToken }) => {
            usernameToken =  (await dataSources.authAPI.getUser(userIdToken)).username
            const publisher =  (await dataSources.backendAPI.publisherById(id))
            if (usernameToken !== undefined){
                if (!publisher){
                    throw new Error(`No se encuentró el editor con id: ${id}`);
                }
                publisher.publisherName  = publisherName;
                publisher.foundationYear = foundationYear;
                return dataSources.backendAPI.createPublisher(publisher)
            }
            else
                return null
        }
    }
};

module.exports = publisherResolver;