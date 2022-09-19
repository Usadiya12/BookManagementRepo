import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Book } from '../Modals/Books';
import { BookService } from '../Service/book.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent implements OnInit {
  books: Book[];

  constructor(private service: BookService) { }

  ngOnInit(): void {
    this.getAllBooks();
  }
  getAllBooks() {
    this.service.getAllBooks().subscribe((response) => {
      this.books = response;
    }

    )

  }
}
