package legend.datastructures

/**
  * Created by boop on 1/7/2017.
  */
case class Point(x:Double,y:Double,z:Double=0.0){}

/*
a basic class for a simple square area, presently 2D
 */
case class Area(val xmin:Double, val ymin: Double, val xmax:Double, val ymax:Double){

  def includes(p: Point): Boolean ={
    if( xmin > p.x ) return false
    if( xmax < p.x ) return false
    if( ymin > p.y ) return false
    if( ymax < p.y ) return false

    return true
  }
}