import { CommonModule } from '@angular/common';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { UserService } from '../../services/user.service';
import { Router, RouterLink } from "@angular/router";

@Component({
  selector: 'app-user-list',
  imports: [CommonModule, RouterLink],
  templateUrl: './user-list.component.html',
  styleUrl: './user-list.component.css'
})
export class UserListComponent implements OnInit {

  users: any[] = [];

  @Output() editEvent = new EventEmitter<any>();

  constructor(
    private userService: UserService,
    private router: Router
  ) { }

  ngOnInit() {
    this.loadUsers();
  }

  loadUsers() {
    this.userService.getAll().subscribe((res: any) => {
      this.users = res.data || res;
    });
  }

  delete(id: number) {
    this.userService.delete(id).subscribe(() => {
      alert('User Deleted');
      this.loadUsers();
    });
  }

  edit(id: number) {
    this.router.navigate(['/edit', id]);
  }

}
