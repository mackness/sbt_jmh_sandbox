package valid

import org.openjdk.jmh.annotations.{Benchmark, BenchmarkMode, Mode}
import org.openjdk.jmh.infra.Blackhole

class ValidParensBenchmark {

  @Benchmark
  @BenchmarkMode(Array(Mode.AverageTime))
  def testMethod(blackHole: Blackhole): Boolean = {
    val result = ValidParensSolution.isValid("()[]{})")
    blackHole.consume(result)
    result
  }
}
