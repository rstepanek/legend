package legend.datastructures

case class State(val name: String,
                 //val state_freq:Option[TimeFreq],
                 //val restriction: Option[List[Restrictions]],
                 //val results: Option[List[Pool]],
                 val cost: Map[String,Int],
                 val Duration: Long,
                 val on_start_message: Option[String],//each time a state is reactivated if it's a freq state
                 val on_exit_message: Option[String],
                 val on_entrance: Option[String]//only once
                ){

}