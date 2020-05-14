import { BrowserModule } from "@angular/platform-browser";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { NgModule } from "@angular/core";
import { CarouselModule } from "ngx-owl-carousel-o";
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { HeaderComponent } from "./components/header/header.component";
import { HeroSectionComponent } from "./components/hero-section/hero-section.component";
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
import { BannerComponent } from './components/banner/banner.component';
import { WomenComponent } from './components/women/women.component';
import { MenComponent } from './components/men/men.component';
import { WeekDealComponent } from './components/week-deal/week-deal.component';
import { InstagramComponent } from './components/instagram/instagram.component';
import { OffresComponent } from './components/offres/offres.component';
import { FooterComponent } from './components/footer/footer.component';
import { StoreComponent } from './components/store/store.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './pages/home/home.component';
import { ShopComponent } from './pages/shop/shop.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { JwtInterceptor } from './helpers/JwtIntercepter';

@NgModule({
  declarations: [AppComponent, HeaderComponent, HeroSectionComponent, BannerComponent, WomenComponent, MenComponent, WeekDealComponent, InstagramComponent, OffresComponent, FooterComponent, StoreComponent, LoginComponent, HomeComponent, ShopComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    BrowserAnimationsModule,
    CarouselModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },

  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
