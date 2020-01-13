import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AccountService } from 'src/app/services/account.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(
    private router:Router,
    private accountService:AccountService,
    private toastr:ToastrService
  ) { }

  ngOnInit() {
  }

  register(name:string, username:string, password:string){
    this.accountService.register(name, username, password)
      .subscribe(
        data => {
          if(data == null){
            alert("Account already taken.");
          }
          else{
            alert("Registered");
            this.router.navigate(['/login']);
          }
        },
        error => {
          this.toastr.error(error.error.message, "Error");
        }
      );
  }
}
