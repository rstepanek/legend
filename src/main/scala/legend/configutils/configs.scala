package legend.configutils

import java.time.format.DateTimeFormatter
import java.time.LocalDate

import legend.fileio.SimFileReader

import scala.collection.mutable.Map

/**
  * A static class that holds user provided values for the simulation. This is preferred to general config libraries.
  *
  * All params subject to change, work in progress.
  * @author Ryan Stepanek
  * @version 0.1
  * @see See [[https://github.com/rstepanek/legend Legend on GItHub]] for more "
  */
object configs {

  val user_configs:Map[String,String] = SimFileReader.load_resource("/Sim.config")
  val formatter:DateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss:SS");
  val start_date_string:String =  if (user_configs.contains("start_date")) user_configs.get("start_date").get else "01/01/3000 00:00:01:00"
  val start_date = LocalDate.parse(start_date_string, formatter)
  val out_file_name =  if (user_configs.contains("out_file_name")) user_configs.get("out_file_name").get else "SimOut.csv"


}
