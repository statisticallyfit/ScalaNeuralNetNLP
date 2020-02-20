package ScorchTryout

import scorch.autograd.Variable
import botkop.{numsca => ns}
import ns.Tensor

/**
 *
 */
object AutoDiffExample extends App {


	val x = Variable(ns.ones(2,2))
	println(s"x = $x")

	println()


	// Do an operation to see gradient info later:
	val y = 3*x + 4
	println(s"y = $y")
	//Has gradFn since was created as result of operation
	// Grad fn only shares info about most RECENT operation (the adding 4)
	println(s"y.gradFn = ${y.gradFn}")

	println()

	// Do more operations
	val z = y * y * 3
	val out = z.mean()
	println(s"z = $z")
	println(s"out = $out")
	println(s"out.gradFn = ${out.gradFn}")

	// Backpropinga nd printing gradients : d(out)/dx
	out.backward()
	println(s"d(out)/dx = ${x.grad}")
}
