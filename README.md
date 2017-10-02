For this assignment, we would like you to implement code that solves the a counting out problem.  In these problems, you are in a circle.  From some starting point, X you count k people.  If you are standing in that kth spot, you are ‘out’.  The counting continues until there is one person standing.  A concrete, but morbid, example of this is the Josephus Problem (https://en.wikipedia.org/wiki/Josephus_problem).

 

For this exercise…

 

Create an application that takes in 2 parameters: the number of people in the circle (n) and the step rate (k).  For example, if k is the step rate, then you skip k-1 people and eliminate the kth person.  The output of the program should be the place you need to stand in the circle to be the last person left.

 

The assignment must…

Use any language, preferably one that we use at Nitro (Scala, Golang, Elixir)
Include a build definition. For example, build and run using SBT (http://www.scala-sbt.org/).  After submission, we should be able to run sbt test and all tests should pass.  Also, we will execute the application using sbt “run n k” (where n and k are the parameters).
Be submitted via Github
Have a readme.md explaining how to run the application (simple, no need to be overly verbose)
Have tests associated with the assignment.  One potential framework you can use is Specs2 (https://etorreborre.github.io/specs2/), but feel free to use any test framework you want.  Make sure your tests cover the following scenarios
Invalid parameters
What happens if n = k?
What happens if n = 3 and k = 2?
What happens if n is very large, but k =2?
Choose a couple of other cases to test