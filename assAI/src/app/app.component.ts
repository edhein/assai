import { Component, DestroyRef, OnInit } from "@angular/core";
import { takeUntilDestroyed } from "@angular/core/rxjs-interop";
import { ProductService } from "./services/product.service";
import { ProductMapper } from "./models/product.mapper";
import { Product, ProductType } from "./models/product.interface";

@Component({
    selector: "app-root",
    templateUrl: "./app.component.html",
    styleUrls: ["./app.component.scss"]
})
export class AppComponent implements OnInit {
    constructor(private service: ProductService, private destroyRef: DestroyRef, private mapper: ProductMapper) {}

    products: Product[] = [];
    productTypes: ProductType[] = [];
    clientId = "1";

    ngOnInit() {
        this.listActiveProduts();
        this.getProductTypes();
    }

    public listActiveProduts() {
        this.service
            .listActiveProducts(this.clientId)
            .pipe(takeUntilDestroyed(this.destroyRef))
            .subscribe((response) => {
                this.products = response.map(this.mapper.view);
            });
    }

    public getProductTypes() {
        this.service
            .getProductTypes(this.clientId)
            .pipe(takeUntilDestroyed(this.destroyRef))
            .subscribe((response) => {
                this.productTypes = response;
            });
    }
}
