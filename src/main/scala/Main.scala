package personal.dojo.zio

import zio.clock.{Clock, currentTime}
import zio.{ExitCode, URIO, ZIO, console}
import zio.console._

import java.io.IOException
import zio.console.Console

object Main extends zio.App {

  def run(args: List[String]): URIO[Console with Clock, ExitCode] =
    myAppLogic.exitCode


  val myAppLogic: ZIO[Console with Clock, IOException, Unit] = {
    console.putStr("asd").orDie

  for {
      _ <- putStrLn("Hello! What is your name?")
      name <- getStrLn
      _ <- putStrLn(s"Hello, ${name}, welcome to ZIO!")
    } yield ()
  }
}
