import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Product, ProductType } from "../models/product.interface";
import { ProductMapper } from "../models/product.mapper";

@Injectable()
export class ProductService {
    constructor(private http: HttpClient, private mapper: ProductMapper) {}

    private baseUrl = "http://localhost:3030/store";

    listActiveProducts(storeId: string) {
        return this.http.get<[Product]>(`${this.baseUrl}/products/${storeId}`);
    }

    getProductTypes(storeId: string) {
        return this.http.get<[ProductType]>(`${this.baseUrl}/product-types/${storeId}`);
    }

    addProduct(productType: ProductType) {
        return this.http.post<any>(`${this.baseUrl}/product`, this.mapper.productDto(productType));
    }

    updateProduct(orderId: number, status: string) {
        return this.http.put<any>(`${this.baseUrl}/order/${orderId}`, { orderId, status });
    }

    cancelProduct(productId: number) {
        return this.http.delete<any>(`${this.baseUrl}/product/${productId}`);
    }
}
