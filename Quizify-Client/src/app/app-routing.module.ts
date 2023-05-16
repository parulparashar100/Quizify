import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './common-components/login/login.component';
import { SignupComponent } from './common-components/signup/signup.component';
import { HomeComponent } from './common-components/home/home.component';

const routes: Routes = [
  {path: "", component: HomeComponent},
  {path: "signup", component: SignupComponent},
  {path: "login", component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
