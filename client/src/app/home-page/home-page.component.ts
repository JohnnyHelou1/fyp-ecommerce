import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../product';
import { ProductServiceService } from '../product-service.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  featuredProducts: Product[] = [];

  constructor(private productService: ProductServiceService,
              private router: Router) {}

  ngOnInit() {
    this.productService.queryFeaturedProducts()
      .subscribe((res: Product[]) => {
        this.featuredProducts = res;
      });
  }

  shopNow() {
    this.productService.queryAllProducts()
      .subscribe((res: Product[]) => {
        this.router.navigateByUrl('/shop-page', { state : { products : res} });
      });
  }

  shopNowByCategory(category: string) {
    this.productService.queryCategoryProducts(category)
      .subscribe((res: Product[]) => {
        this.router.navigateByUrl('/shop-page', { state : { products : res} });
      });
  }

  instagram() {
    window.open('https://www.instagram.com/carecon.sarl/', "_blank");
  }

  facebook() {
    window.open('https://www.facebook.com/carecon.sarl', "_blank");
  }

  whatsapp() {
    window.open('https://wa.me/+96181342774', "_blank");
  }

  tiktok() {
    window.open('https://www.tiktok.com/@carecon.sarl', "_blank");
  }
}