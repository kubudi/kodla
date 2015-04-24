package asserts

import scala.annotation.tailrec

object Workshop {

  //Sum of given numbers
  def function1(num1: Int, num2: Int) = {
    num1 + num2
  }

  //euler1
  def function2() = {
    (1 to 999).filter(i => i % 3 == 0 || i % 5 == 0).sum
  }

  //euler2
  def function3() = {
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
}