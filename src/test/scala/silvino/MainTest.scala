package silvino

import org.scalatest._

class MainTest extends FlatSpec with Matchers {

  "Valid input" should "only be two integers" in {
    val validInput = Main.validateInput(List("10", "11"))

    validInput.right.get should be (10, 11)
  }

  "Invalid input" should "return an error message" in {

    Main.validateInput(List("")) should be ('left)
    Main.validateInput(List("test")) should be ('left)
    Main.validateInput(List("10", "test")) should be ('left)
    Main.validateInput(List("1", "3", "4")) should be ('left)
  }

  "Finding surviors" should "work for different combinations of people, and steps" in {

    Main.findSurvivor(8, 2).right.get should be (1)
    Main.findSurvivor(9, 2).right.get should be (3)
    Main.findSurvivor(1, 2).right.get should be (1)
    Main.findSurvivor(41, 2).right.get should be (19)
  }

  "Finding survivors" should "handle when people equals number of steps" in {
    Main.findSurvivor(1, 1).right.get should be (1)
    Main.findSurvivor(2, 2).right.get should be (1)
    Main.findSurvivor(10, 10).right.get should be (8)
    Main.findSurvivor(41, 41).right.get should be (13)
    Main.findSurvivor(3, 2).right.get should be (3)
  }

  "Finding survivors" should "return error messages when invalid parameters are passed" in {

    Main.findSurvivor(-1, 0) should be ('left)
    Main.findSurvivor(-100, -100) should be ('left)
    Main.findSurvivor(100, -1) should be ('left)
  }
}
