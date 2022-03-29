const { RESTDataSource } = require('apollo-datasource-rest');

const serverConfig = require('../server');

class BackendAPI extends RESTDataSource {

    constructor() {
        super();
        this.baseURL = serverConfig.backend_api_url;
    }

    async createAuthor(author) {
        author = new Object(JSON.parse(JSON.stringify(author)));
        return await this.post(`/authors`, author);
    }

    async authorsById(id) {
        return await this.get(`/authors/id/${id}`);
    }

    async authorsByAuthorName(authorName) {
        return await this.get(`/authors/${authorName}`);
    } 

    async allAuthors() {
        return await this.get('/authors/all');
    }

    async createBook(book) {
        book = new Object(JSON.parse(JSON.stringify(book)));
        return await this.post(`/books`, book);
    }

    async bookById(id) {
        return await this.get(`/books/id/${id}`);
    }

    async booksByTitle(title) {
        return await this.get(`/books/title/${title}`);
    }

    async booksByAuthor(author) {
        return await this.get(`/books/author/${author}`);
    }

    async booksByPublisher(publisher) {
        return await this.get(`/books/publisher/${publisher}`);
    }

    async booksByPublicationYear(publicationYear) {
        return await this.get(`/books/year/${publicationYear}`);
    }

    async allBooks() {
        return await this.get('/books/all');
    }

    async createPublisher(publisher) {
        publisher = new Object(JSON.parse(JSON.stringify(publisher)));
        return await this.post(`/publishers`, publisher);
    }

    async publisherById(id) {
        return await this.get(`/publishers/id/${id}`);
    }

    async publisherByPublisherName(publisherName) {
        return await this.get(`/publishers/${publisherName}`);
    }

    async allPublishers() {
        return await this.get('/publishers/all');
    }
}

module.exports = BackendAPI;