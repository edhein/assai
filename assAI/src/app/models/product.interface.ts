export interface Product {
    startDate: string;
    productId: number;
    orderStatus: string;
    orderId: number;
    productType: ProductType;
    client?: Client;
}

export interface ProductType {
    prepareTime: number;
    price: number;
    productTypeId?: number;
    name: string;
}

export interface Client {
    name: string;
    id: number;
    telephone: number;
}
