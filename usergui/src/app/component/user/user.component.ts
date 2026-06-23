import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { User } from '../../models/user';
import { UserService } from '../../services/user.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router, RouterLink } from "@angular/router";

@Component({
  selector: 'app-user',
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent implements OnInit {

  user: any = {
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

  selectedHobbies: string[] = [];

  isEdit = false;
  id!: number;

  constructor(
    private userService: UserService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {

    this.id = this.route.snapshot.params['id'];

    if (this.id) {
      this.isEdit = true;
      this.userService.getById(this.id).subscribe((res: any) => {
        this.user = res.data || res;

        this.selectedHobbies =
          this.user.hobbies ? this.user.hobbies.split(',') : [];
      });
    }
  }

  onHobbyChange(event: any) {

    const value = event.target.value;

    if (event.target.checked) {
      this.selectedHobbies.push(value);
    } else {
      this.selectedHobbies =
        this.selectedHobbies.filter(h => h !== value);
    }

    this.user.hobbies = this.selectedHobbies.join(',');
  }

  save() {

    if (this.isEdit) {

      this.userService.update(this.id, this.user)
        .subscribe(() => {
          alert('Updated');
          this.router.navigate(['/']);
        });

    } else {

      this.userService.create(this.user)
        .subscribe(() => {
          alert('Created');
          this.router.navigate(['/']);
        });
    }
  }
}
