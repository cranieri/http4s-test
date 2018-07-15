import cats.effect.IO
import com.example.quickstart.HelloWorldRoutes
import org.http4s._
import org.http4s.implicits._
import org.scalatest.{Matchers, WordSpec}

class HelloWorldSpec extends WordSpec with Matchers {

  "StatusRoutes" should {
    "return status (GET /status)" in {
      retHelloWorld.status shouldEqual Status.Ok
      retHelloWorld.as[String].unsafeRunSync() shouldEqual ("{\"message\":\"ok\"}")
    }
  }

  private[this] val retHelloWorld: Response[IO] = {
    val getHW = Request[IO](Method.GET, Uri.uri("/status"))
    new HelloWorldRoutes[IO].service.orNotFound(getHW).unsafeRunSync()
  }
}

