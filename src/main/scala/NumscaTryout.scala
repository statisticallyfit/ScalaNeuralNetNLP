import botkop.{numsca => ns}
import ns.Tensor
import scorch._

/**
 *
 */
object NumscaTryout extends App {


	println("Creating Tensors: ")
	println()

	val tensor1: Tensor = Tensor(3, 2, 1, 0)
	println("tensor1: \n" + tensor1)
	println()

	println("zeroes: \n" + ns.zeros(3, 3))
	println()

	println("ones: \n" + ns.ones(5, 2))
	println()

	val tensor2: Tensor = Tensor(4,5,1,1)

	println(s"multiplying tensors: $tensor1 * $tensor2 \n" + tensor1 * tensor2)
	println()


	val tensorA: Tensor = ns.arange(10)
	//assert(tensorA == Tensor((0 until 10).toArray) )

	val tensorB: Tensor = ns.reshape(ns.arange(9), 3, 3)
	println("ns.reshape(ns.arange(9), 3, 3) = \n" + tensorB)
	println()


	val tensorC: Tensor = ns.reshape(ns.arange(2 * 3 * 4), 2, 3, 4)
	println("ns.reshape(ns.arange(2 * 3 * 4), 2, 3, 4) = \n" + tensorC)
	println()

	// ------------------------------------------------------------------------------------

	// ACCESSING
	println("Accessing: ")
	println()

	//assert(tensorC(0, 1, 2) == Tensor(6.0), "Test 1 error")
	//assert(tensorC(0, 1, 2) == Tensor(6.0), "Test 1 error")
	//assert(tensorC(1, 2, 1) == Tensor(21), "Test 2 error")


	// ------------------------------------------
	// ------------------------------------------
}