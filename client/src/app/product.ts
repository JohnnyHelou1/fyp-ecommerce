export class Product {
  productID: number
  name: string
  description: string
  price: number
  category: string
  featured: boolean
  images: ProductImage[]
}

export class ProductImage {
  id: number
  image: number[]
}