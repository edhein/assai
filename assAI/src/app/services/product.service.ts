import { HttpClient } from "@angular/common/http";
import { Product } from "../interfaces/product.interface";
import { Injectable } from "@angular/core";

@Injectable()
export class ProductService {
    constructor(private http: HttpClient) {}

    private baseUrl = "http://localhost:3030/";

    getActiveProducts(storeId: string) {
        return this.http.get<[Product]>(`${this.baseUrl}store/products/${storeId}`);
    }
}
