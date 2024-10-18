# Todo
* Add create endpoint

# Changes - Review:

## Directories - Project Structure
Reading the names of the directories, it has benn assumed that there was an intention of splitting the layers in an Hexagonal architecture. 
The division have been done that way:
1. application
2. domain
3. infrastructure

## Domain
1. Coupon and Basket are object domain and are saved in ./model
2. BigDecimal is changed to Double in Coupon.discount, Coupon.minBasketValue and Basket.appliedDiscount. Double is more efficient and for this use case it is not needed the preccission of a BigDecimal.
3. boolean type is switched to Boolean, as it is more recommended for OOP. 
4. CouponService is now implementing the useCases defined in the application layer.
5. CouponService is now using the CouponOutputPort interface instead of repository, in order to implement de defined logic in the application layer and not depending from the jpaRepository.This adheres to the Dependency Inversion Principle and facilitates the maintainability and testing of the code.

## Infrastructure
1. Coupon as a database Entity is created as CouponPersistenceAdapter.
2. It has been added a new derive query in CouponPersistenceRepository that does the logic of getting coupons by a list of codes.

## Application
1. NotNull has been changed to NotEmpty in CouponRequestDTO.codes. It invalidates empty List and also a null List.
2. UseCase Interfaces have been created and implemented on the services.
3. CouponOutputPort and CouponOutputPortImpl have been created and used in the CouponService.

## Resources
### data.sql
Invisible chars in the .sql have been deleted. Now the data is being inserted successfully.
