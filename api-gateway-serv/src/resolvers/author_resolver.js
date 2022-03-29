const authorResolver = {
    Query: {
        authorsById: async(_, {id}, { dataSources }) => {
            return dataSources.backendAPI.authorsById(id)
        },
        authorsByAuthorName: async(_, {authorName}, { dataSources }) => {
            return dataSources.backendAPI.authorsByAuthorName(authorName)
        },
        allAuthors: async(_, {}, { dataSources }) => {
            return dataSources.backendAPI.allAuthors()
        }
    },
    Mutation: {
        createAuthor: async(_, {author}, { dataSources, userIdToken }) => {
            usernameToken =  (await dataSources.authAPI.getUser(userIdToken)).username
            if (usernameToken !== undefined)
                return dataSources.backendAPI.createAuthor(author)
            else
                return null
        },
        updateAuthor: async(_, {id, authorName, country}, { dataSources, userIdToken }) => {
            usernameToken =  (await dataSources.authAPI.getUser(userIdToken)).username
            const author =  (await dataSources.backendAPI.authorsById(id))
            if (usernameToken !== undefined){
                if (!author){
                    throw new Error(`No se encuentró el autor con id: ${id}`);
                }
                author.authorName = authorName;
                author.country    = country;
                return dataSources.backendAPI.createAuthor(author)
            }
            else
                return null
        }
    }
};

module.exports = authorResolver;