# JEE Project

> Swagger.IO : http://localhost:8080

### Feature
- Sneaker price for all User changes based on sneaker like count
    > This is one is automatic on each like, it will refresh the price.
- User gets a discount on 1 sneaker based on his level. He gains level the more his wishlist contains sneakers !
      > To test this functionnaly, you must call this endpoint : http://localhost:8080/v1/sneakers/price as a GET method and provide in the body 
    > 
    >````json
    >{
    >   "userId": "1",
    >   "sneakerId": "363a40f7-923b-4cd0-b628-241dc6f889ab"
    >}
    >````

### API
> There is a total of 4 API
- User
- WishList
- Sneaker
- Ranking (Like)
