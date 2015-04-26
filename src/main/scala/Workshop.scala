package asserts

import scala.annotation.tailrec

object Workshop {
//=========================================================================
//Sum of given two numbers
  def function1(a: Int, b: Int) = {
    a + b
  }
//=========================================================================
//Calculate Hypotenuse
//Hint: Use Math.sqrt()
  def function2(a: Int, b: Int) = {
    Math.sqrt(a*a + b*b)
  }
//=========================================================================
//Assignment
  def functionAssign() = {
    //assign
    var mutable = Math.random
    val immutable = Math.random
    def func = Math.random

    //reassign
    //mutable = 4
    //immutable = 4
    //func = 4


    //println("mutable: " + mutable)
    //println("immutable: " + immutable)
    //println("func: " + func)
  }
//=========================================================================
//Create Tuple
//Hint: Representation => (value1, value2)
  def function3(a: Int, b: Int) = {
    (a, b)
  }
//=========================================================================
//Sum of a list
  def function4(l: List[Int]) = {
    l.sum
  }
//=========================================================================
//Find sum of even numbers in list
//Hint: filter
  def function5(l: List[Int]) = {
    l.filter(e => e%2 == 0).sum
  }
//=========================================================================
//Find sum of all numbers except the ones divisible by 5
//Hint: filterNot
  def function6(l: List[Int]) = {
    // l.filter(e => e%5 != 0).sum

    l.filterNot(e => e%5 == 0).sum
  }
//=========================================================================
//Multiply all elements with 2
//Hint: map
  def function7(l: List[Int]): List[Int] = {
    //l.map(e => e*2)

    l.map(_*2)
  }
//=========================================================================
//Merge two lists into one
//Hint: zip
  def function8(name: List[String], surname: List[String]) = {
    // name.zip(surname)

    name zip surname
  }
//=========================================================================
//Currying function
  def function9(a: Int) = {
    def power(exponent: Int)(number: Int): Int = {
      if(exponent == 0)
        1
      else
        number * power(exponent-1)(number)
    }

    def square = power(2)_
    def cube = power(3)_

    square(a) + cube(a)
  }
//=========================================================================
//Imperative euler2
  def function10() = {
    var sum = 0
    var prev = 1
    var curr = 1

    while (curr < 4000000) {
      if(curr%2 == 0)
        sum +=curr
      curr += prev
      prev = curr - prev
    }

    sum
  }
//=========================================================================
//Recursive euler2
  def function11() = {
    @tailrec
    def iter(prev: Int, curr: Int, sum: Int): Int =
      if(curr < 4000000) {
        val newSum = 
          if(curr % 2 == 0)
            sum + curr
          else
            sum

        iter(curr, curr + prev, newSum)
      }
      else sum

    iter(1, 1, 0)
  }
//=========================================================================
//Pattern matching
abstract class Animal

case class Cat extends Animal
case class Dog extends Animal

  def function12(a: Animal) = {
    a match {
      case d:Dog => "hav"
      case c:Cat => "miyav"
    }
  }
//=========================================================================

}
