import { Component, OnInit } from '@angular/core';
import { Product } from './product';
import { ProductServiceService } from './product-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'ecommerce-client';
  featuredProducts: Product[] = [];

  constructor(private productService: ProductServiceService) {}

  ngOnInit() {
    this.productService.queryFeaturedProducts()
      .subscribe((res: Product[]) => {
        this.featuredProducts = res;
      });
  }

  shopNow() {
    this.productService.queryAllProducts()
      .subscribe((res: Product[]) => {
        console.log(res);
        // Open Shop Page
      });
  }

  shopNowByCategory(category: string) {
    this.productService.queryCategoryProducts(category)
      .subscribe((res: Product[]) => {
        console.log(res);
        // Open Shop Page
      });
  }

  goToCart() {
    console.log("Go to cart");
  }

  instagram() {
  }

  facebook() {
  }

  whatsapp() {
  }

  tiktok() {
  }
}
