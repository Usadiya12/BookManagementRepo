import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../Modals/Books';
import { BookService } from '../Service/book.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.scss']
})
export class AddBookComponent implements OnInit {
  book: Book = new Book();

  constructor(private service: BookService, private route: Router) { }

  ngOnInit(): void {
  }
  addNewBook() {

    this.service.addNewBook(this.book).subscribe((response) => {
      this.route.navigate(['/book']);
    }

    )
  }

}
