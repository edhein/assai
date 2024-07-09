import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { MatIconModule } from "@angular/material/icon";
import { AppComponent } from "./app.component";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { ProductCardComponent } from "./components/productCard/productCard.component";
import { MatButtonModule } from "@angular/material/button";
import { MatProgressBarModule } from "@angular/material/progress-bar";
import { ProductService } from "./services/product.service";
import { HttpClientModule } from "@angular/common/http";

@NgModule({
    declarations: [AppComponent, ProductCardComponent],
    imports: [
        BrowserModule,
        MatIconModule,
        BrowserAnimationsModule,
        MatButtonModule,
        MatProgressBarModule,
        HttpClientModule
    ],
    providers: [ProductService],
    bootstrap: [AppComponent]
})
export class AppModule {}
