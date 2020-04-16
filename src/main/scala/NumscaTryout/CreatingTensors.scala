package NumscaTryout

import botkop.{numsca => ns}
import ns.Tensor


import org.scalatest.Assertions._

/**
 *
 */
object CreatingTensors extends App {


	val tensor1: Tensor = Tensor(3, 2, 1, 0)
	println(s"tensor1: \n $tensor1 \n")

	println(s"zeroes: \n ${ns.zeros(3, 3)}\n")

	println(s"ones: \n ${ns.ones(5, 2)}\n")

	// ------------------------------------------------------------------------------------------
	val tensor2: Tensor = Tensor(4,5,1,1)
	println(s"multiplying tensors: $tensor1 * $tensor2 \n ${tensor1 * tensor2}\n")
	assert(tensor2.shape === Array(1,4), "Test: not shape 1")
	assert(tensor2.data === Array(4, 5, 1, 1).map(_.toDouble), "Test: data must be Array")

	// ------------------------------------------------------------------------------------------

	val tensor3: Tensor = ns.reshape(ns.arange(9), 3, 3)
	println(s"ns.reshape(ns.arange(9), 3, 3) = \n $tensor3 \n")

	assert(tensor3.shape === Array(3,3), "Test: not shape (3,3)")


	// ------------------------------------------------------------------------------------------

	val tensor4: Tensor = ns.reshape(ns.arange(2 * 3 * 4), 2, 3, 4)
	println(s"ns.reshape(ns.arange(2 * 3 * 4), 2, 3, 4) = \n $tensor4 \n")

	assert(tensor4.shape === Array(2,3,4), "Test: not shape (2,3,4)")
	assert(tensor4.reshape(3,4,2).shape === Array(3,4,2), "Test: not shape (3,4,2)")


	// ------------------------------------------------------------------------------------------

	val tensor: Tensor = ns.reshape(ns.arange(2*3*5), 2,3,5)

	val innerArray = Array((0 until 30):_*).map(_.toDouble)


	assert(tensor sameElements Tensor(innerArray).reshape(tensor.shape),
		"Test: Tensor must equal its inner array")



	val innerShapedArray =
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

	assert(innerShapedArray.flatten.flatten === innerArray,
		"Test: flattened inner shaped array must equal the tensor's hypothetical inner array")

	assert(tensor sameElements Tensor(innerShapedArray.flatten.flatten).reshape(tensor.shape),
		"Test: Tensor must equal the flattened array that is reshaped to match original tensor")

}


