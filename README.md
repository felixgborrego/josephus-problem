Josephus Problem
================

Usage: `sbt "run [OPTION] nPlaces kSteps"`

Options:

    --verbose         More verbose output
    --solver <value>  Select an alternative impl: NonRecursiveFormula CircularList
    --help            prints this usage text
    nPlaces           the number of places in the circle (n)
    kSteps            the step rate (k)


Places are labeled from 0 to nPeople-1. Usage example: `sbt "run --verbose --solver CircularList 7 3"`

    Resolving Josephus problem for:
      Number of places: 7 [labeled from 0 to 6]
      Steps rate k: 3 [skipping 2 before killing next one]
         
    [debug] [step: 0] kill: 2, places: [0 1 2 3 4 5 6]
    [debug] [step: 1] kill: 5, places: [0 1 3 4 5 6]
    [debug] [step: 2] kill: 1, places: [0 1 3 4 6]
    [debug] [step: 3] kill: 6, places: [0 3 4 6]
    [debug] [step: 4] kill: 4, places: [0 3 4]
    [debug] [step: 5] kill: 0, places: [0 3]
    Survivor place: 3


Since we are only interested in the last survivor, the default implementation 
 is using a [mathematical formula](https://en.wikipedia.org/wiki/Josephus_problem#The_general_case).
 For reference purpose, there is an alternative implementation using a circular list too.

###Dependencies:

* [scallop](https://github.com/scopt/scopt) for parsing the command-line arguments & inline instructions
* [specs2](https://etorreborre.github.io/specs2/) as a testing framework.

### Testing

 `sbt test`
 
### Other implementations

[Josephus problem](https://en.wikipedia.org/wiki/Josephus_problem) is a well known math puzzle, 
you can find other implementations at:
 
- https://rosettacode.org/wiki/Josephus_problem#Scala
- https://github.com/rolandtritsch/scala-josephus/