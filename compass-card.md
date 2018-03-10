# compass-card

In this project, you'll be completing the design of a class which represents a compass card issued by [Translink](https://www.translink.ca/). There are a number of requirements you'll need to complete, so read the following sections very carefully.

## Requirements

Your project will need to fulfill the following requirements. 

* A call to the constructor for the class `CompassCard` will instantiate one `CompassCard` with no stored value, no stored points, and no stored trips. 
* `get` methods should return their respective values. For example, a method `getX` of a class will return `X` field of the class.
* `loadValue` will add the given value onto the `storedValue` of the `CompassCard`.
* `rideBus` will control the flow of execution such that if there is a `storedTrip` available on the card, it will be used. Otherwise, it will call the method `payCorrectFare`.
* `payCorrectFare` will call a function which deducts the correct amount of money from `storedValue` according to the type of `Rider`. 
* `deductFare` will deduct the correct amount of money and call a function which handles the point awarding to the `CompassCard`, else, it will return false and no money shall be deducted. 

## Testing
Software testing and validation is a large part of the skills you will begin to grow with this project. 