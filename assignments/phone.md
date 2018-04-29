# phone

An interface is often called Java's answer to its lack of multiple-inheritance. In a sense, it is true; it allows 
for the emulation of a type hierarchy which, at first glance, seems to allow for multiple-inheritance.
However, this is not always the case.

An interface allows for the abstraction of the responsibilities a class, or even, a series of related classes 
may have. By delegating and declaring these class responsibilities (in the form of methods written
in the interface), we specifically encapsulate these responsibilities and give them a concrete 
representation in high-level design. This is often not possible, or is not best served by the 
inclusion of a superclass which other classes may extend.

Phone is a basic example of how an interface serves the purpose stated above. There are three interfaces you can
look at in the file:

* `Communcator.java`
* `Mobile.java`
* `Wireless.java`

Two of these interfaces are implemented by the classes below:

* `Landline.java`
* `PayPhone.java`

Take a look at *how* and *why* these classes implement their respective interfaces, and ask yourself
if the same behaviour could have been, or even should have been modelled by classical superclassing.

It will be your task in this assignment to complete the implementation of `CellPhone.java`. Notice that 
it is almost entirely empty. Don't worry! This will be one of the most straightforward classes you write!
Think about the responsibilities your phone has; it's able to make/answer calls, send text messages,
and access the internet. All of this behaviour has been specified in the 3 interfaces which have already been
declared for you. I'm not looking for anything fancy in your implementation of the methods,
but it should be similar to the examples already written. 

Don't forget to test what you can!