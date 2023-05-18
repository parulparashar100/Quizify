import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './common-components/login/login.component';
import { SignupComponent } from './common-components/signup/signup.component';
import { HomeComponent } from './common-components/home/home.component';
import { AdminDashboardComponent } from './admin-components/admin-dashboard/admin-dashboard.component';
import { UserDashboardComponent } from './user-components/user-dashboard/user-dashboard.component';
import { AdminGuard } from './authentication/admin.guard';
import { AuthGuard } from './authentication/auth.guard';
import { ProfileComponent } from './common-components/profile/profile.component';
import { ForgotPasswordComponent } from './common-components/forgot-password/forgot-password.component';
import { ShowCategoryComponent } from './user-components/show-category/show-category.component';
import { AddCategoryComponent } from './admin-components/add-category/add-category.component';
import { ShowQuizComponent } from './common-components/show-quiz/show-quiz.component';
import { ScoreComponent } from './user-components/score/score.component';
import { ShowQuestionsComponent } from './user-components/show-questions/show-questions.component';
import { AddQuizComponent } from './admin-components/add-quiz/add-quiz.component';

const routes: Routes = [
  {path: "", component: HomeComponent},
  {path: "signup", component: SignupComponent},
  {path: "login", component: LoginComponent},
  {path: "forgot-password", component: ForgotPasswordComponent},
  {path: "admin-dashboard", component:AdminDashboardComponent, canActivate: [AdminGuard], 
  children: [
    {path: "", component: HomeComponent},
    {path: "profile", component: ProfileComponent},
    {path: "show-category", component: ShowCategoryComponent},
    {path: "add-category", component: AddCategoryComponent},
    {path: "show-quiz", component: ShowQuizComponent},
    {path: "add-quiz", component: AddQuizComponent}
  ]},
  {path: "user-dashboard", component: UserDashboardComponent, canActivate: [AuthGuard],
  children: [
    {path: "", component: HomeComponent},
    {path: "profile", component: ProfileComponent},
    {path: "show-category", component: ShowCategoryComponent},
    {path: "show-quiz", component: ShowQuizComponent},
    {path: "score", component: ScoreComponent},
    {path: "show-questions/:id", component: ShowQuestionsComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
