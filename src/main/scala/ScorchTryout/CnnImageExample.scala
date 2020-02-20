package ScorchTryout

import botkop.numsca.Tensor
import botkop.{numsca => ns}
import scorch._
import scorch.autograd.Variable
import scorch.nn.cnn.{Conv2d, MaxPool2d}
import scorch.nn._
import scorch.optim.{Adam, Optimizer}

/**
 *
 */
object CnnImageExample extends App {


	//network blueprint for conv -> relu -> pool -> affine -> affine
	case class ConvReluPoolAffineNetwork(numSamples: Int,
								  numChannels: Int,
								  imageSize: Int,
								  numClasses: Int) extends Module{

		//numClasses = for output layer shape
		//input layer shape
		val inputShape: List[Int] = List(numSamples, numChannels, imageSize, imageSize)

		// convolutional layer
		val convLayer: Conv2d = Conv2d(numChannels = 3,
			numFilters = 32,
			filterSize = 7,
			weightScale = 1e-3,
			pad = 1,
			stride = 1)

		//pooling layer
		val poolLayer: MaxPool2d = MaxPool2d(poolSize = 2, stride = 2)

		// calculate number of flat features
		val poolOutShape: Seq[Int] = poolLayer
			.outputShape(inputShape = convLayer
				.outputShape(inputShape = inputShape))

		val numFlatFeatures: Int = poolOutShape.tail.product // all dimensions except batch dimension

		// reshape from 3d pooling output to 2d affine input
		def reshape3DTo2D(v: Variable): Variable = v.reshape(-1, numFlatFeatures)

		// First affine layer
		val firstLinearLayer: Linear = Linear(inFeatures = numFlatFeatures, outFeatures = 100)
		// Second affine layer
		val secondLinearLayer: Linear = Linear(inFeatures = 100, outFeatures = numClasses)


		// Chain the layers in a forward pass definition
		override def forward(x: Variable): Variable =
			x ~> convLayer ~> relu ~> poolLayer ~> reshape3DTo2D ~> firstLinearLayer ~> secondLinearLayer


	}



	//Create training loop
	def train(input: Variable, target: Variable, optimizer: Optimizer,
			net: ConvReluPoolAffineNetwork): Unit ={

		//loop should reach 100% accuracy in 2 steps
		for(j <- 0 to 5){
			//reset gradients
			optimizer.zeroGrad()

			//forward pass
			val output: Variable = net(x = input)

			//calculate the loss
			val loss: Variable = softmaxLoss(x = output, y = target)

			// log the accuracy
			val guessed: Tensor = ns.argmax(t = output.data, axis = 1)
			val accuracy: Double = ns.sum(target.data == guessed) / net.numSamples

			Console.println(s"$j: loss: ${loss.data.squeeze()} accuracy: $accuracy")

			// backward pass
			loss.backward()

			//update parameters with gradients
			optimizer.step()
		}
	}



	// Now running the network training:
	//------ Instantiate and parallelize the network
	val net: ConvReluPoolAffineNetwork = ConvReluPoolAffineNetwork(numSamples = 8,
		numChannels = 3, imageSize = 32, numClasses = 10)

	//Adam optimizer for updating parameters
	val optimizer = Adam(parameters = net.parameters, lr = 0.001)

	// Creating inputs and targets (random)
	val input: Variable = Variable(data = ns.randn(net.inputShape:_*))
	val target: Variable = Variable(data = ns.randint(low = net.numClasses,
		shape = Array(net.numSamples, 1)))


	train(input, target, optimizer, net)

}
