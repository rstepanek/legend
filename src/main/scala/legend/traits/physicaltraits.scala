package legend.traits

import legend.datastructures.Point

trait physical{
  var com:Point//center of mass
  var vis: Boolean = true
}
//case class Point(x:Double,y:Double,z:Double=0.0){}
