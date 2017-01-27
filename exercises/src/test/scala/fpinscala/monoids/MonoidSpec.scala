package fpinscala.monoids

//import fpinscala.monoids.Monoid
import org.scalatest.{FlatSpec, Matchers}
import org.scalacheck.{Arbitrary, Prop, Properties}
import org.scalacheck.Prop.forAll


object MonoidSpec extends Properties("Monoids..") {


  def associative[A :Arbitrary] (m: Monoid[A]) = forAll { (a1: A, a2: A, a3: A) =>
    m.op(m.op(a1,a2), a3) == m.op(a1,m.op(a2,a3)) }

  def unit[A :Arbitrary] (m :Monoid[A]) = forAll { (a :A) => m.op(a, m.zero) == a } :| "right unit" &&
    forAll { (a :A) => m.op(m.zero, a) == a } :| "left unit"

  def monoid[A :Arbitrary] (m :Monoid[A]) = associative (m) && unit (m)

  property ("stringMonoid is a monoid") = monoid (Monoid.stringMonoid)
  property ("intAddition is a monoid") = monoid (Monoid.intAddition)
  property ("intMultiplication is a monoid") = monoid (Monoid.intMultiplication)
  property ("booleanAnd is a monoid") = monoid (Monoid.booleanAnd)
  property ("booleanOr is a monoid") = monoid (Monoid.booleanOr)
}

