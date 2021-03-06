package com.example.quickstart

import cats.effect.Effect
import io.circe.Json
import org.http4s.HttpService
import org.http4s.circe._
import org.http4s.dsl.Http4sDsl

class HelloWorldRoutes[F[_]: Effect] extends Http4sDsl[F] {

  val service: HttpService[F] = {
    HttpService[F] {
      case GET -> Root / "status" =>
        Ok(Json.obj("message" -> Json.fromString(s"ok")))
    }
  }
}
