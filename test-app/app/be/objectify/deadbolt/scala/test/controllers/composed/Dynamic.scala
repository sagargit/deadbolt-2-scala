package be.objectify.deadbolt.scala.test.controllers.composed

import javax.inject.Inject

import be.objectify.deadbolt.scala.DeadboltActions
import be.objectify.deadbolt.scala.test.controllers.AbstractDynamic
import play.api.mvc.{Action, AnyContent, Controller}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * @author Steve Chaloner (steve@objectify.be)
  */
class Dynamic @Inject()(deadbolt: DeadboltActions) extends Controller with AbstractDynamic {

  def index: Action[AnyContent] =
    deadbolt.Dynamic(name = "niceName")() { authRequest =>
      Future {
               Ok("Content accessible")
             }
                                          }
}
