/*
 * Copyright 2026 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.agentriskingbackend.controllers

import play.api.libs.json.Format.GenericFormat
import play.api.libs.json.Format
import play.api.libs.json.JsError
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.Reads
import play.api.mvc.Action
import play.api.mvc.ControllerComponents
import uk.gov.hmrc.play.bootstrap.backend.controller.BackendController

import javax.inject.Inject
import javax.inject.Singleton

final case class RiskingRequest(
  arn: String,
  utr: Option[String]
)

object RiskingRequest:
  given Format[RiskingRequest] = Json.format[RiskingRequest]

@Singleton()
class EnsureRiskingController @Inject() (
  cc: ControllerComponents
)
extends BackendController(cc):

  def run(): Action[RiskingRequest] =
    Action(parse.json[RiskingRequest]):
      implicit request =>
        Ok(Json.toJson(request.body))
