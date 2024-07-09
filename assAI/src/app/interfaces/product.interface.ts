export interface Product {
    productId: number;
    startDate: string;
    price: number;
    prepareTime: number;
    productName: string;
    orderStatus: string;
    clientName?: string;
    clientId?: number;
}
