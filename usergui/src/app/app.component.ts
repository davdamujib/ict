import { Component } from '@angular/core';
import { RouterOutlet, RouterLinkWithHref } from '@angular/router';
import { UserComponent } from "./component/user/user.component";
import { UserListComponent } from './component/user-list/user-list.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, UserComponent, UserListComponent, RouterLinkWithHref],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'usergui';
}
