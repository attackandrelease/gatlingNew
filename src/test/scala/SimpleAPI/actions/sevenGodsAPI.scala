package SimpleAPI.actions

import io.gatling.http.Predef._
import io.gatling.core.Predef._

package object simpleAPI {

  val httpConf = http.baseUrl("https://gatling.io")

  val gatling = exec(
    http("Get Gatling page")
      .get("/")
      .check(status is(200))
  )
}