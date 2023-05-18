import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import { MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatListModule} from '@angular/material/list';
import {MatDividerModule} from '@angular/material/divider';
// import {MatLineModule} from '@angular/material/line';

import { SignupComponent } from './common-components/signup/signup.component';
import { LoginComponent } from './common-components/login/login.component';
import { HomeComponent } from './common-components/home/home.component';
import { HeaderComponent } from './common-components/header/header.component';
import { AdminDashboardComponent } from './admin-components/admin-dashboard/admin-dashboard.component';
import { UserDashboardComponent } from './user-components/user-dashboard/user-dashboard.component';
import { authInterceptorProviders } from './authentication/auth.interceptor';
import { ProfileComponent } from './common-components/profile/profile.component';
import { ForgotPasswordComponent } from './common-components/forgot-password/forgot-password.component';
import { ShowCategoryComponent } from './user-components/show-category/show-category.component';
import { AddCategoryComponent } from './admin-components/add-category/add-category.component';
import { ShowQuizComponent } from './common-components/show-quiz/show-quiz.component';
import { ScoreComponent } from './user-components/score/score.component';
import { ShowQuestionsComponent } from './user-components/show-questions/show-questions.component';
import { AddQuizComponent } from './admin-components/add-quiz/add-quiz.component';
import { QuizResultComponent } from './user-components/quiz-result/quiz-result.component';

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LoginComponent,
    HomeComponent,
    HeaderComponent,
    AdminDashboardComponent,
    UserDashboardComponent,
    ProfileComponent,
    ForgotPasswordComponent,
    ShowCategoryComponent,
    AddCategoryComponent,
    ShowQuizComponent,
    ScoreComponent,
    ShowQuestionsComponent,
    AddQuizComponent,
    QuizResultComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatSnackBarModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatListModule,
    MatDividerModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
