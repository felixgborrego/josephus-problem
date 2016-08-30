package util

/**
  * Basic logger.
  */
trait Logger {
  def debug(x: => Any): Unit
}

object DummyLogger extends Logger {
  def debug(msg: => Any): Unit = {}
}

object VerboseLogger extends Logger {
  def debug(msg: => Any): Unit = println(s"[debug] $msg")
}