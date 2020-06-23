import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ShelfComponent } from './shelf/shelf.component';
import { AddBookComponent} from './shelf/add-book/add-book.component';

const routes: Routes = [
  { path: '',   redirectTo: '/home', pathMatch: 'full' },
  {path: 'home', component:  HomeComponent},
  {path: 'shelf', component: ShelfComponent},
  {path: 'add-book', component: AddBookComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
