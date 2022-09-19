import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../Modals/Books';
import { BookService } from '../Service/book.service';

@Component({
  selector: 'app-delete-book',
  templateUrl: './delete-book.component.html',
  styleUrls: ['./delete-book.component.scss']
})
export class DeleteBookComponent implements OnInit {
  id: number;
  book: Book = new Book();
  bookdelete: boolean;
  constructor(private service: BookService, private routes: ActivatedRoute, private route: Router) {

  }

  ngOnInit(): void {
    this.routes.params.subscribe((params) => {
      this.id = params['id'];
    })
    this.getBookById();
  }
  getBookById() {
    this.service.getBookByID(this.id).subscribe((response) => {
      this.book = response;

    })
  }

  deleteBook() {
    this.bookdelete = confirm('Are you sure want to delete the book');
    if (this.bookdelete === true) {
      this.service.deleteBook(this.id).subscribe((response) => {
        this.route.navigate(['/book']);

      });

    }

  }
}
