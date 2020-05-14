import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './pages/home/home.component';
import { ShopComponent } from './pages/shop/shop.component';
import { AuthentificationGuard } from './helpers/authentification.guard';


const routes: Routes = [
  {path:"", component:HomeComponent, canActivate:[AuthentificationGuard]},
  {path:"shop", component:ShopComponent, canActivate: [AuthentificationGuard]},
  {path:"login", component:LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
