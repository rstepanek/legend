package legend.main

import legend.configutils.configs
import com.typesafe.scalalogging._
import legend.datastructures.State
import legend.fileio.SimFileReader

/**
  * The main driving class of the simulation, currently used for testing. It will hold the main event loop of the scenario.
  *
  * All params subject to change, work in progress.
  * @author Ryan Stepanek
  * @version 0.1
  * @see See [[https://github.com/rstepanek/legend Legend on GitHub]] for more.
  */
object SimDriver extends LazyLogging{

  def main(args: Array[String]): Unit = {
    for((k,v)<-configs.user_configs) logger.debug(k+"\t"+v)

    /*Test the construction of the state object*/
    val file_data = SimFileReader.load_resource(SimFileReader.tfile)
    logger.debug(s"Loaded file data:\n${file_data}\nCreating state class...")
    val test_state = State(file_data)
    logger.debug(s"State object constructed with the following params\n${test_state.toString}")
  }

  /*
  TODO: Write EventScheduleParser,
  TODO: Implement Main Event Loop
  TODO: Implement spawning actor
  TODO: Implement output actor
  TODO: Have a log that records sim events, a log that records messages, a warning log, and an error log
   */

}
