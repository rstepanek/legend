package legend.configutils

import java.time.format.DateTimeFormatter
import java.time.LocalDate

import legend.fileio.SimFileReader
import legend.utils.converter

import scala.collection.immutable.Map

/**
  * A static class that holds user provided values for the simulation. This is preferred to general config libraries.
  *
  * All params subject to change, work in progress.
  * @author Ryan Stepanek
  * @version 0.1
  * @see See [[https://github.com/rstepanek/legend Legend on GitHub]] for more.
  */
object configs {

  val user_configs:Map[String,String] = SimFileReader.load_resource("/Sim.config")

  /*Load the start date*/
  val formatter:DateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss:SS");
  val start_date_string:String =  if (user_configs.contains("start_date")) user_configs.get("start_date").get else "01/01/3000 00:00:01:00"
  val start_date = formatter.parse(start_date_string)//LocalDate.parse(start_date_string, formatter)
  /********************/

  val out_file_name =  if (user_configs.contains("out_file_name")) user_configs.get("out_file_name").get else "SimOut.csv"
  val state_file_directory = if(user_configs.contains("state_file_directory"))user_configs.get("state_file_directory").get else "/scenario/states"
  val process_file_directory = if(user_configs.contains("process_file_directory"))user_configs.get("process_file_directory").get else "/scenario/processes"
  val entity_file_directory = if(user_configs.contains("entity_file_directory"))user_configs.get("entity_file_directory").get else "/scenario/entities"

  val kml_file_location = if(user_configs.contains("kml_file_location"))user_configs.get("kml_file_location").get else "/scenario/scenario.kml"
  val simevent_file_location = if(user_configs.contains("simevent_file_location"))user_configs.get("simevent_file_location").get else "/scenario/SimEventSchedule.txt"

  /*We're getting meta now*/
  val runtime_configs = converter.ccToMap(this)
}

