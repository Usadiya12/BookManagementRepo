import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddBookComponent } from './add-book/add-book.component';
import { BookListComponent } from './book-list/book-list.component';
import { DeleteBookComponent } from './delete-book/delete-book.component';
import { ErrorPathComponent } from './error-path/error-path.component';
import { HomeComponent } from './home/home.component';
import { UpdateBookComponent } from './update-book/update-book.component';

const routes: Routes = [
  { path: '', component:BookListComponent },
  { path: 'book', component: BookListComponent },
  { path: 'addbook', component: AddBookComponent },
  { path: 'update/:id', component: UpdateBookComponent },
  { path: 'delete/:id', component: DeleteBookComponent },
  { path: '**', component: ErrorPathComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
