import { Component, OnInit } from '@angular/core';
import { UserService } from './user.service';
import { User } from './user';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent implements OnInit {
  
  public users?: User[];
  public deleteUser!: User;

  

  constructor(private userService: UserService){ }

  ngOnInit() {
    this.getUsers();
  }

  public getUsers(): void{
    this.userService.getUsers().subscribe(
      (response: User[])=>{
        this.users = response;
        console.log(response);
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
      });
    
  }

  public onAddUser(addForm:NgForm): void{
    this.userService.addUser(addForm.value).subscribe(
      (response: User) =>{
        console.log(response);
        this.getUsers();
        alert("add")
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      }
    );
   

  }

  public onDeleteUser(userId:number): void{
    this.userService.deleteUsers(userId).subscribe(
      (response: void) =>{
        console.log(response);
        this.getUsers();
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      }
    );

  }

  public searchUsers(key:String):void{
 
    const results:User[] = [];
    for(const user of this.users!){
      if(user.name.toLowerCase().indexOf(key.toLowerCase())!==-1 
      ||user.email.toLowerCase().indexOf(key.toLowerCase())!==-1){
        results.push(user);
      }
    }
   
    this.users = results;
    if(results.length === 0 || !key){
       this.getUsers();
    }

  }

  public onOpenModal(user:User,mode: string): void {
    console.log('openmodel');
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#user-form-modal');
    }
    if(mode ==='delete'){
      this.deleteUser = user;
    }
    
    container?.appendChild(button);
    console.log(container);
    button.click();
  }

  

}
 