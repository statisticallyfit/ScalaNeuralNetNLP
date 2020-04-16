package NumscaTryout


import botkop.{numsca => ns}
import ns.Tensor

/**
 *
 */

object Ops {
	def equalTensors(tensor1: Tensor, tensor2: Tensor): Boolean = {
		(tensor1 == tensor2).data.forall(_ == 1) // float 1.0 or int 1?
	}
}
