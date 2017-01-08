package legend.datastructures


/*
*TODO: Unify traits into a single class of create a trait interface
 */
trait Restriction{
  //def meetRestriction: Boolean
}

case class poolRestriction(val poolName: String, val argument: String, val limit: Int) extends Restriction{
  def meetRestriction(pool: Pool): Boolean={
    argument match{
      case ">" => pool.value > limit
      case ">=" => pool.value >= limit
      case "<" => pool.value < limit
      case "<=" => pool.value <= limit
      case "==" => pool.value == limit
      case "!=" => pool.value != limit
      case _ => true//ignore invalid restrictions
    }
}
}

  case class tagRestriction(val restrictionName: String, val argument: String, val tagRestr: String) extends Restriction {
    def meetRestriction(tags: String*): Boolean = {
      if(argument=="has") {
        return tags.contains(tagRestr)
      }
      else if(argument=="lacks") {
        return !tags.contains(tagRestr)
      }
      else return true
    }
  }