import { Component, Input, OnInit } from "@angular/core";
import { Product } from "src/app/interfaces/product.interface";

@Component({
    selector: "app-product-card",
    templateUrl: "./productCard.component.html",
    styleUrls: ["./productCard.component.scss"]
})
export class ProductCardComponent implements OnInit {
    constructor() {}

    @Input({ required: true }) product = <Product>{};
    @Input({ required: true }) index = 0;

    progress = 0;
    private intervalId: any;

    ngOnInit() {
        this.calculateProgressBar();
    }

    ngOnDestroy() {
        if (this.intervalId) {
            clearInterval(this.intervalId);
        }
    }

    calculateProgressBar() {
        const startTime = new Date(this.product.startDate).getTime();
        const duration = this.product.prepareTime;
        const endTime = startTime + duration;

        this.intervalId = setInterval(() => {
            const now = Date.now();
            const elapsedTime = now - startTime;
            this.progress = Math.min(Math.max((elapsedTime / duration) * 100, 0), 100);

            if (now >= endTime) {
                clearInterval(this.intervalId);
                this.progress = 100;
            }
        }, 100);
    }
}
