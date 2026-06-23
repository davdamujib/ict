import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { UserService } from '../../services/user.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-register',
  imports: [CommonModule, FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent implements OnInit {

  user: User = {
    name: '',
    email: '',
    password: '',
    age: 0,
    mobileNumber: '',
    dob: '',
    gender: '',
    hobbies: '',
    country: '',
    address: ''
  };

  users: User[] = [];

  isEdit = false;
  editId!: number;

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.loadUsers()
  }

  loadUsers() {
    this.userService.getAll().subscribe((res: any) => {
      this.users = res.data || res;
    });
  }

  save() {
    if (this.isEdit) {
      this.userService.update(this.editId, this.user)
        .subscribe(() => {
          alert('User Updated')
          this.reset();
          this.loadUsers();
        });

    } else {
      this.userService.create(this.user)
        .subscribe(() => {
          alert('User Created')
          this.reset();
          this.loadUsers();
        });
    }
  }

  edit(user: User) {
    this.user = { ...user };
    this.editId = user.id!;
    this.isEdit = true;
  }

  delete(id: number) {
    this.userService.delete(id)
      .subscribe(() => {
        alert('User Deleted');
        this.loadUsers();
      });
  }

  reset() {
    this.user = {
      name: '',
      email: '',
      password: '',
      age: 0,
      mobileNumber: '',
      dob: '',
      gender: '',
      hobbies: '',
      country: '',
      address: ''
    };
    this.isEdit = false;
  }
}