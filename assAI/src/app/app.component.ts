import { Component, DestroyRef, OnInit } from "@angular/core";
import { Product } from "./interfaces/product.interface";
import { takeUntilDestroyed } from "@angular/core/rxjs-interop";
import { ProductService } from "./services/product.service";

@Component({
    selector: "app-root",
    templateUrl: "./app.component.html",
    styleUrls: ["./app.component.scss"]
})
export class AppComponent implements OnInit {
    constructor(private service: ProductService, private destroyRef: DestroyRef) {}

    products: Product[] = [];
    clientId = "1";

    ngOnInit() {
        this.listActiveProduts();
    }

    public listActiveProduts() {
        this.service
            .getActiveProducts(this.clientId)
            .pipe(takeUntilDestroyed(this.destroyRef))
            .subscribe((response) => {
                this.products = response;
            });
    }
}
