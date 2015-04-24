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

    "function1 must return correct value" in {
      val res = function1(3, 5)
      val expected = 8

      if(res == expected) {
        push("assert1", res.toString)
      }

      res mustEqual expected
    }

    "function2 must return correct value" in {
      val res = function2()
      val expected = 233168

      if(res == expected) {
        push("assert2", res.toString)
      }

      res mustEqual expected
    }

    "function3 must return correct value" in {
      val res = function3()
      val expected = 4613732

      if(res == expected) {
        push("assert3", res.toString)
      }

      res mustEqual expected
    }
  }

  def push(assert: String, result: String) = {
    val message = s"""$username&$assert&$result"""
    pusher.trigger(channel, event, Collections.singletonMap("message", message));
  }
}


