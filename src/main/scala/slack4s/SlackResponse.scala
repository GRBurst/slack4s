package slack4s.slack4s

sealed trait SlackResponse[A]

case class Success[A](ok: Boolean, result: A) extends SlackResponse[A]

case class Failure(ok: Boolean, error: String) extends SlackResponse[Unit]

case class Warning[A](ok: Boolean, warning: String, result: A) extends SlackResponse[A]
