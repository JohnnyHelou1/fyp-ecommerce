import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from './product';
import { ProductServiceService } from './product-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'ecommerce-client';
  shopProducts: ShopProducts;

  constructor(private productService: ProductServiceService,
    private router: Router) { }

  ngOnInit() {
    this.productService.queryAllProducts()
      .subscribe((res: Product[]) => {
        this.shopProducts = { products: res };
      });
  }

  shopNow() {
    this.productService.queryAllProducts()
      .subscribe((res: Product[]) => {
        this.router.navigateByUrl('/shop-page', { state: { products: res } });
      });
  }
}

class ShopProducts {
  products: Product[]
}
