import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UserComponent } from "./component/user/user.component";
import { UserListComponent } from './component/user-list/user-list.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, UserComponent, UserListComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'usergui';
}
