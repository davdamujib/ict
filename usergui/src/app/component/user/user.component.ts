import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { UserService } from '../../services/user.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-user',
  imports: [CommonModule, FormsModule],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent implements OnInit {

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

  selectedHobbies: string[] = [];

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

  onHobbyChange(event: any) {
    const hobby = event.target.value;

    if (event.target.checked) {
      this.selectedHobbies.push(hobby);
    } else {
      this.selectedHobbies = this.selectedHobbies.filter(h => h !== hobby);
    }

    this.user.hobbies = this.selectedHobbies.join(',');
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
        this.reset();
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
    this.selectedHobbies = [];
  }

}
