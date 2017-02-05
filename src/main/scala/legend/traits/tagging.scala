package legend.traits


/**
  * A trait denoting a tagged object, all tagged objects must be searchable on their tags.
  */
trait tagged_object {
  val tags:Option[List[String]]
}
