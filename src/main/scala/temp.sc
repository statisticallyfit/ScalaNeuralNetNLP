import botkop.{numsca => ns}

import ns.Tensor




Tensor(3, 2, 1, 0).shape



Tensor(1,2,3,4,5,6,7).shape


ns.reshape(ns.arange(2 * 3 * 4), 2, 3, 4)


val ta: Tensor = ns.arange(10)

ns.reshape(ns.arange(2*3*5), 2,3,5)

