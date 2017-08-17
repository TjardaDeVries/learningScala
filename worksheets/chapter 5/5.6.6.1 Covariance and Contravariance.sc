// !! Functions are contravariant in terms of their arguments
// and covariant in terms of their return type.

// Siamese <: Cat <: Animal
// Purr <: CatSound <: Sound
//
//
// def groom(groomer: Cat => CatSound): CatSound =
// val oswald = Cat("Black", "Cat food")
// groomer(oswald)
// }


// A function of type Animal => Purr
// ok, because Animal is a supertype of Cat
// and Purr is a subtype of CatSound

// A function of type Siamese => Purr
// not ok, because Siamese is a subtype of Cat

// A function of type Animal => Sound
// not ok, because Sound is a supertype of CatSound


