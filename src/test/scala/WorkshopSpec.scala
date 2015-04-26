package asserts

import org.specs2._
import Workshop._
import com.pusher.rest._
import java.util.Collections
import com.typesafe.config.ConfigFactory

class WorkshopSpec extends mutable.Specification {
  val conf = ConfigFactory.load()
  val username = conf.getString("username")

  val pusher = new Pusher(conf.getString("app_id"), conf.getString("key"), conf.getString("secret"))
  val channel = conf.getString("channel")
  val event = conf.getString("event")

  "Functions" should {

    "function1 must calculate sum of 3 + 4" in {
      val res = function1(3, 4)
      val expected = 7

      if(res == expected)
        push("assert1", res.toString)

      res mustEqual expected
    }

    "function2 must calculate Hypotenuse for 3 and 4" in {
      val res = function2(3, 4)
      val expected = 5

      if(res == expected)
        push("assert2", res.toString)

      res mustEqual expected
    }

    "function3 must create a tuple with 3 and 4" in {
      val res = function3(3, 4)
      val expected = (3, 4)

      if(res == expected)
        push("assert3", res.toString)

      res mustEqual expected
    }

    "function4 must calculate sum of a list form 1 to 100" in {
      val res = function4((1 to 100).toList)
      val expected = 5050

      if(res == expected)
        push("assert4", res.toString)

      res mustEqual expected
    }

    "function5 must calculate sum of even numbers in a list form 1 to 100" in {
      val res = function5((1 to 100).toList)
      val expected = 2550

      if(res == expected)
        push("assert5", res.toString)

      res mustEqual expected
    }

    "function6 must calculate sum of numbers not divisible by 5" in {
      val res = function6((1 to 100).toList)
      val expected = 4000

      if(res == expected)
        push("assert6", res.toString)

      res mustEqual expected
    }

    "function7 must multiply all values in the list with 2" in {
      val res = function7((1 to 5).toList)
      val expected = List(2,4,6,8,10)

      if(res == expected)
        push("assert7", res.toString)

      res mustEqual expected
    }

    "function8 must merge two list into one" in {
      val res = function8(List("Ali", "Veli", "Hasan"), List("Oz", "Ak", "Can"))
      val expected = List(("Ali","Oz"), ("Veli","Ak"), ("Hasan","Can"))

      if(res == expected)
        push("assert8", res.toString)

      res mustEqual expected
    }

    "function9 calculate sum of square and cube of a given number" in {
      val res = function9(2)
      val expected =  12

      if(res == expected)
        push("assert9", res.toString)

      res mustEqual expected
    }

    "function10 should solve project euler 2 imperatively" in {
      val res = function10()
      val expected =  4613732

      if(res == expected)
        push("assert10", res.toString)

      res mustEqual expected
    }

    "function11 should solve project euler 2 recursively" in {
      val res = function11()
      val expected = 4613732

      if(res == expected)
        push("assert11", res.toString)

      res mustEqual expected
    }

    "function12 bark and meow accordingly" in {
      val res = function12(new Dog)
      val expected = "hav"

      val res2 = function12(new Cat)
      val expected2 = "miyav"

      if(res == expected && res2 == expected2)
        push("assert12", res.toString)

      res mustEqual expected
      res2 mustEqual expected2
    }
  }

  def push(assert: String, result: String) = {
    val message = s"""$username&$assert&$result"""
    pusher.trigger(channel, event, Collections.singletonMap("message", message));
  }
}


