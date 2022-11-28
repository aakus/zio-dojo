package experiments

import zio.*
import zio.Console.printLine
import zio.stream.ZStream

object HelloWorld extends ZIOAppDefault:

  val program = for {
    q <- Queue.unbounded[Int]

    in = ZStream.fromQueue(q).map(_ + 10)
    _ <- in.foreach(i => printLine(s"received $i")).fork
    _ <- ZStream
      .unfold(0)(a => Some((a, a + 1)))
//      .schedule(Schedule.spaced(1.seconds))
      .foreach(i =>
         q.offer(i)
      )

  } yield ()

  override def run = program.exitCode
