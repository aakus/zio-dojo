package experiments

import net.objecthunter.exp4j.ExpressionBuilder
import zio.ZIOAppDefault

@main def print() =
  val b = new ExpressionBuilder("(4+((5+(7*(9*1)))+1))")
  println(b.build().evaluate().round.toInt)

