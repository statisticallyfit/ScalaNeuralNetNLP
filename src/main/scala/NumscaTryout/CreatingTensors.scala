package NumscaTryout

import botkop.{numsca => ns}
import ns.Tensor

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
	assert(tensor2.shape == Array(1,4), "Test: not shape 1")
	assert(tensor2.data == Array(4, 5, 1, 1).map(_.toDouble), "Test: data must be Array")

	// ------------------------------------------------------------------------------------------

	val tensor3: Tensor = ns.reshape(ns.arange(9), 3, 3)
	println(s"ns.reshape(ns.arange(9), 3, 3) = \n $tensor3 \n")

	assert(tensor3.shape == Array(3,3), "Test: not shape (3,3)")


	// ------------------------------------------------------------------------------------------

	val tensor4: Tensor = ns.reshape(ns.arange(2 * 3 * 4), 2, 3, 4)
	println(s"ns.reshape(ns.arange(2 * 3 * 4), 2, 3, 4) = \n $tensor4 \n")

	assert(tensor4.shape == Array(2,3,4), "Test: not shape (2,3,4)")
	assert(tensor4.reshape(3,4,2) == Array(3,4,2), "Test: not shape (3,4,2)")


	// ------------------------------------------------------------------------------------------
}
