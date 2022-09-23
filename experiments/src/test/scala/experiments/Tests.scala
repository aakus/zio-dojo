package experiments

import zio.*
import zio.test.{test, *}

object Tests extends ZIOSpecDefault:
  def spec = suite("suite")(
    test("updating ref") {
      for
        r <- Ref.make(0)
        _ <- r.update(_ + 1)
        v <- r.get
      yield assertTrue(v == 1)
    }
  )
