package legend.main

import legend.configutils.configs

import com.typesafe.scalalogging._

/**
  * The main driving class of the simulation, currently used for testing. It will hold the main event loop of the scenario.
  *
  * All params subject to change, work in progress.
  * @author Ryan Stepanek
  * @version 0.1
  * @see See [[https://github.com/rstepanek/legend Legend on GItHub]] for more "
  */
object SimDriver extends LazyLogging{

  def main(args: Array[String]): Unit = {
    for((k,v)<-configs.user_configs) logger.debug(k+"\t"+v)

  }

}
