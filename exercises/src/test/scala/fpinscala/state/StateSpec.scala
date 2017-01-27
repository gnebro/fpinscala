package fpinscala.state

import fpinscala.state.RNG.Simple
import org.scalatest.{FlatSpec, Matchers}
import org.scalacheck.{Arbitrary, Gen, Properties}
import org.scalacheck.Prop.forAll

object StateSpec extends Properties("RNG") {

  implicit val rngArbitrary: Arbitrary[RNG] = Arbitrary(Arbitrary.arbitrary[Long].map(l => Simple(l)))
  property("nonNegativeInt") = forAll { (rng: RNG) =>
    RNG.nonNegativeInt(rng)._1 >= 0
  }
}
