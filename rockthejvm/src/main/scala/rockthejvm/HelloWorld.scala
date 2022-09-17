package rockthejvm

import zio.*

object HelloWorld extends ZIOAppDefault:

  def run =
    ZIO.attempt(
      println("hello world")
    )
