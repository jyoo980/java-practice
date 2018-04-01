# bank

In this assignment, you'll utilize what you know about polymorphism, subtyping, and supertyping to 
reduce the amount of complexity in this project and make your code much more cleaner. Below are the
tasks which you'll need to complete for this project.

1. Write unit tests for both the `StudentAccount`, `RegularAccount`, and the `Bank` classes. It is 
extremely important that have complete unit tests before starting to refactor your code. Remember that 
unit tests act as a guide for us to make sure that our code refactoring has affected only the <i>structure</i>
of our code, not its behaviour. 
2. Take a look at the `StudentAccount` and the `RegularAccount` classes. Notice that there is a large
amount of duplicated code. Refactor where necessary, and extract shared logic into a superclass that these classes
can both extend.
3. Run your unit tests for the `StudentAccount` and `RegularAccount` classes, make sure that they pass.
4. Take a look at the `Bank` class. Is there a reason to refactor this class? After making `StudentAccount` and
`RegularAccount` extend the behaviour of some superclass, is there a need for methods specific to each type?

This project is probably the most involved one we've tackled so far. Here are some tips to help you through

* Go <i>slow</i>, it's better to end up with a nicely refactored project than to rush through and do it incorrectly
* Draw out some dependencies. How does class A differ from class B? Writing things out on paper is more helpful than you think
* Work incrementally and <i>test often</i>. Don't make a ton of changes at once and expect things to just work, 
make some small changes, test that those changes are successful, and then move on.

Good luck!
