import { Routes } from '@angular/router';
import { UserListComponent } from './component/user-list/user-list.component';
import { UserComponent } from './component/user/user.component';

export const routes: Routes = [
    { path: '', component: UserListComponent },
    { path: 'create', component: UserComponent },
    {path: 'edit/:id', component: UserComponent}
];
