package fpinscala.monad

import fpinscala.monoids.Monoid
import org.scalacheck.Prop._
import org.scalacheck.{ Arbitrary, Properties }

object MonadSpec extends Properties("Monad.."){

  def associative[A :Arbitrary] (m: Monoid[A]) = forAll { (a1: A, a2: A, a3: A) =>
    m.op(m.op(a1,a2), a3) == m.op(a1,m.op(a2,a3)) }

}
