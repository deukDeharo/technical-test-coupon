# GERARD DE HARO TECHNICAL EXERCISE

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
4. CouponService is now using the CouponOutputPort interface instead of repository, in order to implement de defined logic in the application layer and not depending from the jpaRepository.This adheres to the Dependency Inversion Principle and facilitates the maintainability and testing of the code.

## Application
1. NotNull has been changed to NotEmpty in CouponRequestDTO.codes. It invalidates empty List and also a null List.
2. UseCase Interfaces have been created and implemented on the input layer.
3. CouponOutputPort and CouponOutputPortImpl have been created and used in the CouponService.
4. CouponUseCase is now using the useCases defined in the application layer and implementing the domain logic thanks to couponService.
5. CouponUseCase is beeing used by the CouponRestAdapter in order to comunicate Infrastructure with application.
6. Mappers have been created in order to transforms dtos to domain object, and domain objects to persistenceEntities.

## Infrastructure
1. Coupon as a database Entity is created as CouponPersistenceAdapter.
2. Coupon repository has been moved here and renamed as CouponPersistenceRepository.
3. It has been added a JPQL query in CouponPersistenceRepository that does the logic of getting coupons by a list of codes.
4. CouponResource has been moved to adpater/input/web/rest and renamed CouponRestAdapter.
5. Exception handler has been created for the CouponRestAdapter.
5. CouponRestAdapter (restcontroller) has been modified:

### CouponRestAdapter (restcontroller)
1. Changed mapping to @RequestMapping("/api/coupon").
2. Changed getCoupons by code funcitionality from @GetMapping("/coupons") to  @PostMapping("/search") 
3. It always return a ResponseEntity<DTO_OBJECTS> 
4. CreateCoupon route has been changed to @PostMapping("/")
5. Apply functionality has been changed


## Resources
### data.sql
1. Invisible chars in the .sql have been deleted. Now the data is being inserted successfully.
2. The files have been changed and splitted in schema.sql and data.sql
3. The types have been adapted.
4. Name coupons have been changed to coupon, respecting the entityDatabase design model.
5. Recommended the creation of an index for the queries that uses a search by code.

## Tests
1. Tests should be changed to a BDD integration test, using this template methodName_ExpectedBehavior
2. Should have an assertion when a function returns and a verify to check if the right functions are called the right times.
