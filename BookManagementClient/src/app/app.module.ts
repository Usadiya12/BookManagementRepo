import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookListComponent } from './book-list/book-list.component';
import { FormsModule } from '@angular/forms';
import { BookService } from './Service/book.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { AddBookComponent } from './add-book/add-book.component';
import { UpdateBookComponent } from './update-book/update-book.component';
import { DeleteBookComponent } from './delete-book/delete-book.component';
import { ErrorPathComponent } from './error-path/error-path.component';
import { RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    BookListComponent,
    AddBookComponent,
    UpdateBookComponent,
    DeleteBookComponent,
    ErrorPathComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    // RouterModule.forRoot([
    //   { path: 'addbook', component: AddBookComponent },
    //   { path: 'book', component: BookListComponent },
     
    //   { path: 'update/:id', component: UpdateBookComponent },
    //   { path: 'delete/:id', component: DeleteBookComponent },
    //   { path: '**', component: ErrorPathComponent }
    // ])
  ],
  providers: [BookService],
  bootstrap: [AppComponent]
})
export class AppModule { }
