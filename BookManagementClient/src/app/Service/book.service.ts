import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from '../Modals/Books';
import { DeleteBookComponent } from '../delete-book/delete-book.component';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  baseUrl: string = 'http://localhost:9092/book';
  books: Observable<Book>;
  constructor(private httpClient: HttpClient) { }

  addNewBook(book: Book): Observable<any> {

    return this.httpClient.post(this.baseUrl + '/addbook', book);
  }
  getAllBooks(): Observable<any> {

    this.books = this.httpClient.get<any>(this.baseUrl + '/getallbooks');
    return this.books;

  }
  UpdateBook(id: number, newBook: Book) {

    return this.httpClient.put(this.baseUrl + '/update' + '/' + id, newBook);

  }
  getBookByID(id: number): Observable<any> {

    return this.httpClient.get<any>(this.baseUrl + '/getbookbyid' + '/' + id);
  }
  deleteBook(id: number) {
    return this.httpClient.delete(this.baseUrl + '/delete' + '/' + id);

  }
}
