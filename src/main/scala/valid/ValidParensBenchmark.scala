package valid

import org.openjdk.jmh.annotations._
import org.openjdk.jmh.infra.Blackhole

@Fork(value = 1, warmups = 1)
@Warmup(iterations = 1)
@BenchmarkMode(Array(Mode.AverageTime))
@State(Scope.Benchmark)
class ValidParensBenchmark {

  @Param(Array("()", "()[]{}", "(]", "]", ")(){}"))
  var parens: String = _

  @Benchmark
  def isValidBenchmark(blackHole: Blackhole): Boolean = {
    val result: Boolean = ValidParensSolution.isValid(parens)
    blackHole.consume(result)
    result
  }
}
