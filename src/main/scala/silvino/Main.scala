package silvino

import scala.annotation.tailrec
import scala.util.Try

object Main {

  def main(args: Array[String]): Unit = {
    validateInput(args.toList).fold(
      println,
      input => {
        findSurvivor(input._1, input._2).fold(println, println)
      }
    )
  }

  implicit class StringNumber(s: String) {
    def convert: Option[Int] = Try(s.toInt).fold(t => None, i => Some(i))
  }

  implicit class PositiveNumber(n: Int) {
    def isPositive: Boolean = n > 0
  }

  def validateInput(args: List[String]): Either[String, (Int, Int)] = {

    if (args.size < 2) {
      Left("missing one of both input parameters")
    } else if (args.size > 2) {
      Left("too many arguments passed in")
    } else {
      val res = for {
        n <- args.head.convert
        k <- args.tail.head.convert
      } yield if (!n.isPositive || !k.isPositive) Left("input must be positive") else Right((n, k))


      res getOrElse Left("input not valid integers")
    }
  }

  /**
    * Run the Josephus problem
    * 
    * @param people - number of people to start out with.
    * @param step - the interval to eliminate people in
    */
  def findSurvivor(people: Int, step: Int): Either[String, Int]= {

    @tailrec
    def helper(n: Int, k: Int, total: Int): Int = {
      if (n == 0) {
        total
      } else {
        helper(n - 1, k + 1, (total + step - 1) % k + 1)
      }
    }

    if (!people.isPositive || !step.isPositive) {
      Left("people and step must be positive")
    } else {
      Right(helper(people, 1, 1))
    }
  }
}
