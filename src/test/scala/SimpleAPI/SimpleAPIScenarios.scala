package SimpleAPI

import scala.concurrent.duration._
import io.gatling.core.Predef._
import SimpleAPI.actions.simpleAPI

object SimpleAPIScenarios {

  val getGatling = scenario("login")
    .exec(
      simpleAPI.gatling
    )
}

class SimpleAPISimulations extends Simulation {
  setUp(
    SimpleAPIScenarios.getGatling.inject(
      constantUsersPerSec(1) during(3)))
    .maxDuration(1 minute).protocols(simpleAPI.httpConf.disableCaching)
}