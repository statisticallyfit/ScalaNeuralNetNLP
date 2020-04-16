package NumscaTryout


import botkop.{numsca => ns}
import ns.Tensor

import org.scalatest.Assertions._
/**
 *
 */
object AccessingInTensors extends App {


	val tensor: Tensor = ns.reshape(ns.arange(2*3*5), 2,3,5)

	val innerShapedArray: Array[Array[Array[Double]]] =
		Array(
			Array(
				Array(0.00,  1.00,  2.00,  3.00,  4.00),
				Array(5.00,  6.00,  7.00,  8.00,  9.00),
				Array(10.00,  11.00,  12.00,  13.00,  14.00)
			),

			Array(
				Array(15.00,  16.00,  17.00,  18.00,  19.00),
				Array(20.00,  21.00,  22.00,  23.00,  24.00),
				Array(25.00,  26.00,  27.00,  28.00,  29.00)
			)
		)


	assert(tensor(0, 1, 2) sameElements Tensor(7.0))
	assert(tensor(0, 2, 4) sameElements Tensor(14.0), "Access last element in dim 0 array")
	assert(tensor(1, 2, 4) sameElements Tensor(29.0), "Access last element in dim 1 array")
	assert(tensor(1, 2, 0) sameElements Tensor(25.0))
	assert(tensor(1, 0, 2) sameElements Tensor(17.0))
	assert(tensor(1, 1, 2) sameElements Tensor(22.0))
	assert(tensor(0, 1, 4) sameElements Tensor(9.0))
	assert(tensor(0, 2, 1) sameElements Tensor(11.0))
	assert(tensor(1, 2, 1) sameElements Tensor(26.0))

	// Checking equality on dimensions // Tensor(innerShapedArray(1).flatten).reshape(tensor.shape.tail)
	assert(tensor(0, 1) sameElements Tensor(5.0, 6.0, 7.0, 8.0, 9.0), "Test row access")
	assert(tensor(0) sameElements Tensor(tensor(0).data).reshape(tensor.shape.tail), "Test dimension access, " +
		"yielding a 2-dim tensor")
	// TODO tensor(1).array == innerShapedArray(1).array

	// The many uses of squeeze()
	assert(Tensor(23, 25, 19, 11)(1).squeeze() == 25, "Test 1: Squeezing is same as accessing in a 1-dim tensor")
	assert(Tensor(23, 25, 19, 11).squeeze(1) == 25.0, "Test 2: Squeezing is same as accessing in a 1-dim tensor")

	assert(tensor(0).squeeze(0,4) == 4.0, "Test 1: squeezing is same as accessing in a 2-dim tensor")
	assert(tensor(0, 0).squeeze(4) == 4.0, "Test 2: squeezing is same as accessing in a 2-dim tensor")


	assert(tensor(0, 1, 2).squeeze() == 7.0, "Test 1: squeezing can be used to extract a single number from a Tensor")
	assert(tensor.squeeze(0,1,2) == 7.0, "Test 2: squeezing is same as accessing in a 3-dim tensor")


}
