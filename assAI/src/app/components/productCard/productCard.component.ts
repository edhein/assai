import { Component, DestroyRef, EventEmitter, Input, OnInit, Output } from "@angular/core";
import { takeUntilDestroyed } from "@angular/core/rxjs-interop";
import { Product, ProductType } from "src/app/models/product.interface";
import { ProductService } from "src/app/services/product.service";

@Component({
    selector: "app-product-card",
    templateUrl: "./productCard.component.html",
    styleUrls: ["./productCard.component.scss"]
})
export class ProductCardComponent implements OnInit {
    constructor(private service: ProductService, private destroyRef: DestroyRef) {}

    @Input() product = <Product>{};
    @Input() isNewRegister = false;
    @Input({ required: true }) productTypes: ProductType[] = [];
    @Input() index = 0;
    @Output() updateScreen = new EventEmitter();

    progress = 0;
    productTypeSelected: ProductType = <ProductType>{};
    remainingTime = "";

    private intervalId: any;

    public ngOnInit() {
        this.calculateProgressBar();
    }

    public ngOnDestroy() {
        if (this.intervalId) {
            clearInterval(this.intervalId);
        }
    }

    public addProduct() {
        if (!this.productTypeSelected.productTypeId) {
            return;
        }

        this.service
            .addProduct(this.productTypeSelected)
            .pipe(takeUntilDestroyed(this.destroyRef))
            .subscribe(() => {
                this.updateScreen.emit();
            });
    }

    public cardAction(status: string) {
        if (this.product.client?.id) {
            this.service
                .updateProduct(this.product.orderId, status)
                .pipe(takeUntilDestroyed(this.destroyRef))
                .subscribe(() => {
                    this.updateScreen.emit();
                });
        }

        this.service
            .cancelProduct(this.product.productId)
            .pipe(takeUntilDestroyed(this.destroyRef))
            .subscribe(() => {
                this.updateScreen.emit();
            });
    }

    private calculateProgressBar() {
        if (this.isNewRegister) {
            return;
        }

        const startTime = new Date(this.product.startDate).getTime();
        const duration = this.product.productType.prepareTime;
        const endTime = startTime + duration;

        this.intervalId = setInterval(() => {
            const now = Date.now();
            const elapsedTime = now - startTime;
            this.progress = Math.min(Math.max((elapsedTime / duration) * 100, 0), 100);

            if (now >= endTime) {
                clearInterval(this.intervalId);
                this.progress = 100;
            }

            this.updateRemainingTimeString(elapsedTime, duration);
        }, 100);
    }

    private updateRemainingTimeString(elapsedTime: number, duration: number) {
        const remainingTime = duration - elapsedTime;
        let timeString = "";

        const hours = Math.floor(remainingTime / 3600000);
        if (hours > 0) {
            timeString += `${hours}h `;
        }

        const minutes = Math.floor((remainingTime % 3600000) / 60000);
        if (hours > 0 || minutes > 0) {
            timeString += `${minutes}m `;
        }

        const seconds = Math.floor((remainingTime % 60000) / 1000);
        timeString += `${seconds}s`;

        this.remainingTime = timeString.trim();

        if (this.progress === 100) {
            this.remainingTime = "Pronto!";
        }
    }
}
