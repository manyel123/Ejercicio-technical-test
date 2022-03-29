const bookResolver = {
    Query: {
        bookById: async(_, {id}, { dataSources }) => {
            return dataSources.backendAPI.bookById(id)
        },
        booksByTitle: async(_, {title}, { dataSources }) => {
            return dataSources.backendAPI.booksByTitle(title)
        },
        booksByAuthor: async(_, {author}, { dataSources }) => {
            return dataSources.backendAPI.booksByAuthor(author)
        },
        booksByPublisher: async(_, {publisher}, { dataSources }) => {
            return dataSources.backendAPI.booksByPublisher(publisher)
        },
        booksByPublicationYear: async(_, {publicationYear}, { dataSources }) => {
            return dataSources.backendAPI.booksByPublicationYear(publicationYear)
        },
        allBooks: async(_, {}, { dataSources }) => {
            return dataSources.backendAPI.allBooks()
        }
    },
    Mutation: {
        createBook: async(_, {book}, { dataSources, userIdToken }) => {
            usernameToken =  (await dataSources.authAPI.getUser(userIdToken)).username
            if (usernameToken !== undefined)
                return dataSources.backendAPI.createBook(book)
            else
                return null
        },
        updateBook: async(_, {id, title, isbn, synopsis, genre, publicationYear, 
                              author, publisher}, { dataSources, userIdToken }) => {
            usernameToken =  (await dataSources.authAPI.getUser(userIdToken)).username
            const book =  (await dataSources.backendAPI.bookById(id))
            if (usernameToken !== undefined){
                if (!book){
                    throw new Error(`No se encuentró el libro con id: ${id}`);
                }
                if (title !== undefined){
                    book.title           = title;
                }
                if (isbn !== undefined){
                    book.isbn            = isbn;
                }
                if (synopsis !== undefined){
                    book.synopsis        = synopsis;
                }
                if (genre !== undefined){
                    book.genre           = genre;
                }
                if (publicationYear !== undefined){
                    book.publicationYear = publicationYear;
                }
                if (author !== undefined){
                    book.author          = author;
                }
                if (publisher !== undefined){
                    book.publisher       = publisher;
                }
                return dataSources.backendAPI.createBook(book)
            }
            else
                return null
        }
    }
};

module.exports = bookResolver;