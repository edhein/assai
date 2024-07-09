import { Injectable } from "@angular/core";
import { Product, ProductType } from "./product.interface";

@Injectable({ providedIn: "root" })
export class ProductMapper {
    constructor() {}
    view = (params: any): Product => {
        console.log(params);
        return {
            startDate: params.startDate,
            productId: params.productId,
            orderStatus: params.orderStatus,
            orderId: params.orderId,
            productType: {
                prepareTime: params.prepareTime,
                price: params.price,
                name: params.productName
            },
            client: {
                name: params.clientName,
                id: params.clientId,
                telephone: params.clientTelephone
            }
        };
    };

    productDto(params: ProductType): any {
        return {
            startDate: new Date().toISOString(),
            productTypeId: params.productTypeId,
            name: params.name
        };
    }
}
