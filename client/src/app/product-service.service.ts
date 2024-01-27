import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  constructor(private http: HttpClient) {}

  queryFeaturedProducts(): Observable<Product[]> {
    return this.http.get<Product[]>('/ecommerce/products/featured');
  }

  queryAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>('/ecommerce/products');
  }

  queryCategoryProducts(category: string): Observable<Product[]> {
    return this.http.get<Product[]>('/ecommerce/products/categories/' + category);
  }
}
