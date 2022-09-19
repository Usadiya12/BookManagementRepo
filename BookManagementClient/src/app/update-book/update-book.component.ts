import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../Modals/Books';
import { BookService } from '../Service/book.service';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.scss']
})
export class UpdateBookComponent implements OnInit {
  book: Book = new Book();
  id: number;


  constructor(private service: BookService, private routes: ActivatedRoute, private route: Router) {

  }

  ngOnInit(): void {
    this.routes.params.subscribe(
      (params) => {
        this.id = params['id'];
      })
    this.getBookById();


  }
  getBookById() {

    this.service.getBookByID(this.id).subscribe((response) => {
      this.book = response;
    })

  }
  updateBook() {
    this.service.UpdateBook(this.id, this.book).subscribe((response) => {
      this.route.navigate(['/book']);
    }

    )

  }

}
