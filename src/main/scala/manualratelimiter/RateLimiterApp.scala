package personal.dojo.zio
package manualratelimiter

import zio.ZIO
import zio.console.putStrLn

object RateLimiterApp extends zio.App {

  override def run(args: List[String]) = program.exitCode

  val program = for {
    limiter <- RateLimiter.make(perSecond = 1.0, buffer = 10)
    _ <- ZIO.foreach(List.range(1, 1000)) { i =>
      limiter.rateLimit(putStrLn(i.toString))
    }
  } yield ()

}
